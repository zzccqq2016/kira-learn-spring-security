package org.kira.learn.springsecurity.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;

/**
 * @author: Zhang Chaoqing
 * Date: 2022/8/20 16:56
 */
@Configuration(proxyBeanMethods = false)
public class KiraWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource(name = "kiraAuthenticationFailureHandler")
    private AuthenticationFailureHandler authenticationFailureHandler;


    @Resource(name = "kiraAuthenticationSuccessHandler")
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * 认证管理器配置
     *
     * @param auth the {@link AuthenticationManagerBuilder} to use
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("123")).roles();
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("123")).roles();
    }


    /**
     * 核心过滤器配置
     *
     * @param web the {@link WebSecurity} to use
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/*.html");
    }

    /**
     * 安全过滤器链配置
     *
     * @param http the {@link HttpSecurity} to use
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单认证
        http.formLogin()
                .loginPage("/login.html")
                //当发现/login 时认为是登录，需 要执行 UserDetailsServiceImpl
                .loginProcessingUrl("/login")
                //登录成功后，跳转到指定请求（此处是 post 请求）
                .successForwardUrl("/aaa")
//                .successHandler(authenticationSuccessHandler)
//                登录失败
                .failureUrl("/loginfail.html");
//                .failureHandler(authenticationFailureHandler);


        http.authorizeRequests().anyRequest().authenticated();

        // url 拦截
//        http.authorizeRequests()
//                .antMatchers("/login.html").permitAll() //login.html 不需要被认证
//                .antMatchers("/loginfail.html").permitAll() //loginfail.html 不需要被认证
//                .anyRequest().authenticated();//所有的请求都必须被认证。必须登录 后才能访问。


        // 关闭 csrf 防护
        http.csrf().disable();
    }


}
