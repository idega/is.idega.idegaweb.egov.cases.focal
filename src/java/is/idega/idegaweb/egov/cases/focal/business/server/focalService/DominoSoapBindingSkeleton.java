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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRSEARCHSTRING"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRSEARCHTYPE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("GETPROJECTLIST", _params, new javax.xml.namespace.QName("", "GETPROJECTLISTReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECTARRAY"));
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
        _oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "CUSTOMER"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "FINDCUSTOMER"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("FINDCUSTOMER") == null) {
            _myOperations.put("FINDCUSTOMER", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("FINDCUSTOMER")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ATTACH"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "ATTACHMENT"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.ATTACHMENT.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUNID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("ADDATTACHMENT", _params, new javax.xml.namespace.QName("", "ADDATTACHMENTReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "ADDATTACHMENT"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("ADDATTACHMENT") == null) {
            _myOperations.put("ADDATTACHMENT", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("ADDATTACHMENT")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "CASEDATA"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("NEWPROJECT", _params, new javax.xml.namespace.QName("", "NEWPROJECTReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "PROJECTRETURNSTATUS"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "NEWPROJECT"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("NEWPROJECT") == null) {
            _myOperations.put("NEWPROJECT", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("NEWPROJECT")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CI"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "COMPANYINFO"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.COMPANYINFO.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("CREATEUPDATECOMPANY", _params, new javax.xml.namespace.QName("", "CREATEUPDATECOMPANYReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "CREATEUPDATECOMPANY"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("CREATEUPDATECOMPANY") == null) {
            _myOperations.put("CREATEUPDATECOMPANY", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("CREATEUPDATECOMPANY")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EI"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "EMPLOYEEINFO"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.EMPLOYEEINFO.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("CREATEUPDATEEMPLOYEE", _params, new javax.xml.namespace.QName("", "CREATEUPDATEEMPLOYEEReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "CREATEUPDATEEMPLOYEE"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("CREATEUPDATEEMPLOYEE") == null) {
            _myOperations.put("CREATEUPDATEEMPLOYEE", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("CREATEUPDATEEMPLOYEE")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "PERS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "PERSONINFO"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("CREATEUPDATEPERSON", _params, new javax.xml.namespace.QName("", "CREATEUPDATEPERSONReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:DefaultNamespace", "CREATEUPDATEPERSON"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("CREATEUPDATEPERSON") == null) {
            _myOperations.put("CREATEUPDATEPERSON", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("CREATEUPDATEPERSON")).add(_oper);
    }

    public DominoSoapBindingSkeleton() {
        this.impl = new is.idega.idegaweb.egov.cases.focal.business.server.focalService.DominoSoapBindingImpl();
    }

    public DominoSoapBindingSkeleton(is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project impl) {
        this.impl = impl;
    }
    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY GETPROJECTLIST(java.lang.String STRSEARCHSTRING, java.lang.String STRSEARCHTYPE, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY ret = impl.GETPROJECTLIST(STRSEARCHSTRING, STRSEARCHTYPE, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER FINDCUSTOMER(java.lang.String STRSOCSECNUM, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER ret = impl.FINDCUSTOMER(STRSOCSECNUM, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS ADDATTACHMENT(is.idega.idegaweb.egov.cases.focal.business.server.focalService.ATTACHMENT ATTACH, java.lang.String STRUNID, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS ret = impl.ADDATTACHMENT(ATTACH, STRUNID, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS NEWPROJECT(is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA CD, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS ret = impl.NEWPROJECT(CD, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATECOMPANY(is.idega.idegaweb.egov.cases.focal.business.server.focalService.COMPANYINFO CI, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS ret = impl.CREATEUPDATECOMPANY(CI, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATEEMPLOYEE(is.idega.idegaweb.egov.cases.focal.business.server.focalService.EMPLOYEEINFO EI, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS ret = impl.CREATEUPDATEEMPLOYEE(EI, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATEPERSON(is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO PERS, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException
    {
        is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS ret = impl.CREATEUPDATEPERSON(PERS, STRPROFILEKEY, STRUSERNAME, STRPASSWORD);
        return ret;
    }

}
