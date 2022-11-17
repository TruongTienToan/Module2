package org.example;

import java.util.Scanner;

public class LargestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hàng: ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập cột: ");
        int n = Integer.parseInt(scanner.nextLine());
        double[][] array = new double[m][n];
        double max = array[0][0];
        int mMax;
        int nMax;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhập số vào phần tử [" + i + "][" + j + "]");
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == max) {
                    mMax = i;
                    nMax = j;
                    System.out.println("Vậy số lớn nhất là " + max + " ở vị trí array[" + mMax + "][" + nMax + "]");
                }
            }
        }
    }
}