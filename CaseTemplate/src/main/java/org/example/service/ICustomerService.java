package org.example.service;

import org.example.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Customer findCustomerById(long idCustomer);
    void updateCustomer(long idCustomer, Customer customer);

    void addCustomer(Customer customer);
}
