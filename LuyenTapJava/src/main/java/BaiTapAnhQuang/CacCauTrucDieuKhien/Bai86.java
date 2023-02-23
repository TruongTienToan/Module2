package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai86 {
    public static void main(String[] args) {
        int num, sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số n");
        num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            sum += i * i * i;
        }
        System.out.println("Tổng của biểu thức là: " + sum);
    }
}
