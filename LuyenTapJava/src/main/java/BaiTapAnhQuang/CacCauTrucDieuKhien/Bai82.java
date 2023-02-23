package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai82 {
        public static void main(String[] args) {
            int num1, num2, num3;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào so thứ nhât");
            num1 = scanner.nextInt();
            System.out.println("Nhap vao so thu hai");
            num2 = scanner.nextInt();
            System.out.println("Nhap vao so thu ba");
            num3 = scanner.nextInt();
            if (num1 > num2 && num1 > num3) {
                System.out.println(num1 + "La so lon nhat");
            } else if (num2 > num1 && num2 > num3) {
                System.out.println(num2 + "La so lon nhat");
            } else {
                System.out.println(num3 + "La so lon nhat");
            }
        }
    }


