package com.ucaru.mvcthymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    // controller method: show initial form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //controller method: process form

    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }


    //controller method: read form data
    //                   add data to model

    @RequestMapping("/processFormV2")
    public String processFormV2(HttpServletRequest request, Model model)
    {
        //read the request param
        String theName = request.getParameter("studentName");
        //convert to all uppercase
        theName = theName.toUpperCase();
        String result = "HI " + theName;
        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String theName, Model model)
    {
        //convert to all uppercase
        theName = theName.toUpperCase();
        String result = "HI AGAIN " + theName;
        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
