package com.springMvcPractice.presentation.controller

import com.springMvcPractice.domain.model.Answer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class AnswerController {
    @GetMapping("/answer")
    fun answer(@ModelAttribute answer: Answer): Answer {
        //kotlinのdata classを扱う場合privateから呼べないため呼べない。
        //対策：kotlinファイルに統一するかデータクラスをやめるか
        println("問題:" + answer.drill.operand)
        println("回答:" + answer.drill.answerInput)
        println("答え:" + answer.calcResult)
        answer.setJudge()
        println("検証結果:" + answer.judge)
        return answer
    }
}
