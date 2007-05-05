/**
 * FocalMockupService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

public interface FocalMockupService extends java.rmi.Remote {
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects findProjects(java.lang.String search_str) throws java.rmi.RemoteException;
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status createCase(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CaseData case_data) throws java.rmi.RemoteException;
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation[] findCustomer(java.lang.String search_str) throws java.rmi.RemoteException;
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status createUpdateCustomer(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation personal_information) throws java.rmi.RemoteException;
}
