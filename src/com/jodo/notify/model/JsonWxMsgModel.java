/**
 * @(#)Jodo, 2013年10月5日
 */
package com.jodo.notify.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.jodo.notify.util.ClassUtil;
import com.jodo.notify.util.JacksonUtil;

/**
 * @author treemanz
 */
public abstract class JsonWxMsgModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected JsonWxMsgModel() {

    }

    private static Map<String, Class<? extends JsonWxMsgModel>> msgClassMap;

    private static Object lock = new Object();

    protected static void addToMsgClassMap(String name,
            Class<? extends JsonWxMsgModel> msgClass) {
        msgClassMap.put(name, msgClass);
    }

    @JsonProperty("msgtype")
    public abstract String getMsgType();

    @SuppressWarnings("unchecked")
    public static JsonWxMsgModel fromMsgType(String msgType) {
        if (null == msgClassMap) {
            synchronized (lock) {
                msgClassMap = new HashMap<String, Class<? extends JsonWxMsgModel>>();
                try {
                    List<Class<?>> classes = ClassUtil
                            .getAllAssignedClass(JsonWxMsgModel.class);
                    for (Class<?> clazz: classes) {
                        Class<? extends JsonWxMsgModel> msgClass = (Class<? extends JsonWxMsgModel>) clazz;
                        addToMsgClassMap(msgClass.newInstance().getMsgType(),
                                msgClass);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (Entry<String, Class<? extends JsonWxMsgModel>> entry: msgClassMap.entrySet()) {
            if (entry.getKey().equals(msgType)) {
                try {
                    JsonWxMsgModel jsonWxMsgModel = entry.getValue().newInstance();
                    return jsonWxMsgModel;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    protected abstract void subFromXml(String name, String text);

    public static JsonWxMsgModel fromXml(String xml) {
        try {
            Document objDoc = DocumentHelper.parseText(xml);
            Element rootElement = objDoc.getRootElement();
            if (rootElement.nodeCount() > 0) {
                Element msgTypeElement = rootElement.element("MsgType");
                if (null == msgTypeElement) {
                    return null;
                }
                String msgType = msgTypeElement.getText().trim();
                JsonWxMsgModel jsonWxMsgModel = fromMsgType(msgType);
                if (null == jsonWxMsgModel) {
                    return null;
                }
                for (Iterator<?> nodeIterator = rootElement.nodeIterator(); nodeIterator
                        .hasNext();) {
                    Node node = (Node) nodeIterator.next();
                    if (node instanceof Element) {
                        Element element = (Element) node;
                        String name = element.getName();
                        String text = element.getTextTrim();
                        if (name.equals("ToUserName")) {
                            jsonWxMsgModel.setToUserName(text);
                        } else if (name.equals("FromUserName")) {
                            jsonWxMsgModel.setFromUserName(text);
                        } else if (name.equals("CreateTime")) {
                            jsonWxMsgModel.setCreateTime(Long.parseLong(text));
                        } else if (name.equals("MsgId")) {
                            jsonWxMsgModel.setMsgId(Long.parseLong(text));
                        } else {
                            jsonWxMsgModel.subFromXml(name, text);
                        }
                    }
                }
                return jsonWxMsgModel;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toXml() {
        StringBuilder sb = new StringBuilder("<xml>");
        if (StringUtils.isNotBlank(getToUserName())) {
            sb.append("<ToUserName><![CDATA[").append(getToUserName())
                    .append("]]></ToUserName>\r\n");
        }
        if (StringUtils.isNotBlank(getFromUserName())) {
            sb.append("<FromUserName><![CDATA[").append(getFromUserName())
                    .append("]]></FromUserName>\r\n");
        }
        if (null != getCreateTime()) {
            sb.append("<CreateTime>").append(getCreateTime())
                    .append("</CreateTime>\r\n");
        }
        if (StringUtils.isNotBlank(getMsgType())) {
            sb.append("<MsgType><![CDATA[").append(getMsgType())
                    .append("]]></MsgType>\r\n");
        }
        if (null != getMsgId()) {
            sb.append("<MsgId>").append(getMsgId()).append("</MsgId>\r\n");
        }
        sb.append(subToXml());
        sb.append("</xml>");
        return sb.toString();
    }

    protected abstract String subToXml();

    public String toJson() {
        return JacksonUtil.toJson(this);
    }

    private String toUserName;

    private String fromUserName;

    private Long createTime;

    private Long msgId;

    /**
     * @return the toUserName
     */
    @JsonProperty("touser")
    public String getToUserName() {
        return toUserName;
    }

    /**
     * @param toUserName
     *            the toUserName to set
     */
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    /**
     * @return the fromUserName
     */
    @JsonIgnore
    public String getFromUserName() {
        return fromUserName;
    }

    /**
     * @param fromUserName
     *            the fromUserName to set
     */
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    /**
     * @return the createTime
     */
    @JsonIgnore
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the msgId
     */
    @JsonIgnore
    public Long getMsgId() {
        return msgId;
    }

    /**
     * @param msgId
     *            the msgId to set
     */
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }



}
