package AI.game.tankwar;

import java.awt.*;

public class CommonWall {
	public static final int width = 20; //����ǽ�Ĺ̶�����
	public static final int length = 20;
	int x, y;

	TankClient tc;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] wallImags = null;
	static {
		wallImags = new Image[] { // ����commonWall��ͼƬ
		tk.getImage(CommonWall.class.getResource("/game/tankwar/Images/commonWall.gif")), };
	}

	public CommonWall(int x, int y, TankClient tc) { // ���캯��
		this.x = x;
		this.y = y;
		this.tc = tc; // ��ý������
	}

	public void draw(Graphics g) {// ��commonWall
		g.drawImage(wallImags[0], x, y, null);
	}

	public Rectangle getRect() {  //����ָ�������ĳ�����ʵ��
		return new Rectangle(x, y, width, length);
	}
}
