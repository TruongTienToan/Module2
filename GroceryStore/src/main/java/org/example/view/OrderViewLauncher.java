package org.example.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderViewLauncher {
    private final Scanner scanner = new Scanner(System.in);
    OrderView orderView = new OrderView();
    boolean is = false;
    public void launch() {
        int choice;
        do {
            menuOrder();
            try {
                System.out.println("\n Chọn chức năng: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        orderView.addOrder();
                        break;
                    case 2:
                        orderView.showListOrder();
                        break;
                    case 3:
                        MainLauncher.menuOption();
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng chức năng!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (!is);
    }


    public void menuOrder() {
        System.out.print("\t\t======================= ORDER MENU ========================" +
                "\n\t\t|                                                         |" +
                "\n\t\t|                                                         |" +
                "\n\t\t|                    1. Tạo Order                         |" +
                "\n\t\t|                    2. Xem danh sách order               |" +
                "\n\t\t|                    3. Quay lại                          |" +
                "\n\t\t|                                                         |" +
                "\n\t\t|                                                         |" +
                "\n\t\t===========================================================\n");
    }
}
