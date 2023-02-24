package org.example.view;

import org.example.comparator.ComparatorByPrice;
import org.example.model.Customer;
import org.example.model.Product;
import org.example.service.IProductService;
import org.example.service.file.FProductService;
import org.example.service.implement.ProductServiceImpl;
import org.example.utils.DateUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    private IProductService productService;



    public void launcher() {
        boolean checkActionMenu = false;
        do {
            System.out.println("Menu quản lý sản phẩm");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Cập nhật sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá");
            System.out.println("6. Sắp xếp sản phẩm theo tên");         // bài 1
            System.out.println("7. Tìm kiếm sản phẩm theo tên");
            System.out.println("8. Tìm kiếm sản phẩm theo khoảng giá");     // bài 2
            System.out.println("9. Tìm kiếm sản phẩm theo tên hoặc giá hoặc theo mô tả");   // bài 3
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showProductsView();
                    break;
                case 2:
                    addProductView();
                    break;
                case 3:
                    deleteProductView();
                    break;
                case 4:
                    updateProductView();
                    break;
                case 5:
                    sortProductByPriceView();
                    break;
                case 6:
                    sortProductByNameView();
                    break;
                case 7:
                    searchProductByNameView();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    checkActionMenu = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                checkActionMenuContinue = false;
                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
                String actionMenuContinue = scanner.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        break;
                    case "N":
                        checkActionMenu = false;
                        break;
                    default:
                        System.out.println("Nhập không không đúng vui lòng nhập lai");
                        checkActionMenuContinue = true;

                }
            }while (checkActionMenuContinue);

        } while (checkActionMenu);
    }

    private void updateProductView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập id san pham cần sửa: ");
        long id = Long.parseLong(scanner.nextLine());
        Product product = productService.findProductById(id);

        System.out.println("Nhập tên san pham mới: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            product.setName(name);
        }

        System.out.println("Nhập mo ta san pham: ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            product.setDescription(description);
        }

        System.out.println("Nhập gia moi: ");
        double price = Double.parseDouble(scanner.nextLine());
        product.setPrice(price);

        System.out.println("Nhap ngay sua: ");
        String createAt = scanner.nextLine();
        if (!createAt.isEmpty()) {
            product.setDescription(createAt);
        }

        productService.updateProductById(product.getId(), product);
        System.out.println("Thông tin san pham đã được caập nhật vào file");
        showProductsView();
    }

    private void addProductView() {
        Product product = new Product();
        System.out.println("Nhap thong tin san pham");
        System.out.println("Nhap ten san pham: ");
        String name = scanner.nextLine();
        System.out.println("Nhap mo ta san pham: ");
        String description = scanner.nextLine();
        System.out.println("Nhap gia san pham: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap ngay tao: ");
        String createAt = scanner.nextLine();

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCreateAt(DateUtils.parseDate(createAt));

        productService.addProduct(product);
        System.out.println("Thêm san pham thành công!");
        showProductsView();
    }

    public ProductView() {
        productService = new FProductService();
    }
    public void showProductsView() {
        List<Product> products = productService.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }
    public void showResultProductsView(List<Product> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
    public void deleteProductView() {
        Product product = new Product();
        productService.deleteProductById(product.getId());
        System.out.println("Xoas san pham thanh cong!");
        showProductsView();
    }

    public void sortProductByPriceView() {
        System.out.println("Sắp xếp sản phẩm theo giá");
        Comparator comparator = new ComparatorByPrice();

        List<Product> productSorts = productService.getAllProducts();
        productSorts.sort(comparator);
        showResultProductsView(productSorts);
    }

    public void searchProductByNameView() {
        System.out.println("Tìm kiếm theo tên: ");
        String nameSearch = scanner.nextLine();

        List<Product> products = productService.getAllProducts();
        List<Product> results = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(nameSearch)) {
                results.add(products.get(i));
            }
        }
        if (results.size() == 0) {
            System.out.println("Sorry bạn! Tui không tìm thấy sản phẩm nào");
        }
        showResultProductsView(results);
    }

    public void sortProductByNameView() {
        System.out.println("Sắp xếp sản phẩm theo tên");
        /**
         Comparator comparatorByName = new ComparatorByName();
         products.sort(comparatorByName);
         // Cách dùng lớp nặc danh: anonymous class
         Comparator comparatorByName1 = new Comparator<Product>(){
        @Override
        public int compare(Product o1, Product o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) {
        return 1;
        } else if (o1.getName().compareTo(o2.getName())==0) {
        return 0;
        }else{
        return -1;
        }
        }
        };
         products.sort(comparatorByName1);
         **/



        List<Product> productSortNames  = productService.getAllProducts();
        productSortNames.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getName().compareTo(o2.getName()) > 0) {
                    return 1;
                } else if (o1.getName().compareTo(o2.getName())==0) {
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        showResultProductsView(productSortNames);
    }
}
