package com.springMvcPractice.domain.model

enum class Operator {
    PLUS {
        override val operator: String
            get() = "+"
    },
    MINUS {
        override val operator: String
            get() = "-"
    };

    abstract val operator: String
}
