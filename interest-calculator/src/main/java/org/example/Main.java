package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double money = 0;
        int month = 1;
        double interset_rate = 1.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền đầu tư: ");
        money = scanner.nextDouble();
        System.out.println("Nhập số tháng:");
        month = scanner.nextInt();
        System.out.println("Nhập lãi suất hàng năm: ");
        interset_rate = scanner.nextDouble();
        double total_interset = 0;
        for (int i = 0; i < month; i ++) {
            total_interset = money * (interset_rate/100/12) * 3;
        }
        System.out.println("Tổng số tiền lãi: " + total_interset);
    }
}