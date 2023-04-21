package com.springMvcPractice.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Operator {
    PLUS("+"),
    MINUS("-");

    private final String operator;
}
