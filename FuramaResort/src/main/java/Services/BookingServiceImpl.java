package Services;

import Models.Booking;
import Utils.DataBookingUtil;
import Utils.DataFacilityUtil;
import Utils.MenuModifier;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService{
    static Scanner scanner = new Scanner(System.in);
    static TreeSet<Booking> bookingTreeSet = new TreeSet<>();
    static DataBookingUtil dataBookingUtil = new DataBookingUtil();
    static DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();
    static MenuModifier menuModifier = new MenuModifier();
    static {
        bookingTreeSet.add(new Booking("43DN", LocalDate.of(2023, 02, 06), LocalDate.of(2023, 02, 10), "77C2", "SVVL-0001"));
        bookingTreeSet.add(new Booking("73QB", LocalDate.of(2023, 02, 04), LocalDate.of(2023, 02, 15), "92C3", "SVRO-0001"));
        bookingTreeSet.add(new Booking("92QN", LocalDate.of(2023, 01, 15), LocalDate.of(2023, 03, 04), "43G2", "SVRO-0003"));
        dataBookingUtil.writeDataBookingToFile(bookingTreeSet);

        try {
            dataFacilityUtil.writeDataRoomToFile(menuModifier.updateTimeUsedOfRoomService());
            dataFacilityUtil.writeDataVillaToFile(menuModifier.updateTimeUsedOfVillaService());
        } catch (IOException e) {

        }
    }

    @Override
    public void display() throws IOException {
        TreeSet<Booking> bookingTreeSet = dataBookingUtil.readDataBookingFromFile();
        for (Booking booking : bookingTreeSet) {
            System.out.println(booking);
        }
        System.out.println("Hoàn thành !!");
    }

    @Override
    public boolean add() {
        try {
            System.out.println("Nhập mã booking: ");
            String idBooking = scanner.nextLine();
            System.out.println("Nhập ngày bắt đầu theo format(dd/mm/yyyy): ");
            String startDayString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
            LocalDate startDate = LocalDate.parse(startDayString, formatter);
            System.out.println("Nhập ngày kết thúc theo format(dd/mm/yyyy): ");
            String endDayString = scanner.nextLine();
            LocalDate endDate = LocalDate.parse(endDayString, formatter);
            System.out.println("Mã khách hàng: ");
            String idCustomer = menuModifier.getCustomerId();
            System.out.println("Tên dịch vụ: ");
            String nameService = menuModifier.getIdService();
            if (nameService.contains("SVRO")) {
                if (menuModifier.checkServiceRoomNeedToMaintain(nameService)) {
                    bookingTreeSet.add(new Booking(idBooking, startDate, endDate, idCustomer, nameService));
                    dataBookingUtil.writeDataBookingToFile(bookingTreeSet);
                    try {
                        dataFacilityUtil.writeDataRoomToFile(menuModifier.updateTimeUsedOfRoomService());
                    } catch (IOException e) {

                    }
                }
            } else if (nameService.contains("SVVL")) {
                if (menuModifier.checkServiceVillaNeedToMaintain(nameService)) {
                    bookingTreeSet.add(new Booking(idBooking, startDate, endDate, idCustomer, nameService));
                    dataBookingUtil.writeDataBookingToFile(bookingTreeSet);
                    try {
                        dataFacilityUtil.writeDataVillaToFile(menuModifier.updateTimeUsedOfVillaService());
                    } catch (IOException e) {

                    }
                }
            }
            System.out.println("Hoàn thành !!");
        } catch (DateTimeParseException e) {
            System.out.println("Nhập sai định dạng !! Mời bạn nhập lại...");
            return add();
        }
        return true;
    }

    @Override
    public boolean edit() {

        return false;
    }
}
