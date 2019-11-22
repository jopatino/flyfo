package com.josepc.flyfo.models;

import com.josepc.flyfo.app.MyApplication;

import java.util.Date;

import javax.annotation.RegEx;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ShoppingCar extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String user;

    private double latitude;
    private double longitude;
    private double total;

    @Required
    private String address;
    @Required
    private String details;
    @Required
    private Date createdAt;


    //Crear relacion entre tabla shoppingcar y products
    private RealmList<Product> products;

    public ShoppingCar(){

    }

    public ShoppingCar(String user, double latitude, double longitude, double total, String address, String details){
        this.id = MyApplication.ShoppingCarID.incrementAndGet();
        this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
        this.total = total;
        this.address = address;
        this.details = details;
        this.products = new RealmList<Product>();
    }

    public int getId() {
        return id;
    }

    /*
    public void setId(int id) {
        this.id = id;
    }
     */

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public RealmList<Product> getProducts() {
        return products;
    }

    public void setProducts(RealmList<Product> products) {
        this.products = products;
    }
}
