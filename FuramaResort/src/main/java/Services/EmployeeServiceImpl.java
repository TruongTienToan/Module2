package Services;

import Models.Employee;
import Utils.DataEmployeeUtil;
import Utils.MenuModifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static DataEmployeeUtil dataEmployeeUtil = new DataEmployeeUtil();
    static MenuModifier menuModifier = new MenuModifier();

    static {
        employeeList.add(new Employee("Nguyen Hoang Hai", "07/06/1993", "Nam", "2038748290", "09384839383", "haihoangbk@gmail.com", "75H1", "Graduate", "Manager", "10000000"));
        employeeList.add(new Employee("Nguyen Minh Lanh", "01/11/1990", "Nam", "2293874849", "0917364929", "minhlanh@gmail.com", "92C1", "Graduate", "Receptionist", "7500000"));
        employeeList.add(new Employee("Nguyen Van Minh", "12/04/1998", "Nam", "8384594399", "0938783622", "minhnguyenbk@gmail.com", "37N3", "College", "Restaurant specialist", "7000000"));
        employeeList.add(new Employee("Chau To Trinh", "30/07/1996", "Nu", "7387005934", "09848493092", "totrinhchau@gmail.com", "77G2", "College", "Waitress", "5000000"));
        employeeList.add(new Employee("Nguyen Quoc Anh", "06/03/1996", "Nam", "9384458758", "0938293873", "quocanh@gmail.com", "74C1", "University", "Supervisor", "7000000"));
        employeeList.add(new Employee("Le Van Chinh", "24/02/2003", "Nam", "8383688463", "09999999999", "chinhpope@gmail.com", "73H1", "Graduate", "CEO", "90000000"));
        try {
            dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
        } catch (IOException e) {

        }
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        try {
            dataEmployeeUtil.readDataEmployeeFromFile();
        } catch (IOException e) {

        }
    }

    @Override
    public boolean add() {
        if (employeeList.add(getInfoEmployee())) {
            try {
                dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
            } catch (IOException e) {

            }
            return true;
        }
        return false;
    }

    @Override
    public boolean edit() {
        System.out.println("Nhập id của nhân viên cần sửa: ");
        String idEmployeeEdit = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdEmployee().equals(idEmployeeEdit)) {
                chooseAndEditAttributeEmployee(employeeList.get(i));
                try {
                    dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
                } catch (IOException e) {

                }
                return true;
            }
        }
        return false;
    }

    public boolean delete() throws ClassNotFoundException {
        System.out.println("Nhập id của nhân viên cần xóa: ");
        boolean flag = false;
        String idEmployeeDelete = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdEmployee().equals(idEmployeeDelete)) {
                employeeList.remove(i);
                try {
                    dataEmployeeUtil.writeDataEmployeeToFile(employeeList);
                } catch (IOException e) {

                }
                System.out.println("Xóa thành công");
                flag = true;
            }
        }
        if (!flag) {
            throw new ClassNotFoundException();
        }
        return flag;
    }

    public Employee getInfoEmployee() {
        System.out.println("Nhập tên nhân viên mới: ");
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
        System.out.println("Nhập id của nhân viên: ");
        String idEmployee = scanner.nextLine();
        System.out.println("Nhập trình độ học vấn: ");
        String level = menuModifier.getAcademicLevelOfEmployee();
        System.out.println("Nhập vị trí trong công ty: ");
        String position = menuModifier.getEmployeePosition();
        System.out.println("Nhập lương khởi điểm: ");
        String wage = scanner.nextLine();
        return new Employee(name, dateOfBirth, gender, cmnd, phone, email, idEmployee, level, position, wage);
    }

    public void chooseAndEditAttributeEmployee(Employee employee) {
        System.out.println("Lựa chọn mục cần sửa: ");
        System.out.println("1. Tên nhân viên");
        System.out.println("2. Ngày sinh");
        System.out.println("3. Giới tính");
        System.out.println("4. CMND ");
        System.out.println("5. Số điện thoại");
        System.out.println("6. Email");
        System.out.println("7. Id của nhân viên ");
        System.out.println("8. Trình độ học vấn ");
        System.out.println("9. Vị trí trong công ty ");
        System.out.println("10. Lương khởi điểm");
        try {
            int chooseUser = Integer.parseInt(scanner.nextLine());
            switch (chooseUser) {
                case 1:
                System.out.println("Nhập tên mới:");
                String name = scanner.nextLine();
                employee.setName(name);
                break;
                case 2:
                    String dateOfBirth = menuModifier.checkDateOfBirth();
                    employee.setDateOfBirth(dateOfBirth);
                    break;
                case 3:
                    System.out.println("Nhập giới tính:");
                    String gender = scanner.nextLine();
                    employee.setGender(gender);
                    break;
                case 4:
                    System.out.println("Nhập số CMND: ");
                    String cmnd = scanner.nextLine();
                    employee.setCMND(cmnd);
                    break;
                case 5:
                    System.out.println("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    employee.setPhone(phone);
                    break;
                case 6:
                    System.out.println("Nhập email mới:");
                    String email = scanner.nextLine();
                    employee.setEmail(email);
                    break;
                case 7:
                    System.out.println("Nhập id mới của nhân viên: ");
                    String idEmployee = scanner.nextLine();
                    employee.setIdEmployee(idEmployee);
                case 8:
                    System.out.println("Nhập trình độ học vấn: ");
                    String level = menuModifier.getAcademicLevelOfEmployee();
                    employee.setLevel(level);
                    break;
                case 9:
                    System.out.println("Nhập vị trí trong công ty: ");
                    String position = menuModifier.getEmployeePosition();
                    employee.setPosition(position);
                    break;
                case 10:
                    System.out.println("Nhập lương khởi điểm: ");
                    String wage = scanner.nextLine();
                    employee.setWage(wage);
                    break;
                default:
                    System.out.println("Không có mục này !! Mời nhập lại: ");
                    chooseAndEditAttributeEmployee(employee);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai định dạng !! Mời bạn nhập lại: ");
            chooseAndEditAttributeEmployee(employee);
        }
    }
}
