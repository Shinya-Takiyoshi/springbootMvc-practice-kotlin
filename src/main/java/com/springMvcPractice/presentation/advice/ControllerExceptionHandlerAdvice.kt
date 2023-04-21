package com.springMvcPractice.presentation.advice;

import com.springMvcPractice.presentation.controller.AnswerController;
import com.springMvcPractice.presentation.controller.ViewController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = {ViewController.class, AnswerController.class})
public class ControllerExceptionHandlerAdvice {
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleCriticalException(Throwable ex) {
        System.out.println("エラーメッセージ:" + ex);
        return "pages/error";
    }
}
