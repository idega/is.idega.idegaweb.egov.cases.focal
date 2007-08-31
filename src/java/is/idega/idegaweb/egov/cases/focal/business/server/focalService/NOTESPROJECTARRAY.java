/**
 * NOTESPROJECTARRAY.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class NOTESPROJECTARRAY  extends is.idega.idegaweb.egov.cases.focal.business.server.focalService.RETURNSTATUS  implements java.io.Serializable {
    private short COUNT;

    private is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECT[] PROJECTARRAY;

    public NOTESPROJECTARRAY() {
    }

    public NOTESPROJECTARRAY(
           java.lang.String ERRORTEXT,
           java.lang.String STATUS,
           short COUNT,
           is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECT[] PROJECTARRAY) {
        super(
            ERRORTEXT,
            STATUS);
        this.COUNT = COUNT;
        this.PROJECTARRAY = PROJECTARRAY;
    }


    /**
     * Gets the COUNT value for this NOTESPROJECTARRAY.
     * 
     * @return COUNT
     */
    public short getCOUNT() {
        return COUNT;
    }


    /**
     * Sets the COUNT value for this NOTESPROJECTARRAY.
     * 
     * @param COUNT
     */
    public void setCOUNT(short COUNT) {
        this.COUNT = COUNT;
    }


    /**
     * Gets the PROJECTARRAY value for this NOTESPROJECTARRAY.
     * 
     * @return PROJECTARRAY
     */
    public is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECT[] getPROJECTARRAY() {
        return PROJECTARRAY;
    }


    /**
     * Sets the PROJECTARRAY value for this NOTESPROJECTARRAY.
     * 
     * @param PROJECTARRAY
     */
    public void setPROJECTARRAY(is.idega.idegaweb.egov.cases.focal.business.server.focalService.NOTESPROJECT[] PROJECTARRAY) {
        this.PROJECTARRAY = PROJECTARRAY;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NOTESPROJECTARRAY)) return false;
        NOTESPROJECTARRAY other = (NOTESPROJECTARRAY) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.COUNT == other.getCOUNT() &&
            ((this.PROJECTARRAY==null && other.getPROJECTARRAY()==null) || 
             (this.PROJECTARRAY!=null &&
              java.util.Arrays.equals(this.PROJECTARRAY, other.getPROJECTARRAY())));
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
        _hashCode += getCOUNT();
        if (getPROJECTARRAY() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPROJECTARRAY());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPROJECTARRAY(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NOTESPROJECTARRAY.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECTARRAY"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COUNT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COUNT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROJECTARRAY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROJECTARRAY"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECT"));
        elemField.setNillable(true);
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
