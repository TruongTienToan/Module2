package Services;

import Models.Customer;
import Utils.DataCustomersUtil;
import Utils.DataFacilityUtil;
import Utils.MenuModifier;
import Utils.RegexAddFacility;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customerList = new LinkedList<>();
    static DataCustomersUtil dataCustomersUtil = new DataCustomersUtil();
    static DataFacilityUtil dataFacilityUtil = new DataFacilityUtil();
    static MenuModifier menuModifier = new MenuModifier();
    static RegexAddFacility regex = new RegexAddFacility();

    static {
        customerList.add(new Customer("Trương Toàn", "23/08/2004", "Nam", "044240000406", "0932357659", "truongtoan238@gmail.com", "73G1", "Silver", "Quảng Bình"));
        customerList.add(new Customer("Quốc Bảo", "24/10/2004", "Nam", "234763597321", "0353478299", "NQB2004@gmail.com", "75G1", "Gold", "Huế"));
        customerList.add(new Customer("Doan Thanh Hai", "01/12/2000", "Nam", "8372673949", "0372937489", "thanhhai@gmail.com", "43G2", "Member", "Da Nang"));
        customerList.add(new Customer("Ho Thi Nuong", "30/01/2002", "Nu", "9284749293", "09157283987", "thinuong@gmail.com", "77C2", "Gold", "Binh Dinh"));
        customerList.add(new Customer("Tran Thi Ngoc Lan", "05/07/2004", "Nu", "0028492847", "09306526765", "ngocnan@gmail.com", "73H1", "Diamond", "Quang Binh"));
        try {
            dataCustomersUtil.writeDataToCustomerFile(customerList);
        } catch (IOException e) {

        }
    }

    Scanner scanner = new Scanner(System.in);


    @Override
    public void display() throws IOException {
        try {
            List<Customer> customerList = dataCustomersUtil.readDataFromCustomerFile();
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        } catch (IOException e) {

        }
    }

    @Override
    public boolean add() {
        customerList.add(getInfoCustomer());
        try {
            dataCustomersUtil.writeDataToCustomerFile(customerList);
        } catch (IOException e) {

        }
        return true;
    }

    @Override
    public boolean edit() {
        System.out.println("Nhập id của khách hàng cần sửa: ");
        String idCustomerEdit = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdCustomer().equals(idCustomerEdit)) {
                chooseAndEditAttributeCustomer(customerList.get(i));
                try {
                    dataCustomersUtil.writeDataToCustomerFile(customerList);
                } catch (IOException e) {

                }
                return true;
            }
        }
        return false;
    }

    public Customer getInfoCustomer() {
        System.out.println("Nhập tên khách hàng mới: ");
        String name = scanner.nextLine();
        String dateOfBirth = menuModifier.checkDateOfBirth();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập số CMND: ");
        String cmnd = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập id của khách hàng: ");
        String idCustomer = scanner.nextLine();
        System.out.println("Nhập loại khách hàng: ");
        String customerType = menuModifier.getCustomerType();
        System.out.println("Nhập địa chỉ của khách hàng: ");
        String address = scanner.nextLine();
        return new Customer(name, dateOfBirth, gender, cmnd, phone, email, idCustomer, customerType, address);
    }

    public void chooseAndEditAttributeCustomer(Customer customer) {
        System.out.println("Lựa chọn mục cần sửa: ");
        System.out.println("1. Tên khách hàng");
        System.out.println("2. Ngày sinh");
        System.out.println("3. Giới tính");
        System.out.println("4. CMND");
        System.out.println("5. Số điện thoại");
        System.out.println("6. Email");
        System.out.println("7. Id của khách hàng");
        System.out.println("8. Loại khách hàng");
        System.out.println("9. Địa chỉ khách hàng");
        try {
            int chooseUser = Integer.parseInt(scanner.nextLine());
            switch (chooseUser) {
                case 1:
                    System.out.println("Nhập tên mới của khách hàng: ");
                    String name = scanner.nextLine();
                    customer.setName(name);
                    break;
                case 2:
                    String dateOfBirth = menuModifier.checkDateOfBirth();
                    customer.setDateOfBirth(dateOfBirth);
                    break;
                case 3:
                    System.out.println("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    customer.setGender(gender);
                    break;
                case 4:
                    System.out.println("Nhập số CMND: ");
                    String cmnd = scanner.nextLine();
                    customer.setCMND(cmnd);
                    break;
                case 5:
                    System.out.println("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    customer.setPhone(phone);
                    break;
                case 6:
                    System.out.println("Nhập email mới: ");
                    String email = scanner.nextLine();
                    customer.setEmail(email);
                    break;
                case 7:
                    System.out.println("Nhập id mới của khách hàng: ");
                    String idCustomer = scanner.nextLine();
                    customer.setIdCustomer(idCustomer);
                    break;
                case 8:
                    System.out.println("Nhập loại khách hàng: ");
                    String customerType = menuModifier.getCustomerType();
                    customer.setCustomerType(customerType);
                    break;
                case 9:
                    System.out.println("Nhập địa chỉ khách hàng: ");
                    String address = scanner.nextLine();
                    customer.setAddress(address);
                    break;
                default:
                    System.out.println("Không có mục này !! Vui lòng nhập lại");
                    chooseAndEditAttributeCustomer(customer);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Bạn nhập sai định dạng !! Mời nhập lại: ");
            chooseAndEditAttributeCustomer(customer);
        }
    }
}
