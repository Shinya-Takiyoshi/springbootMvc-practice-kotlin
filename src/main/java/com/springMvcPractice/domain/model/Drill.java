package com.springMvcPractice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ドリルのモデリングクラス
 **/
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Drill {
    private final String operand;
    private Integer answerInput;
}
