package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Nhập số phần tử của mảng: ");
            number = Integer.parseInt(scanner.nextLine());
            if (number < 0) {
                System.out.print("Số phần tử không hợp lệ: ");
            }
        } while (number < 0);

        int[] arr = new int[number];
        int j = 0;
        while (j < arr.length) {
            System.out.print("Nhập phần tử thứ " + (j + 1) + ": ");
            arr[j] = Integer.parseInt(scanner.nextLine());
            j++;
        }
        System.out.println("Mảng vừa nhập là: " + Arrays.toString(arr));
        int number1;
        System.out.print("Nhập phần tử cần xoá khỏi mảng: ");
        number1 = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (number1 == arr[i]) {
                check = true;
                for (int x = i; x < arr.length - 1; x++) {
                    arr[x] = arr[x + 1];
                    arr[x + 1] = 0;
                }
                i--;
            }
        }
        if (!check) {
            System.out.print("Số vừa nhập không thoả mãn là phần tử của mảng " +
                    "");
        } else {
            System.out.println("Mảng vừa xoá phần tử là: " + Arrays.toString(arr));
        }
    }
}