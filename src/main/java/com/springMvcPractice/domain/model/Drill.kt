package com.springMvcPractice.domain.model

import lombok.Getter
import lombok.NonNull

/**
 * ドリルのモデリングクラス
 */
@Getter
data class Drill(@NonNull val operand: String, val answerInput: Int = 0)