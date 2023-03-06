package org.example.view;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.IUserService;
import org.example.service.impl.UserService;
import org.example.utils.AppUtils;
import org.example.utils.InstantUtils;
import org.example.utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private IUserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public UserView() {
        this.userService = UserService.getInstance();
    }

    public void deleteUser(InputOption inputOption) {
        showUsers(InputOption.SHOW);
        System.out.println("Nhập id ngươời dùng muốn xóa: ");
        int idUser = inputId(InputOption.DELETE);
        userService.deleteUser(idUser);
        System.out.println("Xóa người dùng thành công!");
        showUsers(InputOption.SHOW);
    }

    public void updateUser() {
        boolean isRetry = false;
        do {
            try {
                showUsers(InputOption.UPDATE);
                //Neu Id khong Ton tai se khong thoat ra khoi vong lap trong ham inputId
                long id = inputId(InputOption.UPDATE);
                System.out.println("\t============== SỬA ==============\n"
                        + "\t|                               |\n"
                        + "\t|     1. Đổi tên                |\n"
                        + "\t|     2. Đổi số điện thoại      |\n"
                        + "\t|     3. Đổi địa chỉ            |\n"
                        + "\t|     4. Đổi gmail              |\n"
                        + "\t|     5. Quay lại               |\n"
                        + "\t|                               |\n"
                        + "\t=================================");
                int option = AppUtils.retryChoose(1, 5);
                User newUser = new User();
                newUser.setId(id);
                switch (option) {
                    case 1:
                        String name = inputFullname(InputOption.UPDATE);
                        newUser.setFullName(name);
                        userService.update(newUser);
                        System.out.println("Bạn đã đổi tên thành công!");
                        break;
                    case 2:
                        String phone = inputPhone(InputOption.UPDATE);
                        newUser.setMobile(phone);
                        userService.update(newUser);
                        System.out.println("Bạn đã đổi số điện thoại thành công");
                        break;
                    case 3:
                        String address = inputAddress(InputOption.UPDATE);
                        newUser.setAddress(address);
                        userService.update(newUser);
                        System.out.println("Bạn đã đổi địa chỉ thành công");
                        break;
                    case 4:
                        String email = inputEmail();
                        newUser.setEmail(email);
                        userService.update(newUser);
                        System.out.println("Bạn đã đổi email thành công");
                        break;
                    case 5:
                        UserMenuView.launch();
                        break;
                }
//                isRetry = option != 5 && AppUtils.isRetry(InputOption.UPDATE );
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (isRetry);
    }

    public void showUsers(InputOption inputOption) {
        System.out.println("----------------------------------------------------------------------------- DANH SÁCH NGƯỜI DÙNG ----------------------------------------------------------------------------");
        System.out.printf("\t%-18s %-17s %-28s %-25s %-18s %-18s %-22s %-13s \n", "ID", "Tên", "Số điện thoại", "Email", "Địa chỉ", "Người dùng", "Ngày tạo", "Ngày cập nhật");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.printf(" %-13d |  %-19s |   %-15s |   %-22s   |  %-20s  |    %-8s  | %20s | %20s |\n",
                    user.getId(),
                    user.getFullName(),
                    user.getMobile(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instantToString(user.getCreatedAt()),
                    user.getUpdatedAt() == null ? "" : InstantUtils.instantToString(user.getUpdatedAt())
            );
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        if (inputOption == InputOption.SHOW)
            AppUtils.isRetry(InputOption.SHOW);
    }

    private int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập id: ");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = userService.existById(id);
            switch (option) {
                case ADD:
                    if(exist)
                        System.out.println("ID này đã tồn tại! Vui lòng nhập id khác");
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist)
                        System.out.println("Không tìm thấy ID! Vui lòng nhập lại");
                    isRetry = !exist;
                    break;
            }
        }while (isRetry);
        return id;
    }

    public void addUser() {
        do {
            try {
                String username = inputUsername();
                String password = inputPassword();
                String fullName = inputFullname(InputOption.ADD);
                String phone = inputPhone(InputOption.ADD);
                String address = inputAddress(InputOption.ADD);
                String email = inputEmail();
                User newUser = new User(username.trim(), password.trim(), fullName.trim(), phone.trim(), email.trim(), address.trim(), Role.USER);
                setRole(newUser);
                userService.add(newUser);
                System.out.println("Đã thêm thành công!");
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            }
        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void setRole(User newuser) {
        System.out.println("=== SET ROLE ===");
        System.out.println("∥              ∥");
        System.out.println("∥   1. USER    ∥");
        System.out.println("∥   2. ADMIN   ∥");
        System.out.println("∥              ∥");
        System.out.println("================");
        System.out.println("Chọn Role: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                newuser.setRole(Role.USER);
                break;
            case 2:
                newuser.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("Nhập không đúng! Vui lòng nhập lại");
                setRole(newuser);
        }
    }

    public String inputEmail() {
        System.out.println("Nhập email (vd: truongtoan238@gmail.com)");
        String email;
        do {
            // email phai dung dinh dang
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("Email " + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.println("Nhập email (vd: truongtoan238@gmail.com)");
                continue;
            }
            // email co ton tai hay khong
            if (userService.existsByEmail(email)) {
                System.out.println("Email " + email + "của bạn đã tồn tại! Vui lòng nhập lại");
                System.out.println("Nhập email (vd: truongtoan238@gmail.com): ");
                continue;
            }
            while (email.trim().equals("")){
                System.out.println("Email không được để trống:");
                email = scanner.nextLine();
            }
            break;
        } while (true);
        return email;
    }

    public String inputAddress(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập địa chỉ (Vidu: Huế): ");
                break;
            case UPDATE:
                System.out.println("Nhập địa chỉ bạn muốn đổi: ");
                break;
        }
        String adress = scanner.nextLine();
        while (adress.trim().equals("")) {
            System.out.println("Địa chỉ không được để trống: ");
            adress = scanner.nextLine();
        }
        return adress;
    }

    public String inputPhone(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số điện thoại: (vd: 0932357659): ");
                break;
            case UPDATE:
                System.out.println("Nhập số điện thoại muốn đổi: ");
                break;
        }
        String phone;
        do {
            if (!ValidateUtils.isPhoneValid(phone = scanner.nextLine())) {
                System.out.println("Số " + phone + "của bạn không đúng! Vui lòng nhập lại! (Số điện thoại phải 10 số và bắt đầu từ 0)");
                System.out.println("Nhập số điện thoại (Vidu: 0932357659): ");
                continue;
            }
            if (userService.existsByPhone(phone)) {
                System.out.println("Số này đã tồn tại! Mời bạn nhập lại: ");
                continue;
            }
            break;
        } while (true);
        return phone;
    }

    public String inputFullname(InputOption option) {

        switch (option) {
            case ADD:
                System.out.println("Nhập họ tên (Vidu: Trương Toàn): ");
                break;
            case UPDATE:
                System.out.println("Nhập tên mà bạn muốn đổi: ");
                break;
        }
        String fullName;
        while (!ValidateUtils.isNameValid(fullName = scanner.nextLine())) {
            System.out.println("Tên" + fullName + "không đúng định dạng! Vui lòng nhập lại. (tên phải viết hoa chữ cái đầu)");
            System.out.println("Nhập tên: (vd: Trương Toàn): ");
        }
        return fullName;
    }

    public String inputPassword() {
        System.out.println("Nhập mật khẩu (mật khẩu phải > 6 kí tự): ");
        String password;
        while (!ValidateUtils.isPasswordValid(password = scanner.nextLine())) {
            if (password.trim().equals("")) {
                System.out.println("mật khẩu không được để trống: ");
                continue;
            }
            System.out.println("Mật khẩu yếu! Vui lòng nhập lại: ");
        }
        return password;
    }

    public String inputUsername() {
        System.out.println("Nhập Username (in hoa kí tự đầu, Username ít nhất 4 chữ): ");
        String username;

        do {
            if (!ValidateUtils.isUsernameValid(username = AppUtils.retryString("username"))) {
                System.out.println(username + " của bạn không đúng định dạng! Vui lòng nhập lại: ");
                continue;
            }
            if (userService.existsByUserName(username)) {
                System.out.println("Username này đã tồn tại! Vui lòng nhập lại: ");
                continue;
            }
            break;
        } while (true);
        return username;
    }
}
