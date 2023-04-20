package com.springMvcPractice.config;

import com.springMvcPractice.domain.model.Drill;
import com.springMvcPractice.presentation.annotation.AnswerFilter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

/**
 * タイミング:リクエストの引数としてもらった時点で処理される
 * 参考:
 * https://qiita.com/rubytomato@github/items/37d58c2748c9f0a8566a
 **/
public class AnswerFilterArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("supportsParameter通過");
        return parameter.hasParameterAnnotation(AnswerFilter.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String operand = webRequest.getParameter("operand");
        Integer answerInput = Integer.parseInt(Objects.requireNonNull(webRequest.getParameter("answerInput")));
        return new Drill(operand, answerInput);
    }
}
