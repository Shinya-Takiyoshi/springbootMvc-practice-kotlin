package com.springMvcPractice.presentation.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.util.UriEncoder;

public class ControllerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        System.out.println("requestUrl:" + requestUrlOfString(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        System.out.println("ResponseStatus:" + response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        System.out.println("CompletedUrl:" + requestUrlOfString(request));
    }

    private String requestUrlOfString(HttpServletRequest req) {
        String decodeParameter = "";
        if (req.getQueryString() != null) {
            decodeParameter = UriEncoder.decode(req.getQueryString());
        }
        return !decodeParameter.isEmpty() ? (req.getRequestURL().toString() + "?" + decodeParameter) : req.getRequestURL().toString();
    }
}
