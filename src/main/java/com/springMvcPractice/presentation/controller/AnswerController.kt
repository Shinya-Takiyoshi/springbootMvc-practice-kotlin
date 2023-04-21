package com.springMvcPractice.presentation.controller;

import com.springMvcPractice.domain.model.Answer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    @GetMapping("/answer")
    public Answer answer(@ModelAttribute Answer answer) {
        System.out.println("問題:" + answer.getDrill().getOperand());
        System.out.println("回答:" + answer.getDrill().getAnswerInput());
        System.out.println("答え:" + answer.getCalcResult());
        answer.setJudge();
        System.out.println("検証結果:" + answer.getJudge());
        return answer;
    }
}
