//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.12.10 at 07:27:01 PM GMT+05:00 
//


package com.google.code.linkedinapi.schema.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.MemberUrl;
import com.google.code.linkedinapi.schema.MemberUrlResources;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "memberUrl"
})
@XmlRootElement(name = "member-url-resources")
public class MemberUrlResourcesImpl
    implements MemberUrlResources
{

    @XmlElement(name = "member-url", required = true, type = MemberUrlImpl.class)
    protected MemberUrlImpl memberUrl;

    public MemberUrl getMemberUrl() {
        return memberUrl;
    }

    public void setMemberUrl(MemberUrl value) {
        this.memberUrl = ((MemberUrlImpl) value);
    }

}
