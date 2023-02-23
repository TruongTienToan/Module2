package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer extends Person{
    private String idCustomer;
    private String customerType;
    private String address;

    public Customer() {

    }

    public Customer(String idCustomer, String customerType, String address) {
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String name, String dateOfBirth, String gender, String CMND, String phone, String email, String idCustomer, String customerType, String address) {
        super(name, dateOfBirth, gender, CMND, phone, email);
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String showInfo() {
        return super.showInfo() +
                ", " + idCustomer +
                ", " + customerType +
                ", " + address;
    }

    @Override
    public int compareTo(Customer o) {
        return LocalDate.parse(this.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).compareTo(LocalDate.parse(o.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
