package com.example.prftmgmt.timesheets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication(exclude= {io.pivotal.spring.cloud.IssuerCheckConfiguration.class})
public class MovieMicroserviceApplication {
    public static void main(String... args) {
        SpringApplication.run(MovieMicroserviceApplication.class, args);
    }
}

