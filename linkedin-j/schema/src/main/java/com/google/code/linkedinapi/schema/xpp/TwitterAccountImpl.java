
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.io.Serializable;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.TwitterAccount;

public class TwitterAccountImpl
	extends BaseSchemaEntity
    implements Serializable, TwitterAccount
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Long providerAccountId;
    protected String providerAccountName;

    public Long getProviderAccountId() {
        return providerAccountId;
    }

    public void setProviderAccountId(Long value) {
        this.providerAccountId = value;
    }

    public String getProviderAccountName() {
        return providerAccountName;
    }

    public void setProviderAccountName(String value) {
        this.providerAccountName = value;
    }
	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("provider-account-id")) {
        		setProviderAccountId(XppUtils.getElementValueAsLongFromNode(parser));
        	} else if (name.equals("provider-account-name")) {
        		setProviderAccountName(XppUtils.getElementValueFromNode(parser));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "twitter-account");
		XppUtils.setElementValueToNode(element, "provider-account-id", getProviderAccountId());
		XppUtils.setElementValueToNode(element, "provider-account-name", getProviderAccountName());
		serializer.endTag(null, "twitter-account");
	}
}
