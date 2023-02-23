package BaiTapQuanLyOOP.Bai1;

public class CongNhan extends CanBo{
    private int rank;

    public CongNhan(int rank) {
        this.rank = rank;
    }

    public CongNhan(String fullname, int age, String gender, String address, int rank) {
        super(fullname, age, gender, address);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Công nhân{"
                + "Bậc=" + rank
                + ", Họ tên=" + fullname
                + ", tuổi =" + age
                + ", giới tính= " + gender
                + ", địa chỉ=" + address
                + "}";
    }
}
