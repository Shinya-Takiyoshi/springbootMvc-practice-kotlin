package com.springMvcPractice.application.service

import com.springMvcPractice.domain.model.Drill
import com.springMvcPractice.domain.model.Operator
import java.util.function.BiPredicate
import java.util.function.Function
import java.util.function.Predicate

class MinusDrillService : DrillService {
    //マイナスリストの生成
    override fun createDrillList(minusCnt: Int, drillSize: Int, stopSize: Int): HashSet<Drill> {
        if (drillSize <= 0) {
            return HashSet()
        } //0以下の場合、空のリストを返す
        //左の式は固定のため1度だけ作成
        val operandLeft = drillSize.toString()
        val copyInteger = Function { x: Int -> x }
        var tempDriller = copyInteger.apply(drillSize)
        val isCounterMax = BiPredicate { cnt: Int, inputCnt: Int -> cnt < inputCnt }
        val isCalcMin = Predicate { inputCnt: Int -> inputCnt == stopSize } //右の式が0になったら終了
        val drillList = HashSet<Drill>()
        var count = 0
        while (isCounterMax.test(count, minusCnt)) {
            //右の式を作る
            val operandRight = tempDriller.toString()
            //式を作成してリストに追加する
            drillList.add(Drill(convertDrillString(operandLeft, operandRight)))
            //左のインクリメント
            --tempDriller
            //生成数のカウント
            count++
            if (isCalcMin.test(tempDriller)) break
        }
        return drillList
    }

    /**
     * 式を作成する
     */
    override fun convertDrillString(operandLeft: String, operandRight: String): String {
        val builder = StringBuilder()
        builder.append(operandLeft)
        builder.append(" " + Operator.MINUS.operator + " ")
        builder.append(operandRight)
        builder.append(" =")
        return builder.toString()
    }
}
