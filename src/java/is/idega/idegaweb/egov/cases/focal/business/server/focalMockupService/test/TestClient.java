package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.test;

import java.net.URL;

import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupServiceServiceLocator;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData;
import is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects;

public class TestClient {

	public static void main(String[] args) {
		
		/*
		 * UserServiceServiceLocator userService = new UserServiceServiceLocator();
			// Now use the service to get a stub which implements the SDI.
			//CaseService port = service.getCaseService(new URL(endpoint)); //
			UserService port2 = userService.getUserService(new URL(endpointUserService));
			Stub stub = (Stub) port2;
			stub.setUsername("vufapp");
			stub.setPassword("8x4vf1");
			//NewCasePort port = service.getCreateNewCaseHttp();
			UserInfo ret2 = port2.getUserInfo("1703532189");
		 */
		
		try {
			
			FocalMockupServiceServiceLocator locator = new FocalMockupServiceServiceLocator();
			FocalMockupService service = locator.getFocalMockup(new URL("http://127.0.0.1:8080/services/FocalMockup"));
			
			ReturnedProjects projects = service.findProjects("huk");
			
			System.out.println("success?: "+projects.getStatus().isSuccess());
			
			ProjectMetaData[] meta_data = projects.getProjects();
			for (int i = 0; i < meta_data.length; i++) {
				
				System.out.println("project: "+meta_data[i].getProjectId()+" name: "+meta_data[i].getName());
				MainParty party = meta_data[i].getMainParty();
				System.out.println("party: "+party.getId()+" name: "+party.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}