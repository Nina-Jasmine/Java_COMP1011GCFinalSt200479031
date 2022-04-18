package com.example.w22comp1011gctest2student;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {

    public static ApiResponse getApiResponseFromJson(String fileName)
    {
        Gson gson = new Gson();


        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        ) {
            return gson.fromJson(jsonReader, ApiResponse.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ApiResponse apiResponse = getApiResponseFromJson("customers.json");
        System.out.println(apiResponse.getCustomers());
    }

}
