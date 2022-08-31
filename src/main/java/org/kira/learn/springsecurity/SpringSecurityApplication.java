package org.kira.learn.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Zhang Chaoqing
 * Date: 2022/8/18 15:38
 * Demo学习地址
 * <a href="https://yunyanchengyu.blog.csdn.net/article/details/118694598">...</a>
 */
@SpringBootApplication
public class SpringSecurityApplication {

    /**
     * 授权码模式
     * <a href="http://localhost:20000/oauth/authorize?client_id=client&client_secret=secret&response_type=code">...</a>
     * 简化模式
     * <a href="http://localhost:20000/oauth/authorize?client_id=client&client_secret=secret&response_type=token">...</a>
     *
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }


}
