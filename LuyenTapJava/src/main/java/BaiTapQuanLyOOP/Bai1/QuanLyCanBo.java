package BaiTapQuanLyOOP.Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyCanBo {
    private List<CanBo> canBos;

    public QuanLyCanBo() {
        this.canBos = new ArrayList<>();
    }

    public void addCanBo(CanBo canBo) {
        this.canBos.add(canBo);
    }

    public List<CanBo> searchCanBoByName(String name) {
        return this.canBos.stream().filter(canBo -> canBo.getFullname().contains(name)).collect(Collectors.toList());
    }

    public void ShowListCanBo() {
        this.canBos.forEach(canBo -> System.out.println(canBo.toString()));
    }
}
