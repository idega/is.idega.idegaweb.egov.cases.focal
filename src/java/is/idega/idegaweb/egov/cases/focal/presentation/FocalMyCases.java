package is.idega.idegaweb.egov.cases.focal.presentation;

import is.idega.idegaweb.egov.cases.data.CaseCategory;
import is.idega.idegaweb.egov.cases.data.CaseType;
import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.util.CasesConstants;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;

import com.idega.block.process.business.CaseManager;
import com.idega.block.process.data.CaseLog;
import com.idega.block.web2.business.Web2Business;
import com.idega.business.IBORuntimeException;
import com.idega.core.file.data.ICFile;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.text.Heading1;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.HiddenInput;
import com.idega.presentation.ui.Label;
import com.idega.presentation.ui.TextArea;
import com.idega.presentation.ui.util.SelectorUtility;
import com.idega.user.data.User;
import com.idega.util.CoreConstants;
import com.idega.util.IWTimestamp;
import com.idega.util.PresentationUtil;
import com.idega.util.expression.ELUtil;
import com.idega.util.text.TextSoap;

public class FocalMyCases extends FocalCasesBlock {
	
	private boolean usePDFDownloadColumn = true;
	private boolean allowPDFSigning = true;
	private boolean showStatistics;
	private boolean hideEmptySection = true;
	
	@Override
	public boolean isUsePDFDownloadColumn() {
		return usePDFDownloadColumn;
	}
	
	@Override
	public void setUsePDFDownloadColumn(boolean usePDFDownloadColumn) {
		this.usePDFDownloadColumn = usePDFDownloadColumn;
	}

	@Override
	public boolean isAllowPDFSigning() {
		return allowPDFSigning;
	}

	@Override
	public void setAllowPDFSigning(boolean allowPDFSigning) {
		this.allowPDFSigning = allowPDFSigning;
	}

	@Override
	public boolean isShowStatistics() {
		return showStatistics;
	}

	@Override
	public void setShowStatistics(boolean showStatistics) {
		this.showStatistics = showStatistics;
	}

	@Override
	public boolean isHideEmptySection() {
		return hideEmptySection;
	}

	@Override
	public void setHideEmptySection(boolean hideEmptySection) {
		this.hideEmptySection = hideEmptySection;
	}

	@Override
	protected void initializeTableSorter(IWContext arg0) throws RemoteException {
	}

	@Override
	protected String getBlockID() {
		return "myCases";
	}

	@Override
	protected void save(IWContext iwc) throws RemoteException {
		Object casePK = iwc.getParameter(PARAMETER_CASE_PK);
		Object caseCategoryPK = iwc.getParameter(PARAMETER_CASE_CATEGORY_PK);
		Object subCaseCategoryPK = iwc.getParameter(PARAMETER_SUB_CASE_CATEGORY_PK);
		Object caseTypePK = iwc.getParameter(PARAMETER_CASE_TYPE_PK);
		String status = iwc.getParameter(PARAMETER_STATUS);
		String reply = iwc.getParameter(PARAMETER_REPLY);

		try {
			getCasesBusiness().handleCase(casePK, subCaseCategoryPK != null ? subCaseCategoryPK : caseCategoryPK, caseTypePK, status, iwc.getCurrentUser(), reply, iwc);
		}
		catch (FinderException fe) {
			fe.printStackTrace();
		}
	}


	@Override
	protected void showProcessor(IWContext iwc, Object casePK) throws RemoteException {
		Web2Business business = ELUtil.getInstance().getBean(Web2Business.class);
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, business.getBundleURIToJQueryLib());
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, CoreConstants.DWR_ENGINE_SCRIPT);
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, CoreConstants.DWR_UTIL_SCRIPT);
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, "/dwr/interface/CasesBusiness.js");
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, iwc.getIWMainApplication().getBundle(CasesConstants.IW_BUNDLE_IDENTIFIER).getVirtualPathWithFileNameString("javascript/egov_cases.js"));

		Form form = new Form();
		form.setStyleClass("adminForm");
		form.setStyleClass("overview");
		form.maintainParameter(PARAMETER_CASE_PK);
		form.addParameter(PARAMETER_ACTION, "");

		HiddenInput localeInput = new HiddenInput("current_locale", iwc.getCurrentLocale().getCountry().toLowerCase());
		localeInput.setID("casesLocale");
		form.add(localeInput);

		boolean useSubCategories = getCasesBusiness(iwc).useSubCategories();

		GeneralCase theCase = null;
		try {
			theCase = getCasesBusiness().getGeneralCase(casePK);
		}
		catch (FinderException fe) {
			fe.printStackTrace();
			throw new IBORuntimeException(fe);
		}
		CaseCategory category = theCase.getCaseCategory();
		CaseCategory parentCategory = category.getParent();
		CaseType type = theCase.getCaseType();
		ICFile attachment = theCase.getAttachment();
		User owner = theCase.getOwner();
		IWTimestamp created = new IWTimestamp(theCase.getCreated());

		form.add(getPersonInfo(iwc, owner));

		Heading1 heading = new Heading1(getResourceBundle().getLocalizedString("case_overview", "Case overview"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		form.add(heading);

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		if (theCase.isPrivate()) {
			section.add(getAttentionLayer(getResourceBundle().getLocalizedString("case.is_private", "The sender wishes that this case be handled as confidential.")));
		}

		Layer clear = new Layer(Layer.DIV);
		clear.setStyleClass("Clear");

		SelectorUtility util = new SelectorUtility();
		DropdownMenu categories = (DropdownMenu) util.getSelectorFromIDOEntities(new DropdownMenu(PARAMETER_CASE_CATEGORY_PK), getCasesBusiness().getCaseCategories(), "getName");
		categories.setID("casesParentCategory");
		categories.keepStatusOnAction(true);
		categories.setSelectedElement(parentCategory != null ? parentCategory.getPrimaryKey().toString() : category.getPrimaryKey().toString());
		categories.setStyleClass("caseCategoryDropdown");

		DropdownMenu subCategories = new DropdownMenu(PARAMETER_SUB_CASE_CATEGORY_PK);
		subCategories.setID("casesSubCategory");
		subCategories.keepStatusOnAction(true);
		subCategories.setSelectedElement(category.getPrimaryKey().toString());
		subCategories.setStyleClass("subCaseCategoryDropdown");

		if (parentCategory != null) {
			Collection collection = getCasesBusiness(iwc).getSubCategories(parentCategory);
			if (collection.isEmpty()) {
				subCategories.addMenuElement(category.getPrimaryKey().toString(), getResourceBundle().getLocalizedString("case_creator.no_sub_category", "no sub category"));
			}
			else {
				Iterator iter = collection.iterator();
				while (iter.hasNext()) {
					CaseCategory subCategory = (CaseCategory) iter.next();
					subCategories.addMenuElement(subCategory.getPrimaryKey().toString(), subCategory.getLocalizedCategoryName(iwc.getCurrentLocale()));
				}
			}
		}

		DropdownMenu types = (DropdownMenu) util.getSelectorFromIDOEntities(new DropdownMenu(PARAMETER_CASE_TYPE_PK), getCasesBusiness().getCaseTypes(), "getName");
		types.keepStatusOnAction(true);
		types.setSelectedElement(type.getPrimaryKey().toString());
		types.setStyleClass("caseTypeDropdown");

		HiddenInput hiddenType = new HiddenInput(PARAMETER_CASE_TYPE_PK, type.getPrimaryKey().toString());

		DropdownMenu statuses = new DropdownMenu(PARAMETER_STATUS);
		statuses.addMenuElement(getCasesBusiness().getCaseStatusPending().getStatus(), getCasesBusiness().getLocalizedCaseStatusDescription(theCase, getCasesBusiness().getCaseStatusPending(), iwc.getCurrentLocale()));
		statuses.addMenuElement(getCasesBusiness().getCaseStatusWaiting().getStatus(), getCasesBusiness().getLocalizedCaseStatusDescription(theCase, getCasesBusiness().getCaseStatusWaiting(), iwc.getCurrentLocale()));
		statuses.addMenuElement(getCasesBusiness().getCaseStatusReady().getStatus(), getCasesBusiness().getLocalizedCaseStatusDescription(theCase, getCasesBusiness().getCaseStatusReady(), iwc.getCurrentLocale()));
		statuses.setSelectedElement(theCase.getStatus());
		statuses.setStyleClass("caseStatusDropdown");

		Layer message = new Layer(Layer.SPAN);
		message.add(new Text(TextSoap.formatText(theCase.getMessage())));

		Layer createdDate = new Layer(Layer.SPAN);
		createdDate.add(new Text(created.getLocaleDateAndTime(iwc.getCurrentLocale(), IWTimestamp.SHORT, IWTimestamp.SHORT)));

		TextArea reply = new TextArea(PARAMETER_REPLY);
		reply.setStyleClass("textarea");
		reply.keepStatusOnAction(true);

		if (getCasesBusiness().useTypes()) {
			Layer element = new Layer(Layer.DIV);
			element.setStyleClass("formItem");
			Label label = new Label(getResourceBundle().getLocalizedString("case_type", "Case type"), types);
			element.add(label);
			element.add(types);
			section.add(element);
		}
		else {
			form.add(hiddenType);
		}

		Layer element = new Layer(Layer.DIV);
		element.setStyleClass("formItem");
		Label label = new Label(getResourceBundle().getLocalizedString("case_category", "Case category"), categories);
		element.add(label);
		element.add(categories);
		section.add(element);

		if (useSubCategories) {
			element = new Layer(Layer.DIV);
			element.setStyleClass("formItem");
			label = new Label(getResourceBundle().getLocalizedString("sub_case_category", "Sub case category"), subCategories);
			element.add(label);
			element.add(subCategories);
			section.add(element);
		}

		element = new Layer(Layer.DIV);
		element.setStyleClass("formItem");
		label = new Label();
		label.setLabel(getResourceBundle().getLocalizedString("created_date", "Created date"));
		element.add(label);
		element.add(createdDate);
		section.add(element);

		if (attachment != null) {
			Link link = new Link(new Text(attachment.getName()));
			link.setFile(attachment);
			link.setTarget(Link.TARGET_BLANK_WINDOW);

			Layer attachmentSpan = new Layer(Layer.SPAN);
			attachmentSpan.add(link);

			element = new Layer(Layer.DIV);
			element.setStyleClass("formItem");
			label = new Label();
			label.setLabel(getResourceBundle().getLocalizedString("attachment", "Attachment"));
			element.add(label);
			element.add(attachmentSpan);
			section.add(element);
		}

		element = new Layer(Layer.DIV);
		element.setStyleClass("formItem");
		element.setStyleClass("informationItem");
		label = new Label();
		label.setLabel(getResourceBundle().getLocalizedString("message", "Message"));
		element.add(label);
		element.add(message);
		section.add(element);

		section.add(clear);

		heading = new Heading1(getResourceBundle().getLocalizedString("handler_overview", "Handler overview"));
		heading.setStyleClass("subHeader");
		form.add(heading);

		section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		element = new Layer(Layer.DIV);
		element.setStyleClass("formItem");
		label = new Label(getResourceBundle().getLocalizedString("status", "status"), statuses);
		element.add(label);
		element.add(statuses);
		section.add(element);

		element = new Layer(Layer.DIV);
		element.setStyleClass("formItem");
		label = new Label(getResourceBundle().getLocalizedString("reply", "Reply"), reply);
		element.add(label);
		element.add(reply);
		section.add(element);

		section.add(clear);

		Collection logs = getCasesBusiness(iwc).getCaseLogs(theCase);
		if (!logs.isEmpty()) {
			Iterator iter = logs.iterator();
			while (iter.hasNext()) {
				CaseLog log = (CaseLog) iter.next();
				form.add(getHandlerLayer(iwc, this.getResourceBundle(), theCase, log));
			}
		}

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link back = getButtonLink(getResourceBundle().getLocalizedString("back", "Back"));
		back.setStyleClass("homeButton");
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_VIEW));
		back.setToFormSubmit(form);
		bottom.add(back);

		Link next = getButtonLink(getResourceBundle().getLocalizedString("process", "Process"));
		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_SAVE));
		next.setToFormSubmit(form);
		bottom.add(next);

		if (theCase.getExternalId() == null) {
			Link focal = getButtonLink(getResourceBundle().getLocalizedString("move_focal", "Move to Focal"));
			focal.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_MOVE_FOCAL));
			focal.setToFormSubmit(form);
			bottom.add(focal);
		}

		add(form);
	}

	@Override
	protected String getCasesProcessorType() {
		return CaseManager.CASE_LIST_TYPE_MY;
	}

}