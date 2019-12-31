package com.example.prftmgmt.timesheetsui;

import com.example.prftmgmt.ticketsui.TicketUI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class TimesheetsClient {
    private static ParameterizedTypeReference<List<TimesheetUI>> timesheetListType = new ParameterizedTypeReference<List<TimesheetUI>>() {
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

    public void delete(long id) {
        restOperations.delete(timesheetURL + "/" + id);
    }

    public List<TimesheetUI> display(long id) {
        List<TimesheetUI> lst = restOperations.exchange(timesheetURL + "/" + id, HttpMethod.GET, null, timesheetListType).getBody();
        return lst;
    }

    public List<TimesheetUI> getAll() {
        List<TimesheetUI> read = restOperations.exchange(timesheetURL, HttpMethod.GET, null, timesheetListType).getBody();
        return read;
    }

    public List<TimesheetUI> getAllSort(String sort) {
        List<TimesheetUI> read = restOperations.exchange(timesheetURL + "/sort_" + sort, HttpMethod.GET, null, timesheetListType).getBody();
        return read;
    }


}