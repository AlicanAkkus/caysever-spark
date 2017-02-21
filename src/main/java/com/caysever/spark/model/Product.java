package com.caysever.spark.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Product {
    
    private int id;
    private String name;
    private List<String> categories = new LinkedList<String>();
    private double price;
    private boolean available;
    
    public int getId() {
	return id;
    }
    
    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public List<String> getCategories() {
	return categories;
    }

    public void setCategories(List<String> categories) {
	this.categories = categories;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public boolean isAvailable() {
	return available;
    }

    public void setAvailable(boolean available) {
	this.available = available;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	StringBuffer asString = new StringBuffer();
	asString.append("id=").append(id).append(", ");
	asString.append("name=").append(name).append(", ");
	asString.append("price=").append(price).append(", ");
	asString.append("available=").append(available).append(", ");
	asString.append("categories=").append(Arrays.asList(categories));
	
	return asString.toString();
    }
    
    public boolean isValid(){
	return name != null && price >= 0.1 && categories.size() > 0;
    }

}
