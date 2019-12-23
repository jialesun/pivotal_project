package com.example.prftmgmt.timesheetsui;

import java.io.Serializable;

public class TimesheetUI implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private int period;
    private String project;
    private int M;
    private int T;
    private int W;
    private int Th;
    private int F;
    private int total;
    private String status;

    public TimesheetUI() {
    }

    public TimesheetUI(int period, String project, int m, int t, int w, int th, int f, int total, String status) {
        this.period = period;
        this.project = project;
        this.M = m;
        this.T = t;
        this.W = w;
        this.Th = th;
        this.F = f;
        this.total = total;
        this.status = status;
    }

    public TimesheetUI(int period, String project, int m, int t, int w, int th, int f) {
        this.period = period;
        this.project = project;
        M = m;
        T = t;
        W = w;
        Th = th;
        F = f;
        this.total = M + T + W + Th + F;
        this.status = "In Review";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }

    public int getW() {
        return W;
    }

    public void setW(int w) {
        W = w;
    }

    public int getTh() {
        return Th;
    }

    public void setTh(int th) {
        Th = th;
    }

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
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
