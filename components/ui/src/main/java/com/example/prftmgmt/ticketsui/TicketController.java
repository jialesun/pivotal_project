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

    @PostMapping("/tickets")
    public String create (@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("teamLead") String teamLead, Map<String, Object> model) {
        TicketUI ticketUI = new TicketUI(name, description, teamLead);
        ticketsClient.create(ticketUI);
        model.put("tickets", ticketsClient.getAll());
        return "tickets";
    }

    @GetMapping("/tickets")
    public String processGetRequests(@RequestParam(value="sort", required=false) String sort,
                                 @RequestParam(value="id", required=false) Long id,
                                 @RequestParam(value="action", required=false) String action,
                                 Map<String, Object> model) {
        if(action == null)
            model.put("tickets", ticketsClient.getAll());
        else if(action.equals("sort")) {
            if(sort == null)
                model.put("tickets", ticketsClient.getAllSort("id"));
            else
                model.put("tickets", ticketsClient.getAllSort(sort));
        }
        else if(action.equals("remove")) {
            if(id == null)
                model.put("tickets", ticketsClient.getAll());
            else {
                ticketsClient.delete(id.longValue());
                model.put("tickets", ticketsClient.getAll());
            }
        }
        else if(action.equals("display")) {
            if(id == null)
                model.put("tickets", ticketsClient.getAll());
            else
                model.put("tickets", ticketsClient.display(id.longValue()));
        }


        else model.put("tickets", ticketsClient.getAll());
        return "tickets";
    }

}
