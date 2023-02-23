package org.example.service;

import org.example.model.Customer;
import org.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    void deleteProductById(long idProduct);

    void updateProductById(long idProduct, Product product);

    Product findProductById(long idProduct);
}
