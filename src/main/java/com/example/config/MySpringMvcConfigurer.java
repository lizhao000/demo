package com.example.config;

import com.example.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfigurer {
    //添加视图控制
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
       return new WebMvcConfigurer() {
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("login");
               registry.addViewController("/home").setViewName("homepage");
           }
//           添加拦截器
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
               registry.addInterceptor(new LoginHandlerInterceptor())
                       //指定要拦截的请求 /** 表示拦截所有请求
                       .addPathPatterns("/**")
                       //排除不需要拦截的请求路径
                       .excludePathPatterns("/","/homepage","/index")
                       //springboot2+之后需要将静态资源文件的访问路径 也排除
                       .excludePathPatterns("/assets/**","/css/*","/fonts/**","/images/*","/img/*","/js/*");
           }
      };
    }
}
