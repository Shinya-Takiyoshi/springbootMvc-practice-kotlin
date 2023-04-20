package com.springMvcPractice.config;

import com.springMvcPractice.presentation.controller.ControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 参考：
 * https://qiita.com/yukina-ge/items/98ba5393bcde4df599d5
 **/
@Configuration
public class MyWebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //addArgmentで起動時にAnswerFilterArgumentResolverが登録されて有効となる
        resolvers.add(new AnswerFilterArgumentResolver());
    }

}
