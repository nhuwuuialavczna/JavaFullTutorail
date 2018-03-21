package DesignPattern.demo.builder;

/**
 * @author  JINX_NHI on 3/21/2018.
 */
public class Main {
    public static void main(String[] args) {
        Office.Builder builder = new Office.Builder();
        Office office = builder.setAir(20)
                .setChair(30)
                .build();
        System.out.println(office);
    }
}
