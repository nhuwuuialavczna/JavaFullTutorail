package AI.game.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author JINX_NHI on 3/14/2018.
 */
public class Gui extends JPanel implements ActionMouse {
    /**
     * Trạng thái hiện tại
     * */
    private TicTacToeState state;

    public Gui() {
        state = new TicTacToeState(Player.TWO);
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 320, 320);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.fillRect(i * 100 + 1, j * 100 + 1, 98, 98);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Square square = state.boardCurrent[i][j];
                if (square != null) {
                    square.paintPlayer(g);
                }
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 100;
        int y = e.getY() / 100;
        state.placeAMove(new Square(x, y, Player.TWO), Player.TWO);
        if (MiniMax.isGameOver(state)) {
            System.out.println(state.currentPlayer);
        } else {
            state.placeAMove(MiniMax.returnBestMove(state), Player.ONE);
            if (MiniMax.isGameOver(state)) {
                System.out.println(state.currentPlayer);
                System.exit(0);
            }
        }
        this.repaint();

    }
}
