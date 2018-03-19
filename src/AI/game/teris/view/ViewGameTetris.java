package AI.game.teris.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import AI.game.teris.controller.IController;

public class ViewGameTetris extends JFrame implements IViewTetris {
	private static final long serialVersionUID = 1L;
	private JPanel panelGame;
	private IController controller;

	public ViewGameTetris(IController controller) {
		super("Demo game taric");
		this.controller = controller;

	}
	

	@Override
	public void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(460, 660);
		panelGame = new PanelGame(controller);
		getContentPane().add(panelGame);
		setFocusable(true);
		addEvent();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void update() {
		repaint();
	}

	public void addEvent() {
		addKeyListener(keyEvent());
	}

	public KeyListener keyEvent() {
		return new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					controller.ronate();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					controller.fastDown();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					controller.moveLeft();
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					controller.moveRight();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					controller.moveDown();
				}
			}
		};
	}


}
