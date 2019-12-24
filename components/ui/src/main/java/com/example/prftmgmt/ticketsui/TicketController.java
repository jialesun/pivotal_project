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
        TicketUI ticketUI = new TicketUI();
        model.put("addTicket", ticketUI);
        return "tickets";
    }

    @PostMapping("/tickets")
    public String create (@ModelAttribute TicketUI ticketUI, Map<String, Object> model) {
        TicketUI ticketUI2 = new TicketUI(ticketUI.getName(), ticketUI.getDescription(), ticketUI.getTeamLead());
        ticketsClient.create(ticketUI2);
        model.put("tickets", ticketsClient.getAll());
        return "tickets";
    }


}
