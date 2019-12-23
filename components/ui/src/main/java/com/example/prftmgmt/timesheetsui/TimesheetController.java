package com.example.prftmgmt.timesheetsui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TimesheetController {
    private TimesheetsClient timesheetsClient;

    public TimesheetController(TimesheetsClient timesheetsClient) {
        this.timesheetsClient = timesheetsClient;
    }

    @GetMapping("/timesheets")
    public String allTimesheets(Map<String, Object> model) {
        model.put("timesheets", timesheetsClient.getAll());
        return "timesheets";
    }
}
