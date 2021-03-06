package AI.game.teris.model;

public class SpinWithBlock3x3 implements Spinnable {

	@Override
	public void spin(Position[] coord) {
		for (int i = 0; i < coord.length; i++) {
			int x = coord[i].getX();
			int y = coord[i].getY();
			coord[i].setX(y);
			coord[i].setY(-x);
		}
	}

}
