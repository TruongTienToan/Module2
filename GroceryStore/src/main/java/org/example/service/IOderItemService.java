package org.example.service;

import org.example.model.OrderItem;

import java.util.List;

public interface IOderItemService {
    List<OrderItem> findAll();

    void add(OrderItem newOrderItem);

    void update(long orderId, double price, double sum);

    OrderItem getOrderItemById(int id);
}
