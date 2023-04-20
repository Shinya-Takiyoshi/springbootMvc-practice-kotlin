package com.springMvcPractice.web

import com.springMvcPractice.presentation.controller.ViewController
import org.springframework.ui.Model
import spock.lang.Specification

class ViewControllerSpec extends Specification {
    def "Index"() {
        given:
        ViewController viewController = new ViewController()
        Model model = Mock(Model)
        model.addAttribute("test", "こんにちは")
        expect:
        viewController.index(model) == "こんにちは"
    }
}
