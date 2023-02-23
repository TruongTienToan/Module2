package BaiTapAnhQuang.CacCauTrucDieuKhien;

import java.util.Scanner;

public class Bai85 {
    public static void main(String[] args) {
        int month;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vaào tháng của 1 năm: ");
        month = scanner.nextInt();
        if( month == 1 || month == 2 || month == 3) {
            System.out.println("Tháng" + month + "Thuộc quý 1 trong năm");
        } else if (month == 4 || month == 5 || month == 6) {
            System.out.println("Tháng " + month + " Thuộc quý 2 trong năm");
        } else if (month == 7 || month == 8 || month == 9) {
            System.out.println("Tháng " + month + " Thuộc quý 3 trong năm");
        } else if (month == 10 || month == 11 || month == 12) {
            System.out.println("Tháng " + month + " Thuôc quý 4 trong năm");
        } else {
            System.out.println("Vui lòng nhập 1 tháng trong năm (1 - 12)");
        }
    }
}
