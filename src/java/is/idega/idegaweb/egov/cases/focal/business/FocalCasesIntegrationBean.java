package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.ProjectServiceLocator;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.Customer;
import is.idega.idegaweb.egov.cases.focal.business.server.focalService.beans.ProjectInfo;

import java.util.ArrayList;
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
 * Last modified: $Date: 2007/05/29 11:03:42 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.9 $
 */
public class FocalCasesIntegrationBean extends IBOServiceBean implements FocalCasesIntegration {

	private static final long serialVersionUID = -486408791846081399L;
//	private static final String service_url = "http://127.0.0.1:8080/services/FocalMockup";
//	private static final String focal_service_url_app_key = "focal.ws.url"; 
	
	private static final String const_project_list = "ProjectList";
	private static final String const_project_info = "ProjectInfo";
	private static final String const_customer = "Customer";
	private static final String focal_service_login_app_key = "focal.ws.login";
	private static final String focal_service_pass_app_key = "focal.ws.pass";
	private static final String ck = "ZIZYFk9nxC41RhCtJBDydBRiUNPvyKlIWmJDJ9p2xYWXvmqIrVyTNXIljGupoFBqi6TyC7bUXWLL2OxdRsWnaph2kQyETYlzHzhv";
	
	private static final Logger logger = Logger.getLogger(FocalCasesIntegrationBean.class.getName());
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public List findProjects(String search_txt) throws Exception {
		
		ProjectServiceLocator locator = new ProjectServiceLocator();
		Project service = locator.getDomino();
		
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
		
		ProjectServiceLocator locator = new ProjectServiceLocator();
		Project service = locator.getDomino();
		
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
		
		ProjectServiceLocator locator = new ProjectServiceLocator();
		Project service = locator.getDomino();
		
		return service;
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
	
	/* -- */
//	/**
//	 * @see FocalCasesIntegration method description
//	 * 
//	 */
//	public List findProjects(String search_txt) throws UnsuccessfulStatusException, Exception {
//	
//		FocalMockupService service = getFocalService();
//		ReturnedProjects projects_ret = service.findProjects(search_txt);
//		
//		FPStatus status = projects_ret.getStatus();
//		
//		if(!status.isSuccess()) {
//			
//			UnsuccessfulStatusException ex = new UnsuccessfulStatusException("Projects could not be found/retrieved due to reason decribed in status (see getStatus())");
//			
//			if(status.isNoCustomer())
//				ex.setStatus(new Status(Status.no_customer));
//			else if(status.isNoProjects())
//				ex.setStatus(new Status(Status.no_projects));
//			else
//				ex.setStatus(new Status(Status.unknown_fail));
//			
//			throw ex;
//		}
//		
//		ProjectMetaData[] projects_data = projects_ret.getProjects();
//		
//		if(projects_data == null || projects_data.length == 0) {
//			
//			UnsuccessfulStatusException ex = new UnsuccessfulStatusException("Projects were not set, but status set to success");
//			ex.setStatus(new Status(Status.unknown_fail));
//			throw ex;
//		}
//		
//		List ret_data = new ArrayList();
//		
//		for (int i = 0; i < projects_data.length; i++) {
//			
//			ProjectData pd = new ProjectData();
//			
//			pd.setProjectId(projects_data[i].getProjectId());
//			pd.setProjectName(projects_data[i].getName());
//			
//			MainParty main_party = projects_data[i].getMainParty();
//			
//			if(main_party != null) {
//				pd.setFirstPartyId(main_party.getId());
//				pd.setFirstPartyName(main_party.getName());
//			}
//			
//			ret_data.add(pd);
//		}
//		
//		return ret_data;
//	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public List createCasesUnderProject(String project_id, List cases) throws Exception {

		return null;
		/*if(cases == null || cases.isEmpty())
			return cases;
		
		FocalMockupService service = getFocalService();
		
		for (Iterator iter = cases.iterator(); iter.hasNext();) {
			CaseArg case_arg = (CaseArg) iter.next();
			GeneralCase gcase = case_arg.getGcase();

			CaseData cdata = new CaseData();
			cdata.setProjectId(project_id);
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(gcase.getCreated().getTime());
			cdata.setDate(cal);
			cdata.setCaseSubject(gcase.getSubject());
			cdata.setCaseBody(gcase.getBody());
			
			ICFile file = gcase.getAttachment();
			
			byte[] serialized_file_value = new byte[file.getFileSize().intValue()];
			file.getFileValue().read(serialized_file_value);
			
			Attachment att = new Attachment();
			att.setFile(serialized_file_value);
			att.setFileSize(file.getFileSize().longValue());
			att.setFName(file.getName());
			
			cdata.setAttachments(new Attachment[] {att});
			
			try {
				is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status status = service.createCase(cdata);
				
				if(status.isSuccess())
					case_arg.setStatus(new Status(Status.success));
				else
					case_arg.setStatus(new Status(Status.unknown_fail));
				
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Exception while creating case under project: "+project_id, e);
				case_arg.setStatus(new Status(Status.unknown_fail));
			}
		}
		
		return cases;
		*/
	}
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	/*
	public List findCustomers(String search_txt) throws Exception {
		
		return null;
		FocalMockupService service = getFocalService();
		CustomerInformation[] informations = service.findCustomer(search_txt);
		
		if(informations == null || informations.length == 0)
			return null;
		
		List customer_information_list = new ArrayList();
		
		for (int i = 0; i < informations.length; i++) {
			
			is.idega.idegaweb.egov.cases.focal.business.beans.CustomerInformation customer_info = new is.idega.idegaweb.egov.cases.focal.business.beans.CustomerInformation();
			customer_info.setCustomerId(informations[i].getCustomerId());
			customer_info.setName(informations[i].getName());
			customer_info.setEmail(informations[i].getEmail());
			customer_info.setPhone(informations[i].getEmail());
			
			customer_information_list.add(customer_info);
		}
		
		return customer_information_list;
	}
	*/
	
	/**
	 * @see FocalCasesIntegration method description
	 * 
	 */
	public Status createUpdateCustomer(is.idega.idegaweb.egov.cases.focal.business.beans.CustomerInformation customer_information) throws Exception {
		
		return null;
		/*
		FocalMockupService service = getFocalService();
		
		CustomerInformation ci = new CustomerInformation();
		ci.setCustomerId(customer_information.getCustomerId());
		ci.setName(customer_information.getName());
		ci.setEmail(customer_information.getEmail());
		ci.setPhone(customer_information.getPhone());
		
		is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status stat = service.createUpdateCustomer(ci);
		
		if(stat.isSuccess())
			return new Status(Status.success);
		
		return new Status(Status.unknown_fail);
		*/
	}
	
//	protected String getServiceUrl() {
//
//		IWMainApplication iwma = IWMainApplication.getDefaultIWMainApplication();
//		
//		if(iwma != null)
//			return (String)iwma.getSettings().getProperty(focal_service_url_app_key, service_url);
//		
//		return service_url;
//	}
	
//	protected FocalMockupService getFocalService() throws MalformedURLException, ServiceException {
//		
//		FocalMockupServiceServiceLocator locator = new FocalMockupServiceServiceLocator();
//		FocalMockupService service = locator.getFocalMockup(new URL(getServiceUrl()));
//		return service;
//	}
}