package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping
    public String sayHello(){
        return "Hello spring";
    }
    @GetMapping("/workout")
    public String workout(){
        return "run a 5km!";
    }
}
