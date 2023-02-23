package org.example.view;

import java.io.IOException;
import java.util.*;

import org.example.model.Customer;
import org.example.model.CustomerType;
import org.example.service.ICustomerService;
import org.example.service.file.FCustomerService;
import org.example.service.implement.CustomerServiceImpl;
import org.example.utils.DateUtils;


public class CustomerView {
    private Scanner scanner = new Scanner(System.in);

    // IM viết tắt: immemory
    private ICustomerService customerService;
    public void launcher() {
        boolean checkActionMenu = false;
        do {
            System.out.println("Menu quản lý khách hàng");
            System.out.println("1. Xem danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Sửa thông tin khách hàng");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showCustomersView();
                    break;
                case 2:
                    addCustomersView();
                    break;
                case 3:
                    editCustomerView();
                    break;
                default:
                    System.out.println("Nhập không đúng vui lòng nhập lại");
                    checkActionMenu = true;
                    continue;
            }
            boolean checkActionMenuContinue = false;
            do{
                checkActionMenuContinue = false;
                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
                String actionMenuContinue = scanner.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        break;
                    case "N":
                        checkActionMenu = false;
                        break;
                    default:
                        System.out.println("Nhập không không đúng vui lòng nhập lai");
                        checkActionMenuContinue = true;

                }
            }while (checkActionMenuContinue);

        } while (checkActionMenu);
    }

//    private void editCustomerView() {
//        boolean checkActionMenu = false;
//        do {
//            System.out.println("Bạn muốn sửa thông tin nào");
//            System.out.println("1. Sửa theo tên");
//            System.out.println("2. Sửa theo số điện thoại");
//            System.out.println("3. Cập nhật loại khách hàng");
//
//            int actionMenu = Integer.parseInt(scanner.nextLine());
//            switch (actionMenu) {
//                case 1:
//                    editCustomerByNameView();
//                    break;
//
//                case 3:
//                    editCustomerByCustomerTypeView();
//                    break;
//                default:
//                    System.out.println("Nhập không đúng vui lòng nhập lại");
//                    checkActionMenu = true;
//                    continue;
//            }
//            boolean checkActionMenuContinue = false;
//            do{
//                checkActionMenuContinue = false;
//                System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
//                String actionMenuContinue = scanner.nextLine();
//                switch (actionMenuContinue) {
//                    case "Y":
//                        checkActionMenu = true;
//                        break;
//                    case "N":
//                        checkActionMenu = false;
//                        break;
//                    default:
//                        System.out.println("Nhập không không đúng vui lòng nhập lai");
//                        checkActionMenuContinue = true;
//
//                }
//            }while (checkActionMenuContinue);
//
//        } while (checkActionMenu);
//    }

    private void editCustomerByCustomerTypeView() {


    }

    private void editCustomerView() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhập id khách hàng cần sửa: ");
            long id = Long.parseLong(scanner.nextLine());
            Customer customer = customerService.findCustomerById(id);

            System.out.println("Nhập tên mới: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                customer.setName(name);
            }

            System.out.println("Nhập số điện thoại mới: ");
            String phone = scanner.nextLine();
            if (!phone.isEmpty()) {
                customer.setPhone(phone);
            }

            System.out.println("Nhập địa chỉ mới: ");
            String address = scanner.nextLine();
            if (!address.isEmpty()) {
                customer.setAddress(address);
            }

            customerService.updateCustomer(customer.getId(), customer);
            System.out.println("Thông tin khách hàng đã được caập nhật vào file");



//        System.out.println("Nhập ID khách hàng bạn muốn sửa");
//        long idCustomer = Long.parseLong(scanner.nextLine());
//
//        Customer customer = customerService.findCustomerById(idCustomer);
//        if (customer == null) {
//
//        }else{
//            System.out.println("Nhập tên mới: ");
//            String nameCustomer = scanner.nextLine();
//
//            customer.setName(nameCustomer);
//            customerService.updateCustomer(customer.getId(), customer);
//            showCustomersView();
//        }

    }


    public CustomerView() {
        customerService = new FCustomerService();
    }
    private void showCustomersView() {
        List<Customer> customers = customerService.getAllCustomers();
        System.out.printf("%5s | %10s | %10s | %10s | %25s | %10s | %10s\n",
                "ID", "Name", "Phone", "Address", "CreateAt", "Consumed", "Customer type");
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.printf("%5s | %10s | %10s | %10s | %25s | %10s | %10s\n",
                    c.getId(), c.getName(), c.getPhone(), c.getAddress(),
                    DateUtils.dateToString(c.getCreateAt()), c.getConsumed(), c.getCustomerType());
        }
    }

    private void addCustomersView() {
        Customer customer = new Customer();

        System.out.println("Nhập thông tin khách hàng:");
        System.out.println("Nhập tên khách hàng:");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại khách hàng:");
        String phoneCustomer= scanner.nextLine();
        System.out.println(("Nhập địa chỉ khách hàng:"));
        String address = scanner.nextLine();
        System.out.println("Nhập ngày tạo:");
        String createdAt = scanner.nextLine();


        customer.setPhone(phoneCustomer);
        customer.setAddress(address);
        customer.setName(name);
        customer.setCustomerType(CustomerType.NORMAL);
        customer.setConsumed(0);
        customer.setCreateAt(DateUtils.parseDate(createdAt));

        customerService.addCustomer(customer);

    }

    private long getMaxID() {
        List<Customer> customers = customerService.getAllCustomers();
        long idMax = -1;
        for (int i = 0; i < customers.size(); i++) {
            long currentId = customers.get(i).getId();
            if (currentId > idMax) {
                idMax = currentId;
            }
        }
        return idMax;
    }
}
