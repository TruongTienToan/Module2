package Models;

import java.lang.String;

public class Employee extends Person{
    private String idEmployee;
    private String level;
    private String position;
    private String wage;

    public Employee() {

    }

    public Employee(String idEmployee, String level, String position, String wage) {
        this.idEmployee = idEmployee;
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public Employee(String name, String dateOfBirth, String gender, String CMND, String phone, String email, String idEmployee, String level, String position, String wage) {
        super(name, dateOfBirth, gender, CMND, phone, email);
        this.idEmployee = idEmployee;
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    @Override
    public String showInfo() {
        return super.showInfo() +
                ", " + idEmployee +
                ", " + level +
                ", " + position +
                ", " + wage;
    }

    @Override
    public int compareTo(Customer o) {
        return 0;
    }
}
