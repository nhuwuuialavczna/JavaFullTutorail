package objects;

import java.util.List;

public class Lop {
    public String lop;
    public List<SinhVien> ds;

    public Lop(String lop, List<SinhVien> ds) {
        this.lop = lop;
        this.ds = ds;
    }

    @Override
    public String toString() {
        return lop+ "\t"+ ds;
    }
}
