package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai90 {
    public static void main(String[] args) {
        int n, m = 0, sum = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập vào số nguyên n: ");
            n = scanner.nextInt();
        } while (n < 0);

        while ((sum + m) < n) {
            sum += ++m;
            System.out.print(m);
            if ((sum + m) < n) {
                System.out.print(" + ");
            }
        }
        if (sum > 0) {
            System.out.println(" = " + sum + " <= " + n);
        }
        System.out.println("số m lớn nhất = " + m);
    }
}
