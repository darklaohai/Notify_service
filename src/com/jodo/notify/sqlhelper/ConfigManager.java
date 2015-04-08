package com.jodo.notify.sqlhelper;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jodo.notify.util.ApplicationHelper;

public class ConfigManager {

    public static final ConfigManager instance = new ConfigManager();

    private Properties properties;

    private ConfigManager() {
        init();
    }

    public void init() {
        if( properties != null ) {
            return;
        }
        // init log4j
        PropertyConfigurator.configure(getConfigPath("log4j.properties"));

        // init config
        String configPath = getConfigPath("config.properties");
        properties = new Properties();
        try {
            FileInputStream is = new FileInputStream(configPath);
            properties.load(is);
            is.close();
        } catch (Exception e) {
            ApplicationHelper.getInstance(ConfigManager.class).error(
                    "create ConfigManager failed", e);
        }
    }

    public void shutdown() {

    }

    public String getConfigPath(String fileName) {
        String path = ConfigManager.class.getResource("/").getPath();
        path = path.replace("classes", "conf");
        return path + fileName;
    }

    public String getValue(String configKey) {
        String value = properties.getProperty(configKey);
        return value == null ? "" : value;
    }

    public String getEnv() {
        return getValue("define.env");
    }

    public boolean isEnvLocal() {
        return getEnv().equals("local");
    }

    public boolean isEnvTest() {
        return getEnv().equals("test");
    }

    public boolean isEnvOnline() {
        return getEnv().equals("online");
    }
    
    public String getResDate() {
        return getValue("res.date");
    }
    
    public String getTaskResDate() {
    	return getValue("taskres.date");
    }

}
