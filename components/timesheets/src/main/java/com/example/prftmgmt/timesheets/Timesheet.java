package com.example.prftmgmt.timesheets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Timesheet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String period;
    private String project;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int total;
    private String status;

    public Timesheet() {
    }

    public Timesheet(String period, String project, int monday, int tuesday, int wednesday, int thursday, int friday, int total, String status) {
        this.period = period;
        this.project = project;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.total = total;
        this.status = status;
    }

    public Timesheet(String period, String project, int monday, int tuesday, int wednesday, int thursday, int friday) {
        this.period = period;
        this.project = project;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.total = monday + tuesday + wednesday + thursday + friday;
        this.status = "In Review";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
