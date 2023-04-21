package com.springMvcPractice.presentation.controller;

import com.springMvcPractice.application.service.CreateDrillService;
import com.springMvcPractice.domain.model.Drill;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {
    // RequestParamは、デフォルトがrequired = trueなので任意の場合は明示的に指定する。
    // defaultValueは指定なしの場合の値を設定できるので初期設定として利用する。
    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "0") @NonNull final int plusCnt,
                        @RequestParam(required = false, defaultValue = "0") @NonNull final int minusCnt,
                        final Model model) {
        //計算ドリル情報
        CreateDrillService createDrillService = new CreateDrillService();
        List<Drill> drillList = createDrillService.execute(plusCnt, minusCnt);
        model.addAttribute("drillList", drillList);
        model.addAttribute("welcome", "こんにちは");
        return "pages/index";
    }
}
