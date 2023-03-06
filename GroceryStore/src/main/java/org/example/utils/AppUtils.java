package org.example.utils;

import org.example.view.InputOption;

import java.util.Scanner;

public class AppUtils {
    static Scanner scanner = new Scanner(System.in);

    public static int retryParseInt() {
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại: ");
            }
        } while (true);
    }

    //Kiem tra
    public static int retryChoose(int min, int max) {
        int option;
        do {
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn không đúng chức năng! Vui lòng chọn lại");
                    continue;
                }
                break;
            }catch (Exception e) {
                System.out.println("Nhập sai ! Vui lòng nhập lại");
            }
        } while (true);
        return option;
    }

    //Kiem tra chuoi co rong khong
    public static String retryString(String fieldName) {
        String result;
        while ((result = scanner.nextLine()).isEmpty()) {
            System.out.printf("%s Không được để trống \n", fieldName);
        }
        return result;
    }

    public static boolean isRetry(InputOption inputOption) {
        do {
            switch (inputOption) {
                case ADD:
                    System.out.println("Nhấn 'y' để thêm tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 'y' để sửa tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                case DELETE:
                    System.out.println("Nhấn 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                case SHOW:
                    System.out.println("Nhấn 'q' để quay lại \t|\t 't' để thoát chương trình");
                    break;
                default:
                    throw new IllegalStateException("Giá trị mới không đổi "+ inputOption);
            }
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    return true;
                case "q":
                    return false;
                case "t":
                    System.out.println("Tạm biệt! Hẹn gặp lại");
                    System.exit(5);
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lai");
                    break;
            }
        } while (true);
    }
}
