package AI.game.tictactoe;

/**
 * @author JINX_NHI on 3/14/2018.
 */
public class SquareAndScore {

    public Square square;
    public int score;

    public SquareAndScore() {
    }

    public SquareAndScore(Square square, int score) {
        this.square = square;
        this.score = score;
    }

    public SquareAndScore(Square square) {
        this.square = square;
        this.score = -1;
    }
}
