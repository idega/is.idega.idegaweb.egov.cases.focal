/**
 * ProjectMetaData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

public class ProjectMetaData  implements java.io.Serializable {
    private is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty mainParty;

    private java.lang.String name;

    private java.lang.String projectId;

    public ProjectMetaData() {
    }

    public ProjectMetaData(
           is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty mainParty,
           java.lang.String name,
           java.lang.String projectId) {
           this.mainParty = mainParty;
           this.name = name;
           this.projectId = projectId;
    }


    /**
     * Gets the mainParty value for this ProjectMetaData.
     * 
     * @return mainParty
     */
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty getMainParty() {
        return mainParty;
    }


    /**
     * Sets the mainParty value for this ProjectMetaData.
     * 
     * @param mainParty
     */
    public void setMainParty(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.MainParty mainParty) {
        this.mainParty = mainParty;
    }


    /**
     * Gets the name value for this ProjectMetaData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ProjectMetaData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the projectId value for this ProjectMetaData.
     * 
     * @return projectId
     */
    public java.lang.String getProjectId() {
        return projectId;
    }


    /**
     * Sets the projectId value for this ProjectMetaData.
     * 
     * @param projectId
     */
    public void setProjectId(java.lang.String projectId) {
        this.projectId = projectId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProjectMetaData)) return false;
        ProjectMetaData other = (ProjectMetaData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mainParty==null && other.getMainParty()==null) || 
             (this.mainParty!=null &&
              this.mainParty.equals(other.getMainParty()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
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
        if (getMainParty() != null) {
            _hashCode += getMainParty().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getProjectId() != null) {
            _hashCode += getProjectId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjectMetaData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "ProjectMetaData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainParty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mainParty"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "MainParty"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
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
