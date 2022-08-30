package org.kira.learn.springsecurity.config.security.proerties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Zhang Chaoqing
 * Date: 2022/8/20 18:25
 */
@ConfigurationProperties(prefix = "kira.security")
public class KiraSecurityProperties {

    private String loginFailureUrl;
    private String loginSuccessUrl;


    public String getLoginFailureUrl() {
        return loginFailureUrl;
    }

    public void setLoginFailureUrl(String loginFailureUrl) {
        this.loginFailureUrl = loginFailureUrl;
    }

    public String getLoginSuccessUrl() {
        return loginSuccessUrl;
    }

    public void setLoginSuccessUrl(String loginSuccessUrl) {
        this.loginSuccessUrl = loginSuccessUrl;
    }
}