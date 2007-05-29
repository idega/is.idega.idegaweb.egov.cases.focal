/**
 * ProjectService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public interface ProjectService extends javax.xml.rpc.Service {
    public java.lang.String getDominoAddress();

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project getDomino() throws javax.xml.rpc.ServiceException;

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project getDomino(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
