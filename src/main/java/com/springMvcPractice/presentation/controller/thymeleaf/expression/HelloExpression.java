package com.springMvcPractice.presentation.controller.thymeleaf.expression;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloExpression {

    @Value("${hello.text}")
    public String helloTextOfConfig;

    public String helloText() {
        return "hello";
    }

}
