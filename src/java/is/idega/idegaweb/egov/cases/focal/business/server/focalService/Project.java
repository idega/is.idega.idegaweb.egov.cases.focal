/**
 * Project.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public interface Project extends java.rmi.Remote {
    public java.lang.String GETPROJECTLIST(java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException;
    public java.lang.String FINDCUSTOMER(java.lang.String STRSOCSECNUM, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException;
    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS NEWPROJECT(is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA CD, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException;
    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATECOMPANY(is.idega.idegaweb.egov.cases.focal.business.server.focalService.COMPANYINFO CI, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException;
    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATEEMPLOYEE(is.idega.idegaweb.egov.cases.focal.business.server.focalService.EMPLOYEEINFO EI, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException;
    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATEPERSON(is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO PERS, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException;
    public java.lang.String GETPROFILEDOCUMENT(java.lang.String STRPROFILEKEY) throws java.rmi.RemoteException;
}
