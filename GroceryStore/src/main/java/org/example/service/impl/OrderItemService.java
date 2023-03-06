package org.example.service.impl;

import org.example.model.OrderItem;
import org.example.service.IOderItemService;
import org.example.utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOderItemService {
    private static final String PATH = "./data/order-items.csv";
    private static OrderItemService instance;

    private OrderItemService() {

    }

    public static OrderItemService getInstance() {
        if (instance == null)
            instance = new OrderItemService();
        return instance;
    }

    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> records = CSVUtils.readToFile(PATH);
        for (String record : records) {
            orderItems.add(OrderItem.parseOrderItem(record));
        }
        return orderItems;
    }

    @Override
    public void add(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        orderItems.add(newOrderItem);
        CSVUtils.writeToFile(PATH, orderItems);
    }

    @Override
    public void update(long orderId, double price, double sum) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getOrderId() == orderId) {
                if (orderItem.getPrice() == price) {
                    orderItem.setGrandTotal(sum);
                    CSVUtils.writeToFile(PATH, orderItems);
                    break;
                }
            }
        }
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getId() == id)
                return orderItem;
        }
        return null;
    }
}
