package org.kira.learn.springsecurity.config.security;

import org.kira.learn.springsecurity.config.security.heandler.KiraAuthenticationFailureHandler;
import org.kira.learn.springsecurity.config.security.heandler.KiraAuthenticationSuccessHandler;
import org.kira.learn.springsecurity.config.security.proerties.KiraSecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * @author: Zhang Chaoqing
 * Date: 2022/8/20 17:19
 */
@EnableConfigurationProperties(KiraSecurityProperties.class)
@Configuration(proxyBeanMethods = false)
public class KiraSecurityAutoconfigure {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 登录失败控制器
     *
     * @param kiraSecurityProperties {@link KiraSecurityProperties}
     * @return {@link KiraAuthenticationFailureHandler}
     */
    @Bean
    public AuthenticationFailureHandler kiraAuthenticationFailureHandler(KiraSecurityProperties kiraSecurityProperties) {
        return new KiraAuthenticationFailureHandler(kiraSecurityProperties);
    }

    /**
     * 登录成功控制器
     *
     * @param kiraSecurityProperties {@link KiraSecurityProperties}
     * @return {@link KiraAuthenticationSuccessHandler}
     */
    @Bean
    public KiraAuthenticationSuccessHandler kiraAuthenticationSuccessHandler(KiraSecurityProperties kiraSecurityProperties) {
        return new KiraAuthenticationSuccessHandler(kiraSecurityProperties);
    }


}