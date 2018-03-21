package AI.demo.minimax;

import AI.game.caro.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author JINX_NHI on 3/20/2018.
 */


public class TicTacToeTest {
    TicTacToe ticTacToe = new TicTacToe();

    @Test
    public void testDanhCo() {
        ticTacToe.danhCo(1, 1, 2);
        ticTacToe.danhCo(0, 0, 1);
        ticTacToe.danhCo(1, 0, 2);
//        ticTacToe.danhCo(1, 2, 1);
//        ticTacToe.danhCo(2, 1, 2);
//        ticTacToe.danhCo(0, 1, 1);
//        ticTacToe.danhCo(2, 2, 2);
        String minimax = "M";
        String alphatbeta = "A";
        Point bestMove = ticTacToe.getBestMove(minimax);
        System.out.println(bestMove);

    }
}
