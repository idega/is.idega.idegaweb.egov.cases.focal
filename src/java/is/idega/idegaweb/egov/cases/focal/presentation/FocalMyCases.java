package is.idega.idegaweb.egov.cases.focal.presentation;

import is.idega.idegaweb.egov.cases.business.CaseCategoryCollectionHandler;
import is.idega.idegaweb.egov.cases.data.CaseCategory;
import is.idega.idegaweb.egov.cases.data.CaseType;
import is.idega.idegaweb.egov.cases.data.GeneralCase;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;

import com.idega.block.process.data.CaseLog;
import com.idega.business.IBORuntimeException;
import com.idega.core.file.data.ICFile;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.remotescripting.RemoteScriptHandler;
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
import com.idega.util.IWTimestamp;
import com.idega.util.text.TextSoap;

public class FocalMyCases extends FocalCasesBlock {

	protected void initializeTableSorter(IWContext arg0) throws RemoteException {
	}

	protected String getBlockID() {
		return "myCases";
	}

	@Override
	protected Collection<GeneralCase> getCases(User user) throws RemoteException {
		return getCasesBusiness().getMyCases(user);
	}

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

	//	protected void showList(IWContext iwc, int action, String result) throws RemoteException {
	//		Form form = new Form();
	//		form.addParameter(PARAMETER_ACTION, "");
	//		
	//		Layer casesSection = new Layer(Layer.DIV);
	//		casesSection.setStyleClass("formSection");
	//
	//		Table2 table = new Table2();
	//		table.setWidth("100%");
	//		table.setCellpadding(0);
	//		table.setCellspacing(0);
	//		table.setStyleClass("adminTable");
	//		table.setStyleClass("ruler");
	//		table.setID(getBlockID());
	//
	//		TableColumnGroup columnGroup = table.createColumnGroup();
	//		TableColumn column = columnGroup.createColumn();
	//		column.setSpan(6);
	//		column = columnGroup.createColumn();
	//		column.setSpan(1);
	//		column.setWidth("12");
	//		Collection cases = getCases(iwc.getCurrentUser());
	//
	//		TableRowGroup group = table.createHeaderRowGroup();
	//		TableRow row = group.createRow();
	//
	//		boolean showCheckBoxes = true;
	//		TableCell2 cell = row.createHeaderCell();
	//		cell.setStyleClass("firstColumn");
	//		cell.setStyleClass("caseNumber");
	//		cell.add(new Text(getResourceBundle().getLocalizedString("case_nr", "Case nr.")));
	//
	//		cell = row.createHeaderCell();
	//		cell.setStyleClass("sender");
	//		cell.add(new Text(getResourceBundle().getLocalizedString("sender", "Sender")));
	//
	//		if (getBusiness().useTypes()) {
	//			cell = row.createHeaderCell();
	//			cell.setStyleClass("caseType");
	//			cell.add(new Text(getResourceBundle().getLocalizedString("case_type", "Case type")));
	//		}
	//
	//		cell = row.createHeaderCell();
	//		cell.setStyleClass("createdDate");
	//		cell.add(new Text(getResourceBundle().getLocalizedString("created_date", "Created date")));
	//
	//		cell = row.createHeaderCell();
	//		cell.setStyleClass("status");
	//		cell.add(new Text(getResourceBundle().getLocalizedString("status", "Status")));
	//
	//		cell = row.createHeaderCell();
	//		cell.setStyleClass("handler");
	//		cell.add(new Text(getResourceBundle().getLocalizedString("handler", "Handler")));
	//
	//		cell = row.createHeaderCell();
	//		if (!showCheckBoxes) {
	//			cell.setStyleClass("lastColumn");
	//		}
	//		cell.setStyleClass("view");
	//		cell.add(new Text(getResourceBundle().getLocalizedString("view", "View")));
	//
	//		cell = row.createHeaderCell();
	//		cell.setStyleClass("lastColumn");
	//		cell.setStyleClass("multiHandle");
	//		cell.add(Text.getNonBrakingSpace());
	//
	//		group = table.createBodyRowGroup();
	//		int iRow = 1;
	//
	//		Iterator iter = cases.iterator();
	//		while (iter.hasNext()) {
	//			GeneralCase theCase = (GeneralCase) iter.next();
	//			CaseStatus status = theCase.getCaseStatus();
	//			CaseType type = theCase.getCaseType();
	//			User owner = theCase.getOwner();
	//			IWTimestamp created = new IWTimestamp(theCase.getCreated());
	//
	//			row = group.createRow();
	//			if (iRow == 1) {
	//				row.setStyleClass("firstRow");
	//			}
	//			else if (!iter.hasNext()) {
	//				row.setStyleClass("lastRow");
	//			}
	//			if (theCase.isPrivate()) {
	//				row.setStyleClass("isPrivate");
	//			}
	//			if (theCase.getExternalId() != null && !theCase.getExternalId().equals("")) {
	//				row.setStyleClass("isInFocal");
	//			}
	//			if (status.equals(getCasesBusiness(iwc).getCaseStatusReview())) {
	//				row.setStyleClass("isReview");
	//			}
	//
	//			cell = row.createCell();
	//			cell.setStyleClass("firstColumn");
	//			cell.setStyleClass("caseNumber");
	//			cell.add(new Text(theCase.getPrimaryKey().toString()));
	//
	//			cell = row.createCell();
	//			cell.setStyleClass("sender");
	//			if (owner != null) {
	//				cell.add(new Text(new Name(owner.getFirstName(), owner.getMiddleName(), owner.getLastName()).getName(iwc.getCurrentLocale())));
	//			}
	//			else {
	//				cell.add(new Text("-"));
	//			}
	//
	//			if (getBusiness().useTypes()) {
	//				cell = row.createCell();
	//				cell.setStyleClass("caseType");
	//				cell.add(new Text(type.getName()));
	//			}
	//
	//			cell = row.createCell();
	//			cell.setStyleClass("createdDate");
	//			cell.add(new Text(created.getLocaleDateAndTime(iwc.getCurrentLocale(), IWTimestamp.SHORT, IWTimestamp.SHORT)));
	//
	//			cell = row.createCell();
	//			cell.setStyleClass("status");
	//			cell.add(new Text(getBusiness().getLocalizedCaseStatusDescription(theCase, status, iwc.getCurrentLocale())));
	//
	//			User handler = theCase.getHandledBy();
	//			cell = row.createCell();
	//			cell.setStyleClass("handler");
	//			if (handler != null) {
	//				cell.add(new Text(new Name(handler.getFirstName(), handler.getMiddleName(), handler.getLastName()).getName(iwc.getCurrentLocale())));
	//			}
	//			else {
	//				cell.add(new Text("-"));
	//			}
	//
	//			cell = row.createCell();
	//			cell.setStyleClass("view");
	//			Link edit = getProcessLink(getBundle().getImage("edit.png", getResourceBundle().getLocalizedString("view_case", "View case")), theCase);
	//			cell.add(edit);
	//			
	//			
	//
	//			cell = row.createCell();
	//			cell.setStyleClass("firstColumn");
	//			cell.setStyleClass("multiHandle");
	//			if (theCase.getExternalId() == null) {
	//				CheckBox box = new CheckBox(PARAMETER_CASE_PK, theCase.getPrimaryKey().toString());
	//				cell.add(box);
	//			}
	//
	//			if (iRow % 2 == 0) {
	//				row.setStyleClass("evenRow");
	//			}
	//			else {
	//				row.setStyleClass("oddRow");
	//			}
	//		}
	//		casesSection.add(table);
	//		form.add(casesSection);
	//		
	//		Layer legendSection = new Layer(Layer.DIV);
	//		legendSection.setStyleClass("formSection");
	//		legendSection.add(getLegend(iwc));
	//		
	//		form.add(legendSection);
	//		
	//		Layer bottom = new Layer(Layer.DIV);
	//		bottom.setStyleClass("bottom");
	//		form.add(bottom);
	//
	//		Link back = getButtonLink(getResourceBundle().getLocalizedString("move_focal", "Move to Focal"));
	//		back.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + String.valueOf(ACTION_MOVE_FOCAL) + "');");
	//		back.setToFormSubmit(form);
	//		bottom.add(back);
	//
	//		add(form);
	//	}

	protected void showProcessor(IWContext iwc, Object casePK) throws RemoteException {
		Form form = new Form();
		form.setStyleClass("adminForm");
		form.setStyleClass("overview");
		form.maintainParameter(PARAMETER_CASE_PK);
		form.addParameter(PARAMETER_ACTION, "");

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
		categories.keepStatusOnAction(true);
		categories.setSelectedElement(parentCategory != null ? parentCategory.getPrimaryKey().toString() : category.getPrimaryKey().toString());
		categories.setStyleClass("caseCategoryDropdown");

		DropdownMenu subCategories = new DropdownMenu(PARAMETER_SUB_CASE_CATEGORY_PK);
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
			try {
				RemoteScriptHandler rsh = new RemoteScriptHandler(categories, subCategories);
				rsh.setRemoteScriptCollectionClass(CaseCategoryCollectionHandler.class);
				element.add(rsh);
			}
			catch (IllegalAccessException iae) {
				iae.printStackTrace();
			}
			catch (InstantiationException ie) {
				ie.printStackTrace();
			}

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
		// TODO Auto-generated method stub
		return null;
	}

}