package com.example.w22comp1011gctest2student;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class Product {
  @SerializedName("id")
   private int productId;

  private String name;

   private String sku;
   private double salePrice;
   private double regularPrice;
  @SerializedName("image")
   private String imageUrl;

  public int getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public String getSku() {
    return sku;
  }

  public double getSalePrice() {
    return salePrice;
  }

  public double getRegularPrice() {
    return regularPrice;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  @Override
  public String toString() {
    return String.format("%s - $%.2f", name, salePrice);

  }
}
