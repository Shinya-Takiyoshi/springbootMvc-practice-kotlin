package com.springMvcPractice.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Answer {
    private final Drill drill;
    private final Integer calcResult;
    private Boolean judge;

    public void setJudge() {
        this.judge = this.calcResult.equals(drill.getAnswerInput());
    }
}
