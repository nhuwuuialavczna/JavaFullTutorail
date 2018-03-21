package objects;

public class SinhVien implements Comparable<SinhVien> {
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

    @Override
    public int compareTo(SinhVien o) {
        if (tuoi > o.tuoi) return 1;
        if (tuoi < o.tuoi) return -1;
        return 0;
    }
}
