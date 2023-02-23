package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai92 {
    public static void main(String[] args) {
        int a, b;
        int ucln = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số nguyên dương a: ");
        a = scanner.nextInt();;
        System.out.println("Nhập số nguyên dương b: ");
        b = scanner.nextInt();

        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 &&b % i == 0)
                ucln = i;
        }
        System.out.println("Ước chung lớn nhất của a và b là : " + ucln);
    }
}
