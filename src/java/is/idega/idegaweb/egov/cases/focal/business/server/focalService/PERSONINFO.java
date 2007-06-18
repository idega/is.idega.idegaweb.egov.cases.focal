/**
 * PERSONINFO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalService;

public class PERSONINFO  extends is.idega.idegaweb.egov.cases.focal.business.server.focalService.CUSTOMERBASE  implements java.io.Serializable {
    private java.lang.String AVARP;

    private java.lang.String BEEPER;

    private java.lang.String CARPHONE;

    private java.lang.String GSM;

    private java.lang.String PERSONNAME;

    private java.lang.String PHONEHOME;

    private java.lang.String PHONEOFFICE;

    private java.lang.String SEPERATOR;

    private java.lang.String TITLE;

    public PERSONINFO() {
    }

    public PERSONINFO(
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
           java.lang.String AVARP,
           java.lang.String BEEPER,
           java.lang.String CARPHONE,
           java.lang.String GSM,
           java.lang.String PERSONNAME,
           java.lang.String PHONEHOME,
           java.lang.String PHONEOFFICE,
           java.lang.String SEPERATOR,
           java.lang.String TITLE) {
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
        this.AVARP = AVARP;
        this.BEEPER = BEEPER;
        this.CARPHONE = CARPHONE;
        this.GSM = GSM;
        this.PERSONNAME = PERSONNAME;
        this.PHONEHOME = PHONEHOME;
        this.PHONEOFFICE = PHONEOFFICE;
        this.SEPERATOR = SEPERATOR;
        this.TITLE = TITLE;
    }


    /**
     * Gets the AVARP value for this PERSONINFO.
     * 
     * @return AVARP
     */
    public java.lang.String getAVARP() {
        return AVARP;
    }


    /**
     * Sets the AVARP value for this PERSONINFO.
     * 
     * @param AVARP
     */
    public void setAVARP(java.lang.String AVARP) {
        this.AVARP = AVARP;
    }


    /**
     * Gets the BEEPER value for this PERSONINFO.
     * 
     * @return BEEPER
     */
    public java.lang.String getBEEPER() {
        return BEEPER;
    }


    /**
     * Sets the BEEPER value for this PERSONINFO.
     * 
     * @param BEEPER
     */
    public void setBEEPER(java.lang.String BEEPER) {
        this.BEEPER = BEEPER;
    }


    /**
     * Gets the CARPHONE value for this PERSONINFO.
     * 
     * @return CARPHONE
     */
    public java.lang.String getCARPHONE() {
        return CARPHONE;
    }


    /**
     * Sets the CARPHONE value for this PERSONINFO.
     * 
     * @param CARPHONE
     */
    public void setCARPHONE(java.lang.String CARPHONE) {
        this.CARPHONE = CARPHONE;
    }


    /**
     * Gets the GSM value for this PERSONINFO.
     * 
     * @return GSM
     */
    public java.lang.String getGSM() {
        return GSM;
    }


    /**
     * Sets the GSM value for this PERSONINFO.
     * 
     * @param GSM
     */
    public void setGSM(java.lang.String GSM) {
        this.GSM = GSM;
    }


    /**
     * Gets the PERSONNAME value for this PERSONINFO.
     * 
     * @return PERSONNAME
     */
    public java.lang.String getPERSONNAME() {
        return PERSONNAME;
    }


    /**
     * Sets the PERSONNAME value for this PERSONINFO.
     * 
     * @param PERSONNAME
     */
    public void setPERSONNAME(java.lang.String PERSONNAME) {
        this.PERSONNAME = PERSONNAME;
    }


    /**
     * Gets the PHONEHOME value for this PERSONINFO.
     * 
     * @return PHONEHOME
     */
    public java.lang.String getPHONEHOME() {
        return PHONEHOME;
    }


    /**
     * Sets the PHONEHOME value for this PERSONINFO.
     * 
     * @param PHONEHOME
     */
    public void setPHONEHOME(java.lang.String PHONEHOME) {
        this.PHONEHOME = PHONEHOME;
    }


    /**
     * Gets the PHONEOFFICE value for this PERSONINFO.
     * 
     * @return PHONEOFFICE
     */
    public java.lang.String getPHONEOFFICE() {
        return PHONEOFFICE;
    }


    /**
     * Sets the PHONEOFFICE value for this PERSONINFO.
     * 
     * @param PHONEOFFICE
     */
    public void setPHONEOFFICE(java.lang.String PHONEOFFICE) {
        this.PHONEOFFICE = PHONEOFFICE;
    }


    /**
     * Gets the SEPERATOR value for this PERSONINFO.
     * 
     * @return SEPERATOR
     */
    public java.lang.String getSEPERATOR() {
        return SEPERATOR;
    }


    /**
     * Sets the SEPERATOR value for this PERSONINFO.
     * 
     * @param SEPERATOR
     */
    public void setSEPERATOR(java.lang.String SEPERATOR) {
        this.SEPERATOR = SEPERATOR;
    }


    /**
     * Gets the TITLE value for this PERSONINFO.
     * 
     * @return TITLE
     */
    public java.lang.String getTITLE() {
        return TITLE;
    }


    /**
     * Sets the TITLE value for this PERSONINFO.
     * 
     * @param TITLE
     */
    public void setTITLE(java.lang.String TITLE) {
        this.TITLE = TITLE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PERSONINFO)) return false;
        PERSONINFO other = (PERSONINFO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AVARP==null && other.getAVARP()==null) || 
             (this.AVARP!=null &&
              this.AVARP.equals(other.getAVARP()))) &&
            ((this.BEEPER==null && other.getBEEPER()==null) || 
             (this.BEEPER!=null &&
              this.BEEPER.equals(other.getBEEPER()))) &&
            ((this.CARPHONE==null && other.getCARPHONE()==null) || 
             (this.CARPHONE!=null &&
              this.CARPHONE.equals(other.getCARPHONE()))) &&
            ((this.GSM==null && other.getGSM()==null) || 
             (this.GSM!=null &&
              this.GSM.equals(other.getGSM()))) &&
            ((this.PERSONNAME==null && other.getPERSONNAME()==null) || 
             (this.PERSONNAME!=null &&
              this.PERSONNAME.equals(other.getPERSONNAME()))) &&
            ((this.PHONEHOME==null && other.getPHONEHOME()==null) || 
             (this.PHONEHOME!=null &&
              this.PHONEHOME.equals(other.getPHONEHOME()))) &&
            ((this.PHONEOFFICE==null && other.getPHONEOFFICE()==null) || 
             (this.PHONEOFFICE!=null &&
              this.PHONEOFFICE.equals(other.getPHONEOFFICE()))) &&
            ((this.SEPERATOR==null && other.getSEPERATOR()==null) || 
             (this.SEPERATOR!=null &&
              this.SEPERATOR.equals(other.getSEPERATOR()))) &&
            ((this.TITLE==null && other.getTITLE()==null) || 
             (this.TITLE!=null &&
              this.TITLE.equals(other.getTITLE())));
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
        if (getAVARP() != null) {
            _hashCode += getAVARP().hashCode();
        }
        if (getBEEPER() != null) {
            _hashCode += getBEEPER().hashCode();
        }
        if (getCARPHONE() != null) {
            _hashCode += getCARPHONE().hashCode();
        }
        if (getGSM() != null) {
            _hashCode += getGSM().hashCode();
        }
        if (getPERSONNAME() != null) {
            _hashCode += getPERSONNAME().hashCode();
        }
        if (getPHONEHOME() != null) {
            _hashCode += getPHONEHOME().hashCode();
        }
        if (getPHONEOFFICE() != null) {
            _hashCode += getPHONEOFFICE().hashCode();
        }
        if (getSEPERATOR() != null) {
            _hashCode += getSEPERATOR().hashCode();
        }
        if (getTITLE() != null) {
            _hashCode += getTITLE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PERSONINFO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:DefaultNamespace", "PERSONINFO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AVARP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AVARP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BEEPER");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BEEPER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CARPHONE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CARPHONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GSM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GSM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PERSONNAME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PERSONNAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PHONEHOME");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PHONEHOME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PHONEOFFICE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PHONEOFFICE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEPERATOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SEPERATOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TITLE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TITLE"));
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
