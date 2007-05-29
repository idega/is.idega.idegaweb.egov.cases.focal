/**
 * DominoSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class DominoSoapBindingSkeleton implements is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project, org.apache.axis.wsdl.Skeleton {
    private is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("GETPROJECTLIST", _params, new javax.xml.namespace.QName("", "GETPROJECTLISTReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "GETPROJECTLIST"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("GETPROJECTLIST") == null) {
            _myOperations.put("GETPROJECTLIST", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("GETPROJECTLIST")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRSOCSECNUM"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("FINDCUSTOMER", _params, new javax.xml.namespace.QName("", "FINDCUSTOMERReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "FINDCUSTOMER"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FINDCUSTOMER") == null) {
            _myOperations.put("FINDCUSTOMER", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FINDCUSTOMER")).add(_oper);
    }

    public DominoSoapBindingSkeleton() {
        this.impl = new is.idega.idegaweb.egov.cases.focal.business.server.focalService.DominoSoapBindingImpl();
    }

    public DominoSoapBindingSkeleton(is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project impl) {
        this.impl = impl;
    }
    public java.lang.String GETPROJECTLIST(java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.GETPROJECTLIST(STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

    public java.lang.String FINDCUSTOMER(java.lang.String STRSOCSECNUM, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.FINDCUSTOMER(STRSOCSECNUM, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

}
