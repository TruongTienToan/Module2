package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

    public class Bai93 {
        public static void main(String[] args) {
            int num;
            int flag = 0;
            int i = 1;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào 1 số để kiểm tra: ");
            num = scanner.nextInt();
            if (num < 2) {
                System.out.println(num + " Không phải là số nguyên tố");
            } else {
                while (i <= num) {
                    if (num % i == 0) {
                        flag += 1;
                    }
                    i++;
                }
                if (flag == 2) {
                    System.out.println(num + " là số nguyên tố");
                } else {
                    System.out.println(num + " không phải là số nguyên tố");
                }
            }
        }
    }

