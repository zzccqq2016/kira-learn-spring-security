package org.kira.learn.springsecurity.config.security.heandler;

import org.kira.learn.springsecurity.config.security.proerties.KiraSecurityProperties;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Zhang Chaoqing
 * Date: 2022/8/20 18:37
 */
public class KiraAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final KiraSecurityProperties kiraSecurityProperties;

    public KiraAuthenticationFailureHandler(KiraSecurityProperties kiraSecurityProperties) {
        this.kiraSecurityProperties = kiraSecurityProperties;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(kiraSecurityProperties.getLoginFailureUrl());
    }
}