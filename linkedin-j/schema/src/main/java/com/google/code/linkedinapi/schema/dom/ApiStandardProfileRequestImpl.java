
package com.google.code.linkedinapi.schema.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.code.linkedinapi.schema.ApiStandardProfileRequest;
import com.google.code.linkedinapi.schema.Headers;

public class ApiStandardProfileRequestImpl
	extends BaseSchemaEntity
    implements ApiStandardProfileRequest
{

    protected String url;
    protected HeadersImpl headers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers value) {
        this.headers = ((HeadersImpl) value);
    }
    
	@Override
	public void init(Element element) {
		setUrl(DomUtils.getElementValueFromNode(element, "url"));
		Element headersElem = (Element) DomUtils.getChildNode(element, "headers");
		if (headersElem != null) {
			HeadersImpl headerImpl = new HeadersImpl();
			headerImpl.init(headersElem);
		}
	}

	@Override
	public Element toXml(Document document) {
		Element element = document.createElement("api-standard-profile-request");
		DomUtils.setElementValueToNode(element, "url", getUrl());
		if (getHeaders() != null) {
			element.appendChild(((HeadersImpl) getHeaders()).toXml(document));
		}
		return element;
	}
}
