package Services;

import Models.Room;
import Models.Villa;
import Utils.DataFacilityUtil;
import Utils.MenuModifier;

import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    static Map<Villa, Integer> serviceVillaUsed = new LinkedHashMap<>();
    static Map<Room, Integer> serviceRoomUsed = new LinkedHashMap<>();
    static DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();
    static MenuModifier menuModifier = new MenuModifier();

    static {
        serviceVillaUsed.put(new Villa("SVVL-0001", "C1122G1", 100, 9000000, 12, "Thuê theo ngày", "Standard", 50, 4), 0);
        serviceVillaUsed.put(new Villa("SVVL-0003", "C0123L1", 65, 6500000, 15, "Thuê theo tháng", "Superior", 60, 2), 0);
        serviceVillaUsed.put(new Villa("SVVL-0005", "A0722I1", 30, 3000000, 18, "Thuê theo năm", "Deluxe", 35, 8), 0);
        serviceRoomUsed.put(new Room("SVRO-0001", "C0822G1", 48, 4500000, 18, "Thuê theo ngày", "Nuớc uống miễn phí"),0);
        serviceRoomUsed.put(new Room("SVRO-0003", "C1022G1", 50, 4700000, 20, "Thuê theo tháng", "Xông hơi miễn phí"),0);
        serviceRoomUsed.put(new Room("SVRO-0005", "C0622G1", 65, 6500000, 16, "Thuê theo năm", "Phục vụ cơm miễn phí"),0);
        try {
            dataFacilityUtil.writeDataVillaToFile(serviceVillaUsed);
            dataFacilityUtil.writeDataRoomToFile(serviceRoomUsed);
        } catch (IOException e) {

        }
    }

    Scanner scanner = new Scanner(System.in);


    @Override
    public void display() throws IOException {
        Map<Room, Integer> dataRoomFacility = dataFacilityUtil.readDataRoomFromFile();
        for (Map.Entry<Room, Integer> entry : dataRoomFacility.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        Map<Villa, Integer> dataVillaFromFileFacility = dataFacilityUtil.readDataVillaFromFile();
        for (Map.Entry<Villa, Integer> entry: dataVillaFromFileFacility.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    @Override
    public boolean add() {
        try {
            System.out.println("1. Thêm Villa mới");
            System.out.println("2. Thêm Room mới");
            System.out.println("3. Quay lại menu");
            int chooseUserServiceType = Integer.parseInt(scanner.nextLine());
            switch (chooseUserServiceType) {
                case 1:
                    serviceVillaUsed.put(menuModifier.getInfoVillaService(), 0);
                    dataFacilityUtil.writeDataVillaToFile(serviceVillaUsed);
                    dataFacilityUtil.writeDataVillaToFile(menuModifier.updateTimeUsedOfVillaService());
                    break;
                case 2:
                    serviceRoomUsed.put(menuModifier.getInfoRoomService(), 0);
                    dataFacilityUtil.writeDataRoomToFile(serviceRoomUsed);
                    dataFacilityUtil.writeDataRoomToFile(menuModifier.updateTimeUsedOfRoomService());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Không có mục này !! Mời chọn lại: ");
                    add();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Bạn nhập sai lựa chọn trong menu !! Mời bạn chọn lại");
            add();
        } catch (InputMismatchException e) {
            System.out.println("Bạn nhập sai lựa chọn trong menu !! Mời bạn chọn lại");
            add();
        } catch (IOException e) {

        }
        return true;
    }

    public void displayListFacilityMaintenance() throws IOException {
        for (Map.Entry<Room, Integer> entry : dataFacilityUtil.readDataRoomFromFile().entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println("Room: " + entry.getKey().getServiceName());
            }
        }
        for (Map.Entry<Villa, Integer> entry : dataFacilityUtil.readDataVillaFromFile().entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println("Villa: " + entry.getKey().getServiceName());
            }
        }
        System.out.println("Hoàn thành !!!");
    }
}
