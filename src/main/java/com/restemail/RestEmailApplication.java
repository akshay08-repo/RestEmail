package com.restemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class RestEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestEmailApplication.class, args);
    }

}
