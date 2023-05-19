package com.study.springbooteecharts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

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
    public Object getData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("444");
        list.add("111");
        list.add("555");
        hashMap.put("data1",list);

        // return "{'name':'猫羽雫'}";
        return hashMap;
    }


}
