package org.example.service;

import org.example.model.Order;

import java.util.List;

public interface IOderService {
    List<Order> findAll();

    void add(Order newOrder);

    void update();

    Order findById(long id);

    List<Order> findByUserId(long id);

    boolean existById(long id);
}
