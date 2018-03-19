package AI.game.tankwar;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bullets {
	public static  int speedX = 10;
	public static  int speedY = 10; // �ӵ���ȫ�־�̬�ٶ�

	public static final int width = 10;
	public static final int length = 10;

	private int x, y;
	Direction diretion;

	private boolean good;
	private boolean live = true;

	private TankClient tc;

	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] bulletImages = null;
	private static Map<String, Image> imgs = new HashMap<String, Image>(); // ����Map��ֵ�ԣ��ǲ�ͬ�����Ӧ��ͬ�ĵ�ͷ

	static {
		bulletImages = new Image[] { // ��ͬ������ӵ�
				tk.getImage(Bullets.class.getClassLoader().getResource(
						"/game/tankwar/Images/bulletL.gif")),

				tk.getImage(Bullets.class.getClassLoader().getResource(
						"/game/tankwar/Images/bulletU.gif")),

				tk.getImage(Bullets.class.getClassLoader().getResource(
						"/game/tankwar/Images/bulletR.gif")),

				tk.getImage(Bullets.class.getClassLoader().getResource(
						"/game/tankwar/Images/bulletD.gif")),

		};

		imgs.put("L", bulletImages[0]); // ����Map����

		imgs.put("U", bulletImages[1]);

		imgs.put("R", bulletImages[2]);

		imgs.put("D", bulletImages[3]);

	}

	public Bullets(int x, int y, Direction dir) { // ���캯��1������λ�úͷ���
		this.x = x;
		this.y = y;
		this.diretion = dir;
	}

	// ���캯��2������������������
	public Bullets(int x, int y, boolean good, Direction dir, TankClient tc) {
		this(x, y, dir);
		this.good = good;
		this.tc = tc;
	}

	private void move() {

		switch (diretion) {
		case L:
			x -= speedX; // �ӵ������������
			break;

		case U:
			y -= speedY;
			break;

		case R:
			x += speedX; // �ֶβ�������
			break;

		case D:
			y += speedY;
			break;

		case STOP:
			break;
		}

		if (x < 0 || y < 0 || x > TankClient.Fram_width
				|| y > TankClient.Fram_length) {
			live = false;
		}
	}

	public void draw(Graphics g) {
		if (!live) {
			tc.bullets.remove(this);
			return;
		}

		switch (diretion) { // ѡ��ͬ������ӵ�
		case L:
			g.drawImage(imgs.get("L"), x, y, null);
			break;

		case U:
			g.drawImage(imgs.get("U"), x, y, null);
			break;

		case R:
			g.drawImage(imgs.get("R"), x, y, null);
			break;

		case D:
			g.drawImage(imgs.get("D"), x, y, null);
			break;

		}

		move(); // �����ӵ�move()����
	}

	public boolean isLive() { // �ж��Ƿ񻹻���
		return live;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, width, length);
	}

	public boolean hitTanks(List<Tank> tanks) {// ���ӵ���̹��ʱ
		for (int i = 0; i < tanks.size(); i++) {
			if (hitTank(tanks.get(i))) { // ��ÿһ��̹�ˣ�����hitTank
				return true;
			}
		}
		return false;
	}

	public boolean hitTank(Tank t) { // ���ӵ���̹����

		if (this.live && this.getRect().intersects(t.getRect()) && t.isLive()
				&& this.good != t.isGood()) {

			BombTank e = new BombTank(t.getX(), t.getY(), tc);
			tc.bombTanks.add(e);
			if (t.isGood()) {
				t.setLife(t.getLife() - 50); // ��һ���ӵ���������50������4ǹ����,������ֵ200
				if (t.getLife() <= 0)
					t.setLive(false); // ������Ϊ0ʱ����������Ϊ����״̬
			} else {
				t.setLive(false); 
			}

			this.live = false;

			return true; // ����ɹ�������true
		}
		return false; // ���򷵻�false
	}

	public boolean hitWall(CommonWall w) { // �ӵ���CommonWall��
		if (this.live && this.getRect().intersects(w.getRect())) {
			this.live = false;
			this.tc.otherWall.remove(w); // �ӵ���CommonWallǽ��ʱ���Ƴ��˻���ǽ
			this.tc.homeWall.remove(w);
			return true;
		}
		return false;
	}

	public boolean hitWall(MetalWall w) { // �ӵ��򵽽���ǽ��
		if (this.live && this.getRect().intersects(w.getRect())) {
			this.live = false;
			//this.tc.metalWall.remove(w); //�ӵ����ܴ�Խ����ǽ
			return true;
		}
		return false;
	}

	public boolean hitHome() { // ���ӵ��򵽼�ʱ
		if (this.live && this.getRect().intersects(tc.home.getRect())) {
			this.live = false;
			this.tc.home.setLive(false); // ���ҽ���һǹʱ������
			return true;
		}
		return false;
	}

}
