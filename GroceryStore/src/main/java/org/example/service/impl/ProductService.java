package org.example.service.impl;

import org.example.model.Product;
import org.example.service.IProductService;
import org.example.utils.CSVUtils;
import org.example.utils.InstantUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductService implements IProductService {
    public static final String PATHPRODUCT = "./data/products.csv";

    private static ProductService instance;

    public ProductService() {

    }

    public static ProductService getInstance() {
        if (instance == null)
            instance = new ProductService();
            return instance;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        List<String> records = CSVUtils.readToFile(PATHPRODUCT);
        for (String record : records) {
            productList.add(Product.parseProduct(record));
        }
        return productList;
    }

    @Override
    public Product findById(long id) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void searchByName(String title) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getTitle().toLowerCase().replace(" ","").equals(title.replace(" ",""))) {
                System.out.printf("Sản phẩm bạn muốn tìm kiếm là: \nID:  %s | Tên sản phẩm:  %s | Giá sản phẩm:  %s | Số lượng:  %s | Ngày tạo:  %s  Ngày cập nhật:  %s\n",
                        product.getId(),
                        product.getTitle(),
                        InstantUtils.doubleToVND(product.getPrice()),
                        InstantUtils.quantityProducts(product.getQuantity()),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "chưa có": InstantUtils.instantToString(product.getUpdateAt()));
                return;
            }
        }
    }

    @Override
    public void searchById(long id) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                System.out.printf("Sản phẩm bạn muốn tìm kiếm là: \nID:  %s | Tên sản phẩm:  %s | Giá sản phẩm:  %s | Số lượng:  %s | Ngày tạo:  %s | Ngày cập nhật:  %s\n",
                        product.getId(),
                        product.getTitle(),
                        InstantUtils.doubleToVND(product.getPrice()),
                        InstantUtils.quantityProducts(product.getQuantity()),
                        InstantUtils.instantToString(product.getCreateAt()),
                        product.getUpdateAt() == null ? "chưa có": InstantUtils.instantToString(product.getUpdateAt()));
                return;
            }
        }
    }

    @Override
    public boolean existById(long id) {
        return findById(id) != null;
    }

    @Override
    public void add(Product newProduct) {
        newProduct.setCreateAt(Instant.now());
        List<Product> productList = findAll();
        for (Product product : productList) {
            String newName = newProduct.getTitle().replace(" ", "").toLowerCase();
            String nameProduct = product.getTitle().replace(" ", "").toLowerCase();
            if (newName.equals(nameProduct) && newProduct.getPrice().equals(product.getPrice())) {
                product.setQuantity(product.getQuantity() + newProduct.getQuantity());
                CSVUtils.writeToFile(PATHPRODUCT, productList);
                return;
            }
        }
        productList.add(newProduct);
        CSVUtils.writeToFile(PATHPRODUCT, productList);
    }

    @Override
    public void update(Product newProduct) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (newProduct.getId().equals(product.getId())) {
                if (newProduct.getTitle() != null && !newProduct.getTitle().isEmpty())
                    product.setTitle(newProduct.getTitle());
                if (newProduct.getPrice() != null)
                    product.setPrice(newProduct.getPrice());
                if (newProduct.getQuantity() != null)
                    product.setQuantity(newProduct.getQuantity());
                product.setUpdateAt(Instant.now());
                CSVUtils.writeToFile(PATHPRODUCT, productList);
            }
        }
    }

    @Override
    public void remove(int idProduct) {
        List<Product> productList =findAll();
        for (Product product : productList) {
            if (product.getId() == idProduct) {
                System.out.println(product);
                productList.remove(product);
                CSVUtils.writeToFile(PATHPRODUCT, productList);
                return;
            }
        }
    }

    @Override
    public Product sortQuantityASC() {
        List<Product> productList = findAll();
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = (o1.getPrice() - o2.getPrice());
                if (result == 0)
                    return 0;
                return (o1.getPrice() - o2.getPrice()) > 0 ? 1 : -1;
            }
        });
        CSVUtils.writeToFile(PATHPRODUCT, productList);
        return null;
    }

    @Override
    public Product sortQuantityDESC() {
        List<Product> productList = findAll();
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                double result = (o2.getPrice() - o1.getPrice());
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });
        CSVUtils.writeToFile(PATHPRODUCT, productList);
        return null;
    }

    @Override
    public void updateQuantity(long id, int quantity) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getId() == id) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    CSVUtils.writeToFile(PATHPRODUCT, productList);
                    break;
                }
            }
        }
    }
}
