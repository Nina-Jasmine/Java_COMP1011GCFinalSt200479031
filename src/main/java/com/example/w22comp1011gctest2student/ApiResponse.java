package com.example.w22comp1011gctest2student;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
public class ApiResponse {
    @SerializedName("BusinessName")
    private String businessName;

    private Customer[] customers;
}
