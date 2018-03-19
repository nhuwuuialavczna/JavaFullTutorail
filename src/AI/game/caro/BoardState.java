package AI.game.caro;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class BoardState {
    public int[][] boardArr;
    public int width;
    public int height;

    public BoardState(int width, int height) {
        boardArr = new int[width][height];
        this.height = height;
        this.width = width;
    }

    public void resetBoard() {
        boardArr = new int[width][height];
    }

    public int checkEnd(int rw, int cl) {
        int r = 0, c = 0;
        int i;
        boolean human, pc;
        // Check hÃ ng ngang
        while (c < width - 4) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (boardArr[rw][c + i] != 1)
                    human = false;
                if (boardArr[rw][c + i] != 2)
                    pc = false;
            }
            if (human)
                return 1;
            if (pc)
                return 2;
            c++;
        }

        // Check hÃ ng doc
        while (r < height - 4) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (boardArr[r + i][cl] != 1)
                    human = false;
                if (boardArr[r + i][cl] != 2)
                    pc = false;
            }
            if (human)
                return 1;
            if (pc)
                return 2;
            r++;
        }

        // Check duong cheo xuong
        r = rw;
        c = cl;
        while (r > 0 && c > 0) {
            r--;
            c--;
        }
        while (r < height - 4 && c < width - 4) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (boardArr[r + i][c + i] != 1)
                    human = false;
                if (boardArr[r + i][c + i] != 2)
                    pc = false;
            }
            if (human)
                return 1;
            if (pc)
                return 2;
            r++;
            c++;
        }

        // Check duong cheo len
        r = rw;
        c = cl;
        while (r < height - 1 && c > 0) {
            r++;
            c--;
        }

        while (r >= 4 && c < height - 4) {
            human = true;
            pc = true;
            for (i = 0; i < 5; i++) {
                if (boardArr[r - i][c + i] != 1)
                    human = false;
                if (boardArr[r - i][c + i] != 2)
                    pc = false;
                // System.out.println(r-i +";"+(c + i));
            }
            if (human)
                return 1;
            if (pc)
                return 2;
            r--;
            c++;
        }
        return 0;
    }

    public int getPosition(int x, int y) {
        return boardArr[x][y];
    }

    public void setPosition(int x, int y, int player) {
        boardArr[x][y] = player;
    }

    public void paintBoard(Graphics g) {
        System.out.println("ve lai");
        try {
            InputStream inputO = this.getClass().getResourceAsStream("/icon/o.png");
            InputStream inputX = this.getClass().getResourceAsStream("/icon/o.png");
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (boardArr[i][j] == 1) {
                        g.drawImage(ImageIO.read(inputO), i * 20 + 1, j * 20 + 1, 18, 18, null);
                    }
                    if (boardArr[i][j] == 2) {
                        g.drawImage(ImageIO.read(inputX), i * 20 + 1, j * 20 + 1, 18, 18, null);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(false);
        }
    }
}
