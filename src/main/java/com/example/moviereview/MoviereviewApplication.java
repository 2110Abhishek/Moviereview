package com.example.moviereview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.moviereview")
public class MoviereviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoviereviewApplication.class, args);
    }
}

