package BaiTapQuanLyOOP.Bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyCanBo quanLyCanBo = new QuanLyCanBo();
        while (true) {
            System.out.println("Ứng dụng quản lý cán bộ");
            System.out.println("Enter 1: Thêm cán bộ");
            System.out.println("Enter 2: Tìm kiếm cán bộ theo tên: ");
            System.out.println("Enter 3: Hiển thị danh sách cán bộ");
            System.out.println("Enter 4: Thoát chương trình:");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Enter a: thêm Kỹ sư");
                    System.out.println("Enter b: thêm Công nhân");
                    System.out.println("Enter c: thêm Nhân viên");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.print("Nhập họ tên: ");
                            String name = scanner.nextLine();
                            System.out.print("Nhập tuổi:");
                            int age = scanner.nextInt();
                            System.out.print("Nhâp giới tính: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Nhập địa chỉ: ");
                            String address = scanner.nextLine();
                            System.out.print("Nhập nghành: ");
                            String branch = scanner.nextLine();
                            CanBo kysu = new KySu(name, age, gender, address, branch);
                            quanLyCanBo.addCanBo(kysu);
                            System.out.println(kysu.toString());
                            break;

                        }
                        case "b": {
                            System.out.print("Nhập họ tên: ");
                            String name = scanner.nextLine();
                            System.out.print("Nhập tuổi:");
                            int age = scanner.nextInt();
                            System.out.print("Nhập giới tính: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Nhập địa chỉ: ");
                            String address = scanner.nextLine();
                            System.out.print("Nhập bậc: ");
                            int rank = scanner.nextInt();
                            CanBo congnhan = new CongNhan(name, age, gender, address, rank);
                            quanLyCanBo.addCanBo(congnhan);
                            System.out.println(congnhan.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "c": {
                            System.out.print("Nhập họ tên: ");
                            String name = scanner.nextLine();
                            System.out.print("Nhập tuổi: ");
                            int age = scanner.nextInt();
                            System.out.print("Nhập giới tính: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Nhập địa chỉ: ");
                            String address = scanner.nextLine();
                            System.out.print("Nhập công việc: ");
                            String task = scanner.nextLine();
                            CanBo nhanvien = new NhanVien(name, age, gender, address, task);
                            quanLyCanBo.addCanBo(nhanvien);
                            System.out.println(nhanvien.toString());
                            break;
                        }
                        default:
                            System.out.println("Không hợp lệ.");
                            break;
                    }
                    break;
                }
                case "2": {
                    System.out.print("Nhập tên để tìm kiếm: ");
                    String name = scanner.nextLine();
                    quanLyCanBo.searchCanBoByName(name).forEach(officer -> {
                        System.out.println(officer.toString());
                    });
                    break;
                }
                case "3": {
                    quanLyCanBo.ShowListCanBo();
                    break;
                }
                case "4": {
                    return;
                }
                default:
                    System.out.println("Không hợp lệ.");
                    continue;
            }

        }
    }
}
