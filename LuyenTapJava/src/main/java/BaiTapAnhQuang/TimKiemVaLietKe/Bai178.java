package BaiTapAnhQuang.TimKiemVaLietKe;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai178 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        int numberInput = 0;
        ArrayList<Integer> array = new ArrayList<>();
        boolean flag = false;
        do {
            System.out.println("Nhập số lượng phần tử trong mảng: ");
            inputNumber = Integer.parseInt(scanner.nextLine());
            if (inputNumber < 0) {
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
        System.out.println("Nhập x: ");
        int startNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập y: ");
        int endNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                if (array.get(i) >= startNumber && array.get(i) <= endNumber) {
                    System.out.println("Các số chẵn trong mảng thuộc đoạn [x,y] là: " + array.get(i));
                }
            }
        }
    }
}
