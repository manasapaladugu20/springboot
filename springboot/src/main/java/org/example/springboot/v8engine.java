package org.example.springboot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Component("v8")
@Component
@Profile("race")
public class v8engine implements engine{
    @Override
    public void start() {
        System.out.println("v8 engine start");
    }

    @Override
    public void stop() {
        System.out.println("v8 engine start");

    }

    @Override
    public void accelerate() {
        System.out.println("v8 engine start");

    }
}
