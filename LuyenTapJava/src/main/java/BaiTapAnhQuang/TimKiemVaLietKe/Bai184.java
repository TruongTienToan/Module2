package BaiTapAnhQuang.TimKiemVaLietKe;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai184 {
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
        for (int i = 0; i < array.size(); i++) {
            for(int j=2; j <= array.get(i); j++){
                if (array.get(i) == 2) {
                    System.out.println("Các vị trí có giá trị là số nguyên tố: " + i);
                }
                if(array.get(i) % j == 0){
                    break;
                }else if(j==array.get(i)-1){
                    System.out.println("Các vị trí có giá trị là số nguyên tố: " + i);
                }
            }
        }
    }
}
