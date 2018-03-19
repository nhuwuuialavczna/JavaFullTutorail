package Collection.function;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class VS implements Serializable {
    private String name;
    private int tuoi;

    public VS(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public boolean equals(Object obj) {
        VS sv = (VS) obj;
        return name.equals(sv.name) && tuoi == sv.tuoi;
    }

    @Override
    public String toString() {
        return name + "\t" + tuoi;
    }

    public static void main(String[] args) {
        VS sv1 = new VS("A", 1);
        VS sv2 = new VS("B", 2);
        VS sv3 = new VS("C", 3);

        List<VS> ds = Arrays.asList(sv1, sv2, sv3);

        System.out.println(ds.contains(new VS("A", 1)));


    }
}
