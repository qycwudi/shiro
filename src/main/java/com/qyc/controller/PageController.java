package com.qyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qyc
 * @time 2020/4/19 - 17:28
 */
@Controller
@RequestMapping("/user")
public class PageController {
    @RequestMapping("/cvip1")
    public String test01(){
        System.out.println("hello");

        return "home";
    }
    @RequestMapping("/cvip2")
    public String test02(){
        System.out.println("hello");

        return "home";
    }
    @RequestMapping("/cvip3")
    public String test03(){
        System.out.println("hello");

        return "home";
    }
}
