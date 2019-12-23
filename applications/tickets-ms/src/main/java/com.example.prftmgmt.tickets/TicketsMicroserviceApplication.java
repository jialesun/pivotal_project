package com.example.prftmgmt.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(exclude= {io.pivotal.spring.cloud.IssuerCheckConfiguration.class})
public class TicketsMicroserviceApplication {
    public static void main(String... args) {
        SpringApplication.run(TicketsMicroserviceApplication.class, args);
    }
}

