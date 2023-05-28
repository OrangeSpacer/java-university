package com.example.magazine;

public class Shop {
    private int id;
    private String name;
    private String address;
    private String openTime;
    private String closeTime;

    public Shop(int id, String name, String address, String openTime, String closeTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }
}
