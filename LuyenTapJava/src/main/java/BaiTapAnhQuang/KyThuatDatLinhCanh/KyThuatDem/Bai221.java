package BaiTapAnhQuang.KyThuatDatLinhCanh.KyThuatDem;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai221 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        int numberInput = 0;
        ArrayList<Integer> array = new ArrayList<>();
        boolean flag = false;
        do {
            System.out.println("Nhập số lượng phần tử trong mảng: ");
            inputNumber = Integer.parseInt(scanner.nextLine());
            if (inputNumber <= 0) {
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        do {
            System.out.println("Nhập phần tử mảng: ");
            numberInput = Integer.parseInt(scanner.nextLine());
            array.add(numberInput);
            if (array.size() == inputNumber) {
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);
        System.out.println("Mảng vừa nhập là: " + array);
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                count++;
            }
        }
        if (count > array.size() - count) {
            System.out.println(-1);
        } else if (array.size() - count == count) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
