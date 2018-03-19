package AI.game.teris.controller;

import java.awt.Graphics;

public interface IController {
	/** start game */
	public void start();

	/** call when Model change ==> View update */
	public void setChange();

	/** block move left */
	public void moveLeft();

	/** block move right */
	public void moveRight();

	/** block move down */
	public void moveDown();

	/** spin block */
	public void ronate();

	/** draw block */
	public void draw(Graphics g);

	/** block fast down */
	public void fastDown();

}
