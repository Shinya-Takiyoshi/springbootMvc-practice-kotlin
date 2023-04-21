package com.springMvcPractice.config

import com.springMvcPractice.presentation.controller.ControllerInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * 参考：
 * https://qiita.com/yukina-ge/items/98ba5393bcde4df599d5
 */
@Configuration
open class MyWebMvcConfigure : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(ControllerInterceptor())
    }

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        //addArgmentで起動時にAnswerFilterArgumentResolverが登録されて有効となる
        resolvers.add(AnswerFilterArgumentResolver())
    }
}
