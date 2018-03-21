package compiler.TinhToan2.test;

import compiler.TinhToan2.semantic.Semanctic;

public class TestSematic {
    public static void main(String[] args) {
        Semanctic semanctic = new Semanctic("2 ^ sqrt(3+2*3) * 6 / 2");
        System.out.println(Math.pow(2, Math.sqrt(3 + 2 * 3)) * 6 / 2);
        System.out.println(semanctic.culc());
    }
}
