package controllers;

import Services.CustomerServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    CustomerServiceImpl  customerService = new CustomerServiceImpl();
    public void displayMenuOfCustomer() {
        int chooseUserFromCase2 = 0;
        do {
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Sửa thông tin khách hàng");
            System.out.println("4. Quay lại menu");
            try {
                chooseUserFromCase2 = Integer.parseInt(scanner.nextLine());
                switch (chooseUserFromCase2) {
                    case 1:
                        customerService.display();
                        break;
                    case 2:
                        customerService.add();
                        System.out.println("Thêm thành công!");
                    case 3:
                        customerService.edit();
                        System.out.println("Sửa thành công!");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Không có mục này ! Mời bạn chọn lại");
                        displayMenuOfCustomer();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng ! Mời bạn nhập lại");
                displayMenuOfCustomer();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (chooseUserFromCase2 > 0 && chooseUserFromCase2 < 4);
    }
}
