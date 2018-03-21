package AI.demo.dequy;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class ThapHaNoi {

    public static void main(String[] args) {
        hanoi(2, 'A', 'C', 'B');
    }

    public static void hanoi(int n, char start, char finish, char spare) {
        if (n == 1) {
            System.out.format("Move a disk from '%c' to '%c'\n", start, finish);
            return;
        } else {
            hanoi(n - 1, start, spare, finish);
            hanoi(1, start, finish, spare);
            hanoi(n - 1, spare, finish, start);
        }
    }

}
