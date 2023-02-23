package BaiTapAnhQuang.MangMotChieu;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai125 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử trong mảng: ");
        int inputNumber = scanner.nextInt();
        ArrayList<Double> array = new ArrayList<>();
        for (int i = 1; i <= inputNumber; i++) {
            array.add(Math.floor(Math.random() * 100 + 30));
        }
        System.out.println("Mảng vừa nhập là: " + array);
        int count = 0;
        for (int i=0; i<array.size();i++) {
            for(int j=2; j<array.get(i); j++){
                if(array.get(i) ==2){
                    System.out.println(2);
                    break;
                }
                if(array.get(i)%j==0){
                    break;
                }else if(j==array.get(i)-1 && array.get(i) < 100){
                    System.out.println("Các số nguyên tố nhỏ hơn 100 trong mảng là: " + array.get(i));
                    count++;
                }
            }
        }
        System.out.println("Số lượng số nguyên tố nhỏ hơn 100 trong mảng là : "+count);

    }
}
