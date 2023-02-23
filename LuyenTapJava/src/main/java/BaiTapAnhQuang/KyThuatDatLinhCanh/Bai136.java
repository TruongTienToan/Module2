package BaiTapAnhQuang.KyThuatDatLinhCanh;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai136 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        int numberInput = 0;
        ArrayList<Integer> array = new ArrayList<>();
        boolean flag = false;
        do {
            System.out.println("Nhập số lượng phần tử trong mảng: ");
            inputNumber = Integer.parseInt(scanner.nextLine());
            if (inputNumber < 0){
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        do {
            System.out.println("Nhập số phần tử mảng: ");
            numberInput = Integer.parseInt(scanner.nextLine());
            array.add(numberInput);
            if (array.size() == inputNumber) {
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);
        System.out.println("Mảng vừa nhập là: " + array);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                arrayList.add(array.get(i));
            }
        }
        if (arrayList.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println("Số chẵn cuối cùng trong mảng là: " + arrayList.get(arrayList.size() - 1));
        }
    }
}
