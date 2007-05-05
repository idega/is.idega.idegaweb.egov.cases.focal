/**
 * CaseData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

public class CaseData  implements java.io.Serializable {
    private is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Attachment[] attachments;

    private java.lang.String caseBody;

    private java.lang.String caseSubject;

    private java.util.Calendar date;

    private java.lang.String projectId;

    public CaseData() {
    }

    public CaseData(
           is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Attachment[] attachments,
           java.lang.String caseBody,
           java.lang.String caseSubject,
           java.util.Calendar date,
           java.lang.String projectId) {
           this.attachments = attachments;
           this.caseBody = caseBody;
           this.caseSubject = caseSubject;
           this.date = date;
           this.projectId = projectId;
    }


    /**
     * Gets the attachments value for this CaseData.
     * 
     * @return attachments
     */
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Attachment[] getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this CaseData.
     * 
     * @param attachments
     */
    public void setAttachments(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.Attachment[] attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the caseBody value for this CaseData.
     * 
     * @return caseBody
     */
    public java.lang.String getCaseBody() {
        return caseBody;
    }


    /**
     * Sets the caseBody value for this CaseData.
     * 
     * @param caseBody
     */
    public void setCaseBody(java.lang.String caseBody) {
        this.caseBody = caseBody;
    }


    /**
     * Gets the caseSubject value for this CaseData.
     * 
     * @return caseSubject
     */
    public java.lang.String getCaseSubject() {
        return caseSubject;
    }


    /**
     * Sets the caseSubject value for this CaseData.
     * 
     * @param caseSubject
     */
    public void setCaseSubject(java.lang.String caseSubject) {
        this.caseSubject = caseSubject;
    }


    /**
     * Gets the date value for this CaseData.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this CaseData.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the projectId value for this CaseData.
     * 
     * @return projectId
     */
    public java.lang.String getProjectId() {
        return projectId;
    }


    /**
     * Sets the projectId value for this CaseData.
     * 
     * @param projectId
     */
    public void setProjectId(java.lang.String projectId) {
        this.projectId = projectId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaseData)) return false;
        CaseData other = (CaseData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.attachments==null && other.getAttachments()==null) || 
             (this.attachments!=null &&
              java.util.Arrays.equals(this.attachments, other.getAttachments()))) &&
            ((this.caseBody==null && other.getCaseBody()==null) || 
             (this.caseBody!=null &&
              this.caseBody.equals(other.getCaseBody()))) &&
            ((this.caseSubject==null && other.getCaseSubject()==null) || 
             (this.caseSubject!=null &&
              this.caseSubject.equals(other.getCaseSubject()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.projectId==null && other.getProjectId()==null) || 
             (this.projectId!=null &&
              this.projectId.equals(other.getProjectId())));
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
        if (getAttachments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCaseBody() != null) {
            _hashCode += getCaseBody().hashCode();
        }
        if (getCaseSubject() != null) {
            _hashCode += getCaseSubject().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getProjectId() != null) {
            _hashCode += getProjectId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaseData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "CaseData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "attachments"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "Attachment"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseBody");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseBody"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseSubject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseSubject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
