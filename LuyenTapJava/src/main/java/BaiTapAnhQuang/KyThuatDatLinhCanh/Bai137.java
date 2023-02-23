package BaiTapAnhQuang.KyThuatDatLinhCanh;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Bai137 {
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
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            arrayList.add(array.get(i));
        }
        for (int j = 0; j < arrayList.size() - 1; j++) {
            for (int y = j + 1; y < arrayList.size(); y++) {
                if (arrayList.get(j) > arrayList.get(y)) {
                    double temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(y));
                    arrayList.set(y, temp);
                }

            }
        }
        for (int a = 0; a < array.size(); a++) {
            if (Objects.equals(array.get(a), arrayList.get(0))){
                System.out.println("Vị trí có giá trị nhỏ nhất trong mảng là: " + a);
            }
        }
    }
}
