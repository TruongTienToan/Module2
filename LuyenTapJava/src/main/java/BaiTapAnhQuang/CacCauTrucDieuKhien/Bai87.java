package BaiTapAnhQuang.CacCauTrucDieuKhien;

public class Bai87 {
    public static void main(String[] args) {
        int num = 0 , sum = 0;
        while (sum < 10000) {
            num++;
            sum = sum + num;
        }
        System.out.println("Số nhỏ nhất để tổng từ nó đến 10000 là: " + num);
        System.out.println("Tổng các số từ 1 đến" + num + "là: " + sum);
    }
}
