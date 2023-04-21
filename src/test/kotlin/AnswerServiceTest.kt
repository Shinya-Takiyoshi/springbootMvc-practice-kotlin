package com.springMvcPractice.web

import com.springMvcPractice.application.service.AnswerService
import com.springMvcPractice.domain.model.Drill
import org.junit.jupiter.api.Test


class AnswerServiceTest  {

    @Test
    fun answerServiceTest() {
        val answerService = AnswerService()
        val drill = Drill("22 + 44 =",66)
        assert(answerService.calcResult(drill).calcResult == 66)

    }

}
