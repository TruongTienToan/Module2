package BaiTapAnhQuang.MangMotChieu;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai126 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        int numberInput = 0;
        ArrayList<Integer> array = new ArrayList<>();
        boolean flag = false;
        do {
            System.out.println("Nhập số phần tử trong mảng: ");
            inputNumber = Integer.parseInt(scanner.nextLine());
            if (inputNumber < 0){
                flag = true;
            }else{
                flag = false;
            }
        }while (flag);
        do{
            System.out.println("Nhập phần tử trong mảng: ");
            numberInput = Integer.parseInt(scanner.nextLine());
            array.add(numberInput);
            if(array.size() == inputNumber){
                flag = false;
            }else{
                flag = true;
            }
        }while (flag);
        System.out.println("Mảng vừa nhập là: " + array);
        double s = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                s = s + array.get(i);
            }
        }
        System.out.println("Tổng các số âm trong mảng là: " + s);
    }
}
