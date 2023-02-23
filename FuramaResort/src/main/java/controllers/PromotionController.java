package controllers;

import Services.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    Scanner scanner = new Scanner(System.in);
    PromotionServiceImpl promotionService = new PromotionServiceImpl();

    public void displayMenuOfPromotion() {
        int chooseUserFromCase5 = 0;
        do {
            System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
            System.out.println("2. Hiển thị danh sách khách hàng nhận voucher");
            System.out.println("3. Quay lại menu chính");
            try {
                chooseUserFromCase5 = Integer.parseInt(scanner.nextLine());
                switch (chooseUserFromCase5) {
                    case 1:
                        promotionService.displayCustomerListUsedService();
                        break;
                    case 2:
                        promotionService.displayCustomerReceiveVoucher();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Không có mục này !! Mời bạn chọn lại");
                        displayMenuOfPromotion();
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng !! Mời bạn nhập lại");
                displayMenuOfPromotion();
            }
        } while (chooseUserFromCase5 > 0 && chooseUserFromCase5 < 3);
    }
}
