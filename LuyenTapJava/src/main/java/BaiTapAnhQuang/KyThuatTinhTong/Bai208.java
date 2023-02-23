package BaiTapAnhQuang.KyThuatTinhTong;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai208 {
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
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            double temp = Math.sqrt(array.get(i));
//            if (temp * temp == array.get(i)) {
//                System.out.println("Các giá trị chính phương trong mảng là: " + array.get(i));
//                sum += array.get(i);
//            }
            if (temp - Math.floor(temp)==0){
                System.out.println("Các giá trị chính phương trong mảng là: " + array.get(i));
                sum+=array.get(i);
            }
        }
        System.out.println("Tổng các số chính phương trong mảng là: " + sum);
    }
}
