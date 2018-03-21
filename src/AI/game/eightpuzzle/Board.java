package AI.game.eightpuzzle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author JINX_NHI on 3/13/2018.
 */
public class Board extends JPanel implements Runnable, ActionListener {
    int[] a = {5, 6, 8, 4, 0, 1, 2, 3, 7};
    Image[] images;
    public static String loai;
    Stack<SearchNode> b;
    Thread thread;
    int i = -1;
    List<SearchNode> goal;

    public Board() {
        images = new Image[9];

        for (int i = 0; i < 9; i++) {
            try {
                images[i] = ImageIO.read(this.getClass().getResourceAsStream("/AI/game/eightpuzzle/Images/" + i + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        thread = new Thread(this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.BLACK);
        g.drawString("Thuật toán: ", 110, 30);
        g.drawString(((loai != null) ? loai : "Chưa chọn"), 110, 50);
        g.drawString("Change: " + ((b != null && b.size() != 0) ? b.size() + "" : ""), 110, 70);

        int[][] board2 = new int[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board2[i][j] = a[k++];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.drawImage(images[board2[j][i]], i * 30, j * 30, 30, 30, null);
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                i--;
                a = ((EightPuzzleState) goal.get(i).getCurState()).getCurBoard();
                repaint();
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Đã xong");
                thread.stop();
            }

        }
    }

    public void menu() {

    }

    public List<SearchNode> covertStack() {
        return b.stream().collect(Collectors.toList());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == EightPuzzle.jMenuDFS) {
            Board.loai = "BFS";
            b = BFSearch.search(a, true);
            i = b.size();
            goal = covertStack();
            this.repaint();

        }
        if (e.getSource().equals(EightPuzzle.jMenuBFS)) {
            Board.loai = "BFS";
            b = BFSearch.search(a, true);
            i = b.size();
            goal = covertStack();
            this.repaint();
        }
        if (e.getSource().equals(EightPuzzle.jMenuAtar)) {
            Board.loai = "A *";
            b = AStarSearch.search(a, true, 'o');
            i = b.size();
            goal = covertStack();
            this.repaint();
        }
        if (e.getSource().equals(EightPuzzle.jMenuStart)) {
            if (Board.loai == null) {
                JOptionPane.showMessageDialog(null, "Bạn hãy chọn loại thuật toán !");
                this.repaint();
            } else {
                this.repaint();
                thread.start();
            }
        }
    }


}
