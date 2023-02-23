package BaiTapAnhQuang.KyThuatTinhTong;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai211 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int countsnt =0;
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
            if (array.size() == inputNumber){
                flag = false;
            } else {
                flag = true;
            }
        } while (flag);

        System.out.println("Mảng vừa nhập là: " + array);

        for (int i = 0; i <array.size(); i++){
            int count =0;
            if (array.get(i)<2){
                continue;
            }
            for (int j = 2; j < array.get(i); j++) {
                if (array.get(i) % j == 0) {
                    count++;
                }
            }
            if (count==0){
                sum+=array.get(i);
                countsnt++;
            }
        }
        System.out.println(sum);
    }
}
