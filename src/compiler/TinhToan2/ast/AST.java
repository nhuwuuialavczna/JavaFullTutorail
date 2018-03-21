package compiler.TinhToan2.ast;

/**
 * @author JINX_NHI on 2/26/2018.
 */
public class AST {

    public static abstract class Exp {
        public static abstract class T {
            public int index;
        }

        public static class Add extends T {
            public T left;
            public T right;

            public Add(T left, T right,int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }
        public static class Sub extends T {
            public T left;
            public T right;

            public Sub(T left, T right,int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }
        public static class Mul extends T {
            public T left;
            public T right;

            public Mul(T left, T right,int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }
        public static class Div extends T {
            public T left;
            public T right;

            public Div(T left, T right,int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Mod extends T {
            public T left;
            public T right;

            public Mod(T left, T right,int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Exponential extends T {
            public T left, right;

            public Exponential(T left, T right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }




        public static class Rational extends T {
            public T left, right;

            public Rational(T left, T right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
            }
        }

        public static class Tan extends T {
            public T body;

            public Tan(T body, int index) {
                this.body = body;
                this.index = index;
            }
        }
        public static class Sin extends T {
            public T body;

            public Sin(T body, int index) {
                this.body = body;
                this.index = index;
            }
        }
        public static class Cos extends T {
            public T body;

            public Cos(T body, int index) {
                this.body = body;
                this.index = index;
            }
        }
        public static class SQRT extends T {
            public T body;

            public SQRT(T body, int index) {
                this.body = body;
                this.index = index;
            }
        }

        public static class Number extends T {
            public double value;

            public Number(double value, int index) {
                this.value = value;
                this.index = index;
            }
        }

        public static class PI extends T {
            public double value;

            public PI(double value, int index) {
                this.value = Math.PI;
            }
        }
        public static class EpxSub extends T {
            public T body;

            public EpxSub(T body, int index) {
                this.body = body;
                this.index = index;
            }
        }
    }

}
