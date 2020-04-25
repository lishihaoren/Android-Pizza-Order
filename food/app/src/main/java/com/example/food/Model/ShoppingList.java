package com.example.food.Model;

public class ShoppingList {

    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Price;
    private String Location;

    public ShoppingList(){

    }

    public ShoppingList(String productId, String productName, String quantity, String price, String location) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        Location = location;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
