package objects;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
//        int[] a = {1, 5, 6}; // a 1,5,6
//        int[] b = a; // b 1,5,6
//        a = new int[2]; // a 0,0,0
//        for (int i = 0; i < 2; i++) {
//            a[i] = 0;
//        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = a;
        a = new int[][]{{0, 0}, {1, 1}};

        for (int i = 0; i < a.length; i++) {
            
        }

        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(b));

    }
}
