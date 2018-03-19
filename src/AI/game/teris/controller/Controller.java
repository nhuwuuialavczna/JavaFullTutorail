package AI.game.teris.controller;

import java.awt.Graphics;

import AI.game.teris.model.GameBoard;
import AI.game.teris.model.IModel;
import AI.game.teris.view.IViewTetris;
import AI.game.teris.view.ViewGameTetris;

public class Controller implements IController {
	private IModel board; // main model
	private IViewTetris viewGameTetris; // view when game is start

	/** call when game is start, it create model and create view */
	public void init() {
		board = new GameBoard(this);
		viewGameTetris = new ViewGameTetris(this);
	}

	/** call when view click button new game */
	public void start() {
		init();
		board.start();
		viewGameTetris.start();
	}

	@Override
	public void draw(Graphics g) {
		board.draw(g);
	}

	@Override
	public void setChange() {
		viewGameTetris.update();
	}

	@Override
	public void moveLeft() {
		board.moveLeft();
		setChange();
	}

	@Override
	public void moveRight() {
		board.moveRight();
		setChange();
	}

	@Override
	public void moveDown() {
		board.moveDown();
		setChange();
	}

	@Override
	public void ronate() {
		board.spin();
		setChange();
	}

	@Override
	public void fastDown() {
		board.fastDown();
		setChange();
	}




}
