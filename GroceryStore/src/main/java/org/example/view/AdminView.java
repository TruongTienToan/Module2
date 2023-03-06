package org.example.view;

import org.example.service.IUserService;
import org.example.service.impl.UserService;
import org.example.utils.AppUtils;

import java.util.Scanner;

public class AdminView {
    private  final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public AdminView() {
        this.userService = UserService.getInstance();
    }

    public void adminLogin() {
        boolean isRetry;
        System.out.println("\t\t\t\t══════════════════════════ ĐĂNG NHẬP HỆ THỐNG ══════════════════════════");
        do {
            System.out.print("Username: ");
            String username = AppUtils.retryString("username");
            System.out.print("passwork: ");
            String passwork = AppUtils.retryString("passwork");
            if(userService.adminLogin(username, passwork) == null) {
                System.out.println("Tài khoản không hợp lệ!");
                isRetry = isRetry();
            } else {
                System.out.println("Bạn đã đăng nhập thành công: ");
                System.out.println("CHÀO MỪNG BẠN ĐẾN VỚI BÁCH HÓA XANH \n");
                isRetry = false;
            }
        } while (isRetry);
    }
    // Xuat hien thong bao cho nguoi ta chon de nhap lai hay khong
    private boolean isRetry() {
        do {
            try {
                System.out.println("\t ==================== CHỌN ======================");
                System.out.println("\t |                                              |");
                System.out.println("\t |   1.Nhấn 'y' để đăng nhập lại                |");
                System.out.println("\t |   2.Nhấn 'n' để thoát chương trình           |");
                System.out.println("\t |                                              |");
                System.out.println("\t ================================================");
                String option = scanner.nextLine();
                switch (option) {
                    case "y" :
                        return true;
                    case "n" :
                        System.out.println("\tTạm biệt. Hẹn gặp lại!");
                        System.exit(5);
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e){
                System.out.println("Nhập sai! Vui lòng chọn lại");
                e.printStackTrace();
            }
        } while (true);
    }
}
