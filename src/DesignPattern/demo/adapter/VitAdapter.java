package DesignPattern.demo.adapter;

import java.util.Random;

public class VitAdapter implements GaTay {
    Vit vit;
    Random rand;

    public VitAdapter(Vit vit) {
        this.vit = vit;
        rand = new Random();
    }

    public void anTap() {
        vit.quack();
    }

    public void bay() {
        if (rand.nextInt(5) == 0) {
            vit.bay();
        }
    }
}