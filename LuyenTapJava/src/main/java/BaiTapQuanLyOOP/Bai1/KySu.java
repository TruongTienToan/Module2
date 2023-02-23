package BaiTapQuanLyOOP.Bai1;

public class KySu extends CanBo{
    private String branch;

    public KySu(String branch) {
        this.branch = branch;
    }

    public KySu(String fullname, int age, String gender, String address, String branch) {
        super(fullname, age, gender, address);
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Kỹ sư{" +
                "nghành đào tạo='" + branch + '\'' +
                ", Họ tên='" + fullname + '\'' +
                ", tuổi=" + age +
                ", giới tính='" + gender + '\'' +
                ", địa chi='" + address + '\'' +
                '}';
    }
}
