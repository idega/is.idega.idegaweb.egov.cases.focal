/**
 * ReturnedProjects.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService;

public class ReturnedProjects  implements java.io.Serializable {
    private is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData[] projects;

    private is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus status;

    public ReturnedProjects() {
    }

    public ReturnedProjects(
           is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData[] projects,
           is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus status) {
           this.projects = projects;
           this.status = status;
    }


    /**
     * Gets the projects value for this ReturnedProjects.
     * 
     * @return projects
     */
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData[] getProjects() {
        return projects;
    }


    /**
     * Sets the projects value for this ReturnedProjects.
     * 
     * @param projects
     */
    public void setProjects(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.ProjectMetaData[] projects) {
        this.projects = projects;
    }


    /**
     * Gets the status value for this ReturnedProjects.
     * 
     * @return status
     */
    public is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ReturnedProjects.
     * 
     * @param status
     */
    public void setStatus(is.idega.idegaweb.egov.cases.focal.business.server.focalMockupService.FPStatus status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReturnedProjects)) return false;
        ReturnedProjects other = (ReturnedProjects) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.projects==null && other.getProjects()==null) || 
             (this.projects!=null &&
              java.util.Arrays.equals(this.projects, other.getProjects()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getProjects() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProjects());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProjects(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReturnedProjects.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "ReturnedProjects"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projects");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projects"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "ProjectMetaData"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:is.idega.idegaweb.egov.cases.focal", "FPStatus"));
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
