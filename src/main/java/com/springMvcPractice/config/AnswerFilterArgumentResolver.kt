package com.springMvcPractice.config

import com.springMvcPractice.domain.model.Drill
import com.springMvcPractice.presentation.annotation.AnswerFilter
import org.springframework.core.MethodParameter
import org.springframework.lang.Nullable
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import java.util.*

/**
 * タイミング:リクエストの引数としてもらった時点で処理される
 * 参考:
 * https://qiita.com/rubytomato@github/items/37d58c2748c9f0a8566a
 */
class AnswerFilterArgumentResolver : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        println("supportsParameter通過")
        return parameter.hasParameterAnnotation(AnswerFilter::class.java)
    }

    @Throws(Exception::class)
    override fun resolveArgument(
        parameter: MethodParameter,
        @Nullable mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        @Nullable binderFactory: WebDataBinderFactory?
    ): Any? {
        val operand = Objects.requireNonNull(webRequest.getParameter("operand"))
        val answerInput = Objects.requireNonNull(webRequest.getParameter("answerInput")).toInt()
        return Drill(operand, answerInput)
    }
}
