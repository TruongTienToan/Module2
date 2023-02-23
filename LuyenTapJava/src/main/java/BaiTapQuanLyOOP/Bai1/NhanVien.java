package BaiTapQuanLyOOP.Bai1;

public class NhanVien extends CanBo {
    private String task;

    public NhanVien(String task) {
        this.task = task;
    }

    public NhanVien(String fullname, int age, String gender, String address, String task) {
        super(fullname, age, gender, address);
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Nhân viên{" +
                "công việc='" + task + '\'' +
                ", họ tên='" + fullname + '\'' +
                ", tuổi=" + age +
                ", giới tính='" + gender + '\'' +
                ", điạ chỉ='" + address + '\'' +
                '}';
    }
}
