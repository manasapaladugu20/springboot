package org.example.springboot;

import org.springframework.stereotype.Component;

@Component
public class offroadwheel implements  wheel{
    @Override
    public void rotate() {
        System.out.println("offroad rotate");
    }

    @Override
    public void brake() {
        System.out.println("offroad brake");
    }
}
