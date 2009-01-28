package is.idega.idegaweb.egov.cases.focal.presentation;

import com.idega.presentation.Block;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.Table2;
import com.idega.presentation.TableCell2;
import com.idega.presentation.TableColumn;
import com.idega.presentation.TableColumnGroup;
import com.idega.presentation.TableRow;
import com.idega.presentation.TableRowGroup;
import com.idega.presentation.text.Heading1;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.TextInput;
import com.idega.util.PresentationUtil;

public class FocalCaseMover extends Block {

	public static final String PARAMETER_ACTION = "cp_prm_action";

	protected static final int ACTION_CASE_PROCESS = 1;
	protected static final int ACTION_MULTI_CASE_PROCESS = 2;

	protected boolean multipleParty = false;

	private int parseAction(IWContext iwc) {
		if (iwc.isParameterSet(PARAMETER_ACTION)) {
			return Integer.parseInt(iwc.getParameter(PARAMETER_ACTION));
		}
		return ACTION_CASE_PROCESS;
	}

	@Override
	public void main(IWContext iwc) throws Exception {
		PresentationUtil.addStyleSheetToHeader(iwc, iwc.getIWMainApplication().getBundle("is.idega.idegaweb.egov.application").getVirtualPathWithFileNameString("style/application.css"));
		present(iwc);
	}

	protected void present(IWContext iwc) throws Exception {
		switch (parseAction(iwc)) {
			case ACTION_CASE_PROCESS:
				multipleParty = false;
				break;
			case ACTION_MULTI_CASE_PROCESS:
				multipleParty = true;
				break;
		}
		showProjectSearch(iwc, multipleParty);
	}

	protected void showProjectSearch(IWContext iwc, boolean multipleParty) {
		Form form = new Form();
		//		form.addParameter(PARAMETER_ACTION, ACTION_MULTI_PROCESS_FORM);

		Layer projectSection = new Layer(Layer.DIV);
		projectSection.setStyleClass("formSection");

		Heading1 heading = new Heading1(getResourceBundle(iwc).getLocalizedString("find_project_focal_label", "Find project in Focal"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		projectSection.add(heading);

		TextInput searchField = new TextInput();
		searchField.setLabel("Search text");
		projectSection.add(searchField);

		Link next = getButtonLink(getResourceBundle(iwc).getLocalizedString("find", "Find"));
		//		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_SAVE));
		next.setToFormSubmit(form);
		projectSection.add(next);

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

		//		Collection cases = getCases(iwc.getCurrentUser());

		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();

		//		boolean showCheckBoxes = showCheckBox() && getCasesBusiness(iwc).allowAnonymousCases();
		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("firstColumn");
		cell.setStyleClass("caseNumber");
		cell.add(new Text(getResourceBundle(iwc).getLocalizedString("focal_project_name", "Project name")));

		cell = row.createHeaderCell();
		cell.setStyleClass("sender");
		cell.add(new Text(getResourceBundle(iwc).getLocalizedString("sender", "Customer")));

		//		if (getBusiness().useTypes()) {
		//			cell = row.createHeaderCell();
		//			cell.setStyleClass("caseType");
		//			cell.add(new Text(getResourceBundle(iwc).getLocalizedString("case_type", "Case type")));
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
		//		if (showCheckBoxes) {
		//			cell = row.createHeaderCell();
		//			cell.setStyleClass("lastColumn");
		//			cell.setStyleClass("multiHandle");
		//			cell.add(Text.getNonBrakingSpace());
		//		}

		group = table.createBodyRowGroup();

		//		List

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
		//			if (!showCheckBoxes) {
		//				cell.setStyleClass("lastColumn");
		//			}
		//			cell.setStyleClass("view");
		//			cell.add(getProcessLink(getBundle().getImage("edit.png", getResourceBundle().getLocalizedString(getPrefix() + "view_case", "View case")), theCase));
		//
		//			if (showCheckBoxes) {
		//				CheckBox box = new CheckBox(PARAMETER_CASE_PK, theCase.getPrimaryKey().toString());
		//
		//				cell = row.createCell();
		//				cell.setStyleClass("firstColumn");
		//				cell.setStyleClass("multiHandle");
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

		projectSection.add(table);
		//		form.add(getLegend(iwc));

		//		if (showCheckBoxes) {
		//			Layer layer = new Layer();
		//			layer.setStyleClass("buttonLayer");
		//			layer.setStyleClass("multiProcessLayer");
		//			form.add(layer);
		//
		//			SubmitButton multiProcess = new SubmitButton(getResourceBundle().getLocalizedString("multi_process", "Multi process"), PARAMETER_ACTION, String.valueOf(ACTION_MULTI_PROCESS_FORM));
		//			multiProcess.setStyleClass("button");
		//			layer.add(multiProcess);
		//		}
		form.add(projectSection);

		Layer customerSection = new Layer(Layer.DIV);
		customerSection.setStyleClass("formSection");

		heading = new Heading1(getResourceBundle(iwc).getLocalizedString("focal_cases_tobemoved", "Cases to be moved"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		customerSection.add(heading);

		table = new Table2();
		table.setWidth("100%");
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setStyleClass("adminTable");
		table.setStyleClass("ruler");
		table.setID("customerTable");

		columnGroup = table.createColumnGroup();
		column = columnGroup.createColumn();
		column.setSpan(6);
		column = columnGroup.createColumn();
		column.setSpan(1);
		column.setWidth("12");

		//		Collection cases = getCases(iwc.getCurrentUser());

		group = table.createHeaderRowGroup();
		row = group.createRow();

		//		boolean showCheckBoxes = showCheckBox() && getCasesBusiness(iwc).allowAnonymousCases();
		cell = row.createHeaderCell();
		cell.setStyleClass("firstColumn");
		cell.setStyleClass("caseNumber");
		cell.add(new Text(getResourceBundle(iwc).getLocalizedString("focal_case_name", "Case name")));

		cell = row.createHeaderCell();
		cell.setStyleClass("sender");
		cell.add(new Text(getResourceBundle(iwc).getLocalizedString("sender", "Customer")));

		customerSection.add(table);
		form.add(customerSection);
		add(form);
	}

	protected Link getButtonLink(String text) {
		Layer all = new Layer(Layer.SPAN);
		all.setStyleClass("buttonSpan");

		Layer left = new Layer(Layer.SPAN);
		left.setStyleClass("left");
		all.add(left);

		Layer middle = new Layer(Layer.SPAN);
		middle.setStyleClass("middle");
		middle.add(new Text(text));
		all.add(middle);

		Layer right = new Layer(Layer.SPAN);
		right.setStyleClass("right");
		all.add(right);

		Link link = new Link(all);
		link.setStyleClass("button");

		return link;
	}

}
