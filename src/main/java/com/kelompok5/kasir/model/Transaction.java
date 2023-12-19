package com.kelompok5.kasir.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Transaction {
    private int id;
    private double total;
    private Timestamp datetime;

    public Transaction() {}
    public Transaction(int id, double total, Timestamp datetime) {
        this.id = id;
        this.total = total;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
