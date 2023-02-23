package BaiTapAnhQuang.CacCauTrucDieuKhien;

public class Bai94 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i+= 2) {
            if ( i == 5 || i == 7 || i == 93) {
                continue;
            }
            System.out.println(i);
        }
    }
}
