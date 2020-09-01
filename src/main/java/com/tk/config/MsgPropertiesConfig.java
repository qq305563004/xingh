package com.tk.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:message.properties")
@ConfigurationProperties(prefix = "com.msg")
public class MsgPropertiesConfig {

    private String version;

    private Map<String, String> retCode = new HashMap<>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, String> getRetCode() {
        return retCode;
    }

    public void setRetCode(Map<String, String> retCode) {
        this.retCode = retCode;
    }

}
