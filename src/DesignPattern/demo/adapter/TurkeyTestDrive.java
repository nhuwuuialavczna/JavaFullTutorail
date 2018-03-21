package DesignPattern.demo.adapter;

public class TurkeyTestDrive {
    public static void main(String[] args) {
        VitTroi vitTroi = new VitTroi();
        GaTay duckAdapter = new VitAdapter(vitTroi);
        for (int i = 0; i < 10; i++) {
            System.out.println("The VitAdapter says...");
            duckAdapter.anTap();
            duckAdapter.bay();
        }
    }
}