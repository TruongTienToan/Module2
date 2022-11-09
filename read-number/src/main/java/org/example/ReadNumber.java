package org.example;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số cần chuyển: ");
        int number = scanner.nextInt();
        String[] string =
                {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] string2 =
                {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        while (number >= 1000) {
            System.out.println("Nhập lại số nhỏ hơn 1000: ");
            number = scanner.nextInt();
        }
        if (number == 0) {
            System.out.println("Zero");
        } else {
            switch (number / 100) {
                case 1:
                    System.out.println("One hundred ");
                    break;
                case 2:
                    System.out.println("Two hundred ");
                    break;
                case 3:
                    System.out.println("Three hundred ");
                    break;
                case 4:
                    System.out.println("Four hundred ");
                    break;
                case 5:
                    System.out.println("Five hundred ");
                    break;
                case 6:
                    System.out.println("Six hundred ");
                    break;
                case 7:
                    System.out.println("Seven hundred ");
                    break;
                case 8:
                    System.out.println("Eight hundred ");
                    break;
                case 9:
                    System.out.println("Nine hundred ");
                    break;
                default:
                    System.out.println("");
            }
            switch ((number % 100) / 10) {
                case 0:
                    System.out.println("");
                    break;
                case 1:
                    for (int i = 0; i < string2.length; i++) {
                        if (number % 10 == i) {
                            System.out.println(string2[i]);
                        }
                    }
                    break;
                case 2:
                    System.out.print("twenty ");
                    break;
                case 3:
                    System.out.print("Thirty ");
                    break;
                case 4:
                    System.out.print("Forty ");
                    break;
                case 5:
                    System.out.print("Fifty ");
                    break;
                case 6:
                    System.out.print("Sixty ");
                    break;
                case 7:
                    break;
                case 8:
                    System.out.print("Eighty ");
                    break;
                case 9:
                    System.out.print("Ninety ");
                    break;
            }
            if ((number % 100) / 10 != 1) {
                for (int i = 1; i <= string.length; i++) {
                    if (number % 10 == i) {
                        System.out.println(string[i - 1]);
                    }
                }
            }
        }
    }
}