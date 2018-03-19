package AI.game.caro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * @author JINX_NHI on 3/15/2018.
 */
public class CaroUI extends JPanel implements ActionMouse, ActionListener {

    Player Human;
    Player computer;
    BoardState boardState;
    Player player;
    GetImg getImg = GetImg.inst;

    public CaroUI() {
        boardState = new BoardState(30, 30);
        addMouseListener(this);
        Human = new PlayerHuman(boardState);
        computer = new AIGame(boardState);

    }

    public Point AI(int player) {
        System.out.println("TIm kiem");
        return this.player.movePoint(player);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.WHITE);

        for (int i = 0; i < boardState.width; i++) {
            for (int j = 0; j < boardState.width; j++) {
                g.fillRect(i * 20 + 1, j * 20 + 1, 18, 18);
            }
        }


        for (int i = 0; i < boardState.width; i++) {
            for (int j = 0; j < boardState.height; j++) {
                if (boardState.boardArr[i][j] == 1) {
                    g.drawImage(getImg.imageX, i * 20 + 1, j * 20 + 1, 18, 18, null);
                }
                if (boardState.boardArr[i][j] == 2) {
                    g.drawImage(getImg.imageO, i * 20 + 1, j * 20 + 1, 18, 18, null);
                }
            }
        }
    }

    public int getPlayerFlag() {
        return player.getPlayerFlag();
    }

    public void setPlayerFlag(int playerFlag) {
        player.setPlayerFlag(playerFlag);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (player == null) {
            JOptionPane.showMessageDialog(null, "Chon che do choi");
        } else {
            int x = e.getX() / 20;
            int y = e.getY() / 20;
            danhCo(x, y, 1);
            Point ai = AI(2);
            danhCo(ai.x, ai.y, 2);
        }
    }

    public void danhCo(int x, int y, int player) {
        if (player == 1) {
            Point point = new Point(x, y);
            point.setPlayer(1);
            boardState.setPosition(x, y, player);
        } else {
            Point point = new Point(x, y);
            point.setPlayer(2);
            boardState.setPosition(x, y, player);
        }
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem playerVSMachine = CaroSuperAI.playerVSMachine, onInternet = CaroSuperAI.onInternet;
        JMenuItem about = CaroSuperAI.about, exit = CaroSuperAI.exit;
        if (e.getSource() == playerVSMachine) {
            this.player = computer;
        }
    }
}
