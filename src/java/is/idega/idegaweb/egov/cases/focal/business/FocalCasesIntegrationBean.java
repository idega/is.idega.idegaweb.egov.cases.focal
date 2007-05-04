package is.idega.idegaweb.egov.cases.focal.business;

import is.idega.idegaweb.egov.cases.focal.business.beans.ProjectData;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupServiceServiceLocator;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.idega.business.IBOServiceBean;

/**
 * 
 * Last modified: $Date: 2007/05/04 09:22:19 $ by $Author: civilis $
 * 
 * @author <a href="civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 */
public class FocalCasesIntegrationBean extends IBOServiceBean implements FocalCasesIntegration {

	private static final long serialVersionUID = -486408791846081399L;
	private static final String service_url = "http://127.0.0.1:8080/services/FocalMockup";

	public List findProjects(String search_txt) throws UnsuccessfulStatusException, Exception {
	
		FocalMockupService service = getFocalService();
		ReturnedProjects projects_ret = service.findProjects(search_txt);
		
		FPStatus status = projects_ret.getStatus();
		
		if(!status.isSuccess()) {
			
			UnsuccessfulStatusException ex = new UnsuccessfulStatusException("Projects could not be found/retrieved due to reason decribed in status (see getStatus())");
			
			if(status.isNoCustomer())
				ex.setStatus(UnsuccessfulStatusException.no_customer);
			else if(status.isNoProjects())
				ex.setStatus(UnsuccessfulStatusException.no_projects);
			else
				ex.setStatus(UnsuccessfulStatusException.unknown_fail);
			
			throw ex;
		}
		
		ProjectMetaData[] projects_data = projects_ret.getProjects();
		
		if(projects_data == null) {
			
			UnsuccessfulStatusException ex = new UnsuccessfulStatusException("Projects were not set, but status set to success");
			ex.setStatus(UnsuccessfulStatusException.unknown_fail);
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