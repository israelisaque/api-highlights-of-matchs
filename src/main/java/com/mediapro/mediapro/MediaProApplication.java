package com.mediapro.mediapro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MediaProApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaProApplication.class, args);
    }
}
