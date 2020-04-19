package com.qyc.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qyc
 * @time 2020/4/19 - 17:12
 */
@Configuration
public class WebCfg implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/userlogin").setViewName("userloginpage");
        registry.addViewController("/home").setViewName("home");

    }
}
