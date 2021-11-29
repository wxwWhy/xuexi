package com.xianwen.xuexi;

import com.xianwen.xuexi.filter.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ：xw.weng
 * @date ：Created in 2020/6/2 8:50
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/*/api/**", "/*/rpc/**");
        super.addInterceptors(registry);
    }

}
