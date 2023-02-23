package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai89 {
    public static void main(String[] args) {
        int num, sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số n: ");
        num = scanner.nextInt();
        for (int i = 1; i < num; i += 2) {
            sum += i;
        }
        System.out.println("Tổng các số lẻ từ 1 đến" + num + "là: " + sum);
    }
}
