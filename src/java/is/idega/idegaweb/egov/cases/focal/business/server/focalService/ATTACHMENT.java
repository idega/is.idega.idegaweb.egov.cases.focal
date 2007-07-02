/**
 * ATTACHMENT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class ATTACHMENT  implements java.io.Serializable {
    private java.lang.String FILENAME;

    private byte[] BASE64;

    private int FILESIZE;

    public ATTACHMENT() {
    }

    public ATTACHMENT(
           java.lang.String FILENAME,
           byte[] BASE64,
           int FILESIZE) {
           this.FILENAME = FILENAME;
           this.BASE64 = BASE64;
           this.FILESIZE = FILESIZE;
    }


    /**
     * Gets the FILENAME value for this ATTACHMENT.
     * 
     * @return FILENAME
     */
    public java.lang.String getFILENAME() {
        return FILENAME;
    }


    /**
     * Sets the FILENAME value for this ATTACHMENT.
     * 
     * @param FILENAME
     */
    public void setFILENAME(java.lang.String FILENAME) {
        this.FILENAME = FILENAME;
    }


    /**
     * Gets the BASE64 value for this ATTACHMENT.
     * 
     * @return BASE64
     */
    public byte[] getBASE64() {
        return BASE64;
    }


    /**
     * Sets the BASE64 value for this ATTACHMENT.
     * 
     * @param BASE64
     */
    public void setBASE64(byte[] BASE64) {
        this.BASE64 = BASE64;
    }


    /**
     * Gets the FILESIZE value for this ATTACHMENT.
     * 
     * @return FILESIZE
     */
    public int getFILESIZE() {
        return FILESIZE;
    }


    /**
     * Sets the FILESIZE value for this ATTACHMENT.
     * 
     * @param FILESIZE
     */
    public void setFILESIZE(int FILESIZE) {
        this.FILESIZE = FILESIZE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ATTACHMENT)) return false;
        ATTACHMENT other = (ATTACHMENT) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FILENAME==null && other.getFILENAME()==null) || 
             (this.FILENAME!=null &&
              this.FILENAME.equals(other.getFILENAME()))) &&
            ((this.BASE64==null && other.getBASE64()==null) || 
             (this.BASE64!=null &&
              java.util.Arrays.equals(this.BASE64, other.getBASE64()))) &&
            this.FILESIZE == other.getFILESIZE();
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
        if (getFILENAME() != null) {
            _hashCode += getFILENAME().hashCode();
        }
        if (getBASE64() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBASE64());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBASE64(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getFILESIZE();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ATTACHMENT.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "ATTACHMENT"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FILENAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FILENAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BASE64");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BASE64"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FILESIZE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FILESIZE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
