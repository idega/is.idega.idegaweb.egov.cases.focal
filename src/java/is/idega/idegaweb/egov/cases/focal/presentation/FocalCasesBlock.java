package is.idega.idegaweb.egov.cases.focal.presentation;

import is.idega.block.nationalregister.business.NationalRegisterBusiness;
import is.idega.block.nationalregister.data.NationalRegister;
import is.idega.block.nationalregister.data.NationalRegisterHome;
import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.focal.FocalConstants;
import is.idega.idegaweb.egov.cases.focal.IWBundleStarter;
import is.idega.idegaweb.egov.cases.focal.beans.FocalProjectList;
import is.idega.idegaweb.egov.cases.focal.business.ExportCasesManagement;
import is.idega.idegaweb.egov.cases.focal.business.FocalCasesIntegration;
import is.idega.idegaweb.egov.cases.focal.business.UnsuccessfulStatusException;
import is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg;
import is.idega.idegaweb.egov.cases.focal.business.beans.CompanyInfo;
import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECT;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.CustomerPersonalInfo;
import is.idega.idegaweb.egov.cases.presentation.CasesProcessor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.idega.block.process.data.CaseStatus;
import com.idega.block.process.presentation.beans.CasePresentation;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.company.companyregister.business.CompanyRegisterBusiness;
import com.idega.company.data.Company;
import com.idega.company.data.CompanyHome;
import com.idega.core.location.business.CommuneBusiness;
import com.idega.core.location.data.Commune;
import com.idega.data.IDOLookup;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.PresentationObject;
import com.idega.presentation.Script;
import com.idega.presentation.Table2;
import com.idega.presentation.TableCell2;
import com.idega.presentation.TableColumn;
import com.idega.presentation.TableColumnGroup;
import com.idega.presentation.TableRow;
import com.idega.presentation.TableRowGroup;
import com.idega.presentation.text.Heading1;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.ListItem;
import com.idega.presentation.text.Lists;
import com.idega.presentation.text.Paragraph;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.CheckBox;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.Label;
import com.idega.presentation.ui.RadioButton;
import com.idega.presentation.ui.TextArea;
import com.idega.presentation.ui.TextInput;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.User;
import com.idega.util.CoreConstants;
import com.idega.util.IWTimestamp;
import com.idega.util.ListUtil;
import com.idega.util.StringUtil;
import com.idega.util.expression.ELUtil;
import com.idega.util.text.Name;
import com.idega.webface.WFUtil;

public abstract class FocalCasesBlock extends CasesProcessor {

	private Logger logger = Logger.getLogger(FocalCasesBlock.class.getName());

	protected static final String PARAMETER_PROJECT_PK = "prm_project_pk";
	protected static final String PARAMETER_PROJECT_SEARCH_KEY = "prm_project_search_key";
	protected static final String PARAMETER_PROJECT_NAME = "prm_project_name";
	protected static final String PARAMETER_COMPANY_ID = "prm_company_id";

	protected static final String PARAMETER_ADDRESS1 = "prm_address_1";
	protected static final String PARAMETER_ADDRESS2 = "prm_address_2";
	protected static final String PARAMETER_COMPANY_NAME = "prm_company_name";
	protected static final String PARAMETER_COUNTY = "prm_county";
	protected static final String PARAMETER_COUNTRY = "prm_country";
	protected static final String PARAMETER_EMAIL = "prm_email";
	protected static final String PARAMETER_FAX = "prm_fax";
	protected static final String PARAMETER_HOMEPAGE = "prm_homepage";
	protected static final String PARAMETER_LANGUAGE = "prm_language";
	protected static final String PARAMETER_LOCATION = "prm_location";
	protected static final String PARAMETER_PHONE_WORK = "prm_phone_work";
	protected static final String PARAMETER_PHONE_HOME = "prm_phone_home";
	protected static final String PARAMETER_PHONE_OFFICE = "prm_phone_office";
	protected static final String PARAMETER_POST_ADDRESS = "prm_post_address";
	protected static final String PARAMETER_SOC_NUMBER = "prm_soc_number";
	protected static final String PARAMETER_AVARP = "prm_avarp";
	protected static final String PARAMETER_PERSON_NAME = "prm_person_name";
	protected static final String PARAMETER_BEEPER = "prm_beeper1";
	protected static final String PARAMETER_DEPARTMENT = "prm_department";
	protected static final String PARAMETER_CARPHONE = "prm_carphone";
	protected static final String PARAMETER_FAXOFFICE = "prm_fax_office";
	protected static final String PARAMETER_CONTACT_SEPERATOR = "prm_contact_separator";
	protected static final String PARAMETER_GSM = "prm_gsm";
	protected static final String PARAMETER_TITLE = "prm_title";
	protected static final String PARAMETER_TARGET_MAIL = "prm_target_mail";

	protected static final String FOCAL_JS = "/idegaweb/bundles/is.idega.idegaweb.egov.cases.focal.bundle/resources/javascript/focal.js";

	protected static final int ACTION_MOVE_FOCAL = 4;
	protected static final int ACTION_SAVE_FOCAL = 5;
	protected static final int ACTION_UPDATE_PERSON = 6;
	protected static final int ACTION_CREATE_COMPANY = 8;
	protected static final int ACTION_SAVE_COMPANY = 9;
	protected static final int ACTION_SEARCH_COMPANY = 10;
	protected static final int ACTION_SAVE_PERSON = 11;
	protected static final int ACTION_CREATE_PERSON = 12;
	protected static final int ACTION_SEARCH_PERSON = 13;

	@Override
	protected void present(IWContext iwc) throws Exception {
		Script script = new Script();
		script.setScriptSource(FOCAL_JS);
		//		AddResource resourceAdder = AddResourceFactory.getInstance(iwc);
		//		resourceAdder.addJavaScriptAtPosition(iwc, AddResource.HEADER_BEGIN, FOCAL_JS);

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
				if (values != null && values.length > 0) {
					result = findProjects(iwc);
					showProjectSearch(iwc, ACTION_MOVE_FOCAL, result);
				}
				else {
					showList(iwc, ACTION_MOVE_FOCAL, null);
				}
				break;

			case ACTION_SAVE_FOCAL:
				result = saveToFocal(iwc);
				if (result.equals(FocalConstants.STATUS_SUCCESS_SAVE)) {
					showList(iwc, ACTION_SAVE_FOCAL, result);
				}
				else {
					showProjectSearch(iwc, ACTION_MOVE_FOCAL, result);
				}
				break;

			case ACTION_CREATE_COMPANY:
				showCreateCustomer(iwc, ACTION_CREATE_COMPANY, null, null, true);
				break;

			case ACTION_CREATE_PERSON:
				showCreateCustomer(iwc, ACTION_CREATE_PERSON, null, null, false);
				break;

			case ACTION_UPDATE_PERSON:
				showCreateCustomer(iwc, ACTION_UPDATE_PERSON, null, searchPerson(iwc), false);
				break;

			case ACTION_SAVE_COMPANY:
				result = saveCompany(iwc);
				showProjectSearch(iwc, ACTION_MOVE_FOCAL, result);
				break;

			case ACTION_SAVE_PERSON:
				result = savePerson(iwc);
				showProjectSearch(iwc, ACTION_MOVE_FOCAL, result);
				break;

			case ACTION_SEARCH_COMPANY:
				Company company = searchCompany(iwc);
				showCreateCustomer(iwc, ACTION_SEARCH_COMPANY, company, null, false);
				break;

			case ACTION_SEARCH_PERSON:
				NationalRegister natReg = searchPerson(iwc);
				showCreateCustomer(iwc, ACTION_SEARCH_PERSON, null, natReg, false);
				break;

		}
		add(script);
	}

	protected NationalRegister searchPerson(IWContext iwc) {
		try {
			String searchKey = iwc.getParameter(PARAMETER_COMPANY_ID);
			if (searchKey == null || searchKey.equals("")) {
				throw new Exception("Search parameter empty");
			}
			NationalRegister customer = getNationalRegisterBusiness(iwc).getEntryBySSN(searchKey);
			return customer;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Exception while searching for a person", e);
			return null;
		}
	}

	protected Company searchCompany(IWContext iwc) {
		try {
			String searchKey = iwc.getParameter(PARAMETER_COMPANY_ID);
			if (searchKey != null && !searchKey.equals("")) {
				Company customer = getCompanyRegisterBusiness(iwc).getEntryByPersonalId(searchKey);
				return customer;
			}
			return null;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Exception while searching for a company", e);
			return null;
		}
	}

	protected String savePerson(IWContext iwc) {
		try {
			CustomerPersonalInfo bean = new CustomerPersonalInfo();
			bean.setTITLE(iwc.getParameter(PARAMETER_TITLE));
			bean.setGSM(iwc.getParameter(PARAMETER_GSM));
			bean.setFAXOFFICE(iwc.getParameter(PARAMETER_FAXOFFICE));
			bean.setAVARP(iwc.getParameter(PARAMETER_AVARP));
			bean.setBEEPER(iwc.getParameter(PARAMETER_BEEPER));
			bean.setCARPHONE(iwc.getParameter(PARAMETER_CARPHONE));
			bean.setCONTACTSEPERATOR("");
			bean.setJOBSTATUS(iwc.getParameter(PARAMETER_STATUS));
			bean.setPHONEHOME(iwc.getParameter(PARAMETER_PHONE_HOME));
			bean.setPHONEOFFICE(iwc.getParameter(PARAMETER_PHONE_OFFICE));
			bean.setADDRESS1(iwc.getParameter(PARAMETER_ADDRESS1));
			bean.setADDRESS2(iwc.getParameter(PARAMETER_ADDRESS2));
			bean.setCUSTOMERNAME(iwc.getParameter(PARAMETER_PERSON_NAME));
			bean.setCOUNTY(iwc.getParameter(PARAMETER_COUNTY));
			bean.setCOUNTRY(iwc.getParameter(PARAMETER_COUNTRY));
			bean.setEMAILADDRESS(iwc.getParameter(PARAMETER_EMAIL));
			bean.setFAX(iwc.getParameter(PARAMETER_FAX));
			bean.setHOMEPAGE(iwc.getParameter(PARAMETER_HOMEPAGE));
			bean.setLANGUAGE(iwc.getParameter(PARAMETER_LANGUAGE));
			bean.setPHONEWORK(iwc.getParameter(PARAMETER_PHONE_WORK));
			bean.setPOSTADDRESS(iwc.getParameter(PARAMETER_POST_ADDRESS));
			bean.setSocNr(iwc.getParameter(PARAMETER_SOC_NUMBER));
			bean.setTargetMail(iwc.isParameterSet(PARAMETER_TARGET_MAIL) ? new Boolean(iwc.getParameter(PARAMETER_TARGET_MAIL)).booleanValue() : false);
			Status status = getFocalCasesIntegration(iwc).createUpdateCustomer(bean);
			if (status.getStatus().intValue() == 0) {
				return FocalConstants.STATUS_SUCCESS_SAVE_CUSTOMER;
			}
			else {
				return FocalConstants.STATUS_ERROR_SAVE_CUSTOMER;
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Exception while creating customer", e);
			return FocalConstants.STATUS_ERROR_SAVE_CUSTOMER;
		}
	}

	protected String saveCompany(IWContext iwc) {
		try {
			CompanyInfo bean = new CompanyInfo();
			bean.setAddress1(iwc.getParameter(PARAMETER_ADDRESS1));
			bean.setAddress2(iwc.getParameter(PARAMETER_ADDRESS2));
			bean.setCompanyName(iwc.getParameter(PARAMETER_COMPANY_NAME));
			bean.setCounty(iwc.getParameter(PARAMETER_COUNTY));
			bean.setCountry(iwc.getParameter(PARAMETER_COUNTRY));
			bean.setEmail(iwc.getParameter(PARAMETER_EMAIL));
			bean.setFax(iwc.getParameter(PARAMETER_FAX));
			bean.setHomepage(iwc.getParameter(PARAMETER_HOMEPAGE));
			bean.setLanguage(iwc.getParameter(PARAMETER_LANGUAGE));
			bean.setLocation(iwc.getParameter(PARAMETER_LOCATION));
			bean.setPhoneWork(iwc.getParameter(PARAMETER_PHONE_WORK));
			bean.setPostAddress(iwc.getParameter(PARAMETER_POST_ADDRESS));
			bean.setSocNumber(iwc.getParameter(PARAMETER_SOC_NUMBER));
			bean.setStatus(iwc.getParameter(PARAMETER_STATUS));
			bean.setTargetMail(iwc.isParameterSet(PARAMETER_TARGET_MAIL) ? new Boolean(iwc.getParameter(PARAMETER_TARGET_MAIL)).booleanValue() : false);
			Status status = getFocalCasesIntegration(iwc).createCompany(bean);
			if (status.getStatus().intValue() == 0) {
				return FocalConstants.STATUS_SUCCESS_CREATE_COMPANY;
			}
			else {
				return FocalConstants.STATUS_ERROR_CREATE_COMPANY;
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Exception while creating customer", e);
			return FocalConstants.STATUS_ERROR_CREATE_COMPANY;
		}
	}

	protected void showCreateCustomer(IWContext iwc, int action, Company company, NationalRegister natReg, boolean searchForCompany) throws RemoteException {
		Form form = new Form();
		form.setId("focalProjectSearchForm");
		form.addParameter(PARAMETER_ACTION, "");
		form.maintainParameter(PARAMETER_CASE_PK);

		Layer projectSection = new Layer(Layer.DIV);
		projectSection.setStyleClass("formSection");

		boolean isCompany = false;
		if (action == ACTION_SEARCH_COMPANY) {
			isCompany = true;
		}

		if (company == null && natReg == null && action != ACTION_SEARCH_COMPANY && action != ACTION_SEARCH_PERSON) {
			Heading1 heading = null;
			if (searchForCompany) {
				heading = new Heading1(getResourceBundle().getLocalizedString("company_information", "Company information"));
			}
			else {
				heading = new Heading1(getResourceBundle().getLocalizedString("customer_information", "Customer information"));
			}
			heading.setStyleClass("subHeader");
			heading.setStyleClass("topSubHeader");
			projectSection.add(heading);

			Layer searchSection = new Layer(Layer.DIV);
			searchSection.setStyleClass("searchSection");

			TextInput searchField = new TextInput();
			searchField.setLabel(getResourceBundle().getLocalizedString("soc_sec_number", "Social security number"));
			searchField.setName(PARAMETER_COMPANY_ID);
			//			searchField.setOnKeyPress("searchProjects(event);");
			searchSection.add(searchField);

			Link next = null;
			if (searchForCompany) {
				next = getButtonLink(getResourceBundle().getLocalizedString("find_company_focal", "Find company"));
				next.setOnClick("if(searchValid()) {changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_SEARCH_COMPANY + "');} else {alert('Please enter a valid SSN'); return false;}");
			}
			else {
				next = getButtonLink(getResourceBundle().getLocalizedString("find_person_focal", "Find person"));
				next.setOnClick("if(searchValid()) {changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_SEARCH_PERSON + "');} else {alert('Please enter a valid SSN'); return false;}");
			}
			next.setStyleClass("searchButton");
			next.setToFormSubmit(form);
			searchSection.add(next);

			projectSection.add(searchSection);

			form.add(projectSection);

			Layer bottom = new Layer(Layer.DIV);
			bottom.setStyleClass("bottom");
			form.add(bottom);

			Link cancel = getButtonLink(getResourceBundle().getLocalizedString("cancel", "Cancel"));
			cancel.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + String.valueOf(ACTION_MOVE_FOCAL) + "');");
			cancel.setToFormSubmit(form);
			bottom.add(cancel);

			add(form);
			return;
		}

		Heading1 heading = null;
		if (isCompany) {
			heading = new Heading1(getResourceBundle().getLocalizedString("company_information", "Company information"));
		}
		else {
			heading = new Heading1(getResourceBundle().getLocalizedString("customer_information", "Customer information"));
		}
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		projectSection.add(heading);

		Layer searchSection = new Layer(Layer.DIV);
		searchSection.setStyleClass("searchSection");

		TextInput searchField = new TextInput();
		searchField.setLabel("Search text");
		searchField.setName(PARAMETER_COMPANY_ID);
		//		searchField.setOnKeyPress("searchProjects(event);");
		searchSection.add(searchField);

		Link next = null;
		if (isCompany) {
			next = getButtonLink(getResourceBundle().getLocalizedString("find_company_focal", "Find company"));
			next.setOnClick("if(searchValid()) {changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_SEARCH_COMPANY + "');} else {alert('Please enter a valid SSN'); return false;}");
		}
		else {
			next = getButtonLink(getResourceBundle().getLocalizedString("find_person_focal", "Find person"));
			next.setOnClick("if(searchValid()) {changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_SEARCH_PERSON + "');} else {alert('Please enter a valid SSN'); return false;}");
		}
		next.setStyleClass("searchButton");
		next.setToFormSubmit(form);
		searchSection.add(next);

		projectSection.add(searchSection);

		form.add(projectSection);

		if ((company == null && action == ACTION_SEARCH_COMPANY) || (natReg == null && action == ACTION_SEARCH_PERSON)) {
			Layer errorSection = new Layer(Layer.DIV);
			errorSection.setStyleClass("receipt");

			Layer icon = new Layer(Layer.DIV);
			icon.setStyleClass("receiptImage");
			errorSection.add(icon);

			Heading1 heading2 = new Heading1(getResourceBundle(iwc).getLocalizedString("focal_entity_not_found", "Nothing found"));
			errorSection.add(heading2);

			Paragraph message = new Paragraph();
			message.addText(getResourceBundle(iwc).getLocalizedString("focal_enter_info_manually", "Please enter the required information manually"));
			errorSection.add(message);

			form.add(errorSection);
		}

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		TextInput textInput = null;
		Label label = null;
		Layer formItem = null;

		if (!isCompany) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_TITLE);
			label = new Label(getResourceBundle().getLocalizedString("person_title", "Title"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);
		}

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		if (isCompany) {
			String companyName = (company == null) ? "" : company.getName();
			textInput = new TextInput(PARAMETER_COMPANY_NAME, companyName);
			label = new Label(getResourceBundle().getLocalizedString("company_name", "Company name"), textInput);
		}
		else {
			String natRegName = (natReg == null) ? "" : natReg.getName();
			textInput = new TextInput(PARAMETER_PERSON_NAME, natRegName);
			label = new Label(getResourceBundle().getLocalizedString("person_name", "Full name"), textInput);
		}
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		if (isCompany) {
			String companySocNr = (company == null) ? "" : company.getPersonalID();
			textInput = new TextInput(PARAMETER_SOC_NUMBER, companySocNr);
		}
		else {
			String natRegSocNr = (natReg == null) ? "" : natReg.getSSN();
			textInput = new TextInput(PARAMETER_SOC_NUMBER, natRegSocNr);
		}
		label = new Label(getResourceBundle().getLocalizedString("soc_sec_number", "Social security number"), textInput);
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		TextArea details = null;
		if (isCompany) {
			String address1 = (company == null ? "" : (company.getAddress() == null ? "" : company.getAddress().getStreetAddress()));
			details = new TextArea(PARAMETER_ADDRESS1, address1);
		}
		else {
			String address1 = natReg == null ? "" : natReg.getAddress();
			details = new TextArea(PARAMETER_ADDRESS1, address1);
		}
		details.setStyleClass("details");
		label = new Label(getResourceBundle().getLocalizedString("adress_1", "Address 1"), textInput);
		formItem.add(label);
		formItem.add(details);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		details = new TextArea(PARAMETER_ADDRESS2, "");
		details.setStyleClass("details");
		label = new Label(getResourceBundle().getLocalizedString("adress_2", "Address 2"), textInput);
		formItem.add(label);
		formItem.add(details);
		section.add(formItem);

		Collection communes = getCommuneBusiness(iwc).getCommunes();

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		DropdownMenu dropdown = new DropdownMenu(PARAMETER_COUNTY);
		dropdown.addMenuElementFirst("", getResourceBundle().getLocalizedString("select_commune", "Select commune"));
		for (Iterator it = communes.iterator(); it.hasNext();) {
			Commune commune = (Commune) it.next();
			dropdown.addMenuElement(commune.getCommuneName(), commune.getCommuneName());
		}
		if (isCompany) {
			String communeValue = (company == null ? "" : (company.getLegalCommune() == null ? "" : company.getLegalCommune().getCommuneName()));
			dropdown.setSelectedElement(communeValue);
		}
		else {
			String communeValue = natReg == null ? "" : natReg.getCommune();
			dropdown.setSelectedElement(communeValue);
		}
		label = new Label(getResourceBundle().getLocalizedString("commune", "Commune"), dropdown);
		formItem.add(label);
		formItem.add(dropdown);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		String country = "";
		if (isCompany) {
			if (company != null) {
				if (company.getAddress() != null) {
					if (company.getAddress().getCountry() != null) {
						country = company.getAddress().getCountry().getName();
					}
				}
			}
		}
		textInput = new TextInput(PARAMETER_COUNTRY, country);
		label = new Label(getResourceBundle().getLocalizedString("country", "Country"), textInput);
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		if (isCompany) {
			String email = company == null ? "" : (company.getEmail() == null ? "" : company.getEmail().getEmailAddress());
			textInput = new TextInput(PARAMETER_EMAIL, email);
		}
		else {
			textInput = new TextInput(PARAMETER_EMAIL, "");
		}
		label = new Label(getResourceBundle().getLocalizedString("email", "Email"), textInput);
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		if (!isCompany) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_PHONE_HOME);
			label = new Label(getResourceBundle().getLocalizedString("phone_home", "Home phone"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);

			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_GSM);
			label = new Label(getResourceBundle().getLocalizedString("gsm_phone", "GSM"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);

			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_PHONE_OFFICE);
			label = new Label(getResourceBundle().getLocalizedString("phone_office", "Office phone"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);

			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_CARPHONE);
			label = new Label(getResourceBundle().getLocalizedString("car_phone", "Car phone"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);

			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_FAXOFFICE);
			label = new Label(getResourceBundle().getLocalizedString("fax_office", "Office fax"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);

			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_BEEPER);
			label = new Label(getResourceBundle().getLocalizedString("beeper", "Beeper"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);

		}

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		if (isCompany) {
			String phone = company == null ? "" : (company.getPhone() == null ? "" : company.getPhone().getNumber());
			textInput = new TextInput(PARAMETER_PHONE_WORK, phone);
		}
		else {
			textInput = new TextInput(PARAMETER_PHONE_WORK, "");
		}
		label = new Label(getResourceBundle().getLocalizedString("phone_work", "Work phone number"), textInput);
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		if (isCompany) {
			String fax = company == null ? "" : (company.getFax() == null ? "" : company.getFax().getNumber());
			textInput = new TextInput(PARAMETER_FAX, fax);
		}
		else {
			textInput = new TextInput(PARAMETER_FAX, "");
		}
		label = new Label(getResourceBundle().getLocalizedString("Fax", "Fax"), textInput);
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		if (isCompany) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_LOCATION, company == null ? "" : company.getName());
			label = new Label(getResourceBundle().getLocalizedString("location", "Location"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);
		}

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		textInput = new TextInput(PARAMETER_LANGUAGE);
		label = new Label(getResourceBundle().getLocalizedString("language", "Language"), textInput);
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		if (isCompany) {
			String postAddress = company == null ? "" : (company.getAddress() == null ? "" : company.getAddress().getPostalAddress());
			details = new TextArea(PARAMETER_POST_ADDRESS, postAddress);
		}
		else {
			String postAddress = natReg == null ? "" : natReg.getAddress();
			details = new TextArea(PARAMETER_POST_ADDRESS, postAddress);
		}
		details.setStyleClass("details");
		label = new Label(getResourceBundle().getLocalizedString("post_address", "Postal address"), textInput);
		formItem.add(label);
		formItem.add(details);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		if (isCompany) {
			textInput = new TextInput(PARAMETER_HOMEPAGE, company == null ? "" : company.getWebPage());
		}
		else {
			textInput = new TextInput(PARAMETER_HOMEPAGE, "");
		}
		label = new Label(getResourceBundle().getLocalizedString("homepage", "Homepage"), textInput);
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		textInput = new TextInput(PARAMETER_STATUS);
		if (isCompany) {
			label = new Label(getResourceBundle().getLocalizedString("company_status", "Status"), textInput);
		}
		else {
			label = new Label(getResourceBundle().getLocalizedString("person_job_status", "Job status"), textInput);
		}
		formItem.add(label);
		formItem.add(textInput);
		section.add(formItem);

		if (!isCompany) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			textInput = new TextInput(PARAMETER_AVARP);
			label = new Label(getResourceBundle().getLocalizedString("avarp", "Avarp"), textInput);
			formItem.add(label);
			formItem.add(textInput);
			section.add(formItem);
		}

		RadioButton yes = new RadioButton(PARAMETER_TARGET_MAIL, Boolean.TRUE.toString());
		yes.setStyleClass("radiobutton");
		RadioButton no = new RadioButton(PARAMETER_TARGET_MAIL, Boolean.FALSE.toString());
		no.setStyleClass("radiobutton");

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(getResourceBundle().getLocalizedString("target_mail", "Target mail"), yes);
		formItem.add(label);
		section.add(formItem);

		Layer selectItem = new Layer(Layer.DIV);
		//		selectItem.setStyleClass("formItem");
		selectItem.setStyleClass("radioButtonItem");
		label = new Label(getResourceBundle().getLocalizedString("yes", "Yes"), yes);
		selectItem.add(yes);
		selectItem.add(label);
		formItem.add(selectItem);

		selectItem = new Layer(Layer.DIV);
		//		selectItem.setStyleClass("formItem");
		selectItem.setStyleClass("radioButtonItem");
		label = new Label(getResourceBundle().getLocalizedString("no", "No"), no);
		selectItem.add(no);
		selectItem.add(label);
		formItem.add(selectItem);

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link cancel = getButtonLink(getResourceBundle().getLocalizedString("cancel", "Cancel"));
		cancel.setStyleClass("homeButton");
		cancel.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + String.valueOf(ACTION_MOVE_FOCAL) + "');");
		cancel.setToFormSubmit(form);
		bottom.add(cancel);

		Link save = getButtonLink(getResourceBundle().getLocalizedString("save", "Save"));
		save.setToFormSubmit(form);
		if (isCompany) {
			save.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + String.valueOf(ACTION_SAVE_COMPANY) + "');");
		}
		else {
			save.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + String.valueOf(ACTION_SAVE_PERSON) + "');");
		}
		bottom.add(save);

		add(form);
	}

	protected void showList(IWContext iwc, int action, String result) throws RemoteException {
		Form form = new Form();
		form.addParameter(PARAMETER_ACTION, "");
		boolean showCheckBoxes = true;

		super.getParentPage().addJavascriptURL(getBundle().getResourcesPath() + "/js/jquery-1.2.1.pack.js");
		super.getParentPage().addJavascriptURL(getBundle().getResourcesPath() + "/js/jquery.tablesorter.pack.js");

		StringBuffer buffer = new StringBuffer();
		buffer.append("$(document).ready(function() { $('#" + getBlockID() + "').tablesorter( { headers: { 2: { sorter: false }, " + (getCasesBusiness().useTypes() ? 6 : 5) + ": { sorter: false}" + (showCheckBoxes ? ", " + (getCasesBusiness().useTypes() ? 7 : 6) + ": { sorter: false}" : "") + "}, sortList: [[0,0]] } ); } );");

		super.getParentPage().getAssociatedScript().addFunction("tableSorter", buffer.toString());

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
		
		if (getCaseManagersProvider() == null) {
			ELUtil.getInstance().autowire(this);
		}
		List<String> emptyList = ListUtil.getEmptyList();
		Collection<CasePresentation> cases = getCaseManagersProvider().getCaseManager().getCases(
				iwc.isLoggedOn() ? iwc.getCurrentUser() : null, getCasesProcessorType(), iwc.getLocale(), emptyList, emptyList, emptyList, 0, -1, isOnlySubscribedCases()
		).getCollection();

		TableRowGroup group = table.createHeaderRowGroup();
		TableRow row = group.createRow();

		TableCell2 cell = row.createHeaderCell();
		cell.setStyleClass("firstColumn");
		cell.setStyleClass("caseNumber");
		cell.add(new Text(getResourceBundle().getLocalizedString("case_nr", "Case nr.")));

		cell = row.createHeaderCell();
		cell.setStyleClass("sender");
		cell.add(new Text(getResourceBundle().getLocalizedString("sender", "Sender")));

		if (getCasesBusiness().useTypes()) {
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

		Iterator<CasePresentation> iter = cases.iterator();
		while (iter.hasNext()) {
			CasePresentation theCase = iter.next();
			CaseStatus status = theCase.getCaseStatus();
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
			if (status != null && status.equals(getCasesBusiness(iwc).getCaseStatusReview())) {
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

			if (getCasesBusiness().useTypes()) {
				cell = row.createCell();
				cell.setStyleClass("caseType");
				cell.add(new Text(theCase.getCaseTypeName()));
			}

			cell = row.createCell();
			cell.setStyleClass("createdDate");
			cell.add(new Text(created.getLocaleDateAndTime(iwc.getCurrentLocale(), IWTimestamp.SHORT, IWTimestamp.SHORT)));

			cell = row.createCell();
			cell.setStyleClass("status");
			cell.add(new Text(StringUtil.isEmpty(theCase.getLocalizedStatus()) ? CoreConstants.EMPTY : theCase.getLocalizedStatus()));

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
			Link edit = getProcessLink(getBundle().getImage("edit.png", getResourceBundle().getLocalizedString("view_case", "View case")), theCase.getPrimaryKey());
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
		form.add(table);

		form.add(getLegend(iwc));

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link back = getButtonLink(getResourceBundle().getLocalizedString("move_focal", "Move to Focal"));
		back.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + String.valueOf(ACTION_MOVE_FOCAL) + "');");
		back.setToFormSubmit(form);
		bottom.add(back);

		add(form);
	}

	protected String saveToFocal(IWContext iwc) {
		try {
			String projectId = iwc.getParameter(PARAMETER_PROJECT_PK);
			String projectName = iwc.getParameter(PARAMETER_PROJECT_NAME);
			if (projectId != null && !projectId.equals("") && projectName != null && !projectName.equals("")) {
				String[] pks = iwc.getParameterValues(PARAMETER_CASE_PK);

				List cases = new ArrayList();
				for (int i = 0; i < pks.length; i++) {
					GeneralCase theCase = getCasesBusiness(iwc).getGeneralCase(pks[i]);
					CaseArg ca = new CaseArg();
					ca.setGcase(theCase);
					cases.add(ca);
				}
				getFocalCasesIntegration(iwc).createCasesUnderProject(projectId, projectName, cases);
				getExportCasesManagement(iwc).updateCasesExternalId(projectId, cases);
			}
			return FocalConstants.STATUS_SUCCESS_SAVE;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Exception while saving to focal", e);
			return FocalConstants.STATUS_ERROR_SAVE;
		}
	}

	protected String findProjects(IWContext iwc) {
		try {
			List projects = new ArrayList();
			String searchKey = iwc.getParameter(PARAMETER_PROJECT_SEARCH_KEY);
			if (searchKey == null) {
				projects = getFocalCasesIntegration(iwc).findProjects("");
			}
			else {
				if (searchKey.equals("")) {
					projects = getFocalCasesIntegration(iwc).findProjects("");
				}
				else if (searchKey.equals("*")) {
					projects = getFocalCasesIntegration(iwc).findProjects("");
				}
				else {
					projects = getFocalCasesIntegration(iwc).findProjects(searchKey);
				}
			}
			FocalProjectList list = (FocalProjectList) WFUtil.getBeanInstance("focalProjectList");
			if (list != null) {
				list.setProjects(projects);
			}
			if (projects == null) {
				return FocalConstants.STATUS_ERROR_FIND_NOPROJECTS;
			}
			return FocalConstants.STATUS_SUCCESS_PROJECTS;
		}
		catch (UnsuccessfulStatusException use) {
			logger.log(Level.SEVERE, "Exception while finding projects", use);
			return FocalConstants.STATUS_ERROR_FIND_PROJECTS;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Exception while finding projects", e);
			return FocalConstants.STATUS_ERROR_FIND_PROJECTS;
		}
	}

	protected void showProjectSearch(IWContext iwc, int action, String result) {
		Form form = new Form();
		form.setId("focalProjectSearchForm");
		form.addParameter(PARAMETER_ACTION, "");
		form.addParameter(PARAMETER_PROJECT_PK, "");
		form.addParameter(PARAMETER_PROJECT_NAME, "");
		//		form.addParameter(PARAMETER_CUSTOMER_PK, "");
		form.maintainParameter(PARAMETER_CASE_PK);

		if (result != null) {
			if (FocalConstants.STATUS_ERROR_SAVE.equals(result)) {
				form.add(getErrorNotificationBox(iwc, result));
			}
			else if (FocalConstants.STATUS_SUCCESS_SAVE_CUSTOMER.equals(result)) {
				form.add(getConfirmationBox(iwc, result));
			}
			else if (FocalConstants.STATUS_SUCCESS_CREATE_COMPANY.equals(result)) {
				form.add(getConfirmationBox(iwc, result));
			}
			else if (FocalConstants.STATUS_ERROR_SAVE_CUSTOMER.equals(result)) {
				form.add(getErrorNotificationBox(iwc, result));
			}
			else if (FocalConstants.STATUS_ERROR_CREATE_COMPANY.equals(result)) {
				form.add(getErrorNotificationBox(iwc, result));
			}
			else if (FocalConstants.STATUS_ERROR_FIND_PROJECTS.equals(result)) {
				form.add(getErrorNotificationBox(iwc, result));
			}
		}

		Layer projectSection = new Layer(Layer.DIV);
		projectSection.setStyleClass("formSection");

		Heading1 heading = new Heading1(getResourceBundle().getLocalizedString("find_project_focal_label", "Find project in Focal"));
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

		String noProjectAlert = getResourceBundle().getLocalizedString("focal.alert.noproject", "Please select a project");

		Link next = getButtonLink(getResourceBundle().getLocalizedString("find_project_focal", "Find projects"));
		next.setStyleClass("searchButton");
		next.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_MOVE_FOCAL + "');");
		//		next.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_MOVE_FOCAL + "');changeInputValue(findObj('" + PARAMETER_PROJECT_SEARCH_KEY + "'), document.getElementById('projectSearchField').value);");
		//		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_MOVE_FOCAL));

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
		table.setStyleClass("projectSearchTable");
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
		cell.add(new Text(getResourceBundle().getLocalizedString("focal_project_name", "Project name")));

		cell = row.createHeaderCell();
		cell.setStyleClass("lastColumn");
		cell.add(new Text(getResourceBundle().getLocalizedString("focal_customer_id", "Customer")));

		group = table.createBodyRowGroup();

		List projects = ((FocalProjectList) WFUtil.getBeanInstance("focalProjectList")).getProjects();
		if (projects != null) {
			Iterator iter = projects.iterator();
			while (iter.hasNext()) {
				NOTESPROJECT theProject = (NOTESPROJECT) iter.next();
				String projectId = theProject.getPROJECTNUMBER();
				int iRow = 1;
				if (projectId != null) {
					row = group.createRow();

					String projectIdFixed = projectId.replaceAll("/", "-");
					row.setId(projectIdFixed);
					row.setMarkupAttribute("onclick", "changeInputValue(findObj('" + PARAMETER_PROJECT_PK + "'), '" + projectId + "');changeInputValue(findObj('" + PARAMETER_PROJECT_NAME + "'), '" + theProject.getPROJECTNAME() + "');selectFocalCasesRow(this.id);");
					if (iRow == 1) {
						row.setStyleClass("firstRow");
					}
					else if (!iter.hasNext()) {
						row.setStyleClass("lastRow");
					}
					else {
						row.setStyleClass("focalRow");
					}
					cell = row.createCell();
					cell.setStyleClass("firstColumn");
					cell.setStyleClass("caseNumber");
					cell.add(new Text(theProject.getPROJECTNAME()));

					cell = row.createCell();
					cell.setStyleClass("lastColumn");
					cell.setStyleClass("caseNumber");
					cell.add(new Text(theProject.getPROJECTCUSTOMER()));
				}
			}
		}

		tableSection.add(table);
		projectSection.add(tableSection);
		form.add(projectSection);

		Layer middle = new Layer(Layer.DIV);
		middle.setStyleClass("bottom");
		form.add(middle);

		Link createCompany = getButtonLink(getResourceBundle().getLocalizedString("create_company", "Create Company"));
		createCompany.setOnClick("changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_CREATE_COMPANY + "');");
		createCompany.setToFormSubmit(form);
		middle.add(createCompany);

		Layer customerSection = new Layer(Layer.DIV);
		customerSection.setStyleClass("formSection");

		heading = new Heading1(getResourceBundle().getLocalizedString("focal_cases_tobemoved", "Cases to be moved"));
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
		cCell.add(new Text(getResourceBundle().getLocalizedString("focal_case_nr", "Case Nr")));

		cCell = cRow.createHeaderCell();
		cCell.setStyleClass("sender");
		cCell.add(new Text(getResourceBundle().getLocalizedString("focal_customer_name", "Customer")));

		cCell = cRow.createHeaderCell();
		cCell.setStyleClass("action");
		cCell.add(new Text(getResourceBundle().getLocalizedString("focal_customer_action", "Create/Update")));

		cGroup = customerTable.createBodyRowGroup();

		String casesPKs[] = iwc.getParameterValues(PARAMETER_CASE_PK);
		List customers = new LinkedList();
		for (int i = 0; i < casesPKs.length; i++) {
			GeneralCase theCase = null;
			try {
				theCase = getCasesBusiness().getGeneralCase(casesPKs[i]);
				User owner = theCase.getOwner();
				if (owner != null) {
					String id = owner.getPersonalID();
					if (!customers.contains(id)) {
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

						if (id != null) {
							CUSTOMER customer = getFocalCasesIntegration(iwc).findCustomer(id);
							Link createCustomer = null;
							if (customer != null) {
								createCustomer = getButtonLink(getResourceBundle().getLocalizedString("update", "Update"));
								createCustomer.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_UPDATE_PERSON));
							}
							else {
								createCustomer = getButtonLink(getResourceBundle().getLocalizedString("create", "Create"));
								createCustomer.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_CREATE_PERSON));
							}
							createCustomer.setOnClick("changeInputValue(findObj('" + PARAMETER_COMPANY_ID + "'), '" + id + "');");
							createCustomer.setStyleClass("homeButton");

							createCustomer.setToFormSubmit(form);
							cCell.add(createCustomer);
						}
						else {
							Link createCustomer = getButtonLink(getResourceBundle().getLocalizedString("create", "Create"));
							createCustomer.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_CREATE_PERSON));
							createCustomer.setStyleClass("homeButton");

							createCustomer.setToFormSubmit(form);
							cCell.add(createCustomer);
						}
					}

				}
			}
			catch (Exception e) {
				e.printStackTrace();
				//TODO
			}
		}

		customerSection.add(customerTable);
		form.add(customerSection);

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link back = getButtonLink(getResourceBundle().getLocalizedString("back", "Back"));
		back.setStyleClass("homeButton");
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_VIEW));
		back.setToFormSubmit(form);
		bottom.add(back);

		Link save = getButtonLink(getResourceBundle().getLocalizedString("save", "Save to Focal"));
		save.setOnClick("if(isProjectSelected()) {changeInputValue(findObj('" + PARAMETER_ACTION + "'), '" + ACTION_SAVE_FOCAL + "');} else {alert('" + noProjectAlert + "');return false;}");
		save.setToFormSubmit(form);
		bottom.add(save);

		add(form);
	}

	@Override
	protected int parseAction(IWContext iwc) {
		if (iwc.isParameterSet(PARAMETER_ACTION)) {
			return Integer.parseInt(iwc.getParameter(PARAMETER_ACTION));
		}
		return ACTION_VIEW;
	}

	@Override
	protected Lists getLegend(IWContext iwc) throws RemoteException {
		Lists list = super.getLegend(iwc);

		list.setStyleClass("formSection");
		ListItem item = new ListItem();
		item.setStyleClass("isInFocal");
		item.add(new Text(getResourceBundle().getLocalizedString("legend.is_inFocal", "Is In Focal")));
		list.add(item);

		return list;
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

	protected CompanyRegisterBusiness getCompanyRegisterBusiness(IWApplicationContext iwac) {
		try {
			return (CompanyRegisterBusiness) IBOLookup.getServiceInstance(iwac, CompanyRegisterBusiness.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected NationalRegisterBusiness getNationalRegisterBusiness(IWApplicationContext iwac) {
		try {
			return (NationalRegisterBusiness) IBOLookup.getServiceInstance(iwac, NationalRegisterBusiness.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected CommuneBusiness getCommuneBusiness(IWApplicationContext iwac) {
		try {
			return (CommuneBusiness) IBOLookup.getServiceInstance(iwac, CommuneBusiness.class);
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

	@Override
	public String getBundleIdentifier() {
		return IWBundleStarter.IW_BUNDLE_IDENTIFIER;
	}

	protected Link getProcessLink(PresentationObject object, Integer primaryKey) {
		Link process = new Link(object);
		process.addParameter(PARAMETER_CASE_PK, primaryKey.toString());
		process.addParameter(PARAMETER_ACTION, ACTION_PROCESS);

		return process;
	}

	protected Layer getConfirmationBox(IWContext iwc, String result) {
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

	protected Layer getErrorNotificationBox(IWContext iwc, String result) {
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

	@Override
	public boolean showCheckBox() {
		return false;
	}

	protected CompanyHome getCompanyHome() {
		CompanyHome home = null;
		try {
			home = (CompanyHome) IDOLookup.getHome(Company.class);
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}

		return home;
	}

	protected NationalRegisterHome getNationalRegisterHome() {
		NationalRegisterHome home = null;
		try {
			home = (NationalRegisterHome) IDOLookup.getHome(NationalRegister.class);
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}

		return home;
	}

	@Override
	public Map<Object, Object> getUserCasesPageMap() {
		return null;
	}
}
