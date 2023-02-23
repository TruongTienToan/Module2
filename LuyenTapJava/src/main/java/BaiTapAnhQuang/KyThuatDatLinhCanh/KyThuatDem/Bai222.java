package BaiTapAnhQuang.KyThuatDatLinhCanh.KyThuatDem;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai222 {
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
            if (i == 0 && array.get(i) != array.get(i + 1)) {
                count++;
            } else if (i == array.size() - 1 && array.get(i - 1) != array.get(i)) {
                count++;
            } else if (array.get(i - 1) > array.get(i) && array.get(i) < array.get(i + 1) || array.get(i - 1) < array.get(i) && array.get(i) > array.get(i+1)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
