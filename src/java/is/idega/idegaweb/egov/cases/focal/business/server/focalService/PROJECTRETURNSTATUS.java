/**
 * PROJECTRETURNSTATUS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class PROJECTRETURNSTATUS  implements java.io.Serializable {
    private java.lang.String ERRORTEXT;

    private java.lang.String STATUS;

    private java.lang.String UNID;

    public PROJECTRETURNSTATUS() {
    }

    public PROJECTRETURNSTATUS(
           java.lang.String ERRORTEXT,
           java.lang.String STATUS,
           java.lang.String UNID) {
           this.ERRORTEXT = ERRORTEXT;
           this.STATUS = STATUS;
           this.UNID = UNID;
    }


    /**
     * Gets the ERRORTEXT value for this PROJECTRETURNSTATUS.
     * 
     * @return ERRORTEXT
     */
    public java.lang.String getERRORTEXT() {
        return ERRORTEXT;
    }


    /**
     * Sets the ERRORTEXT value for this PROJECTRETURNSTATUS.
     * 
     * @param ERRORTEXT
     */
    public void setERRORTEXT(java.lang.String ERRORTEXT) {
        this.ERRORTEXT = ERRORTEXT;
    }


    /**
     * Gets the STATUS value for this PROJECTRETURNSTATUS.
     * 
     * @return STATUS
     */
    public java.lang.String getSTATUS() {
        return STATUS;
    }


    /**
     * Sets the STATUS value for this PROJECTRETURNSTATUS.
     * 
     * @param STATUS
     */
    public void setSTATUS(java.lang.String STATUS) {
        this.STATUS = STATUS;
    }


    /**
     * Gets the UNID value for this PROJECTRETURNSTATUS.
     * 
     * @return UNID
     */
    public java.lang.String getUNID() {
        return UNID;
    }


    /**
     * Sets the UNID value for this PROJECTRETURNSTATUS.
     * 
     * @param UNID
     */
    public void setUNID(java.lang.String UNID) {
        this.UNID = UNID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PROJECTRETURNSTATUS)) return false;
        PROJECTRETURNSTATUS other = (PROJECTRETURNSTATUS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ERRORTEXT==null && other.getERRORTEXT()==null) || 
             (this.ERRORTEXT!=null &&
              this.ERRORTEXT.equals(other.getERRORTEXT()))) &&
            ((this.STATUS==null && other.getSTATUS()==null) || 
             (this.STATUS!=null &&
              this.STATUS.equals(other.getSTATUS()))) &&
            ((this.UNID==null && other.getUNID()==null) || 
             (this.UNID!=null &&
              this.UNID.equals(other.getUNID())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getERRORTEXT() != null) {
            _hashCode += getERRORTEXT().hashCode();
        }
        if (getSTATUS() != null) {
            _hashCode += getSTATUS().hashCode();
        }
        if (getUNID() != null) {
            _hashCode += getUNID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PROJECTRETURNSTATUS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "PROJECTRETURNSTATUS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRORTEXT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRORTEXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UNID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UNID"));
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
