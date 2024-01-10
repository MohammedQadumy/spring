package com.luv2code.springcodedemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("Consrtuctor called" +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k !";
    }
}
