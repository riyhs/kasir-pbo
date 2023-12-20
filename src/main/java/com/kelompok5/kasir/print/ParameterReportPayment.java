package com.kelompok5.kasir.print;

import java.util.List;

public class ParameterReportPayment {
    String total;
    String date;
    List<FieldReportPayment> fields;

    public ParameterReportPayment() {}
    public ParameterReportPayment(String total, String date, List<FieldReportPayment> fields) {
        this.total = total;
        this.date = date;
        this.fields = fields;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<FieldReportPayment> getFields() {
        return fields;
    }

    public void setFields(List<FieldReportPayment> fields) {
        this.fields = fields;
    }
}
