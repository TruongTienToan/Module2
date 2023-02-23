package org.example.model;

import org.example.utils.DateUtils;

import java.util.Date;
import java.util.Objects;

public class Customer {
    private long id;
    private String name;
    private String phone;
    private String address;
    private Date createAt;
    private double consumed;
    private CustomerType customerType;

    public Customer() {

    }

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer(long id, String name, String phone, String address, Date createAt, double consumed, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.consumed = consumed;
        this.customerType = customerType;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getConsumed() {
        return consumed;
    }

    public void setConsumed(double consumed) {
        this.consumed = consumed;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String toString() {
        // Date: createAt => createAt.toString() : Thu Feb 23 07:00:00 ICT 2006
        // cần chuyển đổi Thu Feb 23 07:00:00 ICT 2006 -> 20-10-2023 08:10
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                id, name, phone, address, DateUtils.dateToString(createAt), consumed, customerType);
    }

    @Override
    public boolean equals(Object obj) {
        Customer customer = (Customer) obj;
        if (this == customer) {
            return true;
        }
        if (this.getName().equals(customer.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}
