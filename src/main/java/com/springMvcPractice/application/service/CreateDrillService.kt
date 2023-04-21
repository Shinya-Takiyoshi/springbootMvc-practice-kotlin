package com.springMvcPractice.application.service;

import com.springMvcPractice.domain.model.Drill;

import java.util.*;
import java.util.stream.Collectors;

public class CreateDrillService {
    public static final int MAX_DRILL_SIZE = 100;
    public static final int MIN_DRILL_SIZE = 0;

    public List<Drill> execute(final int plusCnt, final int minusCnt) {
        //プラスのリスト作成
        List<Drill> plusDrillList = createPlusList(plusCnt);
        //マイナスのリスト作成
        List<Drill> minusDrillList = createMinusList(minusCnt);

        //生成した数が要求された数を満たしている場合
        //プラスとマイナスをマージ
        //plusSetAllを全体のリストとする。
        //追加する場合は plusDrillList.addAll(*DrillList);
        plusDrillList.addAll(minusDrillList);

        //リストをシャッフルする
        Collections.shuffle(plusDrillList);

        return plusDrillList;
    }

    public List<Drill> createPlusList(int plusCnt) {
        if (plusCnt <= 0) {
            return Collections.EMPTY_LIST;
        }
        //--createPlusList() start
        HashSet<Drill> plusSetAll = new HashSet<>();
        //乱数生成
        Random r = new Random();
        DrillService plusDrillService = new PlusDrillService();
        do {
            //重複しないプラスリストの生成
            HashSet<Drill> plusSet = plusDrillService.createDrillList(plusCnt, r.nextInt(MAX_DRILL_SIZE), MAX_DRILL_SIZE);
            //全体のリストにマージしていく
            plusSetAll.addAll(plusSet);
        } while (plusSetAll.size() < plusCnt);//生成したプラスのリストが指定された数生成できているか確認

        List<Drill> plusDrillList = new ArrayList<>(plusSetAll);
        // 余分に作成してしまった場合は削除する
        if (plusSetAll.size() > plusCnt) {
            plusDrillList = plusSetAll.stream().limit(plusCnt).collect(Collectors.toList());
        }
        System.out.println("plusList:" + plusDrillList.size());
        return plusDrillList;
        //--createPlusList() end
    }

    public List<Drill> createMinusList(int minusCnt) {
        if (minusCnt <= 0) {
            return Collections.EMPTY_LIST;
        }
        //乱数生成
        Random r = new Random();
//--createMinusList() start
        //重複しないマイナスリストの生成
        DrillService minudDrillService = new MinusDrillService();
        HashSet<Drill> minusSetAll = new HashSet<>();
        do {
            HashSet<Drill> minusSet = minudDrillService.createDrillList(minusCnt, r.nextInt(MAX_DRILL_SIZE), MIN_DRILL_SIZE);
            minusSetAll.addAll(minusSet);
        } while (minusSetAll.size() < minusCnt);//生成したマイナスのリストが指定された数生成できているか確認

        List<Drill> minusDrillList = new ArrayList<>(minusSetAll);
        // 余分に作成してしまった場合は削除する
        if (minusSetAll.size() > minusCnt) {
            minusDrillList = minusSetAll.stream().limit(minusCnt).collect(Collectors.toList());
        }

        System.out.println("minusList:" + minusDrillList.size());
        return minusDrillList;
        //--createMinusList() end
    }
}


