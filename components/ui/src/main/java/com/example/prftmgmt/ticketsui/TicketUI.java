package com.example.prftmgmt.ticketsui;

import java.io.Serializable;

public class TicketUI implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String description;
    private String teamLead;
    private String status;
    private String stDate;
    private String endDate;



    public TicketUI() {
    }

    public TicketUI(String name, String description, String teamLead, String status, String stDate, String endDate) {
        this.name = name;
        this.description = description;
        this.teamLead = teamLead;
        this.status = status;
        this.stDate = stDate;
        this.endDate = endDate;
    }

    public TicketUI(String name, String description, String teamLead) {
        this.name = name;
        this.description = description;
        this.teamLead = teamLead;
        this.status = "OPEN";
        this.stDate = "-";
        this.endDate = "-";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setLead(String teamLead) {
        this.teamLead = teamLead;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStDate() {
        return stDate;
    }

    public void setStDate(String stDate) {
        this.stDate = stDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

