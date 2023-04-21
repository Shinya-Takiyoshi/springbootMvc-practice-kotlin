package com.springMvcPractice.application.service

import com.springMvcPractice.domain.model.Drill
import java.util.*
import java.util.stream.Collectors

class CreateDrillService {
    fun execute(plusCnt: Int, minusCnt: Int): List<Drill?> {
        //プラスのリスト作成
        val plusDrillList = createPlusList(plusCnt)
        //マイナスのリスト作成
        val minusDrillList = createMinusList(minusCnt)

        //生成した数が要求された数を満たしている場合
        //プラスとマイナスをマージ
        //plusSetAllを全体のリストとする。
        //追加する場合は plusDrillList.addAll(*DrillList);
        plusDrillList.addAll(minusDrillList)

        //リストをシャッフルする
        Collections.shuffle(plusDrillList)
        return plusDrillList
    }

    fun createPlusList(plusCnt: Int): MutableList<Drill?> {
        if (plusCnt <= 0) {
            return mutableListOf()
        }
        //--createPlusList() start
        val plusSetAll = HashSet<Drill?>()
        //乱数生成
        val r = Random()
        val plusDrillService: DrillService = PlusDrillService()
        do {
            //重複しないプラスリストの生成
            val plusSet = plusDrillService.createDrillList(plusCnt, r.nextInt(MAX_DRILL_SIZE), MAX_DRILL_SIZE)
            //全体のリストにマージしていく
            plusSetAll.addAll(plusSet)
        } while (plusSetAll.size < plusCnt) //生成したプラスのリストが指定された数生成できているか確認
        var plusDrillList: MutableList<Drill?> = ArrayList(plusSetAll)
        // 余分に作成してしまった場合は削除する
        if (plusSetAll.size > plusCnt) {
            plusDrillList = plusSetAll.stream().limit(plusCnt.toLong()).collect(Collectors.toList())
        }
        println("plusList:" + plusDrillList.size)
        return plusDrillList
        //--createPlusList() end
    }

    fun createMinusList(minusCnt: Int): List<Drill?> {
        if (minusCnt <= 0) {
            return mutableListOf()
        }
        //乱数生成
        val r = Random()
        //--createMinusList() start
        //重複しないマイナスリストの生成
        val minudDrillService: DrillService = MinusDrillService()
        val minusSetAll = HashSet<Drill?>()
        do {
            val minusSet = minudDrillService.createDrillList(minusCnt, r.nextInt(MAX_DRILL_SIZE), MIN_DRILL_SIZE)
            minusSetAll.addAll(minusSet)
        } while (minusSetAll.size < minusCnt) //生成したマイナスのリストが指定された数生成できているか確認
        var minusDrillList: List<Drill?> = ArrayList(minusSetAll)
        // 余分に作成してしまった場合は削除する
        if (minusSetAll.size > minusCnt) {
            minusDrillList = minusSetAll.stream().limit(minusCnt.toLong()).collect(Collectors.toList())
        }
        println("minusList:" + minusDrillList.size)
        return minusDrillList
        //--createMinusList() end
    }

    companion object {
        const val MAX_DRILL_SIZE = 100
        const val MIN_DRILL_SIZE = 0
    }
}
