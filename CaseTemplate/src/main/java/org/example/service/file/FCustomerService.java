package org.example.service.file;

import org.example.model.Customer;
import org.example.model.CustomerType;
import org.example.service.ICustomerService;
import org.example.service.implement.CustomerServiceImpl;
import org.example.utils.DateUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FCustomerService implements ICustomerService {
    private final String pathCustomer = "./data/customer.csv";
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathCustomer);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                // line: 1L,Quang Dang,0399578134,28 NTP,20-12-2023 08:00,0,NORMAL
                String[] items = line.split(",");
                Customer customer = new Customer();
                customer.setId(Long.parseLong(items[0]));
                customer.setName(items[1]);
                customer.setPhone(items[2]);
                customer.setAddress(items[3]);
                customer.setCreateAt(DateUtils.parseDate(items[4]));
                customer.setConsumed(Double.parseDouble(items[5]));
                customer.setCustomerType(CustomerType.parseToCustomerType(items[6]));

                customers.add(customer);
            }
            fileReader.close();
            bufferedReader.close();
            return customers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer findCustomerById(long idCustomer) {
        List<Customer> customers = getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == idCustomer) {
                return customers.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(long idCustomer, Customer customer) {
        List<Customer> customers = getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == idCustomer) {
                customers.get(i).setName(customer.getName());
                customers.get(i).setAddress(customer.getAddress());
                customers.get(i).setConsumed(customer.getConsumed());
                customers.get(i).setCreateAt(customer.getCreateAt());
                customers.get(i).setPhone(customer.getPhone());
                customers.get(i).setCustomerType(customer.getCustomerType());
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(pathCustomer);
            for (int i = 0; i < customers.size(); i++) {
                Customer c = customers.get(i);
                fileWriter.write(c.toString());
                if (i != customers.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


//Thêm khách hàng va lưu vao file


    }

    @Override
    public void addCustomer(Customer customer) {
        List<Customer> customers = getAllCustomers();
        long lastId = 1;
        if(customers.size()!=0){
            Customer lastCustomer = customers.get(customers.size()-1);
            lastId = lastCustomer.getId()+1;
        }
        customer.setId(lastId);
        customers.add(customer);

        try {
            FileWriter fileWriter = new FileWriter(pathCustomer);
            for (int i = 0; i < customers.size(); i++) {
                Customer c = customers.get(i);
                fileWriter.write(c.toString());
                if (i != customers.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(long idCustomer) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = getAllCustomers();
        System.out.println("Nhập id khách hàng cần xóa: ");
        long id = Long.parseLong(scanner.nextLine());
        Customer customer = findCustomerById(id);
        if (customer != null) {
            customers.remove(customer);
        }
        try {
            FileWriter fileWriter = new FileWriter(pathCustomer);
            for (int i = 0; i < customers.size(); i++) {
                Customer c = customers.get(i);
                fileWriter.write(c.toString());
                if (i != customers.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }


}
