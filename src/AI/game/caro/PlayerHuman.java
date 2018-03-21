package AI.game.caro;

public class PlayerHuman implements Player {
	BoardState boardState;
	int playerFlag = 1;

	public PlayerHuman(BoardState board) {
		this.boardState = board;
	}

	@Override
	public Point movePoint(int player) {
		// TODO Auto-generated Test.method stub
		return null;
	}

	@Override
	public int getPlayerFlag() {
		// TODO Auto-generated Test.method stub
		return playerFlag;
	}

	@Override
	public void setPlayerFlag(int playerFlag) {
		this.playerFlag = playerFlag;
	}

	@Override
	public BoardState getBoardState() {
		// TODO Auto-generated Test.method stub
		return boardState;
	}

}
