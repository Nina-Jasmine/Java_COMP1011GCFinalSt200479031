package com.example.w22comp1011gctest2student;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Customer {
    @SerializedName("id")
    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private ArrayList<Product> purchases;

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Product> getPurchases() {
        return purchases;
    }
}
