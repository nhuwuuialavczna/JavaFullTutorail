package AI.game.teris.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import AI.game.teris.controller.IController;

public class PanelGame extends JPanel {
	private static final long serialVersionUID = 1L;
	private IController controller;

	public PanelGame(IController controller) {
		this.controller = controller;
		init();
		
	}

	

	
	


	private void init() {
		setSize(new Dimension(450, 620));
		setLayout(null);
		setBackground(new Color(66, 66, 66, 160));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		controller.draw(g);
	}
}
