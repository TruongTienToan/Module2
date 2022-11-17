package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " của mảng 1: ");
            arr1[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Mảng 1 là: " + Arrays.toString(arr1));
        System.out.println();

        int[] arr2 = new int[5];
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " của mảng 2: ");
            arr2[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Mảng 2 là: " + Arrays.toString(arr2));
        System.out.println();

        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (i == j) {
                    arr3[i] = arr1[i];
                }
            }
        }
        for (int i = arr1.length; i < arr3.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (i == j + arr1.length) {
                    arr3[i] = arr2[j];
                }
            }
        }
        System.out.println("Mảng vừa được gộp là: " + Arrays.toString(arr3));
    }
}