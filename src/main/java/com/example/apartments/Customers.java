package com.example.apartments;


import java.util.Date;

public class Customers {

    private int customer_id;
    private String first_name;
    private String last_name;
    private int Apartment_id;
    private String address;
    private double price;
    private String status;
    private double deposit;
    private Date date;
    private double remining;


    public Customers(double remining) {
        this.remining = remining;
    }




    public Customers(int customer_id, String first_name, String last_name, int apartment_id,
                     String address, double price, String status, double remining) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        Apartment_id = apartment_id;
        this.address = address;
        this.price = price;
        this.status = status;
     //   this.deposit = deposit;
        this.remining = remining;
    }


    public Customers(int customer_id, String first_name, String last_name, int apartment_id,
                     String address, double price, String status,
                     double deposit, Date date, double remining) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        Apartment_id = apartment_id;
        this.address = address;
        this.price = price;
        this.status = status;
        this.deposit = deposit;
        this.date = date;
        this.remining = remining;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getRemining() {
        return remining;
    }

    public void setRemining(double remining) {
        this.remining = remining;
    }

    public int getApartment_id() {
        return Apartment_id;
    }

    public void setApartment_id(int apartment_id) {
        Apartment_id = apartment_id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String toStringr() {
        return
                "" + remining +
                        "  $";
    }



    @Override
    public String toString() {
        return "Customer Details:" + '\n' + '\n' +
                "Customer_id=  " + customer_id + '\n'+
                "First_Name=  " + first_name + '\n' +
                "Last_Name=  " + last_name + '\n' +
                "Apartment_id=  " + Apartment_id +'\n'+
                "Address=  " + address + '\n' +
                "Price=  " + price + '\n' +
                "Status=  " + status + '\n' +
              //  "deposit=" + h.getTxtDeposit().getText() + '\n'+
                "Deposit_Date=  " + java.time.LocalDate.now() + '\n'

                ;
    }
}
