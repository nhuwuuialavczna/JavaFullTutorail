package AI.game.eightpuzzle;

import javax.swing.*;

/**
 * @author JINX_NHI on 3/13/2018.
 */
public class EightPuzzle extends JFrame {
    int type = -1;
    static JMenuBar jMenuBar;
    static JMenu jMenu;
    static JMenuItem jMenuBFS, jMenuDFS, jMenuAtar, jMenuStart;

    public EightPuzzle() {

        jMenuBar = new JMenuBar();
        jMenu = new JMenu("Hệ thống");
        jMenuBFS = new JMenuItem("BFS");
        jMenuDFS = new JMenuItem("DFS");
        jMenuAtar = new JMenuItem("A *");
        jMenuStart = new JMenuItem("Start");
        jMenu.add(jMenuBFS);
        jMenu.add(jMenuDFS);
        jMenu.add(jMenuAtar);
        jMenu.add(jMenuStart);
        jMenuBar.add(jMenu);

//        board.menu();
        Board board = new Board();
        jMenuBFS.addActionListener(board);
        jMenuDFS.addActionListener(board);
        jMenuAtar.addActionListener(board);
        jMenuStart.addActionListener(board);
        add(board);

        setJMenuBar(jMenuBar);
        setSize(230, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EightPuzzle();
    }
}
