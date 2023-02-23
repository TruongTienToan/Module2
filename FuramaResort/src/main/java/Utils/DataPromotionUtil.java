package Utils;

import Models.Booking;
import Models.Customer;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

public class DataPromotionUtil {
    DataBookingUtil dataBookingUtil = new DataBookingUtil();
    DataCustomersUtil dataCustomersUtil = new DataCustomersUtil();

    public TreeSet<Customer> getCustomerListUsedService() {
        TreeSet<Customer> customerListUsedService = new TreeSet<>();
        try {
            TreeSet<Booking> bookingList = dataBookingUtil.readDataBookingFromFile();
            List<Customer> customerList = dataCustomersUtil.readDataFromCustomerFile();
            for (Booking booking : bookingList) {
                for (Customer customer : customerList) {
                    if (customer.getIdCustomer().equals(booking.getCustomerId())) {
                        customerListUsedService.add(customer);
                    }
                }
            }
            return customerListUsedService;
        } catch (IOException e) {
            System.out.println("Can not get data from file !!!");
        }
        return customerListUsedService;
    }
}
