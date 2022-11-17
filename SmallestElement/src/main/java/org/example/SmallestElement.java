package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập độ dài mảng: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size <= 0) {
                System.out.println("Độ dài mảng không hợp lệ, vui lòng nhập lại: ");
            }
        } while (size < 0);

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ":\t");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng vừa nhập là: " + Arrays.toString(arr));
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất là: " + min);
    }
}
