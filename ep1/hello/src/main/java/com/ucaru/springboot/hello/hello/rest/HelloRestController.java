package com.ucaru.springboot.hello.hello.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @Value("${coach.name}")
    private String coach;

    @Value("${team.name}")
    private String team;

    @GetMapping("/")
    public String sayHello()
    {
        return "<div><h1>HELLO</h1></div>";
    }

    @GetMapping("/test")
    public String red()
    {
        return "<div> <fieldset> <legend>TEST</legend>"
                +"<input id = 'hello' type = 'password'> </input> <br>"
                +"<input id = 'hello2'> </input>"
                +"  </fieldset> </div>";
    }

    @GetMapping("/teaminfo")
    public String teamInfo()
    {
        return "<h1>team name is :" + team + " coach name is : " + coach + "</h1>";
    }

}
