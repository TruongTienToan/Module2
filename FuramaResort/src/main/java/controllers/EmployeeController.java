package controllers;

import Services.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    Scanner scanner = new Scanner(System.in);
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    public void displayMenuOfEmployee() {
        int chooseUserFromCase1 = 0;
        do {
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Sửa thông tin nhân viên");
            System.out.println("5. Quay lại menu");
            try {
                chooseUserFromCase1 = Integer.parseInt(scanner.nextLine());
                switch (chooseUserFromCase1) {
                    case 1:
                        employeeService.display();
                        break;
                    case 2:
                        employeeService.add();
                        System.out.println("Thêm thành công!");
                        break;
                    case 3:
                        try {
                            employeeService.delete();
                        } catch (ClassNotFoundException e) {
                            System.err.println("Không thể tìm thấy nhân viên !!");
                        }
                        break;
                    case 4:
                        employeeService.edit();
                        System.out.println("Sửa thành công!");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Không có mục này !! Mời bạn chọn mục khác");
                        displayMenuOfEmployee();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng !! Mời bạn nhập lại");
                displayMenuOfEmployee();
            }
        } while (chooseUserFromCase1 > 0 && chooseUserFromCase1 < 5);
    }
}
