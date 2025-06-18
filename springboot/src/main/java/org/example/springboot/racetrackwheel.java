package org.example.springboot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Component("racetrack")
@Component
@Profile("race")
public class racetrackwheel implements wheel{
    @Override
    public void rotate() {
        System.out.println("racetrack rotate");
    }

    @Override
    public void brake() {
        System.out.println("racetrack brake");

    }
}
