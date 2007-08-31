/**
 * CASEDATA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class CASEDATA  implements java.io.Serializable {
    private java.lang.String BODY;

    private java.lang.String CUSTOMERNAME;

    private java.lang.String CREATEDATE;

    private java.lang.String PROJECTNAME;

    private java.lang.String PROJECTNUMBER;

    private java.lang.String SOCSECNUM;

    private java.lang.String SUBJECT;

    public CASEDATA() {
    }

    public CASEDATA(
           java.lang.String BODY,
           java.lang.String CUSTOMERNAME,
           java.lang.String CREATEDATE,
           java.lang.String PROJECTNAME,
           java.lang.String PROJECTNUMBER,
           java.lang.String SOCSECNUM,
           java.lang.String SUBJECT) {
           this.BODY = BODY;
           this.CUSTOMERNAME = CUSTOMERNAME;
           this.CREATEDATE = CREATEDATE;
           this.PROJECTNAME = PROJECTNAME;
           this.PROJECTNUMBER = PROJECTNUMBER;
           this.SOCSECNUM = SOCSECNUM;
           this.SUBJECT = SUBJECT;
    }


    /**
     * Gets the BODY value for this CASEDATA.
     * 
     * @return BODY
     */
    public java.lang.String getBODY() {
        return BODY;
    }


    /**
     * Sets the BODY value for this CASEDATA.
     * 
     * @param BODY
     */
    public void setBODY(java.lang.String BODY) {
        this.BODY = BODY;
    }


    /**
     * Gets the CUSTOMERNAME value for this CASEDATA.
     * 
     * @return CUSTOMERNAME
     */
    public java.lang.String getCUSTOMERNAME() {
        return CUSTOMERNAME;
    }


    /**
     * Sets the CUSTOMERNAME value for this CASEDATA.
     * 
     * @param CUSTOMERNAME
     */
    public void setCUSTOMERNAME(java.lang.String CUSTOMERNAME) {
        this.CUSTOMERNAME = CUSTOMERNAME;
    }


    /**
     * Gets the CREATEDATE value for this CASEDATA.
     * 
     * @return CREATEDATE
     */
    public java.lang.String getCREATEDATE() {
        return CREATEDATE;
    }


    /**
     * Sets the CREATEDATE value for this CASEDATA.
     * 
     * @param CREATEDATE
     */
    public void setCREATEDATE(java.lang.String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }


    /**
     * Gets the PROJECTNAME value for this CASEDATA.
     * 
     * @return PROJECTNAME
     */
    public java.lang.String getPROJECTNAME() {
        return PROJECTNAME;
    }


    /**
     * Sets the PROJECTNAME value for this CASEDATA.
     * 
     * @param PROJECTNAME
     */
    public void setPROJECTNAME(java.lang.String PROJECTNAME) {
        this.PROJECTNAME = PROJECTNAME;
    }


    /**
     * Gets the PROJECTNUMBER value for this CASEDATA.
     * 
     * @return PROJECTNUMBER
     */
    public java.lang.String getPROJECTNUMBER() {
        return PROJECTNUMBER;
    }


    /**
     * Sets the PROJECTNUMBER value for this CASEDATA.
     * 
     * @param PROJECTNUMBER
     */
    public void setPROJECTNUMBER(java.lang.String PROJECTNUMBER) {
        this.PROJECTNUMBER = PROJECTNUMBER;
    }


    /**
     * Gets the SOCSECNUM value for this CASEDATA.
     * 
     * @return SOCSECNUM
     */
    public java.lang.String getSOCSECNUM() {
        return SOCSECNUM;
    }


    /**
     * Sets the SOCSECNUM value for this CASEDATA.
     * 
     * @param SOCSECNUM
     */
    public void setSOCSECNUM(java.lang.String SOCSECNUM) {
        this.SOCSECNUM = SOCSECNUM;
    }


    /**
     * Gets the SUBJECT value for this CASEDATA.
     * 
     * @return SUBJECT
     */
    public java.lang.String getSUBJECT() {
        return SUBJECT;
    }


    /**
     * Sets the SUBJECT value for this CASEDATA.
     * 
     * @param SUBJECT
     */
    public void setSUBJECT(java.lang.String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CASEDATA)) return false;
        CASEDATA other = (CASEDATA) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BODY==null && other.getBODY()==null) || 
             (this.BODY!=null &&
              this.BODY.equals(other.getBODY()))) &&
            ((this.CUSTOMERNAME==null && other.getCUSTOMERNAME()==null) || 
             (this.CUSTOMERNAME!=null &&
              this.CUSTOMERNAME.equals(other.getCUSTOMERNAME()))) &&
            ((this.CREATEDATE==null && other.getCREATEDATE()==null) || 
             (this.CREATEDATE!=null &&
              this.CREATEDATE.equals(other.getCREATEDATE()))) &&
            ((this.PROJECTNAME==null && other.getPROJECTNAME()==null) || 
             (this.PROJECTNAME!=null &&
              this.PROJECTNAME.equals(other.getPROJECTNAME()))) &&
            ((this.PROJECTNUMBER==null && other.getPROJECTNUMBER()==null) || 
             (this.PROJECTNUMBER!=null &&
              this.PROJECTNUMBER.equals(other.getPROJECTNUMBER()))) &&
            ((this.SOCSECNUM==null && other.getSOCSECNUM()==null) || 
             (this.SOCSECNUM!=null &&
              this.SOCSECNUM.equals(other.getSOCSECNUM()))) &&
            ((this.SUBJECT==null && other.getSUBJECT()==null) || 
             (this.SUBJECT!=null &&
              this.SUBJECT.equals(other.getSUBJECT())));
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
        if (getBODY() != null) {
            _hashCode += getBODY().hashCode();
        }
        if (getCUSTOMERNAME() != null) {
            _hashCode += getCUSTOMERNAME().hashCode();
        }
        if (getCREATEDATE() != null) {
            _hashCode += getCREATEDATE().hashCode();
        }
        if (getPROJECTNAME() != null) {
            _hashCode += getPROJECTNAME().hashCode();
        }
        if (getPROJECTNUMBER() != null) {
            _hashCode += getPROJECTNUMBER().hashCode();
        }
        if (getSOCSECNUM() != null) {
            _hashCode += getSOCSECNUM().hashCode();
        }
        if (getSUBJECT() != null) {
            _hashCode += getSUBJECT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CASEDATA.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "CASEDATA"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BODY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BODY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUSTOMERNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CUSTOMERNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CREATEDATE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CREATEDATE"));
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
        elemField.setFieldName("SOCSECNUM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SOCSECNUM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUBJECT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SUBJECT"));
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
