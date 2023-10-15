package com.arias.kadai07.entity;

public class Catalog_List {
    private int id;
    private String productName;
    private int productPrice;
    private int productStock;

    public Catalog_List() {
    }

    public Catalog_List(int id, String productName, int productPrice, int productStock) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
