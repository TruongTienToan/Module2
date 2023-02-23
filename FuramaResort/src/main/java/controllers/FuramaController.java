package controllers;

import java.util.Scanner;

public class FuramaController {
    Scanner scanner = new Scanner(System.in);
    EmployeeController employeeController = new EmployeeController();
    CustomerController customerController = new CustomerController();
    FacilityController facilityController = new FacilityController();
    BookingController bookingController = new BookingController();
    PromotionController promotionController = new PromotionController();


    public void subMenu(int chooseUser) {
        switch (chooseUser) {
            case 1:
                employeeController.displayMenuOfEmployee();
                break;
            case 2:
                customerController.displayMenuOfCustomer();
                break;
            case 3:
                facilityController.displayMenuOfFacility();;
                break;
            case 4:
                bookingController.displayMenuOfBooking();
                break;
            case 5:
                promotionController.displayMenuOfPromotion();
                break;
        }
    }

    public void displayMainMenu() throws NumberFormatException {
        int chooseUser = 0;
        do {
            System.out.println("Welcome to Furama Resort");
            System.out.println("1. Quản lý nhân sự.");
            System.out.println("2. Quản lý khách hàng.");
            System.out.println("3. Quản lý cơ sở.");
            System.out.println("4. Quản lý đặt phòng.");
            System.out.println("5. Quản lý khuyến mãi.");
            System.out.println("6. Thoát chương trình");
            try {
                chooseUser = Integer.parseInt(scanner.nextLine());
                switch (chooseUser) {
                    case 1:
                        subMenu(1);
                        break;
                    case 2:
                        subMenu(2);
                        break;
                    case 3:
                        subMenu(3);
                        break;
                    case 4:
                        subMenu(4);
                        break;
                    case 5:
                        subMenu(5);
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Không có mục này !! Xin mời nhập lại");
                        displayMainMenu();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai ký tự, ký tự bạn nhập phải là số!");
                displayMainMenu();
            }
        } while (chooseUser > 0 && chooseUser < 6);
    }
}
