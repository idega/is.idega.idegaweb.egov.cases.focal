package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.data.GeneralCase;
import is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg;
import is.idega.idegaweb.egov.cases.focal.business.beans.ProjectData;
import is.idega.idegaweb.egov.cases.focal.business.beans.Status;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CaseData;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupServiceServiceLocator;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Attachment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import com.idega.business.IBOServiceBean;
import com.idega.core.file.data.ICFile;

/**
 * 
 * Last modified: $Date: 2007/05/05 18:43:25 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.5 $
 */
public class FocalCasesIntegrationBean extends IBOServiceBean implements FocalCasesIntegration {

	private static final long serialVersionUID = -486408791846081399L;
	private static final String service_url = "http://127.0.0.1:8080/services/FocalMockup";
	
	Logger logger = Logger.getLogger(FocalCasesIntegrationBean.class.getName());

	
	/**
	 * Finds projects by main party (customer) id or name(probably)
	 * 
	 * @param search_txt - id or name(?)
	 * @return list of is.idega.idegaweb.egov.cases.focal.business.beans.ProjectData objects
	 * @throws UnsuccessfulStatusException - contains the cause (use getStatus()) of projects missing, if there was an objective reason for that - e.g. no customer exists, or customer has no projects
	 * @throws Exception
	 */
	public List findProjects(String search_txt) throws UnsuccessfulStatusException, Exception {
	
		FocalMockupService service = getFocalService();
		ReturnedProjects projects_ret = service.findProjects(search_txt);
		
		FPStatus status = projects_ret.getStatus();
		
		if(!status.isSuccess()) {
			
			UnsuccessfulStatusException ex = new UnsuccessfulStatusException("Projects could not be found/retrieved due to reason decribed in status (see getStatus())");
			
			if(status.isNoCustomer())
				ex.setStatus(new Status(Status.no_customer));
			else if(status.isNoProjects())
				ex.setStatus(new Status(Status.no_projects));
			else
				ex.setStatus(new Status(Status.unknown_fail));
			
			throw ex;
		}
		
		ProjectMetaData[] projects_data = projects_ret.getProjects();
		
		if(projects_data == null || projects_data.length == 0) {
			
			UnsuccessfulStatusException ex = new UnsuccessfulStatusException("Projects were not set, but status set to success");
			ex.setStatus(new Status(Status.unknown_fail));
			throw ex;
		}
		
		List ret_data = new ArrayList();
		
		for (int i = 0; i < projects_data.length; i++) {
			
			ProjectData pd = new ProjectData();
			
			pd.setProjectId(projects_data[i].getProjectId());
			pd.setProjectName(projects_data[i].getName());
			
			MainParty main_party = projects_data[i].getMainParty();
			
			if(main_party != null) {
				pd.setFirstPartyId(main_party.getId());
				pd.setFirstPartyName(main_party.getName());
			}
			
			ret_data.add(pd);
		}
		
		return ret_data;
	}
	
	/**
	 * 
	 * Creates cases under the same project
	 * 
	 * @param project_id - project to create under id
	 * @param cases - list of is.idega.idegaweb.egov.cases.focal.business.beans.CaseArg - status may be empty as it is used on return only
	 * @return cases - the same list with status modified to each case move status
	 */
	public List createCasesUnderProject(String project_id, List cases) throws Exception {

		if(cases == null || cases.isEmpty())
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
	}
	
	public List findCustomers(String search_txt) throws Exception {
		
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
	
	public Status createUpdateCustomer(is.idega.idegaweb.egov.cases.focal.business.beans.CustomerInformation customer_information) throws Exception {
		
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
	}
	
	protected String getServiceUrl() {
	
//		TODO: try to lookup application property
		return service_url;
	}
	
	protected FocalMockupService getFocalService() throws MalformedURLException, ServiceException {
		
		FocalMockupServiceServiceLocator locator = new FocalMockupServiceServiceLocator();
		FocalMockupService service = locator.getFocalMockup(new URL(getServiceUrl()));
		return service;
	}
}