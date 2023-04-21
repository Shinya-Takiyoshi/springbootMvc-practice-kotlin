package com.springMvcPractice.domain.model

import lombok.Getter
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
@Getter
class Answer(drill: Drill, calcResult: Int) {
    private val drill: Drill? = drill
    private val calcResult: Int? = calcResult
    private var judge: Boolean? = null
    fun setJudge() {
        judge = calcResult == drill!!.answerInput
    }
}
