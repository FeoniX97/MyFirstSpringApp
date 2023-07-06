package com.feonix97.myfirstapp.rest;

import com.feonix97.myfirstapp.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;

    // Setter Injection
    @Autowired
    public void setMyCoach(@Qualifier("trackCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // Constructor Injection
//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
