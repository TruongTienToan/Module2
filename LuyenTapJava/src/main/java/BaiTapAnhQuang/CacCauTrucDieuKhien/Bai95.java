package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai95 {
    public static void main(String[] args) {
        float a, b , c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a: ");
        a = scanner.nextInt();
        System.out.println("Nhập b: ");
        b = scanner.nextInt();
        System.out.println("Nhập c: ");
        c = scanner.nextInt();

        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (c < 0) {
            c = -c;
        }
        System.out.println("3 số sau khi thay đổi là: " + a + "," + b + "," + c);
    }
}
