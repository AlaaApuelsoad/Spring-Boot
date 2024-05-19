package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //inject properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teamInfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+ coachName + " ,Team name:"+ teamName;
    }


    // expose "/" that return "Hello world"
    @GetMapping
    public String sayHello(){
        return "Hello spring";
    }

    // expose a new endpoint
    @GetMapping("/workout")
    public String workout(){
        return "run a 5km!";
    }



}
