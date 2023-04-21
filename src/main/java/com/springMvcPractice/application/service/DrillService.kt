package com.springMvcPractice.application.service

import com.springMvcPractice.domain.model.Drill

interface DrillService {
    fun createDrillList(cnt: Int, drillSize: Int, stopSize: Int): HashSet<Drill>
    fun convertDrillString(operandLeft: String, operandRight: String): String
}
