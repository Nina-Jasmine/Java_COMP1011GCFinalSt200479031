/*
*
* */

package com.example.w22comp1011gctest2student;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Customer {
    @SerializedName("id")
    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @SerializedName("purchases")
    private ArrayList<Product> products;

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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotalPurchases(){
       return products.stream()
                .mapToDouble(products -> products.getSalePrice())
                .sum();
    }

    public double getSaved(){
        double saved = 0;
         for(Product product : products){

             saved += product.getRegularPrice() - product.getSalePrice();
         }
         return saved;
    }
    public boolean isSaved5OrMore(){
        return getSaved() >= 5;
    }
}
