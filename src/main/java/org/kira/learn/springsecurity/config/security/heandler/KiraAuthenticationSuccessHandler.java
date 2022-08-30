package org.kira.learn.springsecurity.config.security.heandler;

import org.kira.learn.springsecurity.config.security.proerties.KiraSecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Zhang Chaoqing
 * Date: 2022/8/20 18:42
 */
public class KiraAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final KiraSecurityProperties kiraSecurityProperties;

    public KiraAuthenticationSuccessHandler(KiraSecurityProperties kiraSecurityProperties) {
        this.kiraSecurityProperties = kiraSecurityProperties;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.sendRedirect(kiraSecurityProperties.getLoginSuccessUrl());
    }
}