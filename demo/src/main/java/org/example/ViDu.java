package org.example;

import java.util.Scanner;

public class ViDu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        try {
            System.out.println("Nhập vào số nguyên n: ");
            n = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Nhập dữ liệu ko đúng");
        } finally {
            System.out.println("Finally!");
        }

        System.out.println("Giá trị nhập vào là: " + n);
        System.out.println("Kết thúc chương trình");
    }
}
