package controllers;

import Services.BookingServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class BookingController {
    Scanner scanner = new Scanner(System.in);
    BookingServiceImpl bookingService = new BookingServiceImpl();

    public void displayMenuOfBooking() {
        int chooseUserFromCase4 = 0;
        do {
            System.out.println("1. Thêm Booking mới");
            System.out.println("2. Hiển thị danh sách Booking");
            System.out.println("3. Quay lại menu");
            try {
                chooseUserFromCase4 = Integer.parseInt(scanner.nextLine());
                switch (chooseUserFromCase4) {
                    case 1:
                        bookingService.add();
                        break;
                    case 2:
                        bookingService.display();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Không có mục này ! Mời bạn chọn lại");
                        displayMenuOfBooking();
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập sai định dạng ! Mời bạn nhập lại");
                displayMenuOfBooking();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (chooseUserFromCase4 > 0 && chooseUserFromCase4 < 3);
    }
}
