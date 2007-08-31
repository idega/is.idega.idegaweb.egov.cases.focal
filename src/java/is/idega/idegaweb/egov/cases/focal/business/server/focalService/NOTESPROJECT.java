/**
 * NOTESPROJECT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class NOTESPROJECT  implements java.io.Serializable {
    private java.lang.String PROJECTCUSTOMER;

    private java.lang.String PROJECTNAME;

    private java.lang.String PROJECTNUMBER;

    private java.lang.String PROJECTSTATUS;

    public NOTESPROJECT() {
    }

    public NOTESPROJECT(
           java.lang.String PROJECTCUSTOMER,
           java.lang.String PROJECTNAME,
           java.lang.String PROJECTNUMBER,
           java.lang.String PROJECTSTATUS) {
           this.PROJECTCUSTOMER = PROJECTCUSTOMER;
           this.PROJECTNAME = PROJECTNAME;
           this.PROJECTNUMBER = PROJECTNUMBER;
           this.PROJECTSTATUS = PROJECTSTATUS;
    }


    /**
     * Gets the PROJECTCUSTOMER value for this NOTESPROJECT.
     * 
     * @return PROJECTCUSTOMER
     */
    public java.lang.String getPROJECTCUSTOMER() {
        return PROJECTCUSTOMER;
    }


    /**
     * Sets the PROJECTCUSTOMER value for this NOTESPROJECT.
     * 
     * @param PROJECTCUSTOMER
     */
    public void setPROJECTCUSTOMER(java.lang.String PROJECTCUSTOMER) {
        this.PROJECTCUSTOMER = PROJECTCUSTOMER;
    }


    /**
     * Gets the PROJECTNAME value for this NOTESPROJECT.
     * 
     * @return PROJECTNAME
     */
    public java.lang.String getPROJECTNAME() {
        return PROJECTNAME;
    }


    /**
     * Sets the PROJECTNAME value for this NOTESPROJECT.
     * 
     * @param PROJECTNAME
     */
    public void setPROJECTNAME(java.lang.String PROJECTNAME) {
        this.PROJECTNAME = PROJECTNAME;
    }


    /**
     * Gets the PROJECTNUMBER value for this NOTESPROJECT.
     * 
     * @return PROJECTNUMBER
     */
    public java.lang.String getPROJECTNUMBER() {
        return PROJECTNUMBER;
    }


    /**
     * Sets the PROJECTNUMBER value for this NOTESPROJECT.
     * 
     * @param PROJECTNUMBER
     */
    public void setPROJECTNUMBER(java.lang.String PROJECTNUMBER) {
        this.PROJECTNUMBER = PROJECTNUMBER;
    }


    /**
     * Gets the PROJECTSTATUS value for this NOTESPROJECT.
     * 
     * @return PROJECTSTATUS
     */
    public java.lang.String getPROJECTSTATUS() {
        return PROJECTSTATUS;
    }


    /**
     * Sets the PROJECTSTATUS value for this NOTESPROJECT.
     * 
     * @param PROJECTSTATUS
     */
    public void setPROJECTSTATUS(java.lang.String PROJECTSTATUS) {
        this.PROJECTSTATUS = PROJECTSTATUS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NOTESPROJECT)) return false;
        NOTESPROJECT other = (NOTESPROJECT) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PROJECTCUSTOMER==null && other.getPROJECTCUSTOMER()==null) || 
             (this.PROJECTCUSTOMER!=null &&
              this.PROJECTCUSTOMER.equals(other.getPROJECTCUSTOMER()))) &&
            ((this.PROJECTNAME==null && other.getPROJECTNAME()==null) || 
             (this.PROJECTNAME!=null &&
              this.PROJECTNAME.equals(other.getPROJECTNAME()))) &&
            ((this.PROJECTNUMBER==null && other.getPROJECTNUMBER()==null) || 
             (this.PROJECTNUMBER!=null &&
              this.PROJECTNUMBER.equals(other.getPROJECTNUMBER()))) &&
            ((this.PROJECTSTATUS==null && other.getPROJECTSTATUS()==null) || 
             (this.PROJECTSTATUS!=null &&
              this.PROJECTSTATUS.equals(other.getPROJECTSTATUS())));
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
        if (getPROJECTCUSTOMER() != null) {
            _hashCode += getPROJECTCUSTOMER().hashCode();
        }
        if (getPROJECTNAME() != null) {
            _hashCode += getPROJECTNAME().hashCode();
        }
        if (getPROJECTNUMBER() != null) {
            _hashCode += getPROJECTNUMBER().hashCode();
        }
        if (getPROJECTSTATUS() != null) {
            _hashCode += getPROJECTSTATUS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NOTESPROJECT.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "NOTESPROJECT"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROJECTCUSTOMER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROJECTCUSTOMER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROJECTNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROJECTNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROJECTNUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROJECTNUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROJECTSTATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROJECTSTATUS"));
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
