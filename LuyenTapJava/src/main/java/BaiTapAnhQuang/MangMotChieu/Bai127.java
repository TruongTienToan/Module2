package BaiTapAnhQuang.MangMotChieu;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai127 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        int numberInput = 0;
        ArrayList<Integer> array = new ArrayList<>();
        boolean flag = false;
        do {
            System.out.println("Nhập số phần tử trong mảng: ");
            inputNumber = Integer.parseInt(scanner.nextLine());
            if (inputNumber < 0) {
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        do {
            System.out.println("Nhập phần tử trong mảng: ");
            numberInput = Integer.parseInt(scanner.nextLine());
            array.add(numberInput);
            if (array.size() == inputNumber) {
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);
        System.out.println("Mảng vừa nhập là: " + array);
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i) > array.get(j)) {
                    int temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }
        }
//        for (int i = 0; i < array.size()-1; i++) {
//            if(array.get(i) > array.get(i+1)){
//                int temp = array.get(i);
//                array.set(i, array.get(i+1));
//                array.set(i+1, temp);
//            }
//        }
        System.out.println("Mảng sau khi sắp xếp thành tăng dần là: " + array);
    }
}
