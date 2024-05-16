package com.ucaru.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String getMainPage()
    {
        return "home";
    }

    @GetMapping("/leaders")
    public String getLeadersPage(){ return "leaders"; }

    @GetMapping("/systems")
    public String getSystemsPage(){ return "systems"; }

}
