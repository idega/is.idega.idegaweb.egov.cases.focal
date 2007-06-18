package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg;
import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.ProjectServiceLocator;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.Customer;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.CustomerPersonalInfo;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.ProjectInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import com.idega.business.IBOServiceBean;
import com.idega.idegaweb.IWMainApplication;
import com.idega.util.CypherText;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;

/**
 * 
 * Last modified: $Date: 2007/06/18 14:20:32 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.11 $
 */
public class FocalCasesIntegrationBean extends IBOServiceBean implements FocalCasesIntegration {

	private static final long serialVersionUID = -486408791846081399L;
	
	private static final String const_project_list = "ProjectList";
	private static final String const_project_info = "ProjectInfo";
	private static final String const_customer = "Customer";
	private static final String focal_service_login_app_key = "focal.ws.login";
	private static final String focal_service_pass_app_key = "focal.ws.pass";
	private static final String ck = "ZIZYFk9nxC41RhCtJBDydBRiUNPvyKlIWmJDJ9p2xYWXvmqIrVyTNXIljGupoFBqi6TyC7bUXWLL2OxdRsWnaph2kQyETYlzHzhv";
	
	private ProjectServiceLocator locator;
	
	private static final Logger logger = Logger.getLogger(FocalCasesIntegrationBean.class.getName());
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public List findProjects(String search_txt) throws Exception {
		
		Project service = getFocalService();
		
		String[] loging_pass = getLoginAndPassword();
		
		if(loging_pass == null)
			throw new NullPointerException("Login and pass for focal ws not set as application properties.");
		
		String xml_str = service.GETPROJECTLIST(const_project_list, loging_pass[0], loging_pass[1]);
		
		if(xml_str == null)
			return null;
		
		XStream xstream = new XStream();
		
		xstream.alias(const_project_list, ArrayList.class);
		xstream.alias(const_project_info, ProjectInfo.class);
		
		try {
			return (List)xstream.fromXML(xml_str);
			
		} catch (StreamException e) {
			
			logger.log(Level.WARNING, "Exception while parsing xml to bean. This can be either an error in document, or that's how focal returns when nothing is found (plain string with blah blah ;])", e);
			return null;
		}
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public Customer findCustomer(String search_txt) throws Exception {
		
		Project service = getFocalService();
		
		String[] loging_pass = getLoginAndPassword();
		
		if(loging_pass == null)
			throw new NullPointerException("Login and pass for focal ws not set as application properties.");
		
		String xml_str = service.FINDCUSTOMER(search_txt, const_project_list, loging_pass[0], loging_pass[1]);
		
		if(xml_str == null)
			return null;
		
		XStream xstream = new XStream();
		
		xstream.alias(const_customer, Customer.class);
		
		try {
			return (Customer)xstream.fromXML(xml_str);
			
		} catch (StreamException e) {
			
			logger.log(Level.WARNING, "Exception while parsing xml to bean. This can be either an error in document, or that's how focal returns when nothing is found (plain string with blah blah ;])", e);
			return null;
		}
	}
	
	protected Project getFocalService() throws ServiceException {
		
		if(locator == null)
			locator = new ProjectServiceLocator();
		
		return locator.getDomino();
	}
	
	protected String[] getLoginAndPassword() {
		
		IWMainApplication iwma = IWMainApplication.getDefaultIWMainApplication();
		
		if(iwma != null) {
			
			String login = (String)iwma.getSettings().getProperty(focal_service_login_app_key);
			String pass = (String)iwma.getSettings().getProperty(focal_service_pass_app_key);
			
			if(login == null || pass == null)
				return null;
			
			CypherText ct = new CypherText();
			login = ct.doDeCypher(login, ck);
			pass = ct.doDeCypher(pass, ck);

			return new String[] {login, pass};
		}
		
		return null;
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public List createCasesUnderProject(String project_id, List cases) throws Exception {

		if(cases == null || cases.isEmpty())
			return cases;
		
		Project service = getFocalService();
		
		for (Iterator iter = cases.iterator(); iter.hasNext();) {
			CaseArg case_arg = (CaseArg) iter.next();
			
			GeneralCase gen_case = case_arg.getGcase();
			
			if(gen_case.getExternalId() != null) {

				logger.log(Level.WARNING, "Case was tried to move under a project when already moved. Case id: "+gen_case.getId()+", external id: "+gen_case.getExternalId());
				continue;
			}
			
			CASEDATA case_data = new CASEDATA(
					gen_case.getOwner().getPersonalID(),				//"SOCSECNUM"
					gen_case.getCreator() == null ? null :
					gen_case.getCreator().getName(), 					//"CUSTOMERNAME"
					gen_case.getSubject(),								//"SUBJECT"
					gen_case.getCreated() == null ? null :
					String.valueOf(gen_case.getCreated().getTime()),	//"DATE"
		            gen_case.getBody(),									//"BODY"
			        null,												//"PROJECTNAME"
			        project_id											//"PROJECTNUMBER"
			);
			
			String[] login_and_pass = getLoginAndPassword();

//			TODO: is this the correct profile key - const_project_list ?
			RETURNSTATUS ret_status = service.NEWPROJECT(case_data, const_project_list, login_and_pass[0], login_and_pass[1]);
			
			try {
				int status_code = Integer.parseInt(ret_status.getSTATUS());
				
				if(status_code == 0)
					case_arg.setStatus(new Status(Status.success));
				else {
					case_arg.setStatus(new Status(Status.unknown_fail));
					logger.log(Level.WARNING, "Error occured while creating project by case. Status message: "+ret_status.getERRORTEXT());
				}
				
			} catch (Exception e) {
				
				case_arg.setStatus(new Status(Status.unknown_fail));
				
				if(ret_status == null)
					logger.log(Level.SEVERE, "No status was retrieved", e);
				else
					logger.log(Level.SEVERE, "Exception while parsing status code. Status message: "+ret_status.getERRORTEXT(), e);
			}
		}
		
		return cases;
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public Status createUpdateCustomer(CustomerPersonalInfo customer) throws Exception {
		
		Project service = getFocalService();
		String[] login_and_pass = getLoginAndPassword();
		
		PERSONINFO person_info = new PERSONINFO(
					customer.getAddress1(),								//ADDRESS2
					customer.getAddress2(), 							//ADDRESS2
					customer.getCounty(), 								//COUNTY
					customer.getCountry(), 								//COUNTRY
					customer.getEmailaddress(),							//EMAIL
					customer.getFax(), 									//FAX
					customer.getHomepage(),								//HOMEPAGE
					customer.getLanguage(), 							//LANGUAGE
					customer.getPhonework(),							//PHONEWORK
					customer.getPostaddress(), 							//POSTADDRESS
					customer.getSocNr(),		 						//SOCSECNUM
					customer.getStatus(), 								//STATUS
					customer.getTargetMail(),				 			//TARGETMAIL
					customer.getAvarp(), 								//AVARP
					customer.getBeeper(), 								//BEEPER
					customer.getCarphone(), 							//CARPHONE
					customer.getGsm(),	 								//GSM
					customer.getName(), 								//PERSONNAME
					customer.getPhonehome(),							//PHONEHOME
					customer.getPhoneoffice(),							//PHONEOFFICE
					customer.getContactseperator(),						//SEPERATOR
					customer.getTitle() 								//TITLE
		);
		
//		TODO: is this the correct profile key - const_project_list ?
		RETURNSTATUS ret_status = service.CREATEUPDATEPERSON(person_info, const_project_list, login_and_pass[0], login_and_pass[1]);
		
		try {
				int status_code = Integer.parseInt(ret_status.getSTATUS());
				
				if(status_code == 0)
					return new Status(Status.success);
				else {
					logger.log(Level.WARNING, "Error occured while doing CREATEUPDATEPERSON. Status message: "+ret_status.getERRORTEXT());
					return new Status(Status.unknown_fail);
				}
				
			} catch (Exception e) {
				
				if(ret_status == null)
					logger.log(Level.SEVERE, "No status was retrieved", e);
				else
					logger.log(Level.SEVERE, "Exception while parsing status code. Status message: "+ret_status.getERRORTEXT(), e);
				
				return new Status(Status.unknown_fail);
			}
	}
}