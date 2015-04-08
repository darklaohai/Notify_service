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
public abstract class JsonWxMsgProModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    protected JsonWxMsgProModel() {

    }

    private static Map<String, Class<? extends JsonWxMsgProModel>> msgClassMap;

    private static Object lock = new Object();

    protected static void addToMsgClassMap(String name,
            Class<? extends JsonWxMsgProModel> msgClass) {
        msgClassMap.put(name, msgClass);
    }

    @JsonProperty("msgtype")
    public abstract String getMsgType();

    @SuppressWarnings("unchecked")
    public static JsonWxMsgProModel fromMsgType(String msgType) {
        if (null == msgClassMap) {
            synchronized (lock) {
                msgClassMap = new HashMap<String, Class<? extends JsonWxMsgProModel>>();
                try {
                    List<Class<?>> classes = ClassUtil
                            .getAllAssignedClass(JsonWxMsgProModel.class);
                    for (Class<?> clazz: classes) {
                        Class<? extends JsonWxMsgProModel> msgClass = (Class<? extends JsonWxMsgProModel>) clazz;
                        addToMsgClassMap(msgClass.newInstance().getMsgType(),
                                msgClass);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (Entry<String, Class<? extends JsonWxMsgProModel>> entry: msgClassMap.entrySet()) {
            if (entry.getKey().equals(msgType)) {
                try {
                    JsonWxMsgProModel jsonWxMsgModel = entry.getValue().newInstance();
                    return jsonWxMsgModel;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    protected abstract String subToXml();

    public String toJson() {
        return JacksonUtil.toJson(this);
    }

    private String toUserName;

    private String fromUserName;
    
    private String toparty;
    
    private String totag;
    
    private Integer agentid;
    
    private Integer safe;

    private Long createTime;

    private Long msgId;

    public String getToparty() {
		return toparty;
	}

	public void setToparty(String toparty) {
		this.toparty = toparty;
	}

	public String getTotag() {
		return totag;
	}

	public void setTotag(String totag) {
		this.totag = totag;
	}

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public Integer getSafe() {
		return safe;
	}

	public void setSafe(Integer safe) {
		this.safe = safe;
	}

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
