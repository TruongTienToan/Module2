package org.example;

import org.example.view.CustomerView;
import org.example.view.ProductView;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

         ProductView productView = new ProductView();
         productView.launcher();


//        OrderView orderView = new OrderView();
//        orderView.laucher();6
//        CustomerView customerView = new CustomerView();
//        customerView.launcher();
    }
}
