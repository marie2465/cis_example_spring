package com.example.cis_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CisExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CisExampleApplication.class, args);
    }

}
