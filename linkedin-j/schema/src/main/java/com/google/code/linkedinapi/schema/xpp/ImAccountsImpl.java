
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.ImAccount;
import com.google.code.linkedinapi.schema.ImAccounts;

public class ImAccountsImpl
	extends BaseSchemaEntity
    implements Serializable, ImAccounts
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<ImAccount> imAccountList;
    protected Long total;

    public List<ImAccount> getImAccountList() {
        if (imAccountList == null) {
            imAccountList = new ArrayList<ImAccount>();
        }
        return this.imAccountList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
		setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("im-account")) {
        		ImAccountImpl accountImpl = new ImAccountImpl();
    			accountImpl.init(parser);
    			getImAccountList().add(accountImpl);
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "im-accounts");
		XppUtils.setAttributeValueToNode(element, "total", getTotal());
		for (ImAccount account : getImAccountList()) {
			((ImAccountImpl) account).toXml(serializer);
		}
		serializer.endTag(null, "im-accounts");
	}
}
