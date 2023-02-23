package Nhap_Xuat_Mang;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNumber = 0;
        double numberInput = 0;
        ArrayList<Double> array = new ArrayList<>();
        boolean flag = false;
        do {
            System.out.println("Nhập số lượng phần tử trong mảng: ");
            inputNumber = Double.parseDouble(scanner.nextLine());
            if (inputNumber < 0) {
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        do {
            System.out.println("Nhập phần tử trong mảng: ");
            numberInput = Double.parseDouble(scanner.nextLine());
            array.add(numberInput);
            if (array.size() == inputNumber) {
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);
        System.out.println("Mảng vừa nhập là: " + array);
        for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < 0) {
                    System.out.println("Vị trí các giá trị âm trong mảng là: " + i);
                }
        }
    }
}
