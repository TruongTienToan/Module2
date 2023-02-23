package BaiTapAnhQuang.MangMotChieu;

public class Bai122 {
    public static void main(String[] args) {
        int[] numArr = {1, 2, 3, 4, 5};
        int max = numArr[0];
        System.out.println("Các phần tử trong mảng là: ");
        for (int i : numArr) {
            System.out.println(i + ", ");
        }
        for (int num : numArr) {
            if (max < num) {
                max = num;
            }
        }
        System.out.println("Số lớn nhất trong mảng là: " + max);
    }
}
