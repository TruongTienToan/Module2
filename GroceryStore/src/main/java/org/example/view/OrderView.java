package org.example.view;

import org.example.model.Order;
import org.example.model.OrderItem;
import org.example.model.Product;
import org.example.service.IOderItemService;
import org.example.service.IOderService;
import org.example.service.IProductService;
import org.example.service.impl.OrderItemService;
import org.example.service.impl.OrderService;
import org.example.service.impl.ProductService;
import org.example.utils.InstantUtils;
import org.example.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private final Scanner scanner = new Scanner(System.in);
    private final IProductService productService;
    private final IOderService oderService;
    private final IOderItemService oderItemService;

    public OrderView() {
        productService = ProductService.getInstance();
        oderItemService = OrderItemService.getInstance();
        oderService = OrderService.getInstance();
    }

    public List<OrderItem> addOderItems(long orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        ProductView productView = new ProductView();
        productView.showProduct();
        System.out.println("Nhập số lượng đơn hàng mà bạn muốn mua: ");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 0) {
            System.out.println("Số lượng đơn hàng không được âm:");
            choice = Integer.parseInt(scanner.nextLine());
        }
        int count = 0;
        do {
            try {
                orderItems.add(addOderItem(orderId));
                count++;
            } catch (Exception e) {
                System.out.println("Không đúng! Vui lòng nhập lại.");
            }
        } while (count < choice);
        return orderItems;
    }

    public void addOrder() {
        try {
            oderItemService.findAll();
            long orderId = System.currentTimeMillis()/1000;
            System.out.println("Nhập tên (Vidu: Trương Toàn): ");
            String name = scanner.nextLine();
            while (name.trim().isEmpty()) {
                System.err.println("Tên của bạn đang được để trống: ");
                name =scanner.nextLine();
            }
            System.out.println("Nhập số điện thoại (từ 10 đến 11 số) : ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone) || phone.trim().isEmpty()) {
                System.out.println("Số điện thoại: " + phone + " không đúng định dạng! Vui lòng nhập lại");
                System.out.println("Nhập lại số điện thoại, phải đủ 10 số: ");
                phone = scanner.nextLine();
            }
            System.out.println("Nhập địa chỉ của bạn: ");
            String address = scanner.nextLine();
            while (address.trim().isEmpty()) {
                System.out.println("Địa chỉ của bạn không được để trống! Vui lòng nhập lại: ");
                address = scanner.nextLine();
            }
            Order order = new Order(orderId, name, phone, address);
            List<OrderItem> orderItems = addOderItems(orderId);
            for (OrderItem orderItem : orderItems) {
                oderItemService.add(orderItem);
            }
            oderService.add(order);
            System.out.println("Đã tạo order thành công: \n" +
                    "\t======================================\n" +
                    "\t|                                    |\n" +
                    "\t|           1. In bill               |\n" +
                    "\t|           2. Quay lai              |\n" +
                    "\t|           3. Exit                  |\n" +
                    "\t|                                    |\n" +
                    "\t======================================\n\n" +
                    "Xin mời chọn chức năng: ");
            do {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            showBillInfo(order);
                            break;
                        case 2:
                            OrderViewLauncher orderViewLauncher = new OrderViewLauncher();
                            orderViewLauncher.launch();
                            break;
                        case 3:
                            MainLauncher.launch();
                            break;
                        default:
                            System.out.println("Không có chức năng! Vui lòng nhập lại");

                }
                } catch (InputMismatchException e) {
                    System.out.println("Nhập sai! Vui lòng nhập lại");
                }
            } while (true);
        } catch (Exception e) {
            System.err.println("Nhập không đúng! Vui lòng nhập lại.");;
        }
    }



    public OrderItem addOderItem(long orderId) {
        do {
            try {
                oderItemService.findAll();
                ProductView productView = new ProductView();
                productView.showProduct();
                long id = System.currentTimeMillis() / 1000;
                System.out.println("Nhập id bạn muốn mua: ");
                int techsId = Integer.parseInt(scanner.nextLine());
                while (!productService.existById(techsId)) {
                    System.out.println("ID sản phẩm không tồn tại! Vui lòng nhập lại: ");
                    techsId = Integer.parseInt(scanner.nextLine());
                }
                Product product = productService.findById(techsId);
                double price = product.getPrice();
                System.out.println("Nhập số lượng sản phẩm bạn muốn mua: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                while (!checkQuantityProduct(product, quantity)) {
                    System.out.println("Số lượng không đủ! Vui lòng mua lại: ");
                    quantity = Integer.parseInt(scanner.nextLine());
                    if (product.getQuantity() == 0)
                        QToContinueTToExist();
                }
                String productName = product.getTitle();
                double total = quantity * price;
                OrderItem orderItem = new OrderItem(id, price, quantity,orderId, techsId, productName, total);
                productService.updateQuantity(techsId, quantity);
                return orderItem;
            } catch (Exception e) {
                System.out.println("Nhập không đúng! Vui lòng nhập lại.");
            }
        } while (true);
    }

    public void showBillInfo(Order order) {
        try {
            System.out.println("\t\t\t\t┌───────────────────────────────────────────────────────────────────────────┐");
            System.out.println("\t\t\t\t│░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ HÓA ĐƠN ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░│");
            System.out.println("\t\t\t\t├───────────────────────────┬───────────────────────────────────────────────┤");
            System.out.printf("\t\t\t\t│\t%-20s\t %-25s %16s │\n", "Tên đầy đủ      :       │", order.getFullName(), "");
            System.out.printf("\t\t\t\t│\t%-20s\t %-25s %16s │\n", "Số điện thoại   :       │", order.getMobile(), "");
            System.out.printf("\t\t\t\t│\t%-20s\t %-25s %16s │\n", "Địa chỉ         :       │", order.getAddress(), "");
            System.out.printf("\t\t\t\t│\t%-20s\t %-25s %16s │\n", "Ngày tạo        :       │", InstantUtils.instantToString(order.getCreatedAt()), "");
            System.out.println("\t\t\t\t├────┬───────────────────┬──┴──────────────────────────┬────────────────────┤");
            System.out.printf("\t\t\t\t│%-4s│%-17s\t │%-28s │%-19s │\n", "STT", "Tên sản phẩm", "Số lượng", "Giá");
            System.out.println("\t\t\t\t├────┼───────────────────┼─────────────────────────────┼────────────────────┤");
            List<OrderItem> orderItems = oderItemService.findAll();
            double sum = 0;
            int count = 0;
            for (OrderItem orderItem1 : orderItems) {
                if (orderItem1.getOrderId() == order.getId()) {
                    sum += orderItem1.getTotal();
                    count++;
                    orderItem1.setGrandTotal(sum);
                    oderItemService.update(orderItem1.getOrderId(), orderItem1.getPrice(), sum);
                    System.out.printf("\t\t\t\t│ %1s  │  %-17s│\t %-25s │  %-18s│\n",
                            count,
                            orderItem1.getProductName(),
                            orderItem1.getQuantity(),
                            InstantUtils.doubleToVND(orderItem1.getPrice()));
                    System.out.println("\t\t\t\t├────┴───────────────────┴─────────────────────────────┴────────────────────┤");
                }
            }
            System.out.println("\t\t\t\t├────┴───────────────────┴─────────────────────────────┴────────────────────┤");
            System.out.printf("\t\t\t\t│                                                  Tổng: %17s  │\n",InstantUtils.doubleToVND(sum));
            System.out.println("\t\t\t\t└───────────────────────────────────────────────────────────────────────────┘\n\n");
            QToContinueTToExist();
        } catch (Exception e) {
            System.err.println("Nhập không đúng! Vui lòng nhập lại.");
        }
    }

    public void showListOrder() {
        List<Order> orders = oderService.findAll();
        List<OrderItem> orderItems = oderItemService.findAll();
        OrderItem newOrderItem = new OrderItem();
        List<OrderItem> orderItemList = new ArrayList<>();
        try {
            int count = 0;
            double printTotal = 0;
            double total = 0;
            double sum = 0;
            double grandTotal = 0;
            System.out.println("──────────────────────────────────────────────────────────── DANH SÁCH HÓA ĐƠN ─────────────────────────────────────────────────────────────────────");
            for (Order order : orders) {
                for (OrderItem orderItem : orderItems) {
                    if (orderItem.getOrderId() == order.getId()) {
                        newOrderItem = orderItem;
                        orderItemList.add(newOrderItem);
                        double price = orderItem.getPrice();
                        int quantity = orderItem.getQuantity();
                        sum = price * quantity;
                        grandTotal += sum;
                    }
                }
                newOrderItem.setGrandTotal(grandTotal);
                oderItemService.update(newOrderItem.getOrderId(), newOrderItem.getPrice(), grandTotal);
                System.out.println("\t┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                System.out.printf("\t│\t%-20s%-20s%-30s%-20s%-25s%-25s│\n", "Id            : ", order.getId(), " ", "Tên khách hàng :", order.getFullName(), "");
                System.out.printf("\t│\t%-20s%-20s%-30s%-20s%-25s%-25s│\n", "Số điện thoại : ", order.getMobile(), " ", "Địa chỉ        : ", order.getAddress(), "");
                System.out.println("\t├───────┬───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
                System.out.printf("\t│\t%-1s │%-19s%-20s%-10s%-15s%-15s%-10s%-10s%-15s %-15s %-1s│\n", "STT", "", "Tên sản phẩm", "", "", "Số lượng", "", "Giá", "  ", "Tổng tiền sản phẩm", "");
                System.out.println("\t├───────┼───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");

                for (OrderItem orderItem : orderItemList) {
                    count++;
                    total = orderItem.getPrice() * orderItem.getQuantity();
                    System.out.printf("\t│\t%-3d │%-1s%-20s%-20s%-10s%-15s%-15d%-10s%-18s%-11s%14s\t│\n", count, "", "", orderItem.getProductName(), " ", "", orderItem.getQuantity()
                            , "", InstantUtils.doubleToVND(orderItem.getPrice())
                            , "", InstantUtils.doubleToVND(total));
                }
                orderItemList.clear();
                printTotal += grandTotal;
                System.out.printf("\t└───────┴──────────────────────────────────────────────────────────────────────────────────────────────────── Tổng đơn:  %15s ───────┘\n\n\n", InstantUtils.doubleToVND(grandTotal));
                sum = 0;
                grandTotal = 0;
                count = 0;
            }
            System.out.printf("\t\t\t\t\t\t\t┌────────────────── Tổng doanh thu: %15s ────────────────────────┐\n", InstantUtils.doubleToVND(printTotal));
            System.out.println("\t\t\t\t\t\t\t└─────────────────────────────────────────────────────────────────────────────────────┘ \n");
            QToContinueTToExist();
        } catch (Exception e) {
            System.out.println("Nhập không đúng! Vui lòng nhập lại");
        }
    }

    public boolean checkQuantityProduct(Product product, int quantity) {
        if (quantity <= product.getQuantity())
            return true;
        return false;
    }

    public void QToContinueTToExist() {
        boolean is = true;
        do {
            System.out.println("Nhấn 'q' để quay lại \t|\t nhấn 't' để thoát chương trình: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "q":
                    OrderViewLauncher orderViewLauncher = new OrderViewLauncher();
                    orderViewLauncher.launch();
                    break;
                case "t":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập không đúng chức năng! Vui lòng nhập lại");
                    is = false;
                    break;
            }
        } while (!is);
    }
}
