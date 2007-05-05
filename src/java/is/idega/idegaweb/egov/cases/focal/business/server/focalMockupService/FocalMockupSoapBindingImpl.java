/**
 * FocalMockupSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

import java.io.File;
import java.io.FileOutputStream;

public class FocalMockupSoapBindingImpl implements is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService{
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
    	System.out.println("cia cia cia");
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status status = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status();
    	status.setSuccess(true);
    	
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Attachment[] attachements = case_data.getAttachments();
    	System.out.println("ats: "+attachements.length);
    	
    	if(attachements !=  null) {
    		
    		for (int i = 0; i < attachements.length; i++) {
    			
    			System.out.println("filesize: "+attachements[i].getFileSize());
    			System.out.println("fname: "+attachements[i].getFName());
    			System.out.println("barray size: "+attachements[i].getFile().length);
    			
    			try {
    				File simple_output = new File("/Users/civilis/tmp/pic_output.jpg");
        			FileOutputStream output = new FileOutputStream(simple_output);
        			output.write(attachements[i].getFile());
        			output.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	}
    	
        return status;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation[] findCustomer(java.lang.String search_str) throws java.rmi.RemoteException {
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation info = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation();
    	
    	info.setCustomerId("some customer id");
    	info.setEmail("email@xx.lt");
    	info.setName("customer name");
    	info.setPhone("00-00-call-me-tonight");
    	
        return  new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation[] {info};
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status createUpdateCustomer(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation personal_information) throws java.rmi.RemoteException {
    	
    	is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status status = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status();
    	status.setSuccess(true);
    	
        return status;
    }

}
