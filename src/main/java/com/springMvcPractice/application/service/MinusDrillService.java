package com.springMvcPractice.application.service;

import com.springMvcPractice.domain.model.Drill;
import com.springMvcPractice.domain.model.Operator;

import java.util.HashSet;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class MinusDrillService implements DrillService {
    //マイナスリストの生成
    public HashSet<Drill> createDrillList(final int minusCnt, final int drillSize, final int stopSize) {
        if (drillSize <= 0) {
            return new HashSet<>();
        }//0以下の場合、空のリストを返す
        //左の式は固定のため1度だけ作成
        String operandLeft = String.valueOf(drillSize);

        Function<Integer, Integer> copyInteger = x -> x;
        Integer tempDriller = copyInteger.apply(drillSize);

        UnaryOperator<Integer> incrementOfMinus = x -> --x;
        BiPredicate<Integer, Integer> isCounterMax = (cnt, inputCnt) -> cnt < inputCnt;
        Predicate<Integer> isCalcMin = (inputCnt) -> inputCnt == stopSize; //右の式が0になったら終了


        HashSet<Drill> drillList = new HashSet<>();
        int count = 0;
        while (isCounterMax.test(count, minusCnt)) {
            //右の式を作る
            String operandRight = tempDriller.toString();
            //式を作成してリストに追加する
            drillList.add(new Drill(convertDrillString(operandLeft, operandRight)));
            //左のインクリメント
            tempDriller = incrementOfMinus.apply(tempDriller);
            //生成数のカウント
            count++;
            if (isCalcMin.test(tempDriller)) break;
        }
        return drillList;
    }

    /**
     * 式を作成する
     **/
    public String convertDrillString(String operandLeft, String operandRight) {
        StringBuilder builder = new StringBuilder();
        builder.append(operandLeft);
        builder.append(" " + Operator.MINUS.getOperator() + " ");
        builder.append(operandRight);
        builder.append(" =");
        return builder.toString();
    }
}

