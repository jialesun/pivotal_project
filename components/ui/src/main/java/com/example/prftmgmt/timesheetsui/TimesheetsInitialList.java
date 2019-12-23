package com.example.prftmgmt.timesheetsui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TimesheetsInitialList {

    public List<TimesheetUI> asList() {
        return Arrays.asList(new TimesheetUI(1, "BSC", 8, 8, 8, 8, 8, 40, "Approved"),
                new TimesheetUI(2, "BSC", 8, 8, 8, 8, 8, 40, "Approved"),
                new TimesheetUI(3, "BSC", 8, 8, 8, 8, 8, 40, "Approved"),
                new TimesheetUI(4, "BSC", 8, 8, 8, 8, 8, 40, "Approved"),
                new TimesheetUI(5, "BSC", 8, 8, 8, 0, 8, 32, "Approved"),
                new TimesheetUI(6, "BSC", 0,0,0,0,5,5, "Rejected")
        );
    }
}