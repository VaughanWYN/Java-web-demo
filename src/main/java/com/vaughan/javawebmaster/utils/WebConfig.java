package com.vaughan.javawebmaster.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 使用 @CrossOrigin 注解允许跨域请求
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // 允许所有路径
//                .allowedOrigins("*") // 允许指定域名访问
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的方法
//                .allowedHeaders("*") // 允许的头信息
//                .allowCredentials(true) // 允许携带认证信息
//                .maxAge(3600); // 预检请求的缓存时间
//    }
}