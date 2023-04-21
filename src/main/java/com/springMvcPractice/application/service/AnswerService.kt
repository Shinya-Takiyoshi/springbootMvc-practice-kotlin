package com.springMvcPractice.application.service;

import com.springMvcPractice.domain.model.Answer;
import com.springMvcPractice.domain.model.Drill;
import lombok.experimental.NonFinal;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * 文字列式計算ライブラリ参考:
 * https://salumarine.com/how-to-evaluate-mathematical-expression-string-in-java/
 **/
public class AnswerService {
    /**
     * 回答結果情報を確認して、◯×を判定する
     **/
    public Answer calcResult(@NonFinal Drill drill) {
        //ここでanswerの答えを解析して設定する
        String originalOperand = drill.getOperand().replace(" =", "");
        Expression expression = new ExpressionBuilder(originalOperand).build();
        Integer calcResult = (int) expression.evaluate();
        return new Answer(drill, calcResult);
    }
}
