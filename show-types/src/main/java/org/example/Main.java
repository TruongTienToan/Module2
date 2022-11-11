package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1. Hiển thị hình chữ nhật");
            System.out.println("2. Hiển thị hình tam giác vuông");
            System.out.println("3. Hiển thị hình tam giác cân");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 1; i < 4; i++) {
                        for (int j = 1; j < 10; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    for (int i = 0; i <= 2; i++) {
                        for (int j = 0; j <= 4; j++) {
                            if (i == 0 && j == 2 || i == 1 && j == 1 || i == 1 && j == 2 || i == 1 && j == 3 ||
                            i == 2 && j >= 0){
                                System.out.print("*");
                            } else{
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                case 4:
                    System.exit(4);
                default:
                    System.out.println("Không có trong menu \n");
            }
        } while (choice > 4 || choice < 1);

    }
}