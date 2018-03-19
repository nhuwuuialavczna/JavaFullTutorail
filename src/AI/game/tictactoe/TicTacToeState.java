package AI.game.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JINX_NHI on 3/14/2018.
 */
public class TicTacToeState {

    public Square[][] boardCurrent;
    public Player currentPlayer;
    private List<Square> listMove;

    public TicTacToeState(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        listMove = new ArrayList<>();
        boardCurrent = new Square[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                boardCurrent[i][j] = new Square();
            }
        }
        if (currentPlayer == Player.ONE) {
            placeAMove(new Square(1, 1, Player.ONE), Player.ONE);
        }

    }

    public void placeAMove(Square square, Player player) {
        listMove.add(square);
        if (!MiniMax.isGameOver(this)) {
            this.currentPlayer = player;
        } else
            this.currentPlayer = currentPlayer.changePlayer();
        square.player = player;
        this.boardCurrent[square.x][square.y] = square;
    }

    public List<Square> getListMove() {
        return listMove;
    }

    public List<Square> getAvailableStates() {
        List<Square> availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (boardCurrent[i][j].player == Player.NONE) {
                    availablePoints.add(new Square(i, j, Player.NONE));
                }
            }
        }
        return availablePoints;
    }

}
