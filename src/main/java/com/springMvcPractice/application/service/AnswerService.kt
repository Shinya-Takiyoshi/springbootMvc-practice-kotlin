package com.springMvcPractice.application.service

import com.springMvcPractice.domain.model.Answer
import com.springMvcPractice.domain.model.Drill
import net.objecthunter.exp4j.ExpressionBuilder

/**
 * 文字列式計算ライブラリ参考:
 * https://salumarine.com/how-to-evaluate-mathematical-expression-string-in-java/
 */
class AnswerService {
    /**
     * 回答結果情報を確認して、◯×を判定する
     */
    fun calcResult(drill: Drill): Answer {
        //ここでanswerの答えを解析して設定する
        val originalOperand = drill.operand.replace(" =", "")
        val expression = ExpressionBuilder(originalOperand).build()
        val calcResult = expression.evaluate().toInt()
        return Answer(drill, calcResult)
    }
}
