package com.example.prftmgmt;

import com.example.prftmgmt.ticketsui.TicketsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication(exclude= {io.pivotal.spring.cloud.IssuerCheckConfiguration.class})
public class Application {


    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public com.example.prftmgmt.timesheetsui.TimesheetsClient timesheetsClient(RestOperations restOperations) {
        return new com.example.prftmgmt.timesheetsui.TimesheetsClient("//timesheets-ms/timesheets", restOperations);
    }

    @Bean
    public TicketsClient ticketsClient(RestOperations restOperations) {
        return new TicketsClient("//tickets-ms/tickets", restOperations);
    }
}
