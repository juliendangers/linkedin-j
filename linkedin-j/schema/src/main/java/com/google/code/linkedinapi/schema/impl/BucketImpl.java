
package com.google.code.linkedinapi.schema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.google.code.linkedinapi.schema.Bucket;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "code"
})
@XmlRootElement(name = "bucket")
public class BucketImpl
    implements Serializable, Bucket
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String code;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }

}
