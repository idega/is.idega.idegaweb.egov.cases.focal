/**
 * ProjectServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class ProjectServiceLocator extends org.apache.axis.client.Service implements is.idega.idegaweb.egov.cases.focal.business.server.focalService.ProjectService {

    public ProjectServiceLocator() {
    }


    public ProjectServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProjectServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Domino
    private java.lang.String Domino_address = "http://217.28.176.153:80/Demo/idega/idegaweb.nsf/idegaproject?OpenWebService";

    public java.lang.String getDominoAddress() {
        return Domino_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DominoWSDDServiceName = "Domino";

    public java.lang.String getDominoWSDDServiceName() {
        return DominoWSDDServiceName;
    }

    public void setDominoWSDDServiceName(java.lang.String name) {
        DominoWSDDServiceName = name;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project getDomino() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Domino_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDomino(endpoint);
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project getDomino(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            is.idega.idegaweb.egov.cases.focal.business.server.focalService.DominoSoapBindingStub _stub = new is.idega.idegaweb.egov.cases.focal.business.server.focalService.DominoSoapBindingStub(portAddress, this);
            _stub.setPortName(getDominoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDominoEndpointAddress(java.lang.String address) {
        Domino_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project.class.isAssignableFrom(serviceEndpointInterface)) {
                is.idega.idegaweb.egov.cases.focal.business.server.focalService.DominoSoapBindingStub _stub = new is.idega.idegaweb.egov.cases.focal.business.server.focalService.DominoSoapBindingStub(new java.net.URL(Domino_address), this);
                _stub.setPortName(getDominoWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Domino".equals(inputPortName)) {
            return getDomino();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:DefaultNamespace", "ProjectService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:DefaultNamespace", "Domino"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Domino".equals(portName)) {
            setDominoEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
