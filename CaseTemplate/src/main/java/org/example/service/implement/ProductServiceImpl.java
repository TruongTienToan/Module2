package org.example.service.implement;

import org.example.model.Customer;
import org.example.model.Product;
import org.example.service.IProductService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products = new ArrayList<>();
        products.add(new Product(1L, "Iphone 11", "2 mat", 11000, new Date()));
        products.add(new Product(2L, "Iphone 12", "2 mat", 12000, new Date()));
        products.add(new Product(3L, "Iphone 13", "2 mat", 13000, new Date()));
        products.add(new Product(4L, "Iphone 14", "2 mat", 14000, new Date()));
        products.add(new Product(5L, "Iphone 15", "2 mat", 15000, new Date()));
    }


    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }
    @Override
    public void deleteProductById(long idProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.remove(i);
                break;
            }
        }
    }

    @Override
    public void updateProductById(long idProduct, Product product) {

    }

    @Override
    public Product findProductById(long idProduct) {
        return null;
    }
}
