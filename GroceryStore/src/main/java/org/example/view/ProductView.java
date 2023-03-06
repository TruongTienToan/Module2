package org.example.view;

import org.example.model.Product;
import org.example.service.IProductService;
import org.example.service.impl.ProductService;
import org.example.utils.AppUtils;
import org.example.utils.InstantUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private final Scanner scanner = new Scanner(System.in);
    private final IProductService productService;

    public ProductView() {
        this.productService = new ProductService();
    }


    public void showProduct() {
        System.out.println("\t=========================================================== DANH SÁCH SẢN PHẨM ========================================================================");
        System.out.printf("\t│\t\t%-6s   ││        %-15s   ││       %-15s   ││   %12s      ││       %-13s    ││    %16s       │\n", "ID", "Tên sản phẩm", "Giá sản phẩm", "Số lượng", "Ngày tạo", "Ngày cập nhật");
        System.out.println("\t=======================================================================================================================================================");
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.printf("\t│\t%-10s   ││   %-20s   ││    %15s      ││     %12s    ││    %-15s    ││    %19s    │\n",
                    product.getId(),
                    product.getTitle(),
                    InstantUtils.doubleToVND(product.getPrice()),
                    InstantUtils.quantityProducts(product.getQuantity()),
                    InstantUtils.instantToString(product.getCreateAt()),
                    product.getUpdateAt() == null ? "" : InstantUtils.instantToString(product.getUpdateAt())
            );
        }
        System.out.println("\t=======================================================================================================================================================\n");
    }

    public void addProduct() {
        do {
            try {
                long id = System.currentTimeMillis() / 1000;
                String productName = inputProductName();
                double productPrice = inputPrice();
                int productQuantity = inputQuantity();
                Product newProduct = new Product(id, productName, productPrice, productQuantity);
                productService.add(newProduct);
                System.out.println("Thêm sản phẩm thành công!");
                showProduct();
            } catch (Exception e) {
                System.err.println("Nhập sai, vui lòng nhập lại.");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void updateProduct() {
        boolean isRetry = false;
        do {
            try {
                showProduct();
                System.out.print("Nhập id bạn muốn tìm kiếm: ");
                long id = inputId();
                System.out.println("=============Sửa=============");
                System.out.println("|                           |");
                System.out.println("|    1. Sửa tên sản phẩm    |");
                System.out.println("|    2. Sửa giá sản phẩm    |");
                System.out.println("|    3. Sửa số lượng        |");
                System.out.println("|    4. Quay lại menu       |");
                System.out.println("|                           |");
                System.out.println("=============================");
                int option = AppUtils.retryChoose(1,4);
                Product newProduct = new Product();
                newProduct.setId(id);
                switch (option) {
                    case 1:
                        String productName = inputProductName();
                        newProduct.setTitle(productName);
                        productService.update(newProduct);
                        System.out.println("Sửa tên sản phẩm thành công!");
                        showProduct();
                        break;
                    case 2:
                        double price = inputPrice();
                        newProduct.setPrice(price);
                        productService.update(newProduct);
                        System.out.println("Sửa giá sản phẩm thành công!");
                        showProduct();
                        break;
                    case 3:
                        int quantity = inputQuantity();
                        newProduct.setQuantity(quantity);
                        productService.update(newProduct);
                        System.out.println("Sửa số lượng sản phẩm thành công!");
                        showProduct();
                        break;
                }
                isRetry = option != 4 && AppUtils.isRetry(InputOption.UPDATE);
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (isRetry);
    }

    public void removeProduct() {
        showProduct();
        System.out.println("Nhập id bạn muốn xóa: ");
        int idProduct = inputId();
        productService.remove(idProduct);
        System.out.println("Xóa sản phẩm thành công!");
        showProduct();
    }

    public void searchProductByTitle() {
        try {
            showProduct();
            System.out.println("Nhập tên sản phẩm: ");
            String title = scanner.nextLine();
            while (title.trim().equals("")) {
                System.out.println("Tên sản phẩm không được để trống: ");
                title = scanner.nextLine();
            }
            productService.searchByName(title.toLowerCase());
        } catch (Exception e) {
            System.out.println("Nhập sai! Vui lòng nhập lại");
        }
    }
    

    public void searchProductById() {
        try {
            showProduct();
            System.out.println("Nhập id của sản phẩm: ");
            long id = inputId();
            productService.searchById(id);
        } catch (Exception e) {
            System.out.println("Nhập sai! Vui lòng nhập lại");
        }
    }

    //sắp xếp tăng dần
    public void sortQuantityASC() {
        productService.sortQuantityASC();
        System.out.println("Sản phẩm đã được sắp xếp theo giá tăng dần!");
        showProduct();
    }

    //sắp xếp giảm dần
    public void sortQuantityDESC() {
        productService.sortQuantityDESC();
        System.out.println("Sản phẩm đã được sắp xếp theo giá giảm dần");
        showProduct();
    }

    public void launch() {
        int choice;
        do {
            System.out.print("\t\t===============================================================================================" +
                    "\n\t\t|                                                                                             |" +
                    "\n\t\t|                                        BÁCH HÓA XANH                                        |" +
                    "\n\t\t|                                          Main Menu                                          |" +
                    "\n\t\t|                                                                                             |" +
                    "\n\t\t|                                  1. Hiển thị danh sách sản phẩm.                            |" +
                    "\n\t\t|                                  2. Thêm sản phẩm.                                          |" +
                    "\n\t\t|                                  3. Sửa sản phẩm.                                           |" +
                    "\n\t\t|                                  4. Xóa sản phẩm.                                           |" +
                    "\n\t\t|                                  5. Tìm sản phẩm theo tên.                                  |" +
                    "\n\t\t|                                  6. Tìm sản phẩm theo ID                                    |" +
                    "\n\t\t|                                  7. Sắp xếp giá tăng dần.                                   |" +
                    "\n\t\t|                                  8. Sắp xếp giá giảm dần.                                   |" +
                    "\n\t\t|                                  9. Quay lại.                                               |" +
                    "\n\t\t|                                                                                             |" +
                    "\n\t\t===============================================================================================\n" +
                    "\n\t\tChọn chức năng mà bạn muốn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        showProduct();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        removeProduct();
                        break;
                    case 5:
                        searchProductByTitle();
                        break;
                    case 6:
                        searchProductById();
                        break;
                    case 7:
                        sortQuantityASC();
                        break;
                    case 8:
                        sortQuantityDESC();
                        break;
                    case 9:
                        MainLauncher.menuOption();
                        break;
                }
            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (true);
    }

    //Kiem tra ten, gia, so luong sp
    public String inputProductName() {
        System.out.println("Nhập tên sản phẩm: ");
        String nameProduct = scanner.nextLine();
        while (nameProduct.trim().equals("")) {
            System.out.println("Tên sản phẩm không được để trống:");
            nameProduct = scanner.nextLine();
        }
        return nameProduct;
    }

    public int inputQuantity() {
        do {
            try {
                System.out.println("Nhập số lượng sản phẩm: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) {
                    System.out.println("Nhập không đúng! Vui lòng nhập lại (số lượng sp không được âm)");
                    quantity = Integer.parseInt(scanner.nextLine());
                    continue;
                } else if (quantity > 5000) {
                    System.out.println("Nhập không đúng! Vui lòng nhập lại: (số lượng sp không được vượt quá 5000)");
                    quantity = Integer.parseInt(scanner.nextLine());
                }
                return quantity;
            } catch (Exception e) {
                System.err.println("Nhập sai vui lòng nhập lại");
            }
        }
        while (true);
    }

    public double inputPrice() {
        do {
            try {
                System.out.println("Nhập giá sản phẩm (Vidu: 10.000)");
                double price = Double.parseDouble(scanner.nextLine());
                if ((price < 0 || price % 1000 != 0) || price > 1000000) {
                    System.out.println("Nhập không đúng! Vui lòng nhập lại: (Giá phải bé hơn 1.000.000)");
                    price = Double.parseDouble(scanner.nextLine());
                    continue;
                }
                return price;
            } catch (Exception e) {
                System.err.println("Nhập sai! Vui lòng nhập lại");
            }
        }
        while (true);
    }

    public int inputId() {
        boolean isRetry = false;
        int id;
        do {
            id = Integer.parseInt(scanner.nextLine());
            boolean exist = productService.existById(id);
            if (!exist) {
                System.out.println("ID này không tồn tại ! Vui lòng nhập lại");
                isRetry = !exist;
            }
            if (exist) {
                return id;
            }
        } while (isRetry);
        return id;
    }
}
