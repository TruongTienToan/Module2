package BaiTapQuanLyOOP.Bai1;

public class CanBo {
    protected String fullname;
    protected int age;
    protected String gender;
    protected String address;

    public CanBo() {

    }

    public CanBo(String fullname, int age, String gender, String address) {
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
