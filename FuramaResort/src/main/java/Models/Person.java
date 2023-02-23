package Models;

public abstract class Person {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String CMND;
    private String phone;
    private String email;

    public Person() {

    }

    public Person(String name, String dateOfBirth, String gender, String CMND, String phone, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.CMND = CMND;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String showInfo() {
        return
                name +
                        ", " + dateOfBirth +
                        ", " + gender +
                        ", " + CMND +
                        ", " + phone +
                        ", " + email;
    }

    public abstract int compareTo(Customer o);
}
