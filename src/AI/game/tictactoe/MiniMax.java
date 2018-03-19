package AI.game.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author JINX_NHI on 3/14/2018.
 */
public class MiniMax {
    static List<SquareAndScore> squareAndScores;

    /**
     * @param state - kiểm tra trạng thái hiện tại có phải là end game chưa
     * */

    public static boolean isGameOver(TicTacToeState state) {
        return (hasXWon(state) || hasOWon(state) || state.getAvailableStates().isEmpty());
    }

    public static boolean hasXWon(TicTacToeState state) {
        Square[][] board = state.boardCurrent;
        if ((board[0][0].player.id == board[1][1].player.id && board[0][0].player.id == board[2][2].player.id && board[0][0].player.id == 1) ||
                (board[0][2].player.id == board[1][1].player.id && board[0][2].player.id == board[2][0].player.id && board[0][2].player.id == 1)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0].player.id == board[i][1].player.id && board[i][0].player.id == board[i][2].player.id && board[i][0].player.id == 1)
                    || (board[0][i].player.id == board[1][i].player.id && board[0][i].player.id == board[2][i].player.id && board[0][i].player.id == 1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasOWon(TicTacToeState state) {
        Square[][] board = state.boardCurrent;
        if ((board[0][0].player.id == board[1][1].player.id && board[0][0].player.id == board[2][2].player.id && board[0][0].player.id == 2) || (board[0][2].player.id == board[1][1].player.id && board[0][2].player.id == board[2][0].player.id && board[0][2].player.id == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0].player.id == board[i][1].player.id && board[i][0].player.id == board[i][2].player.id && board[i][0].player.id == 2) || (board[0][i].player.id == board[1][i].player.id && board[0][i].player.id == board[2][i].player.id && board[0][i].player.id == 2)) {
                return true;
            }
        }
        return false;
    }

    private static int returnMin(List<Integer> list) {
        return Collections.min(list);
    }

    private static int returnMax(List<Integer> list) {
        return Collections.max(list);
    }



    public static int minimax(TicTacToeState state, int depth, int turn) {
        if (hasXWon(state)) return 1;
        if (hasOWon(state)) return -1;
        List<Square> pointsAvailable = state.getAvailableStates();
        if (pointsAvailable.isEmpty()) return 0;
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Square square = pointsAvailable.get(i);
            if (turn == 1) { //X's turn select the highest from below game.tictactoe() call
                state.placeAMove(square, Player.ONE);
                int currentScore = minimax(state, depth + 1, 2);
                scores.add(currentScore);
                if (depth == 0) {
                    squareAndScores.add(new SquareAndScore(square, currentScore));
                }
            } else if (turn == 2) {//O's turn select the lowest from below game.tictactoe() call
                state.placeAMove(square, Player.TWO);
                scores.add(minimax(state, depth + 1, 1));
            }
            state.boardCurrent[square.x][square.y] = new Square(); //Reset this point
        }
        return turn == 1 ? returnMax(scores) : returnMin(scores);
    }

    public static Square returnBestMove(TicTacToeState state) {
        callMinimax(state, 0, 1);
        int MAX = -100000;
        int best = -1;

        for (int i = 0; i < squareAndScores.size(); ++i) {
            if (MAX < squareAndScores.get(i).score) {
                MAX = squareAndScores.get(i).score;
                best = i;
            }
        }
        return squareAndScores.get(best).square;
    }
    // endregion

    // region Minmax
    public static void callMinimax(TicTacToeState state, int depth, int turn) {
        squareAndScores = new ArrayList<>();
        minimax(state, depth, turn);
    }

}
