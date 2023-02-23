package controllers;

import Services.FacilityServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class FacilityController {
    Scanner scanner = new Scanner(System.in);
    FacilityServiceImpl facilityService = new FacilityServiceImpl();

    public void displayMenuOfFacility() {
        int chooseUserFromCase3 = 0;
        do {
            System.out.println("1. Hiển thị danh sách cơ sở");
            System.out.println("2. Thêm mới cơ sở");
            System.out.println("3. Hiển thị danh sách cơ sở bảo trì");
            System.out.println("4. Quay lại menu chính");
            try {
                chooseUserFromCase3 = Integer.parseInt(scanner.nextLine());
                switch (chooseUserFromCase3) {
                    case 1:
                        facilityService.display();
                        System.out.println("Completed !!");
                        break;
                    case 2:
                        facilityService.add();
                        System.out.println("Added !!");
                        break;
                    case 3:
                        facilityService.displayListFacilityMaintenance();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Khong co muc nay!!! moi ban chon muc khac...");
                        displayMenuOfFacility();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ky tu ban nhap khong phai la so !! Moi ban nhap lai ...");
                displayMenuOfFacility();
            } catch (IOException e) {
            }
        } while (chooseUserFromCase3 > 0 && chooseUserFromCase3 < 4);
    }
}
