package AI.game.teris.model;

import java.awt.Color;

/**
 * Đây là class cho khối chữ I - khối dọc
 * Màu sẽ là màu đỏ
 * GIá trị trên bàn sẽ là 1
 * */
public class IBlock extends Block {

	public IBlock(GameBoard gameBoard) {
		super(gameBoard);
		init();
	}

	@Override
	public void init() {
		setSpinBehavior(new SpinWithBlock4x4());
		setTopLeftPosition(new Position(0, 0));
		potentialTopLeft = new Position(1, 1);
		color = Color.RED;
		coord = new Position[] { new Position(0, -1), new Position(0, 0), new Position(0, 1), new Position(0, 2) };
		tempCoord = new Position[] { new Position(0, -1), new Position(0, 0), new Position(0, 1), new Position(0, 2) };
	}

	@Override
	public void changeCoord() {
		gameBoard.addPosition(topLeftPosition.sum(coord[0]), 1);
		gameBoard.addPosition(topLeftPosition.sum(coord[1]), 1);
		gameBoard.addPosition(topLeftPosition.sum(coord[2]), 1);
		gameBoard.addPosition(topLeftPosition.sum(coord[3]), 1);
	}

}
