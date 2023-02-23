package Utils;

import Models.Booking;
import Models.Customer;
import Models.Room;
import Models.Villa;

import java.io.IOException;
import java.util.*;

public class MenuModifier {
    static Scanner scanner = new Scanner(System.in);
    RegexAddFacility regexAddFacility = new RegexAddFacility();
    DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();
    DataBookingUtil dataBookingUtil = new DataBookingUtil();

    public String getCustomerType() {
        int chooseType = 0;
        String customerType = null;
        System.out.println("1. Diamond");
        System.out.println("2. Platinum");
        System.out.println("3. Gold");
        System.out.println("4. Silver");
        System.out.println("5. Member");
        System.out.println("Mời bạn chọn: ");
        try {
            chooseType = Integer.parseInt(scanner.nextLine());
            switch (chooseType) {
                case 1:
                    customerType = "Diamond";
                    break;
                case 2:
                    customerType = "Platinum";
                    break;
                case 3:
                    customerType = "Gold";
                    break;
                case 4:
                    customerType = "Silver";
                    break;
                case 5:
                    customerType = "Member";
                    break;
                default:
                    System.out.println("Không có mục này! Mời bạn chọn lại: ");
                    return getCustomerType();
            }
        } catch (NumberFormatException e) {
            System.err.println("Nhập sai định dạng! Mời bạn nhập lại: ");
            return getCustomerType();
        }
        return customerType;
    }

    public String getAcademicLevelOfEmployee() {
        int chooseType = 0;
        String academicLevel = null;
        System.out.println("1. Trung cấp");
        System.out.println("2. Cao đẳng");
        System.out.println("3. Đại học");
        System.out.println("4. Sau đại học");
        System.out.println("Mời bạn chọn trình độ học vấn");
        try {
            chooseType = Integer.parseInt(scanner.nextLine());
            switch (chooseType) {
                case 1:
                    academicLevel = "Trung cấp";
                    break;
                case 2:
                    academicLevel = "Cao đẳng";
                    break;
                case 3:
                    academicLevel = "Đại học";
                    break;
                case 4:
                    academicLevel = "Sau đại học";
                    break;
                default:
                    System.out.println("Không có mục này ! Mời bạn chọn lại: ");
                    return getAcademicLevelOfEmployee();
            }
        } catch (NumberFormatException e){
            System.out.println("Nhập sai định dạng ! Mời bạn nhập lại: ");
            return getAcademicLevelOfEmployee();
        }
        return academicLevel;
    }

    public String getEmployeePosition() {
        int chooseType;
        String position = null;
        System.out.println("1. Lễ tân");
        System.out.println("2. Phục vụ");
        System.out.println("3. Chuyên viên");
        System.out.println("4. Giám sát");
        System.out.println("5. Quản lý");
        System.out.println("6. Giám đốc");
        System.out.println("Mời bạn chọn vị trí: ");
        try {
            chooseType = Integer.parseInt(scanner.nextLine());
            switch (chooseType) {
                case 1:
                    position = "Lễ tân";
                    break;
                case 2:
                    position = "Phục vụ";
                    break;
                case 3:
                    position = "Chuyên viên";
                    break;
                case 4:
                    position = "Giám sát";
                    break;
                case 5:
                    position = "Quản lý";
                    break;
                case 6:
                    position = "Giám đốc";
                    break;
                default:
                    System.out.println("KHông có mục này ! Mời bạn chọn lại: ");
                    return getEmployeePosition();
            }
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai định dạng ! Mời bạn nhập lại: ");
            return getEmployeePosition();
        }
        return position;
    }

    public Villa getInfoVillaService() {
        Villa villaService = null;
        try {
            String codeService;
            do {
                System.out.println("Nhập mã dịch vụ theo format (SVVL-YYYY): ");
                codeService = scanner.nextLine();
            } while (!regexAddFacility.checkCodeVillaServiceRegex(codeService));
            String nameService;
            do {
                System.out.println("Nhập tên dịch vụ (Chữ cái đầu viết hoa):");
                nameService = scanner.nextLine();
            } while (!regexAddFacility.checkNameServiceRegex(nameService));
            double usableArea;
            do {
                System.out.println("Nhập diện tích sử dụng (>= 30 m^2): ");
                usableArea = Double.parseDouble(scanner.nextLine());
            } while (usableArea < 30);
            double rentalCosts;
            do {
                System.out.println("Nhập giá muốn thuê dịch vụ ( >0 ): ");
                rentalCosts = Double.parseDouble(scanner.nextLine());
            } while (rentalCosts <= 0);
            int maximumPeople;
            do {
                System.out.println("Nhập số người muốn sử dụng dịch vụ: ");
                maximumPeople = Integer.parseInt(scanner.nextLine());
            } while (maximumPeople < 1 || maximumPeople >= 20);
            String rentalType = getRentalType();
            int roomStandard;
            do {
                System.out.println("Nhập tiêu chuẩn phòng từ 1 - > 5 sao: ");
                roomStandard = Integer.parseInt(scanner.nextLine());
            } while ((roomStandard < 1 || roomStandard > 5));
            double poolArea;
            do {
                System.out.println("Nhập diện tích hồ bơi (>= 30 m^2): ");
                poolArea = Double.parseDouble(scanner.nextLine());
            } while (poolArea < 30);
            int numberOfFloor;
            do {
                System.out.println("Bạn muốn ở tầng bao nhiêu: ");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
            } while (numberOfFloor <= 0);
            villaService = new Villa(
                    codeService,
                    nameService,
                    usableArea, rentalCosts,
                    maximumPeople,
                    rentalType,
                    roomStandard,
                    poolArea,
                    numberOfFloor
            );
        } catch (NumberFormatException e) {
            System.out.println("Bạn nhập sai format !! Mời bạn nhập lại ...");
            return getInfoVillaService();
        }
        return villaService;
    }


    public Room getInfoRoomService() {
        Room roomService = null;
        try {
            String codeService;
            do {
                System.out.println("Nhập mã dịch vụ theo format (SVRO-YYYY): ");
                codeService = scanner.nextLine();
            } while (!regexAddFacility.checkCodeRoomServiceRegex(codeService));
            String nameService;
            do {
                System.out.println("Nhập tên dịch vụ (Chữ cái đầu viết hoa):");
                nameService = scanner.nextLine();
            } while (!regexAddFacility.checkNameServiceRegex(nameService));
            double usableArea;
            do {
                System.out.println("Nhập diện tích sử dụng (>= 30 m^2): ");
                usableArea = Double.parseDouble(scanner.nextLine());
            } while (usableArea < 30);
            double rentalCosts;
            do {
                System.out.println("Nhập giá muốn thuê dịch vụ ( >0 ): ");
                rentalCosts = Double.parseDouble(scanner.nextLine());
            } while (rentalCosts <= 0);
            int maximumPeople;
            do {
                System.out.println("Nhập số người sử dụng dịch vụ: ");
                maximumPeople = Integer.parseInt(scanner.nextLine());
            } while (maximumPeople < 1 || maximumPeople >= 20);
            String rentalType = getRentalType();
            String freeService = getFreeService();
            roomService = new Room(codeService, nameService, usableArea, rentalCosts, maximumPeople, rentalType, freeService);
        } catch (NumberFormatException e) {
            return getInfoRoomService();
        }
        return roomService;
    }


    public String getRentalType() {
        int chooseType;
        String rentalType = null;
        try {
            System.out.println("Bạn muốn thuê theo kiểu nào: ");
            System.out.println("1. Thuê theo ngày.");
            System.out.println("2. Thuê theo tháng.");
            System.out.println("3. Thuê theo năm.");
            chooseType = Integer.parseInt(scanner.nextLine());
            switch (chooseType) {
                case 1:
                    rentalType = "Thuê theo ngày";
                    break;
                case 2:
                    rentalType = "Thuê theo tháng";
                    break;
                case 3:
                    rentalType = "Thuê theo năm";
                    break;
                default:
                    System.out.println("Không có mục này !! Xin mời bạn nhập lại: ");
                    return getRentalType();
            }
        } catch (NumberFormatException e) {
            System.out.println("Bạn nhập sai định dạng !! Xin mời bạn nhập lại: ");
            return getRentalType();
        }
        return rentalType;
    }

    public String getFreeService() {
        int chooseType;
        System.out.println("Bạn muốn theo kèm dịch vụ miễn phí nào? ");
        System.out.println("1. Nước uống miễn phí");
        System.out.println("2. Phục vụ cơm miễn phí");
        System.out.println("3. Xông hơi miễn phí");
        try {
            chooseType = Integer.parseInt(scanner.nextLine());
            switch (chooseType) {
                case 1:
                    return "Nước uống miễn phí";
                case 2:
                    return "Phục vụ cơm miễn phí";
                case 3:
                    return "Xông hơi miễn phí";
                default:
                    System.out.println("Không có mục này ! Mời quý khách chọn lại");
                    return getFreeService();
            }
        } catch (NumberFormatException e) {
            System.out.println("Không có mục này ! Mời quý khách chọn lại");
            return getFreeService();
        }
    }

    public String getCustomerId() {
        String CustomerIdChosen = null;
        boolean flag = false;
        try {
            List<Customer> customerList = new LinkedList<>();
            DataCustomersUtil dataCustomersUtil = new DataCustomersUtil();
            customerList = dataCustomersUtil.readDataFromCustomerFile();
            System.out.println("Danh sách mã khách hàng: ");
            for (Customer customer : customerList) {
                System.out.println(customer.getIdCustomer());
            }
            System.out.println("Mời bạn chọn mã khách hàng: ");
            CustomerIdChosen = scanner.nextLine();
            for (Customer customer : customerList) {
                if (CustomerIdChosen.equals(customer.getIdCustomer())) {
                    flag = true;
                    return CustomerIdChosen;
                }
            }
        } catch (IOException e) {
            System.out.println("Không lấy được mã khách hàng!!!");
        }
        if (!flag) {
            System.out.println("Bạn nhập sai format! Mời bạn nhập lại");
            return getCustomerId();
        }
        return CustomerIdChosen;
    }

    public String getIdService() {
        Map<Room, Integer> dataRoomService = new LinkedHashMap<>();
        Map<Villa, Integer> dataVillaService = new LinkedHashMap<>();
        String idService = null;
        boolean flag = false;
        try {
            dataVillaService = dataFacilityUtil.readDataVillaFromFile();
            dataRoomService = dataFacilityUtil.readDataRoomFromFile();
            System.out.println("Danh sách mã dịch vụ: ");
            for (Map.Entry<Room, Integer> entry : dataRoomService.entrySet()) {
                System.out.println(entry.getKey().getIdService());
            }
            for (Map.Entry<Villa, Integer> entry : dataVillaService.entrySet()) {
                System.out.println(entry.getKey().getIdService());
            }
            System.out.println("Moi ban chon ma dich vu: ");
            idService = scanner.nextLine();
            for (Map.Entry<Room, Integer> entry : dataRoomService.entrySet()) {
                if (idService.equals(entry.getKey().getIdService())) {
                    flag = true;
                    return idService;
                }
            }
            for (Map.Entry<Villa, Integer> entry : dataVillaService.entrySet()) {
                if (idService.equals(entry.getKey().getIdService())) {
                    flag = true;
                    return idService;
                }
            }
        } catch (IOException e) {
            System.out.println("Can not get data !!");
        }
        if (!flag) {
            return getIdService();
        }
        return idService;
    }

    public Stack<Integer> getAmountVoucher(int amountCustomers) {
        Stack<Integer> amountVoucher = new Stack<>();
        System.out.println("Mời bạn nhập số lượng voucher ( tổng = " + amountCustomers + " )");
        int voucher10Percent;
        int voucher20Percent;
        int voucher50Percent;
        do {
            System.out.println("Nhập số lượng voucher 10%: ");
            voucher10Percent = scanner.nextInt();
            System.out.println("Nhập số lượng voucher 20%:");
            voucher20Percent = scanner.nextInt();
            System.out.println("Nhập số lượng voucher 50%:");
            voucher50Percent = scanner.nextInt();
        } while ((voucher10Percent + voucher20Percent + voucher50Percent) != amountCustomers);
        for (int i = 1; i <= voucher50Percent; i++) {
            amountVoucher.push(50);
        }
        for (int i = 1; i <= voucher20Percent; i++) {
            amountVoucher.push(20);
        }
        for (int i = 1; i <= voucher10Percent; i++) {
            amountVoucher.push(10);
        }
        return amountVoucher;
    }


    public Map<Room, Integer> updateTimeUsedOfRoomService() {
        TreeSet<Booking> bookingTreeSet = dataBookingUtil.readDataBookingFromFile();
        Map<Room, Integer> dataRoomFacility = null;
        try {
            dataRoomFacility = dataFacilityUtil.readDataRoomFromFile();
            for (Map.Entry<Room, Integer> entry : dataRoomFacility.entrySet()) {
                int count = 0;
                for (Booking booking : bookingTreeSet) {
                    if (entry.getKey().getIdService().equals(booking.getServiceName()) && entry.getValue() < 5) {
                        count++;
                    }
                }
                dataRoomFacility.put(entry.getKey(), count);
            }
            return dataRoomFacility;
        } catch (IOException e) {
            System.err.println("Can not get data from database !! Try again ...");
        }
        return dataRoomFacility;
    }

    public boolean checkServiceRoomNeedToMaintain(String nameService) {
        Map<Room, Integer> dataRoomFacility = null;
        try {
            dataRoomFacility = dataFacilityUtil.readDataRoomFromFile();
            for (Map.Entry<Room, Integer> entry : dataRoomFacility.entrySet()) {
                if (entry.getKey().getIdService().equals(nameService) && entry.getValue() < 5) {
                    return true;
                }
                else if (entry.getKey().getIdService().equals(nameService) && entry.getValue()>= 5){
                    System.out.println("Dịch vụ đang được bảo trì !!");
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Can not get data from database !! Try again ...");
        }
        return true;
    }


    public Map<Villa, Integer> updateTimeUsedOfVillaService() {
        TreeSet<Booking> bookingTreeSet = dataBookingUtil.readDataBookingFromFile();
        Map<Villa, Integer> dataVillaFacility = null;
        try {
            dataVillaFacility = dataFacilityUtil.readDataVillaFromFile();
            for (Map.Entry<Villa, Integer> entry : dataVillaFacility.entrySet()) {
                int count = 0;
                for (Booking booking : bookingTreeSet) {
                    if (entry.getKey().getIdService().equals(booking.getServiceName()) && entry.getValue() < 5) {
                        count++;
                    }
                    dataVillaFacility.put(entry.getKey(), count);
                }
            }
            return dataVillaFacility;
        } catch (IOException e) {
            System.err.println("Can not get data from database !! Try again ...");
        }
        return dataVillaFacility;
    }


    public boolean checkServiceVillaNeedToMaintain(String nameService) {
        Map<Villa, Integer> dataVillaFacility = null;
        try {
            dataVillaFacility = dataFacilityUtil.readDataVillaFromFile();
            for (Map.Entry<Villa, Integer> entry : dataVillaFacility.entrySet()) {
                if (entry.getKey().getIdService().equals(nameService) && entry.getValue() < 5) {
                    return true;
                }
                else if (entry.getKey().getIdService().equals(nameService) && entry.getValue()>= 5){
                    System.out.println("Dịch vụ đang cần được bảo trì!!");
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Can not get data from database !! Try again ...");
        }
        return true;
    }

    public String checkDateOfBirth() {
        String dateOfBirth;
        System.out.println("Nhập ngày sinh theo format (dd/mm/yy): ");
        dateOfBirth = scanner.nextLine();
        try {
            regexAddFacility.checkDateOfBirthUser(dateOfBirth);
        } catch (UserException e) {
            return checkDateOfBirth();
        }
        return dateOfBirth;
    }
}
