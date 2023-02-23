package QuanLyThuVien;

import java.util.Scanner;

public class QuanLyThuVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyThuVien quanLyThuVien = new QuanLyThuVien();
        while (true) {
            System.out.println("Ứng dụng quản lý thư viện");
            System.out.println("1. Thêm mới tài liêu: Sách, tạp chí, báo.");
            System.out.println("2. Xoá tài liệu theo mã tài liệu");
            System.out.println("3. Hiện thị thông tin về tài liệu.");
            System.out.println("4. Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.");
            System.out.println("5. Thoát khỏi chương trình");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("1. Thêm sách");
                    System.out.println("2. Thêm báo");
                    System.out.println("3. Thêm tạp chí");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "1": {
                            System.out.print("Nhập mã tài liệu: ");
                            String id = scanner.nextLine();
                            System.out.print("Nhập nhà xuât bản: ");
                            String nxb = scanner.nextLine();
                            System.out.println("Nhập số bản phát hành: ");
                            int number = scanner.nextInt();
                            System.out.println("Nhập ten tác giả: ");
                            scanner.nextLine();
                            String author = scanner.nextLine();
                            System.out.println("Nhập số trang: ");
                            int pageNumber = scanner.nextInt();
                        }
                    }
                }
            }
        }
    }
}
