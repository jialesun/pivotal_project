package com.example.prftmgmt.timesheetsui;

import com.example.prftmgmt.timesheetsui.TimesheetUI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TimesheetController {
    private TimesheetsClient timesheetsClient;

    public TimesheetController(TimesheetsClient timesheetsClient) {
        this.timesheetsClient = timesheetsClient;
    }

    @PostMapping("/timesheets")
    public String create (@RequestParam("period") String period, @RequestParam("project") String project, @RequestParam("monday") int monday,
                          @RequestParam("tuesday") int tuesday, @RequestParam("wednesday") int wednesday, @RequestParam("thursday") int thursday,
                          @RequestParam("friday") int friday, Map<String, Object> model) {
        TimesheetUI timesheetUI = new TimesheetUI(period, project, monday, tuesday, wednesday, thursday, friday);
        timesheetsClient.create(timesheetUI);
        model.put("timesheets", timesheetsClient.getAll());
        return "timesheets";
    }

    @GetMapping("/timesheets")
    public String processGetRequests(@RequestParam(value="sort", required=false) String sort,
                                     @RequestParam(value="id", required=false) Long id,
                                     @RequestParam(value="action", required=false) String action,
                                     Map<String, Object> model) {
        if(action == null)
            model.put("timesheets", timesheetsClient.getAll());
        else if(action.equals("sort")) {
            if(sort == null)
                model.put("timesheets", timesheetsClient.getAll());
            else
                model.put("timesheets", timesheetsClient.getAllSort(sort));
        }
        else if(action.equals("remove")) {
            if(id == null)
                model.put("timesheets", timesheetsClient.getAll());
            else {
                timesheetsClient.delete(id.longValue());
                model.put("timesheets", timesheetsClient.getAll());
            }
        }
        else if(action.equals("display")) {
            if(id == null)
                model.put("timesheets", timesheetsClient.getAll());
            else
                model.put("timesheets", timesheetsClient.display(id.longValue()));
        }


        else model.put("timesheets", timesheetsClient.getAll());
        return "timesheets";
    }
}
