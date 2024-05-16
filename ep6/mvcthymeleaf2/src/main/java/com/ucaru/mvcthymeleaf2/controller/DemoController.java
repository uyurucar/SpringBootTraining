package com.ucaru.mvcthymeleaf2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class DemoController {

    @RequestMapping("/login")
    public String login()
    {
        return "hello-login";
    }

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }


}
