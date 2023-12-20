package com.kelompok5.kasir.print;

public class FieldReportPayment {
    private double harga;
    private int qty;
    private String nama;
    private double total;

    public FieldReportPayment() {}
    public FieldReportPayment(double harga, int qty, String nama, double total) {
        this.harga = harga;
        this.qty = qty;
        this.nama = nama;
        this.total = total;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
