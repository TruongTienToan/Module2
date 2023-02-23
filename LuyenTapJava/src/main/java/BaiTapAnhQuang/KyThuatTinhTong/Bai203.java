package BaiTapAnhQuang.KyThuatTinhTong;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai203 {
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
            String [] s = Integer.toString(array.get(i)).split("");
            if (s.length>=2){
                int number = Integer.parseInt(s[s.length -2]);
                if (number == 5) {
                    count += array.get(i);
                }
            }
        }
        System.out.println("Tổng các chữ số có hàng chục là 5 bằng: " + count);
    }
}
