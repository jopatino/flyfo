package com.josepc.flyfo.models;

import com.josepc.flyfo.app.MyApplication;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Product extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String name;
    @Required
    private String description;

    private double price;
    @Required
    private String url;
    @Required
    private Date createdAt;

    public Product(){

    }


    public Product(String name, String description, String url, double price){
        this.id = MyApplication.ProductID.incrementAndGet();
        this.name = name;
        this.description = description;
        this.price = price;
        this.url = url;
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    /*
    public void setId(int id) {
        this.id = id;
    }
    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    /*
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
     */
}
