package objects;

public class Student extends Person {
    private String mssv;

    public Student(String name, int age, String mssv) {
        super(name, age);
        this.mssv = mssv;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String toString() {
        return super.toString() + "\t" + mssv;
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
