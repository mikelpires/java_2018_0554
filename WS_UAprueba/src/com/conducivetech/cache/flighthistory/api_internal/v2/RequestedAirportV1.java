/**
 * RequestedAirportV1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class RequestedAirportV1  implements java.io.Serializable {
    private java.lang.String requestedCode;

    private java.lang.String fsCode;

    private com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 airport;

    private java.lang.String error;

    public RequestedAirportV1() {
    }

    public RequestedAirportV1(
           java.lang.String requestedCode,
           java.lang.String fsCode,
           com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 airport,
           java.lang.String error) {
           this.requestedCode = requestedCode;
           this.fsCode = fsCode;
           this.airport = airport;
           this.error = error;
    }


    /**
     * Gets the requestedCode value for this RequestedAirportV1.
     * 
     * @return requestedCode
     */
    public java.lang.String getRequestedCode() {
        return requestedCode;
    }


    /**
     * Sets the requestedCode value for this RequestedAirportV1.
     * 
     * @param requestedCode
     */
    public void setRequestedCode(java.lang.String requestedCode) {
        this.requestedCode = requestedCode;
    }


    /**
     * Gets the fsCode value for this RequestedAirportV1.
     * 
     * @return fsCode
     */
    public java.lang.String getFsCode() {
        return fsCode;
    }


    /**
     * Sets the fsCode value for this RequestedAirportV1.
     * 
     * @param fsCode
     */
    public void setFsCode(java.lang.String fsCode) {
        this.fsCode = fsCode;
    }


    /**
     * Gets the airport value for this RequestedAirportV1.
     * 
     * @return airport
     */
    public com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 getAirport() {
        return airport;
    }


    /**
     * Sets the airport value for this RequestedAirportV1.
     * 
     * @param airport
     */
    public void setAirport(com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1 airport) {
        this.airport = airport;
    }


    /**
     * Gets the error value for this RequestedAirportV1.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this RequestedAirportV1.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestedAirportV1)) return false;
        RequestedAirportV1 other = (RequestedAirportV1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.requestedCode==null && other.getRequestedCode()==null) || 
             (this.requestedCode!=null &&
              this.requestedCode.equals(other.getRequestedCode()))) &&
            ((this.fsCode==null && other.getFsCode()==null) || 
             (this.fsCode!=null &&
              this.fsCode.equals(other.getFsCode()))) &&
            ((this.airport==null && other.getAirport()==null) || 
             (this.airport!=null &&
              this.airport.equals(other.getAirport()))) &&
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError())));
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
        if (getRequestedCode() != null) {
            _hashCode += getRequestedCode().hashCode();
        }
        if (getFsCode() != null) {
            _hashCode += getFsCode().hashCode();
        }
        if (getAirport() != null) {
            _hashCode += getAirport().hashCode();
        }
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestedAirportV1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedAirportV1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestedCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestedCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fsCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fsCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("airport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "airport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
