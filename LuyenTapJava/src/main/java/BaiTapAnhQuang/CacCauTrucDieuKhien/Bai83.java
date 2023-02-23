package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai83 {
    public static void main(String[] args) {
        int num1, num2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số đầu tiên: ");
        num1 = scanner.nextInt();
        System.out.println("Nhập số thứ 2: ");
        num2 = scanner.nextInt();
        if (num1 * num2 > 0) {
            System.out.println("2 số có cùng dấu");
        } else {
            System.out.println("2 số khác dấu");
        }
    }
}
