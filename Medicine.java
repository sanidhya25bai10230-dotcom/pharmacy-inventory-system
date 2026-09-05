package model;

import java.time.LocalDate;

public abstract class Medicine {

    private String id;
    private String name;
    private String batchNumber;
    private double price;
    private int quantity;
    private LocalDate expiryDate;

    public Medicine(String id, String name, String batchNumber,
                    double price, int quantity, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.batchNumber = batchNumber;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getCategory();

    public String toCsvRow() {
        return id + "," + name + "," + batchNumber + ","
                + price + "," + quantity + "," + expiryDate + ","
                + getCategory();
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name
                + "  Batch: " + batchNumber
                + "  Price: " + price
                + "  Stock: " + quantity
                + "  Exp: " + expiryDate
                + "  Type: " + getCategory();
    }
}