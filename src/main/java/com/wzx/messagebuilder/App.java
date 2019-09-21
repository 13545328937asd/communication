package com.wzx.messagebuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        try {
            SpringApplication.run(App.class);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
