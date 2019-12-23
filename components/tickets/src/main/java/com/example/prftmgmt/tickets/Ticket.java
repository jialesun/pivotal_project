package com.example.prftmgmt.tickets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String desc;
    private String lead;
    private String status;
    private String stDate;
    private String endDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Ticket() {
    }

    public Ticket(String name, String desc, String lead, String status, String stDate, String endDate) {
        this.name = name;
        this.desc = desc;
        this.lead = lead;
        this.status = status;
        this.stDate = stDate;
        this.endDate = endDate;
    }

    public Ticket(String name, String desc, String lead) {
        this.name = name;
        this.desc = desc;
        this.lead = lead;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
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
