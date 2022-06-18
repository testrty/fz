package com.md.mybatisplus.t;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
       // InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        InterceptorRegistration registration = registry.addInterceptor(adminInterceptor);
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
                "http://127.0.0.1:1001/swagger-ui.html",
                "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"    //记得如果暴露swagger的话，记得把对应的jscss也得暴露出来
//                "你的登陆路径",            //登录
//                "/**/*.html",            //html静态资源
//                "/**/*.js",              //js静态资源
//                "/**/*.css",             //css静态资源
//                "/**/*.woff",
//                "/**/*.ttf"
        );
    }
}
