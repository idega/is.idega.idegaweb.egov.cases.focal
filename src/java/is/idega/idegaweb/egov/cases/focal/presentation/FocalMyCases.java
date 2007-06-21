package is.idega.idegaweb.egov.cases.focal.presentation;

import is.idega.idegaweb.egov.cases.business.CaseCategoryCollectionHandler;
import is.idega.idegaweb.egov.cases.data.CaseCategory;
import is.idega.idegaweb.egov.cases.data.CaseType;
import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.focal.FocalConstants;
import is.idega.idegaweb.egov.cases.focal.IWBundleStarter;
import is.idega.idegaweb.egov.cases.focal.beans.FocalProjectList;
import is.idega.idegaweb.egov.cases.focal.business.ExportCasesManagement;
import is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegration;
import is.idega.idegaweb.egov.cases.focal.business.UnsuccessfulStatusException;
import is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.Customer;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.CustomerPersonalInfo;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.ProjectInfo;
import is.idega.idegaweb.egov.cases.presentation.MyCases;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.FinderException;

import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import com.idega.block.process.data.CaseLog;
import com.idega.block.process.data.CaseStatus;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.core.file.data.ICFile;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.PresentationObject;
import com.idega.presentation.Table2;
import com.idega.presentation.TableCell2;
import com.idega.presentation.TableColumn;
import com.idega.presentation.TableColumnGroup;
import com.idega.presentation.TableRow;
import com.idega.presentation.TableRowGroup;
import com.idega.presentation.remotescripting.RemoteScriptHandler;
import com.idega.presentation.text.Heading1;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.ListItem;
import com.idega.presentation.text.Lists;
import com.idega.presentation.text.Paragraph;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.CheckBox;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.HiddenInput;
import com.idega.presentation.ui.Label;
import com.idega.presentation.ui.TextArea;
import com.idega.presentation.ui.TextInput;
import com.idega.presentation.ui.util.SelectorUtility;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;
import com.idega.util.text.Name;
import com.idega.util.text.TextSoap;
import com.idega.webface.WFUtil;

public class FocalMyCases extends MyCases {
	
	public static final String PARAMETER_ACTION = "cp_prm_action";
	public static final String PARAMETER_CASE_PK = "prm_case_pk";
	public static final String PARAMETER_PROJECT_PK = "prm_project_pk";
	public static final String PARAMETER_PROJECT_SEARCH_KEY = "prm_project_search_key";
	public static final String PARAMETER_CUSTOMER_PK = "prm_customer_pk";
	public static final String PARAMETER_PROJECT_NAME = "prm_project_name";
	
	private static final String PARAMETER_CASE_CATEGORY_PK = "prm_case_category_pk";
	private static final String PARAMETER_SUB_CASE_CATEGORY_PK = "prm_sub_case_category_pk";
	private static final String PARAMETER_CASE_TYPE_PK = "prm_case_type_pk";
	
	private static final String FOCAL_JS = "/idegaweb/bundles/is.idega.idegaweb.egov.cases.focal.bundle/resources/javascript/focal.js";
	private static final String DWR_ENGINE_JS = "/dwr/engine.js";
	private static final String DWR_FOCAL_JS = "/dwr/interface/FocalCasesIntegration.js";

	protected static final int ACTION_VIEW = 1;
	protected static final int ACTION_PROCESS = 2;
	protected static final int ACTION_SAVE = 3;
	protected static final int ACTION_MOVE_FOCAL = 4;
	protected static final int ACTION_SAVE_FOCAL = 5;
	protected static final int ACTION_CREATE_CUSTOMER = 6;
	protected static final int ACTION_UPDATE_CUSTOMER = 7;
	
	private int parseAction(IWContext iwc) {
		if (iwc.isParameterSet(PARAMETER_ACTION)) {
			return Integer.parseInt(iwc.getParameter(PARAMETER_ACTION));
		}
		return ACTION_VIEW;
	}
	
	protected void present(IWContext iwc) throws Exception {
		AddResource resourceAdder = AddResourceFactory.getInstance(iwc);
		resourceAdder.addJavaScriptAtPosition(iwc, AddResource.HEADER_BEGIN, DWR_ENGINE_JS);
		resourceAdder.addJavaScriptAtPosition(iwc, AddResource.HEADER_BEGIN, DWR_FOCAL_JS);
		resourceAdder.addJavaScriptAtPosition(iwc, AddResource.HEADER_BEGIN, FOCAL_JS);
		
		String result = null;
		
		switch (parseAction(iwc)) {
			case ACTION_VIEW:
				showList(iwc, ACTION_VIEW, null);
				break;

			case ACTION_PROCESS:
				showProcessor(iwc, iwc.getParameter(PARAMETER_CASE_PK));
				break;

			case ACTION_SAVE:
				save(iwc);
				showList(iwc, ACTION_VIEW, null);
				break;
				
			case ACTION_MOVE_FOCAL:
				String values[] = iwc.getParameterValues(PARAMETER_CASE_PK);
				if(values != null && values.length > 0) {
					result = findProjects(iwc);
					showProjectSearch(iwc, ACTION_MOVE_FOCAL, result);
				} else {
					showList(iwc, ACTION_MOVE_FOCAL, null);
				}
				break;
				
			case ACTION_SAVE_FOCAL:
				result = saveToFocal(iwc);
				if(result.equals(FocalConstants.STATUS_SUCCESS_SAVE)) {
					showList(iwc, ACTION_SAVE_FOCAL, result);
				} else {
					showProjectSearch(iwc, ACTION_MOVE_FOCAL, result);
				}
				break;
				
			case ACTION_CREATE_CUSTOMER:
				result = createUpdateCustomer(iwc, false);
				showProjectSearch(iwc, ACTION_CREATE_CUSTOMER, result);
				break;
				
			case ACTION_UPDATE_CUSTOMER:
				result = createUpdateCustomer(iwc, true);
				showProjectSearch(iwc, ACTION_UPDATE_CUSTOMER, result);
				break;
		}
	}
	
	protected String findProjects(IWContext iwc) {
		try {
			List projects = new ArrayList();
			String searchKey = iwc.getParameter(PARAMETER_PROJECT_SEARCH_KEY);
			if(searchKey == null) {
				projects = getFocalCasesIntegration(iwc).findProjects("");
			} else {
				if(searchKey.equals("")) {
					projects = getFocalCasesIntegration(iwc).findProjects("");
				} else if(searchKey.equals("*")) {
					projects = getFocalCasesIntegration(iwc).findProjects("");
				} else {
					projects = getFocalCasesIntegration(iwc).findProjects(searchKey);
				}
			}
			FocalProjectList list = (FocalProjectList) WFUtil.getBeanInstance("focalProjectList");
			if(list != null) {
				list.setProjects(projects);
			}
			if(projects == null) {
				return FocalConstants.STATUS_ERROR_FIND_NOPROJECTS;
			}
			return FocalConstants.STATUS_SUCCESS_PROJECTS;
		} catch(UnsuccessfulStatusException use) {
			return FocalConstants.STATUS_ERROR_FIND_PROJECTS;
		} catch(Exception e) {
			return FocalConstants.STATUS_ERROR_FIND_PROJECTS;
		}
	}
	
	protected String createUpdateCustomer(IWContext iwc, boolean exist) {
		try {
			String customerId = iwc.getParameter(PARAMETER_CUSTOMER_PK);
			if(customerId != null && !customerId.equals("")) {
				CustomerPersonalInfo ci = getFocalCasesIntegration(iwc).createCustomerBean(customerId, iwc);		
				if(ci != null) {
					getFocalCasesIntegration(iwc).createUpdateCustomer(ci);
				}
			}
			if(exist) {
				return FocalConstants.STATUS_SUCCESS_UPDATE_CUSTOMER;
			} else {
				return FocalConstants.STATUS_SUCCESS_CREATE_CUSTOMER;
			}
		} catch(Exception e) {
			if(exist) {
				return FocalConstants.STATUS_ERROR_UPDATE_CUSTOMER;
			} else {
				return FocalConstants.STATUS_ERROR_CREATE_CUSTOMER;
			}
		}
	}
	
	protected String saveToFocal(IWContext iwc) {
		try {
			String projectId = iwc.getParameter(PARAMETER_PROJECT_PK);
			String projectName = iwc.getParameter(PARAMETER_PROJECT_NAME);
			if(projectId != null && !projectId.equals("") && projectName != null && !projectName.equals("")) {
				String[] pks = iwc.getParameterValues(PARAMETER_CASE_PK);
				
				List cases = new ArrayList();
				for(int i = 0; i < pks.length; i++) {
					GeneralCase theCase = getCasesBusiness(iwc).getGeneralCase(pks[i]);
					CaseArg ca = new CaseArg();
					ca.setGcase(theCase);
					cases.add(ca);	
				}
				getFocalCasesIntegration(iwc).createCasesUnderProject(projectId, projectName, cases);
				getExportCasesManagement(iwc).updateCasesExternalId(projectId, cases);
			}
			return FocalConstants.STATUS_SUCCESS_SAVE;
		} catch(Exception e) {
			return FocalConstants.STATUS_ERROR_SAVE;
		}
	}
	
	private Layer getConfirmationBox(IWContext iwc, String result) {
		Layer errorSection = new Layer(Layer.DIV);
		errorSection.setStyleClass("receipt");
		
		Layer icon = new Layer(Layer.DIV);
		icon.setStyleClass("receiptImage");
		errorSection.add(icon);
		
		Heading1 heading = new Heading1(getResourceBundle(iwc).getLocalizedString(result + FocalConstants.TITLE_POSTFIX, "Operation successful"));
		errorSection.add(heading);
		
		Paragraph message = new Paragraph();
		message.addText(getResourceBundle(iwc).getLocalizedString(result + FocalConstants.MESSAGE_POSTFIX, ""));
		errorSection.add(message);
		
		return errorSection;
	}
	
	private Layer getErrorNotificationBox(IWContext iwc, String result) {
		Layer errorSection = new Layer(Layer.DIV);
		errorSection.setStyleClass("errorLayer");
		
		Layer icon = new Layer(Layer.DIV);
		icon.setStyleClass("errorImage");
		errorSection.add(icon);
		
		Heading1 heading = new Heading1(getResourceBundle(iwc).getLocalizedString(result + FocalConstants.TITLE_POSTFIX, "Error occured"));
		errorSection.add(heading);
		
		Paragraph message = new Paragraph();
		message.addText(getResourceBundle(iwc).getLocalizedString(result + FocalConstants.MESSAGE_POSTFIX, ""));
		errorSection.add(message);
		
		return errorSection;
	} 
	
	protected void showProjectSearch(IWContext iwc, int action, String result) {
		Form form = new Form();
		form.setId("focalProjectSearchForm");
		form.addParameter(PARAMETER_ACTION, "");
		form.addParameter(PARAMETER_PROJECT_PK, "");
		form.addParameter(PARAMETER_PROJECT_NAME, "");
		form.addParameter(PARAMETER_CUSTOMER_PK, "");
		form.maintainParameter(PARAMETER_CASE_PK);
		
		if(result != null) {
			if(FocalConstants.STATUS_ERROR_SAVE.equals(result)) {			
				form.add(getErrorNotificationBox(iwc, result));
			} else if(FocalConstants.STATUS_SUCCESS_UPDATE_CUSTOMER.equals(result)) {
				form.add(getConfirmationBox(iwc, result));
			} else if(FocalConstants.STATUS_SUCCESS_CREATE_CUSTOMER.equals(result)) {
				form.add(getConfirmationBox(iwc, result));
			} else if(FocalConstants.STATUS_ERROR_UPDATE_CUSTOMER.equals(result)) {
				form.add(getErrorNotificationBox(iwc, result));
			} else if(FocalConstants.STATUS_ERROR_CREATE_CUSTOMER.equals(result)) {
				form.add(getErrorNotificationBox(iwc, result));
			} else if(FocalConstants.STATUS_ERROR_FIND_PROJECTS.equals(result)) {
				form.add(getErrorNotificationBox(iwc, result));
			}
		}
		
		Layer projectSection = new Layer(Layer.DIV);
		projectSection.setStyleClass("formSection");
		
		Heading1 heading = new Heading1(getResourceBundle(iwc).getLocalizedString("find_project_focal_label", "Find project in Focal"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		projectSection.add(heading);
		
		Layer searchSection = new Layer(Layer.DIV);
		searchSection.setStyleClass("searchSection");
		
		TextInput searchField = new TextInput();
		searchField.setLabel("Search text");
		searchField.setName(PARAMETER_PROJECT_SEARCH_KEY);
//		searchField.setOnKeyUp("doProjectSearch(this.value);");
		searchField.setOnKeyPress("searchProjects(event);");
		searchSection.add(searchField);
		
		String noProjectAlert = getResourceBundle(iwc).getLocalizedString("focal.alert.noproject", "Please select a project");
		
		Link next = getButtonLink(getResourceBundle(iwc).getLocalizedString("find_project_focal", "Find projects"));
		next.setStyleClass("searchButton");
		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_MOVE_FOCAL));
		
		next.setToFormSubmit(form);
		searchSection.add(next);
		
		projectSection.add(searchSection);
		
		Layer tableSection = new Layer(Layer.DIV);
		tableSection.setStyleClass("tableSection");

		Table2 table = new Table2();
		table.setWidth("100%");
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setStyleClass("adminTable");
		table.setStyleClass("ruler");
		table.setID("projectTable");

		TableColumnGroup columnGroup = table.createColumnGroup();
		TableColumn column = columnGroup.createColumn();
		column.setSpan(6);
		column = columnGroup.createColumn();
		column.setSpan(1);
		column.setWidth("12");

		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();

		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("firstColumn");
		cell.setStyleClass("caseNumber");
		cell.add(new Text(getResourceBundle(iwc).getLocalizedString("focal_project_name", "Project name")));

		cell = row.createHeaderCell();
		cell.setStyleClass("sender");
		cell.add(new Text(getResourceBundle(iwc).getLocalizedString("focal_customer_id", "Customer")));

		group = table.createBodyRowGroup();
		
		List projects = ((FocalProjectList) WFUtil.getBeanInstance("focalProjectList")).getProjects();
		if(projects != null) {
			Iterator iter = projects.iterator();
			while (iter.hasNext()) {
				ProjectInfo theProject = (ProjectInfo) iter.next();
				int iRow = 1;
				row = group.createRow();
				String projectId = theProject.getNumber();
				String projectIdFixed = projectId.replaceAll("/", "-");
				row.setId(projectIdFixed);
				row.setMarkupAttribute("onclick", "changeInputValue(findObj('" + PARAMETER_PROJECT_PK + "'), '" + projectId + "');changeInputValue(findObj('" + PARAMETER_PROJECT_NAME + "'), '" + theProject.getName() + "');selectFocalCasesRow(this.id);");
				if (iRow == 1) {
					row.setStyleClass("firstRow");
				}
				else if (!iter.hasNext()) {
					row.setStyleClass("lastRow");
				} else {
					row.setStyleClass("focalRow");
				}
				cell = row.createCell();
				cell.setStyleClass("firstColumn");
				cell.setStyleClass("caseNumber");
				cell.add(new Text(theProject.getName()));
				
				cell = row.createCell();
				cell.setStyleClass("lastColumn");
				cell.setStyleClass("caseNumber");
				cell.add(new Text(theProject.getCustomer()));
			}
		}
							
		tableSection.add(table);
		projectSection.add(tableSection);
		form.add(projectSection);
		
		Layer customerSection = new Layer(Layer.DIV);
		customerSection.setStyleClass("formSection");
		
		heading = new Heading1(getResourceBundle(iwc).getLocalizedString("focal_cases_tobemoved", "Cases to be moved"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		customerSection.add(heading);
		
		Table2 customerTable = new Table2();
		customerTable.setWidth("100%");
		customerTable.setCellpadding(0);
		customerTable.setCellspacing(0);
		customerTable.setStyleClass("adminTable");
		customerTable.setStyleClass("ruler");
		customerTable.setID("customerTable");

		TableColumnGroup cColumnGroup = customerTable.createColumnGroup();
		TableColumn cColumn = cColumnGroup.createColumn();
		cColumn.setSpan(6);
		cColumn = cColumnGroup.createColumn();
		cColumn.setSpan(1);
		cColumn.setWidth("12");

		TableRowGroup cGroup = customerTable.createHeaderRowGroup();
		TableRow cRow = cGroup.createRow();

		TableCell2 cCell = cRow.createHeaderCell();
		cCell.setStyleClass("firstColumn");
		cCell.setStyleClass("caseNumber");
		cCell.add(new Text(getResourceBundle(iwc).getLocalizedString("focal_case_nr", "Case Nr")));

		cCell = cRow.createHeaderCell();
		cCell.setStyleClass("sender");
		cCell.add(new Text(getResourceBundle(iwc).getLocalizedString("focal_customer_name", "Customer")));
		
		cCell = cRow.createHeaderCell();
		cCell.setStyleClass("action");
		cCell.add(new Text(getResourceBundle(iwc).getLocalizedString("focal_customer_action", "Create/Update")));
		
		cGroup = customerTable.createBodyRowGroup();
		
		String casesPKs[] = iwc.getParameterValues(PARAMETER_CASE_PK);
		List customers = new LinkedList();
		for(int i = 0; i < casesPKs.length; i++) {
			GeneralCase theCase = null;
			try {
				theCase = getBusiness().getGeneralCase(casesPKs[i]);
				User owner = theCase.getOwner();
				if(owner != null) {
					String id = owner.getPersonalID();
					if(!customers.contains(id)) {
						customers.add(id);
						
						cRow = cGroup.createRow();
						if (i == 1) {
							cRow.setStyleClass("firstRow");
						}
						else if (i == (casesPKs.length - 1)) {
							cRow.setStyleClass("lastRow");
						}
						
						cCell = cRow.createCell();
						cCell.setStyleClass("firstColumn");
						cCell.setStyleClass("caseNumber");
						cCell.add(new Text(theCase.getPrimaryKey().toString()));
						
						cCell = cRow.createCell();
						cCell.setStyleClass("sender");
						
						cCell.add(new Text(new Name(owner.getFirstName(), owner.getMiddleName(), owner.getLastName()).getName(iwc.getCurrentLocale())));
						
						cCell = cRow.createCell();
						cCell.setStyleClass("view");
						cCell.setStyleClass("lastColumn");
						
						if(id != null) {
							Customer customer = getFocalCasesIntegration(iwc).findCustomer(id);
							
							Link createCustomer = null;
							if(customer != null) {
								createCustomer = getButtonLink(getResourceBundle().getLocalizedString("update", "Update"));
								createCustomer.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_UPDATE_CUSTOMER));
							} else {
								createCustomer = getButtonLink(getResourceBundle().getLocalizedString("create", "Create"));
								createCustomer.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_CREATE_CUSTOMER));
							}
							createCustomer.setOnClick("changeInputValue(findObj('" + PARAMETER_CUSTOMER_PK + "'), '" + id + "');");
							createCustomer.setStyleClass("homeButton");
							
							createCustomer.setToFormSubmit(form);
							cCell.add(createCustomer);
						}
					}
					
				}
			} catch(Exception e) {
				e.printStackTrace();
				//TODO
			}
		}
		
		customerSection.add(customerTable);
		form.add(customerSection);
		
		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);
		
		Link save = getButtonLink(getResourceBundle().getLocalizedString("save", "Save to Focal"));
		save.setStyleClass("homeButton");
//		save.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_SAVE_FOCAL));
		save.setOnClick("if(isProjectSelected()) {changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_SAVE_FOCAL + "');} else {alert('" + noProjectAlert + "');return false;}");
		save.setToFormSubmit(form);
		bottom.add(save);

		Link back = getButtonLink(getResourceBundle().getLocalizedString("back", "Back"));
		back.setStyleClass("homeButton");
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_VIEW));
		back.setToFormSubmit(form);
		bottom.add(back);
		
		add(form);
	}
	
	private void showList(IWContext iwc, int action, String result) throws RemoteException {
		Form form = new Form();
		form.addParameter(PARAMETER_ACTION, "");
		
		Layer casesSection = new Layer(Layer.DIV);
		casesSection.setStyleClass("formSection");

		Table2 table = new Table2();
		table.setWidth("100%");
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setStyleClass("adminTable");
		table.setStyleClass("ruler");
		table.setID(getBlockID());

		TableColumnGroup columnGroup = table.createColumnGroup();
		TableColumn column = columnGroup.createColumn();
		column.setSpan(6);
		column = columnGroup.createColumn();
		column.setSpan(1);
		column.setWidth("12");
		Collection cases = getCases(iwc.getCurrentUser());

		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();

		boolean showCheckBoxes = true;
		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("firstColumn");
		cell.setStyleClass("caseNumber");
		cell.add(new Text(getResourceBundle().getLocalizedString("case_nr", "Case nr.")));

		cell = row.createHeaderCell();
		cell.setStyleClass("sender");
		cell.add(new Text(getResourceBundle().getLocalizedString("sender", "Sender")));

		if (getBusiness().useTypes()) {
			cell = row.createHeaderCell();
			cell.setStyleClass("caseType");
			cell.add(new Text(getResourceBundle().getLocalizedString("case_type", "Case type")));
		}

		cell = row.createHeaderCell();
		cell.setStyleClass("createdDate");
		cell.add(new Text(getResourceBundle().getLocalizedString("created_date", "Created date")));

		cell = row.createHeaderCell();
		cell.setStyleClass("status");
		cell.add(new Text(getResourceBundle().getLocalizedString("status", "Status")));

		cell = row.createHeaderCell();
		cell.setStyleClass("handler");
		cell.add(new Text(getResourceBundle().getLocalizedString("handler", "Handler")));

		cell = row.createHeaderCell();
		if (!showCheckBoxes) {
			cell.setStyleClass("lastColumn");
		}
		cell.setStyleClass("view");
		cell.add(new Text(getResourceBundle().getLocalizedString("view", "View")));

		cell = row.createHeaderCell();
		cell.setStyleClass("lastColumn");
		cell.setStyleClass("multiHandle");
		cell.add(Text.getNonBrakingSpace());

		group = table.createBodyRowGroup();
		int iRow = 1;

		Iterator iter = cases.iterator();
		while (iter.hasNext()) {
			GeneralCase theCase = (GeneralCase) iter.next();
			CaseStatus status = theCase.getCaseStatus();
			CaseType type = theCase.getCaseType();
			User owner = theCase.getOwner();
			IWTimestamp created = new IWTimestamp(theCase.getCreated());

			row = group.createRow();
			if (iRow == 1) {
				row.setStyleClass("firstRow");
			}
			else if (!iter.hasNext()) {
				row.setStyleClass("lastRow");
			}
			if (theCase.isPrivate()) {
				row.setStyleClass("isPrivate");
			}
			if (theCase.getExternalId() != null && !theCase.getExternalId().equals("")) {
				row.setStyleClass("isInFocal");
			}
			if (status.equals(getCasesBusiness(iwc).getCaseStatusReview())) {
				row.setStyleClass("isReview");
			}

			cell = row.createCell();
			cell.setStyleClass("firstColumn");
			cell.setStyleClass("caseNumber");
			cell.add(new Text(theCase.getPrimaryKey().toString()));

			cell = row.createCell();
			cell.setStyleClass("sender");
			if (owner != null) {
				cell.add(new Text(new Name(owner.getFirstName(), owner.getMiddleName(), owner.getLastName()).getName(iwc.getCurrentLocale())));
			}
			else {
				cell.add(new Text("-"));
			}

			if (getBusiness().useTypes()) {
				cell = row.createCell();
				cell.setStyleClass("caseType");
				cell.add(new Text(type.getName()));
			}

			cell = row.createCell();
			cell.setStyleClass("createdDate");
			cell.add(new Text(created.getLocaleDateAndTime(iwc.getCurrentLocale(), IWTimestamp.SHORT, IWTimestamp.SHORT)));

			cell = row.createCell();
			cell.setStyleClass("status");
			cell.add(new Text(getBusiness().getLocalizedCaseStatusDescription(theCase, status, iwc.getCurrentLocale())));

			User handler = theCase.getHandledBy();
			cell = row.createCell();
			cell.setStyleClass("handler");
			if (handler != null) {
				cell.add(new Text(new Name(handler.getFirstName(), handler.getMiddleName(), handler.getLastName()).getName(iwc.getCurrentLocale())));
			}
			else {
				cell.add(new Text("-"));
			}

			cell = row.createCell();
			cell.setStyleClass("view");
			Link edit = getProcessLink(getBundle().getImage("edit.png", getResourceBundle().getLocalizedString("view_case", "View case")), theCase);
			cell.add(edit);
			
			

			cell = row.createCell();
			cell.setStyleClass("firstColumn");
			cell.setStyleClass("multiHandle");
			if (theCase.getExternalId() == null) {
				CheckBox box = new CheckBox(PARAMETER_CASE_PK, theCase.getPrimaryKey().toString());
				cell.add(box);
			}

			if (iRow % 2 == 0) {
				row.setStyleClass("evenRow");
			}
			else {
				row.setStyleClass("oddRow");
			}
		}
		casesSection.add(table);
		form.add(casesSection);
		
		Layer legendSection = new Layer(Layer.DIV);
		legendSection.setStyleClass("formSection");
		legendSection.add(getLegend(iwc));
		
		form.add(legendSection);
		
		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link back = getButtonLink(getResourceBundle().getLocalizedString("move_focal", "Move to Focal"));
		back.setStyleClass("homeButton");
		back.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + String.valueOf(ACTION_MOVE_FOCAL) + "');");
		back.setToFormSubmit(form);
		bottom.add(back);

		add(form);
	}
	
	protected Lists getLegend(IWContext iwc) throws RemoteException {
		Lists list = super.getLegend(iwc);

		list.setStyleClass("formSection");
		ListItem item = new ListItem();
		item.setStyleClass("isInFocal");
		item.add(new Text(getResourceBundle().getLocalizedString("legend.is_inFocal", "Is In Focal")));
		list.add(item);

		return list;
	}
	
	protected void showProcessor(IWContext iwc, Object casePK) throws RemoteException {
		Form form = new Form();
		form.setStyleClass("adminForm");
		form.setStyleClass("overview");
		form.maintainParameter(PARAMETER_CASE_PK);
		form.addParameter(PARAMETER_ACTION, "");

		boolean useSubCategories = getCasesBusiness(iwc).useSubCategories();

		GeneralCase theCase = null;
		try {
			theCase = getBusiness().getGeneralCase(casePK);
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
		DropdownMenu categories = (DropdownMenu) util.getSelectorFromIDOEntities(new DropdownMenu(PARAMETER_CASE_CATEGORY_PK), getBusiness().getCaseCategories(), "getName");
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

		DropdownMenu types = (DropdownMenu) util.getSelectorFromIDOEntities(new DropdownMenu(PARAMETER_CASE_TYPE_PK), getBusiness().getCaseTypes(), "getName");
		types.keepStatusOnAction(true);
		types.setSelectedElement(type.getPrimaryKey().toString());
		types.setStyleClass("caseTypeDropdown");

		HiddenInput hiddenType = new HiddenInput(PARAMETER_CASE_TYPE_PK, type.getPrimaryKey().toString());

		DropdownMenu statuses = new DropdownMenu(PARAMETER_STATUS);
		statuses.addMenuElement(getBusiness().getCaseStatusPending().getStatus(), getBusiness().getLocalizedCaseStatusDescription(theCase, getBusiness().getCaseStatusPending(), iwc.getCurrentLocale()));
		statuses.addMenuElement(getBusiness().getCaseStatusWaiting().getStatus(), getBusiness().getLocalizedCaseStatusDescription(theCase, getBusiness().getCaseStatusWaiting(), iwc.getCurrentLocale()));
		statuses.addMenuElement(getBusiness().getCaseStatusReady().getStatus(), getBusiness().getLocalizedCaseStatusDescription(theCase, getBusiness().getCaseStatusReady(), iwc.getCurrentLocale()));
		statuses.setSelectedElement(theCase.getStatus());
		statuses.setStyleClass("caseStatusDropdown");

		Layer message = new Layer(Layer.SPAN);
		message.add(new Text(TextSoap.formatText(theCase.getMessage())));

		Layer createdDate = new Layer(Layer.SPAN);
		createdDate.add(new Text(created.getLocaleDateAndTime(iwc.getCurrentLocale(), IWTimestamp.SHORT, IWTimestamp.SHORT)));

		TextArea reply = new TextArea(PARAMETER_REPLY);
		reply.setStyleClass("textarea");
		reply.keepStatusOnAction(true);

		if (getBusiness().useTypes()) {
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
	
	private Link getProcessLink(PresentationObject object, GeneralCase theCase) {
		Link process = new Link(object);
		process.addParameter(PARAMETER_CASE_PK, theCase.getPrimaryKey().toString());
		process.addParameter(PARAMETER_ACTION, ACTION_PROCESS);

		return process;
	}
	
	protected FocalCasesIntegration getFocalCasesIntegration(IWApplicationContext iwac) {
		try {
			return (FocalCasesIntegration) IBOLookup.getServiceInstance(iwac, FocalCasesIntegration.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}
	
	protected UserBusiness getUserBusiness(IWApplicationContext iwac) {
		try {
			return (UserBusiness) IBOLookup.getServiceInstance(iwac, UserBusiness.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}
	
	protected ExportCasesManagement getExportCasesManagement(IWApplicationContext iwac) {
		try {
			return (ExportCasesManagement) IBOLookup.getServiceInstance(iwac, ExportCasesManagement.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}
	
	public String getBundleIdentifier() {
		return IWBundleStarter.IW_BUNDLE_IDENTIFIER;
	}
}