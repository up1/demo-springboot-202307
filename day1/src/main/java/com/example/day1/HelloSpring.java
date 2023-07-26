package com.example.day1;

import org.springframework.stereotype.Component;

@Component
public class HelloSpring {

    public int count = 10;

    public String sayHi() {
        return "Hello Spring " + count;
    }

}

class Demo {
    public static void main(String[] args) {
        HelloSpring helloSpring = new HelloSpring();
        String result = helloSpring.sayHi();
        System.out.println(result);
    }
}
