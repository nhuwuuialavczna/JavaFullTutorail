package AI.game.caro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvalBoard {
	public int height, width;
	public int[][] EBoard;
	public int evaluationBoard = 0;
	public EvalBoard(int height, int width) {
		this.height = height;
		this.width = width;
		EBoard = new int[height][width];
//		resetBoard();
	}

	public void resetBoard() {
		for (int r = 0; r < height; r++)
			for (int c = 0; c < width; c++)
				EBoard[r][c] = 0;
	}

	public void setPosition(int x, int y, int diem) {
		EBoard[x][y] = diem;
	}

	public Point MaxPos() {
		int Max = 0;
		Point p = new Point();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (EBoard[i][j] > Max) {
					p.x = i;
					p.y = j;
					Max = EBoard[i][j];
				}
			}
		}
		if (Max == 0) {
			return null;
		}
		evaluationBoard = Max;
		return p;
	}


}
