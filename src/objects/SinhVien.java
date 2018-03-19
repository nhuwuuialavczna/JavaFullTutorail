package objects;

public class SinhVien {
    public String name;
    public int tuoi;

    public SinhVien(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return name + "\t" + tuoi;
    }
}
