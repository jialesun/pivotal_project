package com.example.prftmgmt;

import com.example.prftmgmt.timesheetsui.TimesheetsClient;
import com.example.prftmgmt.timesheetsui.TimesheetsInitialList;
import com.example.prftmgmt.ticketsui.TicketsClient;
import com.example.prftmgmt.ticketsui.TicketsInitialList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RootController {
    private TimesheetsClient timesheetsClient;
    private TicketsClient ticketsClient;
    private TimesheetsInitialList timesheetsInitialList;
    private TicketsInitialList ticketsInitialList;

    public RootController(TimesheetsClient timesheetsClient, TicketsClient ticketsClient, TimesheetsInitialList timesheetsInitialList, TicketsInitialList ticketsInitialList) {
        this.timesheetsClient = timesheetsClient;
        this.ticketsClient = ticketsClient;
        this.timesheetsInitialList = timesheetsInitialList;
        this.ticketsInitialList = ticketsInitialList;
    }

    @GetMapping("/")
    public String rootPath() {
        return "index";
    }

    @GetMapping("/setup")
    public String setupDatabase(Map<String, Object> model) {

        timesheetsInitialList.asList().forEach(timesheetsClient::create);
        model.put("timesheets", timesheetsClient.getAll());

        ticketsInitialList.asList().forEach(ticketsClient::create);
        model.put("tickets", timesheetsClient.getAll());


        return "setup";
    }

}