package org.example.model;

import org.example.utils.DateUtils;

import java.util.Date;
import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private Date createAt;


    public Product(long id, String name, String description, double price, Date createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
//        return "Product " + this.name + " price: " + this.price;
        return String.format("%s,%s,%s,%s,%s",
                this.getId(), this.getName(), this.getDescription(), this.getPrice(),
                DateUtils.dateToString(this.getCreateAt()));
    }


    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        if (this == p) {
            return true;
        }
        if (this.getName().equals(p.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
