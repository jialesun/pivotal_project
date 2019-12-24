package com.example.prftmgmt.ticketsui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/tickets")
    public String create (@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("teamLead") String teamLead, Map<String, Object> model) {
        TicketUI ticketUI = new TicketUI(name, description, teamLead);
        ticketsClient.create(ticketUI);
        model.put("tickets", ticketsClient.getAll());
        return "tickets";
    }

    @DeleteMapping("/tickets/{id}")


}
