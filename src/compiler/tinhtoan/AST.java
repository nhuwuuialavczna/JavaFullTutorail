package compiler.tinhtoan;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class AST {

    public static abstract class EXP {
        public static abstract class T {
            int index;
        }

        public static class Add extends T {
            T left, right;

            public Add(T left, T right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Sub extends T {
            T left, right;

            public Sub(T left, T right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Mul extends T {
            T left, right;

            public Mul(T left, T right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Div extends T {
            T left, right;

            public Div(T left, T right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Exponential extends T {
            T left, right;

            public Exponential(T left, T right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Number extends T {
            double value;

            public Number(double value, int index) {
                this.value = value;
                this.index = index;
            }
        }
    }
}
