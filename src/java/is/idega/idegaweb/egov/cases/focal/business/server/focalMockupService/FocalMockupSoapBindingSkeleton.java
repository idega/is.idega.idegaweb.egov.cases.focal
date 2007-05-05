/**
 * FocalMockupSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

public class FocalMockupSoapBindingSkeleton implements is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService, org.apache.axis.wsdl.Skeleton {
    private is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "search_str"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("findProjects", _params, new javax.xml.namespace.QName("", "findProjectsReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "ReturnedProjects"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "findProjects"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("findProjects") == null) {
            _myOperations.put("findProjects", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("findProjects")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "case_data"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "CaseData"), is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CaseData.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("createCase", _params, new javax.xml.namespace.QName("", "createCaseReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "Status"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "createCase"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createCase") == null) {
            _myOperations.put("createCase", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("createCase")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "search_str"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("findCustomer", _params, new javax.xml.namespace.QName("", "findCustomerReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "ArrayOfCustomerInformation"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "findCustomer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("findCustomer") == null) {
            _myOperations.put("findCustomer", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("findCustomer")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "personal_information"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "CustomerInformation"), is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("createUpdateCustomer", _params, new javax.xml.namespace.QName("", "createUpdateCustomerReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "Status"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "createUpdateCustomer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createUpdateCustomer") == null) {
            _myOperations.put("createUpdateCustomer", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("createUpdateCustomer")).add(_oper);
    }

    public FocalMockupSoapBindingSkeleton() {
        this.impl = new is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupSoapBindingImpl();
    }

    public FocalMockupSoapBindingSkeleton(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FocalMockupService impl) {
        this.impl = impl;
    }
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects findProjects(java.lang.String search_str) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ReturnedProjects ret = impl.findProjects(search_str);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status createCase(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CaseData case_data) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status ret = impl.createCase(case_data);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation[] findCustomer(java.lang.String search_str) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation[] ret = impl.findCustomer(search_str);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status createUpdateCustomer(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.CustomerInformation personal_information) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Status ret = impl.createUpdateCustomer(personal_information);
        return ret;
    }

}
