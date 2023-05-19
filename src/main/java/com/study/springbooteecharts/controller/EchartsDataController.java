package com.study.springbooteecharts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Rrow
 * @date: 2023/5/19 12:13
 * Description:
 */
@Controller
public class EchartsDataController {

    @RequestMapping("echarts")
    public String firstDemo() {
        return "index";
    }

    @GetMapping("getData")
    @ResponseBody
    public String getData() {
        return "{'name':'猫羽雫'}";
    }


}
