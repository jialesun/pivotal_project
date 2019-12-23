package com.example.prftmgmt.ticketsui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TicketController {
    private TicketsClient ticketsClient;

    public TicketController(TicketsClient ticketsClient) {
        this.ticketsClient = ticketsClient;
    }

    @GetMapping("/tickets")
    public String allTickets(Map<String, Object> model) {
        model.put("tickets", ticketsClient.getAll());
        return "tickets";
    }
}
