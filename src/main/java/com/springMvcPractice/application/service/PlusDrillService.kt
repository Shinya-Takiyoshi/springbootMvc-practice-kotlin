package com.springMvcPractice.application.service

import com.springMvcPractice.domain.model.Drill
import com.springMvcPractice.domain.model.Operator
import java.util.function.BiFunction
import java.util.function.BiPredicate
import java.util.function.Function
import java.util.function.UnaryOperator

class PlusDrillService : DrillService {
    //プラスリストの生成
    override fun createDrillList(plusCnt: Int, drillSize: Int, stopSize: Int): HashSet<Drill> {
        if (drillSize <= 0) {
            return HashSet()
        } //0以下の場合、空のリストを返す
        val copyInteger = Function { x: Int -> x }
        var tempDriller = copyInteger.apply(drillSize)
        val rightCalc = BiFunction { y: Int, z: Int -> y - z }
        val isCounterMax = BiPredicate { cnt: Int, inputCnt: Int -> cnt < inputCnt }
        val isCalcMax = BiPredicate { cnt: Int, inputCnt: Int -> cnt < inputCnt } //左右どちらかの値が100になったら終了
        val drillList = HashSet<Drill>()
        var count = 0
        while (isCounterMax.test(count, plusCnt)) {
            //左の式を作る
            val operandLeft = tempDriller.toString()
            //右の式を作る
            val operandRight = rightCalc.apply(stopSize, tempDriller).toString()
            //式を作成してリストに追加する
            drillList.add(Drill(convertDrillString(operandLeft, operandRight)))
            //左のインクリメント
            --tempDriller
            //生成数のカウント
            count++
            if (isCalcMax.test(stopSize, tempDriller)) break
        }
        return drillList
    }

    /**
     * 式を作成する
     */
    override fun convertDrillString(operandLeft: String, operandRight: String): String {
        val builder = StringBuilder()
        builder.append(operandLeft)
        builder.append(" " + Operator.PLUS.operator + " ")
        builder.append(operandRight)
        builder.append(" =")
        return builder.toString()
    }
}
