package com.example.prftmgmt.ticketsui;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TicketsInitialList {

    public List<TicketUI> asList() {
        return Arrays.asList(new TicketUI("Release_Jan",
                        "January release",
                        "Alex"),
                new TicketUI("Release_Feb",
                        "February release",
                        "Tom"),
                new TicketUI("Release_Mar",
                        "March release",
                        "John"),
                new TicketUI("Release_Apr",
                        "April release",
                        "Kate")
        );
    }
    }