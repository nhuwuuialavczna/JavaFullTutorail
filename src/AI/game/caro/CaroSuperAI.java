package AI.game.caro;

import javax.swing.*;

/**
 * @author JINX_NHI on 3/15/2018.
 */
public class CaroSuperAI extends JFrame {
    static JMenu jMenuHeThong, jMenuAbout;
    static JMenuBar jMenuBar;
    static JMenuItem playerVSMachine, onInternet;
    static JMenuItem about, exit;

    public CaroSuperAI() {
        jMenuBar = new JMenuBar();
        CaroUI caroUI = new CaroUI();
        playerVSMachine = new JMenuItem("VS COM");
        onInternet = new JMenuItem("Play on internet");

        jMenuHeThong = new JMenu("System");
        jMenuAbout = new JMenu("About");

        jMenuHeThong.add(playerVSMachine);
        jMenuHeThong.add(onInternet);
        about = new JMenuItem("About");
        exit = new JMenuItem("Exit");
        jMenuAbout.add(about);
        jMenuAbout.add(exit);
        jMenuBar.add(jMenuHeThong);
        jMenuBar.add(jMenuAbout);
        playerVSMachine.addActionListener(caroUI);
        onInternet.addActionListener(caroUI);
        about.addActionListener(caroUI);
        exit.addActionListener(caroUI);

        setJMenuBar(jMenuBar);

        add(caroUI);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CaroSuperAI();
    }

}
