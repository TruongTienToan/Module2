package BaiTapAnhQuang.KyThuatTinhTong;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai206 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNumber = 0;
        double numberInput = 0;
        ArrayList<Double> array = new ArrayList<>();
        boolean flag = false;
        do {
            System.out.println("Nhập số lượng phần tử trong mảng: ");
            inputNumber = Double.parseDouble(scanner.nextLine());
            if (inputNumber <= 0) {
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        do {
            System.out.println("Nhập phần tử mảng: ");
            numberInput = Double.parseDouble(scanner.nextLine());
            array.add(numberInput);
            if (array.size() == inputNumber) {
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);
        System.out.println("Mảng vừa nhập là: " + array);
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (i == 0 && array.get(i) > array.get(i + 1)) {
                sum += array.get(i);
            } else if (i != 0 && i!=array.size()-1 && array.get(i) > array.get(i + 1) && array.get(i) > array.get(i - 1)){
                sum += array.get(i);
            } else if (i == array.size() - 1 && array.get(i) > array.get(i - 1)) {
                sum += array.get(i);
            }
        }
        System.out.println("Sum: " + sum);
    }
}
