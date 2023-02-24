package org.example.service.file;

import org.example.model.Customer;
import org.example.model.Product;
import org.example.service.IProductService;
import org.example.utils.DateUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FProductService implements IProductService {
    private final String  pathProduct = "./data/product.csv";
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathProduct);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] items = line.split(",");
                Product product = new Product();
                product.setId(Long.parseLong(items[0]));
                product.setName(items[1]);
                product.setDescription(items[2]);
                product.setPrice(Double.parseDouble(items[3]));
                product.setCreateAt(DateUtils.parseDate(items[4]));
                products.add(product);
            }
            fileReader.close();
            bufferedReader.close();
            return products;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = getAllProducts();
        long lastId = 1;
        if(products.size()!=0){
            Product lastCustomer = products.get(products.size()-1);
            lastId = lastCustomer.getId()+1;
        }
        product.setId(lastId);

        products.add(product);

        try {
            FileWriter fileWriter = new FileWriter(pathProduct);
            for (int i = 0; i < products.size(); i++) {
                Product c = products.get(i);
                fileWriter.write(c.toString());
                if (i != products.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public void deleteProductById(long idProduct) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = getAllProducts();
        System.out.println("Nhập id khách hàng cần xóa: ");
        long id = Long.parseLong(scanner.nextLine());
        Product product = findProductById(id);
        if (product != null) {
            products.remove(product);
        }
        try {
            FileWriter fileWriter = new FileWriter(pathProduct);
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                fileWriter.write(p.toString());
                if (i != products.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public void updateProductById(long idProduct, Product product) {
        List<Product> products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                products.get(i).setName(product.getName());
                products.get(i).setDescription(product.getDescription());
                products.get(i).setPrice(product.getPrice());
                products.get(i).setCreateAt(product.getCreateAt());
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(pathProduct);
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                fileWriter.write(p.toString());
                if (i != products.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public Product findProductById(long idProduct) {
        List<Product> products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProduct) {
                return products.get(i);
            }
        }
        return null;
    }
}
