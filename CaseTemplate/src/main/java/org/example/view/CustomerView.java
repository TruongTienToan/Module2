package org.example.view;

import java.util.*;

import org.example.model.Customer;
import org.example.model.CustomerType;
import org.example.service.ICustomerService;
import org.example.service.file.FCustomerService;
import org.example.utils.DateUtils;


public class CustomerView {
    private Scanner scanner = new Scanner(System.in);

    private ICustomerService customerService;
    public void launcher() {
        boolean checkActionMenu = false;
        do {
            System.out.println("Menu quản lý khách hàng");
            System.out.println("1. Xem danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");

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
                case 4:
                    deleteCustomerView();
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

    private void deleteCustomerView() {
        Customer customer = new Customer();
        customerService.deleteCustomer(customer.getId());
        System.out.println("Xoas khach hang thanh cong!");
        showCustomersView();
    }


    private void editCustomerByCustomerTypeView() {


    }

    private void   editCustomerView() {

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
            showCustomersView();

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
        System.out.println("Thêm khách hàng thành công!");
        showCustomersView();
    }

}
