package AI.game.teris.model;

import java.awt.Color;
/**
 * Đây là class cho khối vuông 2,2
 * Màu sẽ là màu xanh
 * GIá trị trên bàn sẽ là 0
 * */
public class OBlock extends Block{

	public OBlock(GameBoard gameBoard) {
		super(gameBoard);
		init();
	}

	@Override
	public void init() {
		setSpinBehavior(new SpinWithBlock2x2());
		setTopLeftPosition(new Position(1, 4));
		potentialTopLeft = new Position(2, 4);
		color = Color.BLUE;
		coord = new Position[]{new Position(-1, 0), new Position(-1, 1), new Position(0, 0), new Position(0, 1)};
		tempCoord = new Position[]{new Position(-1, 0), new Position(-1, 1), new Position(0, 0), new Position(0, 1)};
	}

	@Override
	public void changeCoord() {
		gameBoard.addPosition(topLeftPosition.sum(coord[0]), 0);
		gameBoard.addPosition(topLeftPosition.sum(coord[1]), 0);
		gameBoard.addPosition(topLeftPosition.sum(coord[2]), 0);
		gameBoard.addPosition(topLeftPosition.sum(coord[3]), 0);
	}

}
