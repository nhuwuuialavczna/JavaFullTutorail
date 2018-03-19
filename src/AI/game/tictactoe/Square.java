package AI.game.tictactoe;

import java.awt.*;

/**
 * @author JINX_NHI on 3/14/2018.
 */
public class Square {
    public int x;
    public int y;
    public Player player;

    public Square(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square() {
        this.x = -1;
        this.y =-1;
        player = Player.NONE;
    }

    public void paintPlayer(Graphics g) {
        if (player.id == 1) {
            g.setColor(Color.RED);
        }
        if (player.id == 2) {
            g.setColor(Color.BLUE);
        }
        g.fillRect(x * 100 + 1, y * 100 + 1, 98, 98);
    }
}
