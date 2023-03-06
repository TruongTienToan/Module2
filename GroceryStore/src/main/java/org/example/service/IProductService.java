package org.example.service;

import org.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(long id);

    void searchByName(String title);
    void searchById(long id);

    boolean existById(long id);

    void add(Product newProduct);

    void update(Product newProduuct);

    void remove(int newProduct);

    Product sortQuantityASC();

    Product sortQuantityDESC();

    void updateQuantity(long id, int quantity);
}
