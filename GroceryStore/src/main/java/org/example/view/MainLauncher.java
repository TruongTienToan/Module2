package org.example.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLauncher {
    private static ProductView productView = new ProductView();
    private static Scanner scanner = new Scanner(System.in);

    public static void launch() {
        AdminView adminView = new AdminView();
        adminView.adminLogin();
        menuOption();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                System.out.println("Vui lòng chọn chức năng: ");
                int number = Integer.parseInt(scanner.nextLine());
                switch (number) {
                    case 1:
                        UserMenuView.launch();
                        break;
                    case 2:
                        productView.launch();
                        break;
                    case 3:
                        OrderViewLauncher orderViewLauncher = new OrderViewLauncher();
                        orderViewLauncher.launch();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại!");
                        menuOption();
                }
            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (true);
    }

    public static void mainMenu() {
        System.out.println("\n\t ============== MAIN MENU ================");
        System.out.println("\t |                                       |");
        System.out.println("\t |        1. Quản lí người dùng          |");
        System.out.println("\t |        2. Quản lí cửa hàng            |");
        System.out.println("\t |        3. Quản lí đơn đặt hàng        |");
        System.out.println("\t |        4. Thoát chương trình          |");
        System.out.println("\t |                                       |");
        System.out.println("\t =========================================");
    }
}
