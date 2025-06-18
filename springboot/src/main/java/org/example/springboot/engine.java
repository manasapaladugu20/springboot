package org.example.springboot;

//@Component
//public class engine {
//    public void start(){
//        System.out.println("start engine ");
//    }
//    public void stop(){
//        System.out.println("stop engine");
//    }
//    public void accelerate(){
//        System.out.println("accelerate engine");
public interface engine {
    void start();
    void stop();
    void accelerate();
}

