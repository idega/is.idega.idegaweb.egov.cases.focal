/**
 * COMPANYINFO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class COMPANYINFO  extends is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMERBASE  implements java.io.Serializable {
    private java.lang.String COMPANYNAME;

    private java.lang.String LOCATION;

    public COMPANYINFO() {
    }

    public COMPANYINFO(
           java.lang.String ADDRESS1,
           java.lang.String ADDRESS2,
           java.lang.String COUNTY,
           java.lang.String COUNTRY,
           java.lang.String EMAIL,
           java.lang.String FAX,
           java.lang.String HOMEPAGE,
           java.lang.String LANGUAGE,
           java.lang.String PHONEWORK,
           java.lang.String POSTADDRESS,
           java.lang.String SOCSECNUM,
           java.lang.String STATUS,
           boolean TARGETMAIL,
           java.lang.String COMPANYNAME,
           java.lang.String LOCATION) {
        super(
            ADDRESS1,
            ADDRESS2,
            COUNTY,
            COUNTRY,
            EMAIL,
            FAX,
            HOMEPAGE,
            LANGUAGE,
            PHONEWORK,
            POSTADDRESS,
            SOCSECNUM,
            STATUS,
            TARGETMAIL);
        this.COMPANYNAME = COMPANYNAME;
        this.LOCATION = LOCATION;
    }


    /**
     * Gets the COMPANYNAME value for this COMPANYINFO.
     * 
     * @return COMPANYNAME
     */
    public java.lang.String getCOMPANYNAME() {
        return COMPANYNAME;
    }


    /**
     * Sets the COMPANYNAME value for this COMPANYINFO.
     * 
     * @param COMPANYNAME
     */
    public void setCOMPANYNAME(java.lang.String COMPANYNAME) {
        this.COMPANYNAME = COMPANYNAME;
    }


    /**
     * Gets the LOCATION value for this COMPANYINFO.
     * 
     * @return LOCATION
     */
    public java.lang.String getLOCATION() {
        return LOCATION;
    }


    /**
     * Sets the LOCATION value for this COMPANYINFO.
     * 
     * @param LOCATION
     */
    public void setLOCATION(java.lang.String LOCATION) {
        this.LOCATION = LOCATION;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof COMPANYINFO)) return false;
        COMPANYINFO other = (COMPANYINFO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.COMPANYNAME==null && other.getCOMPANYNAME()==null) || 
             (this.COMPANYNAME!=null &&
              this.COMPANYNAME.equals(other.getCOMPANYNAME()))) &&
            ((this.LOCATION==null && other.getLOCATION()==null) || 
             (this.LOCATION!=null &&
              this.LOCATION.equals(other.getLOCATION())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCOMPANYNAME() != null) {
            _hashCode += getCOMPANYNAME().hashCode();
        }
        if (getLOCATION() != null) {
            _hashCode += getLOCATION().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(COMPANYINFO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "COMPANYINFO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMPANYNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COMPANYNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOCATION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOCATION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
