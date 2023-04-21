package com.springMvcPractice.application.service;

import com.springMvcPractice.domain.model.Drill;
import com.springMvcPractice.domain.model.Operator;

import java.util.HashSet;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class PlusDrillService implements DrillService {
    //プラスリストの生成
    public HashSet<Drill> createDrillList(final int plusCnt, final int drillSize, final int stopSize) {
        if (drillSize <= 0) {
            return new HashSet<>();
        }//0以下の場合、空のリストを返す

        Function<Integer, Integer> copyInteger = x -> x;
        Integer tempDriller = copyInteger.apply(drillSize);

        UnaryOperator<Integer> incrementOfPlus = x -> ++x;
        BiFunction<Integer, Integer, Integer> rightCalc = (y, z) -> y - z;
        BiPredicate<Integer, Integer> isCounterMax = (cnt, inputCnt) -> cnt < inputCnt;
        BiPredicate<Integer, Integer> isCalcMax = (cnt, inputCnt) -> cnt < inputCnt; //左右どちらかの値が100になったら終了

        HashSet<Drill> drillList = new HashSet<>();
        int count = 0;
        while (isCounterMax.test(count, plusCnt)) {
            //左の式を作る
            String operandLeft = tempDriller.toString();
            //右の式を作る
            String operandRight = rightCalc.apply(stopSize, tempDriller).toString();
            //式を作成してリストに追加する
            drillList.add(new Drill(convertDrillString(operandLeft, operandRight)));
            //左のインクリメント
            tempDriller = incrementOfPlus.apply(tempDriller);
            //生成数のカウント
            count++;
            if (isCalcMax.test(stopSize, tempDriller)) break;
        }
        return drillList;
    }

    /**
     * 式を作成する
     **/
    public String convertDrillString(String operandLeft, String operandRight) {
        StringBuilder builder = new StringBuilder();
        builder.append(operandLeft);
        builder.append(" " + Operator.PLUS.getOperator() + " ");
        builder.append(operandRight);
        builder.append(" =");
        return builder.toString();
    }
}

