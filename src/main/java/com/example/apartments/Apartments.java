package com.example.apartments;



public class Apartments {

    private int Apartment_id;
    private String address;
    private double price;
    private String status;

//    public Apartments(String address, double price, String status) {
//        this.address = address;
//        this.price = price;
//        this.status = status;
//    }

    public Apartments(int apartment_id, String address, double price, String status) {
        Apartment_id = apartment_id;
        this.address = address;
        this.price = price;
        this.status = status;
    }

    public int getApartment_id() {
        return Apartment_id;
    }

    public void setApartment_id(int apartment_id) {
        Apartment_id = apartment_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
