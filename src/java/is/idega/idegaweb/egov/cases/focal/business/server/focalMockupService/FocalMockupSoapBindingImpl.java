/**
 * FocalMockupSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

public class FocalMockupSoapBindingImpl implements is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService {
	
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects findProjects(java.lang.String search_str) throws java.rmi.RemoteException {
    
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects projects = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects();
    	
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData[] project_meta_datas = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData[] {
    		new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData(), new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData()
    	};
    	
    	for (int i = 0; i < project_meta_datas.length; i++) {
			
    		project_meta_datas[i].setName("Project Name "+(i+1));
    		project_meta_datas[i].setProjectId("pid_"+i);
    		
    		is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty party = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty();
    		party.setId("partyid_"+i);
    		party.setName("Party Name "+(i+1)+" "+search_str);
    		project_meta_datas[i].setMainParty(party);
		}
    	
    	projects.setProjects(project_meta_datas);
    	
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus status = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus();
    	status.setSuccess(true);
    	projects.setStatus(status);
    	
        return projects;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status createCase(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CaseData case_data) throws java.rmi.RemoteException {
    	
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status status = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status();
    	status.setSuccess(true);
    	
        return status;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerPersonalInformation findCustomer(java.lang.String search_str) throws java.rmi.RemoteException {
    	
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerPersonalInformation info = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerPersonalInformation();
    	
    	info.setCustomerId("some customer id");
    	info.setEmail("email@xx.lt");
    	info.setName("customer name");
    	info.setPhone("00-00-call-me-tonight");
    	
        return info;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status createUpdateCustomer(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerPersonalInformation personal_information) throws java.rmi.RemoteException {
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status status = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status();
    	status.setSuccess(true);
    	
        return status;
    }
}
