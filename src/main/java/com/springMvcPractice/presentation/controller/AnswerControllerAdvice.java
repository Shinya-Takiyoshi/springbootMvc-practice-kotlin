package com.springMvcPractice.presentation.controller;

import com.springMvcPractice.application.service.AnswerService;
import com.springMvcPractice.domain.model.Answer;
import com.springMvcPractice.domain.model.Drill;
import com.springMvcPractice.presentation.annotation.AnswerFilter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * タイミング:controllerの前後処理
 **/
@ControllerAdvice(assignableTypes = AnswerController.class)
public class AnswerControllerAdvice {
    @ModelAttribute("answer")
    public Answer addDrill(@AnswerFilter Drill drill) {
        AnswerService answerService = new AnswerService();
        return answerService.calcResult(drill);
    }

}
