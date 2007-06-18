/**
 * CUSTOMERBASE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class CUSTOMERBASE  implements java.io.Serializable {
    private java.lang.String ADDRESS1;

    private java.lang.String ADDRESS2;

    private java.lang.String COUNTY;

    private java.lang.String COUNTRY;

    private java.lang.String EMAIL;

    private java.lang.String FAX;

    private java.lang.String HOMEPAGE;

    private java.lang.String LANGUAGE;

    private java.lang.String PHONEWORK;

    private java.lang.String POSTADDRESS;

    private java.lang.String SOCSECNUM;

    private java.lang.String STATUS;

    private boolean TARGETMAIL;

    public CUSTOMERBASE() {
    }

    public CUSTOMERBASE(
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
           boolean TARGETMAIL) {
           this.ADDRESS1 = ADDRESS1;
           this.ADDRESS2 = ADDRESS2;
           this.COUNTY = COUNTY;
           this.COUNTRY = COUNTRY;
           this.EMAIL = EMAIL;
           this.FAX = FAX;
           this.HOMEPAGE = HOMEPAGE;
           this.LANGUAGE = LANGUAGE;
           this.PHONEWORK = PHONEWORK;
           this.POSTADDRESS = POSTADDRESS;
           this.SOCSECNUM = SOCSECNUM;
           this.STATUS = STATUS;
           this.TARGETMAIL = TARGETMAIL;
    }


    /**
     * Gets the ADDRESS1 value for this CUSTOMERBASE.
     * 
     * @return ADDRESS1
     */
    public java.lang.String getADDRESS1() {
        return ADDRESS1;
    }


    /**
     * Sets the ADDRESS1 value for this CUSTOMERBASE.
     * 
     * @param ADDRESS1
     */
    public void setADDRESS1(java.lang.String ADDRESS1) {
        this.ADDRESS1 = ADDRESS1;
    }


    /**
     * Gets the ADDRESS2 value for this CUSTOMERBASE.
     * 
     * @return ADDRESS2
     */
    public java.lang.String getADDRESS2() {
        return ADDRESS2;
    }


    /**
     * Sets the ADDRESS2 value for this CUSTOMERBASE.
     * 
     * @param ADDRESS2
     */
    public void setADDRESS2(java.lang.String ADDRESS2) {
        this.ADDRESS2 = ADDRESS2;
    }


    /**
     * Gets the COUNTY value for this CUSTOMERBASE.
     * 
     * @return COUNTY
     */
    public java.lang.String getCOUNTY() {
        return COUNTY;
    }


    /**
     * Sets the COUNTY value for this CUSTOMERBASE.
     * 
     * @param COUNTY
     */
    public void setCOUNTY(java.lang.String COUNTY) {
        this.COUNTY = COUNTY;
    }


    /**
     * Gets the COUNTRY value for this CUSTOMERBASE.
     * 
     * @return COUNTRY
     */
    public java.lang.String getCOUNTRY() {
        return COUNTRY;
    }


    /**
     * Sets the COUNTRY value for this CUSTOMERBASE.
     * 
     * @param COUNTRY
     */
    public void setCOUNTRY(java.lang.String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }


    /**
     * Gets the EMAIL value for this CUSTOMERBASE.
     * 
     * @return EMAIL
     */
    public java.lang.String getEMAIL() {
        return EMAIL;
    }


    /**
     * Sets the EMAIL value for this CUSTOMERBASE.
     * 
     * @param EMAIL
     */
    public void setEMAIL(java.lang.String EMAIL) {
        this.EMAIL = EMAIL;
    }


    /**
     * Gets the FAX value for this CUSTOMERBASE.
     * 
     * @return FAX
     */
    public java.lang.String getFAX() {
        return FAX;
    }


    /**
     * Sets the FAX value for this CUSTOMERBASE.
     * 
     * @param FAX
     */
    public void setFAX(java.lang.String FAX) {
        this.FAX = FAX;
    }


    /**
     * Gets the HOMEPAGE value for this CUSTOMERBASE.
     * 
     * @return HOMEPAGE
     */
    public java.lang.String getHOMEPAGE() {
        return HOMEPAGE;
    }


    /**
     * Sets the HOMEPAGE value for this CUSTOMERBASE.
     * 
     * @param HOMEPAGE
     */
    public void setHOMEPAGE(java.lang.String HOMEPAGE) {
        this.HOMEPAGE = HOMEPAGE;
    }


    /**
     * Gets the LANGUAGE value for this CUSTOMERBASE.
     * 
     * @return LANGUAGE
     */
    public java.lang.String getLANGUAGE() {
        return LANGUAGE;
    }


    /**
     * Sets the LANGUAGE value for this CUSTOMERBASE.
     * 
     * @param LANGUAGE
     */
    public void setLANGUAGE(java.lang.String LANGUAGE) {
        this.LANGUAGE = LANGUAGE;
    }


    /**
     * Gets the PHONEWORK value for this CUSTOMERBASE.
     * 
     * @return PHONEWORK
     */
    public java.lang.String getPHONEWORK() {
        return PHONEWORK;
    }


    /**
     * Sets the PHONEWORK value for this CUSTOMERBASE.
     * 
     * @param PHONEWORK
     */
    public void setPHONEWORK(java.lang.String PHONEWORK) {
        this.PHONEWORK = PHONEWORK;
    }


    /**
     * Gets the POSTADDRESS value for this CUSTOMERBASE.
     * 
     * @return POSTADDRESS
     */
    public java.lang.String getPOSTADDRESS() {
        return POSTADDRESS;
    }


    /**
     * Sets the POSTADDRESS value for this CUSTOMERBASE.
     * 
     * @param POSTADDRESS
     */
    public void setPOSTADDRESS(java.lang.String POSTADDRESS) {
        this.POSTADDRESS = POSTADDRESS;
    }


    /**
     * Gets the SOCSECNUM value for this CUSTOMERBASE.
     * 
     * @return SOCSECNUM
     */
    public java.lang.String getSOCSECNUM() {
        return SOCSECNUM;
    }


    /**
     * Sets the SOCSECNUM value for this CUSTOMERBASE.
     * 
     * @param SOCSECNUM
     */
    public void setSOCSECNUM(java.lang.String SOCSECNUM) {
        this.SOCSECNUM = SOCSECNUM;
    }


    /**
     * Gets the STATUS value for this CUSTOMERBASE.
     * 
     * @return STATUS
     */
    public java.lang.String getSTATUS() {
        return STATUS;
    }


    /**
     * Sets the STATUS value for this CUSTOMERBASE.
     * 
     * @param STATUS
     */
    public void setSTATUS(java.lang.String STATUS) {
        this.STATUS = STATUS;
    }


    /**
     * Gets the TARGETMAIL value for this CUSTOMERBASE.
     * 
     * @return TARGETMAIL
     */
    public boolean isTARGETMAIL() {
        return TARGETMAIL;
    }


    /**
     * Sets the TARGETMAIL value for this CUSTOMERBASE.
     * 
     * @param TARGETMAIL
     */
    public void setTARGETMAIL(boolean TARGETMAIL) {
        this.TARGETMAIL = TARGETMAIL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CUSTOMERBASE)) return false;
        CUSTOMERBASE other = (CUSTOMERBASE) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ADDRESS1==null && other.getADDRESS1()==null) || 
             (this.ADDRESS1!=null &&
              this.ADDRESS1.equals(other.getADDRESS1()))) &&
            ((this.ADDRESS2==null && other.getADDRESS2()==null) || 
             (this.ADDRESS2!=null &&
              this.ADDRESS2.equals(other.getADDRESS2()))) &&
            ((this.COUNTY==null && other.getCOUNTY()==null) || 
             (this.COUNTY!=null &&
              this.COUNTY.equals(other.getCOUNTY()))) &&
            ((this.COUNTRY==null && other.getCOUNTRY()==null) || 
             (this.COUNTRY!=null &&
              this.COUNTRY.equals(other.getCOUNTRY()))) &&
            ((this.EMAIL==null && other.getEMAIL()==null) || 
             (this.EMAIL!=null &&
              this.EMAIL.equals(other.getEMAIL()))) &&
            ((this.FAX==null && other.getFAX()==null) || 
             (this.FAX!=null &&
              this.FAX.equals(other.getFAX()))) &&
            ((this.HOMEPAGE==null && other.getHOMEPAGE()==null) || 
             (this.HOMEPAGE!=null &&
              this.HOMEPAGE.equals(other.getHOMEPAGE()))) &&
            ((this.LANGUAGE==null && other.getLANGUAGE()==null) || 
             (this.LANGUAGE!=null &&
              this.LANGUAGE.equals(other.getLANGUAGE()))) &&
            ((this.PHONEWORK==null && other.getPHONEWORK()==null) || 
             (this.PHONEWORK!=null &&
              this.PHONEWORK.equals(other.getPHONEWORK()))) &&
            ((this.POSTADDRESS==null && other.getPOSTADDRESS()==null) || 
             (this.POSTADDRESS!=null &&
              this.POSTADDRESS.equals(other.getPOSTADDRESS()))) &&
            ((this.SOCSECNUM==null && other.getSOCSECNUM()==null) || 
             (this.SOCSECNUM!=null &&
              this.SOCSECNUM.equals(other.getSOCSECNUM()))) &&
            ((this.STATUS==null && other.getSTATUS()==null) || 
             (this.STATUS!=null &&
              this.STATUS.equals(other.getSTATUS()))) &&
            this.TARGETMAIL == other.isTARGETMAIL();
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
        if (getADDRESS1() != null) {
            _hashCode += getADDRESS1().hashCode();
        }
        if (getADDRESS2() != null) {
            _hashCode += getADDRESS2().hashCode();
        }
        if (getCOUNTY() != null) {
            _hashCode += getCOUNTY().hashCode();
        }
        if (getCOUNTRY() != null) {
            _hashCode += getCOUNTRY().hashCode();
        }
        if (getEMAIL() != null) {
            _hashCode += getEMAIL().hashCode();
        }
        if (getFAX() != null) {
            _hashCode += getFAX().hashCode();
        }
        if (getHOMEPAGE() != null) {
            _hashCode += getHOMEPAGE().hashCode();
        }
        if (getLANGUAGE() != null) {
            _hashCode += getLANGUAGE().hashCode();
        }
        if (getPHONEWORK() != null) {
            _hashCode += getPHONEWORK().hashCode();
        }
        if (getPOSTADDRESS() != null) {
            _hashCode += getPOSTADDRESS().hashCode();
        }
        if (getSOCSECNUM() != null) {
            _hashCode += getSOCSECNUM().hashCode();
        }
        if (getSTATUS() != null) {
            _hashCode += getSTATUS().hashCode();
        }
        _hashCode += (isTARGETMAIL() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CUSTOMERBASE.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "CUSTOMERBASE"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADDRESS1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ADDRESS1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ADDRESS2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ADDRESS2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COUNTY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COUNTY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COUNTRY");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COUNTRY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EMAIL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HOMEPAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "HOMEPAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LANGUAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LANGUAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PHONEWORK");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PHONEWORK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POSTADDRESS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POSTADDRESS"));
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
        elemField.setFieldName("STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TARGETMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TARGETMAIL"));
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
