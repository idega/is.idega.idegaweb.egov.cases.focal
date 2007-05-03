/**
 * FPStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

public class FPStatus  implements java.io.Serializable {
    private boolean noCustomer;

    private boolean noProjects;

    private boolean success;

    public FPStatus() {
    }

    public FPStatus(
           boolean noCustomer,
           boolean noProjects,
           boolean success) {
           this.noCustomer = noCustomer;
           this.noProjects = noProjects;
           this.success = success;
    }


    /**
     * Gets the noCustomer value for this FPStatus.
     * 
     * @return noCustomer
     */
    public boolean isNoCustomer() {
        return noCustomer;
    }


    /**
     * Sets the noCustomer value for this FPStatus.
     * 
     * @param noCustomer
     */
    public void setNoCustomer(boolean noCustomer) {
        this.noCustomer = noCustomer;
    }


    /**
     * Gets the noProjects value for this FPStatus.
     * 
     * @return noProjects
     */
    public boolean isNoProjects() {
        return noProjects;
    }


    /**
     * Sets the noProjects value for this FPStatus.
     * 
     * @param noProjects
     */
    public void setNoProjects(boolean noProjects) {
        this.noProjects = noProjects;
    }


    /**
     * Gets the success value for this FPStatus.
     * 
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }


    /**
     * Sets the success value for this FPStatus.
     * 
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FPStatus)) return false;
        FPStatus other = (FPStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.noCustomer == other.isNoCustomer() &&
            this.noProjects == other.isNoProjects() &&
            this.success == other.isSuccess();
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
        _hashCode += (isNoCustomer() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isNoProjects() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSuccess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FPStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "FPStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noCustomer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noCustomer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noProjects");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noProjects"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("success");
        elemField.setXmlName(new javax.xml.namespace.QName("", "success"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
