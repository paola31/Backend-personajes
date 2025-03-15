package com.example.databasepersonajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DataBasePersonajesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataBasePersonajesApplication.class, args);
    }

}
