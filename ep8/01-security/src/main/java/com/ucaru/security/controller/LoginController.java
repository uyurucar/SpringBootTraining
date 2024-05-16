package com.ucaru.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/loginPage")
    public String getLoginPage()
    {
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage()
    {
        return "access-denied";
    }
}
