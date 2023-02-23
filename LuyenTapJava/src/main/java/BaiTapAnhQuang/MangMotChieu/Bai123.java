package BaiTapAnhQuang.MangMotChieu;

import java.util.Scanner;

public class Bai123 {
    public static void main(String[] args) {
        int[] arr = {6,2,3,4,5};
        int length = 0;
        int min  = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (min > arr[i]) {
                min = arr[i];
                length = i;
            }
        }
        System.out.println("Phần tử nhỏ nhâất của mảng là: " + min + " vị trí: " + length);
    }
}