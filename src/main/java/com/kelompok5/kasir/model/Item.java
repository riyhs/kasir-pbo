package com.kelompok5.kasir.model;

public class Item {
    private int id;
    private double price;
    private int qty;
    private String name;
    private double total;
    private int transactionId;
    private int productId;

    public Item(){};

    public Item(int id, double price, int qty, String name, double total, int transactionId, int productId) {
        this.id = id;
        this.price = price;
        this.qty = qty;
        this.name = name;
        this.total = total;
        this.transactionId = transactionId;
        this.productId = productId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }
}
