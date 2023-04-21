package com.springMvcPractice.presentation.controller

import com.springMvcPractice.application.service.CreateDrillService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ViewController {
    // RequestParamは、デフォルトがrequired = trueなので任意の場合は明示的に指定する。
    // defaultValueは指定なしの場合の値を設定できるので初期設定として利用する。
    @GetMapping("/")
    fun index(
        @RequestParam(required = false, defaultValue = "0") plusCnt: Int,
        @RequestParam(required = false, defaultValue = "0") minusCnt: Int,
        model: Model
    ): String {
        //計算ドリル情報
        val createDrillService = CreateDrillService()
        val drillList = createDrillService.execute(plusCnt, minusCnt)
        model.addAttribute("drillList", drillList)
        model.addAttribute("welcome", "こんにちは")
        return "pages/index"
    }
}
