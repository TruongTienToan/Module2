package org.example.view;

import java.util.Scanner;

public class UserMenuView {
    public static void launch() {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        int option = -1;
        do {
            menuUser();
            try {
                do {
                    System.out.println("Chọn chức năng: ");
                    option = Integer.parseInt(scanner.nextLine());
                    if (option > 5 || option < 1)
                        System.out.println("Chọn chức năng không đúng! Vui lòng nhập lại: ");
                } while (option > 5 || option < 1);
                switch (option) {
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.updateUser();
                        break;
                    case 3:
                        userView.showUsers(InputOption.SHOW);
                        break;
                    case 4:
                        userView.deleteUser(InputOption.DELETE);
                        break;
                    case 5:
                        MainLauncher.menuOption();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng nhập lại!!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại!");
            }
        } while (option != 5);
    }
    public static void menuUser() {
        System.out.println("\t ============ QUẢN LÍ NGƯỜI DÙNG ============");
        System.out.println("\t |                                          |");
        System.out.println("\t |      1. Thêm người dùng                  |");
        System.out.println("\t |      2. Sửa thông tin người dùng         |");
        System.out.println("\t |      3. Hiển thị danh sách người dùng    |");
        System.out.println("\t |      4. Xóa người dùng                   |");
        System.out.println("\t |      5. Quay lại                         |");
        System.out.println("\t |                                          |");
        System.out.println("\t ============================================");
    }
}

