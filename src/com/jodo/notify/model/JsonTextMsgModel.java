/**
 * @(#)Jodo, 2013年10月5日
 */
package com.jodo.notify.model;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;



/**
 * @author treemanz
 */
public class JsonTextMsgModel extends JsonWxMsgModel {

    /**
     * 
     */
    private static final long serialVersionUID = 3232470220074913898L;

    /*
     * (non-Javadoc)
     * @see vo.Msg#getMsgType()
     */
    @Override
    public String getMsgType() {
        return "text";
    }

    /*
     * (non-Javadoc)
     * @see vo.Msg#subFromXml(java.lang.String, java.lang.String)
     */
    @Override
    protected void subFromXml(String name, String text) {
        if (name.equals("Content")) {
            this.setContent(text);
        }
    }

    /*
     * (non-Javadoc)
     * @see vo.Msg#subToXml()
     */
    @Override
    protected String subToXml() {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(getContent())) {
            sb.append("<Content><![CDATA[").append(getContent())
                    .append("]]></Content>\r\n");
        }
        return sb.toString();
    }

    private String content;

    /**
     * @return the content
     */
    @JsonIgnore
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    protected class Text implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 6670834123967752115L;

        @JsonProperty("content")
        public String getContent() {
            return content;
        }
    }

    @JsonProperty("text")
    public final Text text = new Text();

}
