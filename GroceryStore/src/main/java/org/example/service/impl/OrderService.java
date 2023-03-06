package org.example.service.impl;

import org.example.model.Order;
import org.example.service.IOderService;
import org.example.utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOderService {
    private final static String PATHORDER = "./data/orders.csv";
    private static OrderService instance;

    public OrderService() {

    }

    public static OrderService getInstance() {
        if (instance == null)
            instance = new OrderService();
        return instance;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtils.readToFile(PATHORDER);
        for (String record: records) {
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orders = findAll();
        newOrder.setCreatedAt(Instant.now());
        orders.add(newOrder);
        CSVUtils.writeToFile(PATHORDER, orders);
    }

    @Override
    public void update() {
        List<Order> orders = findAll();
        CSVUtils.writeToFile(PATHORDER, orders);
    }

    @Override
    public Order findById(long id) {
        List<Order> orders = findAll();
        for (Order order: orders) {
            if (order.getId() == id)
                return order;
        }
        return null;
    }

    @Override
    public List<Order> findByUserId(long id) {
        List<Order> newOrder = new ArrayList<>();
        for (Order order : findAll()) {
            if (order.getId() == id)
                newOrder.add(order);
        }
        return null;
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }
}
