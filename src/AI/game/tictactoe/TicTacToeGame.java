package AI.game.tictactoe;

import javax.swing.*;

/**
 * @author JINX_NHI on 3/14/2018.
 */
public class TicTacToeGame extends JFrame {

    public TicTacToeGame() {
        add(new Gui());
        setSize(320, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToeGame();
    }
}
