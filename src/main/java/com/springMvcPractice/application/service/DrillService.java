package com.springMvcPractice.application.service;

import com.springMvcPractice.domain.model.Drill;

import java.util.HashSet;


public interface DrillService {
    HashSet<Drill> createDrillList(final int Cnt, final int drillSize, final int stopSize);

    String convertDrillString(String operandLeft, String operandRight);
}

