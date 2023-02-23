package BaiTapAnhQuang.MangMotChieu;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai124 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử trong mảng: ");
        int inputNumber = scanner.nextInt();
        ArrayList<Double> array = new ArrayList<>();
        for (int i = 1; i <= inputNumber; i++) {
            array.add(Math.floor(Math.random() * 3000 + 1000));
        }
        System.out.println(array);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 2004 && array.get(i) % 2 == 0) {
                System.out.println("Các số chẵn nhỏ hơn 2004 trong mảng là: " + array.get(i));
            }
        }
    }
}
