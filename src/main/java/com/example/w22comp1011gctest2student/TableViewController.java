/*
 * Name: Ni Na Liu
 * Student Number: 200479031
 * */
package com.example.w22comp1011gctest2student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TableViewController implements Initializable {
    @FXML
    private Label saleLabel;

    @FXML
    private Label msrpLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> totalPurchaseColumn;

    @FXML
    private ListView<Product> purchaseListView;

    @FXML
    private ImageView imageView;

    private ReadJson ReadsJson;


    ApiResponse apiResponse = ReadsJson.getApiResponseFromJson("customers.json");

    ArrayList<Customer> customers = apiResponse.getCustomers();


    @FXML
    private void top10Customers() {
    

        System.out.println("called method top10Customers()");
    }

    @FXML
    private void customersSavedOver5() {


       // customers.stream()
            //    .filter(Customer::isSaved5OrMore)
            //    .collect(Collectors.toList());



        tableView.getItems().clear();
        tableView.getItems().addAll(customers.stream()
                .filter(Customer::isSaved5OrMore)
                .collect(Collectors.toList()));
        rowsInTableLabel.setText("#Rows In Table " + tableView.getItems().size());
        System.out.println("called method customersSavedOver5()");
    }

    @FXML
    private void loadAllCustomers() {
        System.out.println("called method loadAllCustomers");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchases"));


         tableView.getItems().clear();
        tableView.getItems().addAll(customers);
        rowsInTableLabel.setText("#Rows In Table " + tableView.getItems().size());
    }

    private void setLabels(Customer customer){

        double sumOfRegularPrice = 0;
        double sumOfSalePrice = 0;
        double saving = 0;

        for(Product product: customer.getProducts()){

            sumOfRegularPrice += product.getRegularPrice();

            sumOfSalePrice += product.getSalePrice();

            saving += (sumOfRegularPrice - sumOfSalePrice);
        }


        msrpLabel.setText("Sum Of Regular Price: "+ sumOfRegularPrice);
        saleLabel.setText("Sum Of Sale Price: "+ sumOfSalePrice);
        savingsLabel.setText("Total Saving: "+ saving);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadAllCustomers();


        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, selectedCustomer) -> {
            purchaseListView.getItems().clear();
            purchaseListView.getItems().addAll(selectedCustomer.getProducts());

            setLabels(selectedCustomer);
            imageView.setImage(null);


                }
        );

        purchaseListView.getSelectionModel().selectedItemProperty().addListener((obsPurchase, old, selectedProduct) -> {

            try {
                imageView.setImage(new Image(selectedProduct.getImageUrl()));

            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        });


    }}

