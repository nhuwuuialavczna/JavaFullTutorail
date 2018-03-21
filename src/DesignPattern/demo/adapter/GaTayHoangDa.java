package DesignPattern.demo.adapter;

public class GaTayHoangDa implements GaTay {
    public void anTap() {
        System.out.println("Gobble gobble");
    }

    public void bay() {
        System.out.println("I'm flying a short distance");
    }
} 