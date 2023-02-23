package BaiTapAnhQuang.TimKiemVaLietKe;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai177 {
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
        System.out.println("Nhap x: ");
        double startNumber = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap y: ");
        double endNumber = Double.parseDouble(scanner.nextLine());
        for(int i=0; i<array.size(); i++){
            if(array.get(i) >= startNumber && array.get(i) <= endNumber){
                System.out.println("Các số trong mảng thuộc đoạn [x,y] là: " + array.get(i));
            }
        }
    }
}
