package com.example.prftmgmt.timesheetsui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class TimesheetsClient {
    private static ParameterizedTypeReference<List<TimesheetUI>> ticketListType = new ParameterizedTypeReference<List<TimesheetUI>>() {
    };
    private String timesheetURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;


    public TimesheetsClient(String timesheetURL, RestOperations restOperations) {
        this.timesheetURL = timesheetURL;
        this.restOperations = restOperations;
    }

    public void create(TimesheetUI timesheetUI) {
        restOperations.postForEntity(timesheetURL, timesheetUI, TimesheetUI.class);
    }


    public List<TimesheetUI> getAll() {
        List<TimesheetUI> read = restOperations.exchange(timesheetURL, HttpMethod.GET, null, ticketListType).getBody();

        return read;
    }
}