package com.springMvcPractice.domain.model

import lombok.Getter
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
@Getter
class Answer(val drill: Drill, val calcResult: Int) {
    var judge: Boolean = false
    fun setJudge() {
        judge = calcResult == drill!!.answerInput
    }
}
