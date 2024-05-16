package com.ucaru.mvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {

    //create mapping for "/hello"

    @GetMapping("/hello")
    public String sayHello(Model theModel)
    {
        theModel.addAttribute("theDate", new java.util.Date());


        return "helloWorld";
    }

}
