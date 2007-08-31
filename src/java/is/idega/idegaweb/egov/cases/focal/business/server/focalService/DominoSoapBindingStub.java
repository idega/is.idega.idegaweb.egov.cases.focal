/**
 * DominoSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class DominoSoapBindingStub extends org.apache.axis.client.Stub implements is.idega.idegaweb.egov.cases.focal.business.server.focalService.Project {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GETPROJECTLIST");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRSEARCHSTRING"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRSEARCHTYPE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECTARRAY"));
        oper.setReturnClass(is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "GETPROJECTLISTReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("FINDCUSTOMER");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRSOCSECNUM"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "CUSTOMER"));
        oper.setReturnClass(is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "FINDCUSTOMERReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ADDATTACHMENT");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ATTACH"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "ATTACHMENT"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.ATTACHMENT.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUNID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        oper.setReturnClass(is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ADDATTACHMENTReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("NEWPROJECT");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "CASEDATA"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "PROJECTRETURNSTATUS"));
        oper.setReturnClass(is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "NEWPROJECTReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CREATEUPDATECOMPANY");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CI"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "COMPANYINFO"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.COMPANYINFO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        oper.setReturnClass(is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CREATEUPDATECOMPANYReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CREATEUPDATEEMPLOYEE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EI"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "EMPLOYEEINFO"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.EMPLOYEEINFO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        oper.setReturnClass(is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CREATEUPDATEEMPLOYEEReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CREATEUPDATEPERSON");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "PERS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:DefaultNamespace", "PERSONINFO"), is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPROFILEKEY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRUSERNAME"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "STRPASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS"));
        oper.setReturnClass(is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CREATEUPDATEPERSONReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

    }

    public DominoSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public DominoSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public DominoSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "ArrayOfNOTESPROJECT");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECT[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECT");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "ATTACHMENT");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.ATTACHMENT.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "CASEDATA");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "COMPANYINFO");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.COMPANYINFO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "CUSTOMER");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "EMPLOYEEINFO");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.EMPLOYEEINFO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECT");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECT.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECTARRAY");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "PERSONINFO");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "PROJECTRETURNSTATUS");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:DefaultNamespace", "RETURNSTATUS");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY GETPROJECTLIST(java.lang.String STRSEARCHSTRING, java.lang.String STRSEARCHTYPE, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:DefaultNamespace", "GETPROJECTLIST"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {STRSEARCHSTRING, STRSEARCHTYPE, STRPROFILEKEY, STRUSERNAME, STRPASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECTARRAY.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER FINDCUSTOMER(java.lang.String STRSOCSECNUM, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:DefaultNamespace", "FINDCUSTOMER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {STRSOCSECNUM, STRPROFILEKEY, STRUSERNAME, STRPASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMER.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS ADDATTACHMENT(is.idega.idegaweb.egov.cases.focal.business.server.focalService.ATTACHMENT ATTACH, java.lang.String STRUNID, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:DefaultNamespace", "ADDATTACHMENT"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ATTACH, STRUNID, STRPROFILEKEY, STRUSERNAME, STRPASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS NEWPROJECT(is.idega.idegaweb.egov.cases.focal.business.server.focalService.CASEDATA CD, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:DefaultNamespace", "NEWPROJECT"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CD, STRPROFILEKEY, STRUSERNAME, STRPASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.cases.focal.business.server.focalService.PROJECTRETURNSTATUS.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATECOMPANY(is.idega.idegaweb.egov.cases.focal.business.server.focalService.COMPANYINFO CI, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:DefaultNamespace", "CREATEUPDATECOMPANY"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CI, STRPROFILEKEY, STRUSERNAME, STRPASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATEEMPLOYEE(is.idega.idegaweb.egov.cases.focal.business.server.focalService.EMPLOYEEINFO EI, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:DefaultNamespace", "CREATEUPDATEEMPLOYEE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {EI, STRPROFILEKEY, STRUSERNAME, STRPASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS CREATEUPDATEPERSON(is.idega.idegaweb.egov.cases.focal.business.server.focalService.PERSONINFO PERS, java.lang.String STRPROFILEKEY, java.lang.String STRUSERNAME, java.lang.String STRPASSWORD) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:DefaultNamespace", "CREATEUPDATEPERSON"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {PERS, STRPROFILEKEY, STRUSERNAME, STRPASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
