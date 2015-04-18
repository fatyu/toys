package com.fatyu;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 背景窗口类
 * 
 * @author Fatyu
 * 
 */
public class BackFrame extends Frame {

	private static final long serialVersionUID = 1L;

	private Image backImage;

	private Tank tank = new Tank(50, 50, Color.BLACK, 20, true,Direction.S, this);
	private List<Tank> tanks = new ArrayList<Tank>();

	private List<Missile> missiles = new ArrayList<Missile>();
	private List<Bomb> bombs = new ArrayList<Bomb>();
	private final static int FRAME_WIDTH = 800;// 窗口初始化宽度

	private final static int FRAME_HEIGHT = 600;// 窗口初始化高度

	// ---------------------------------------Setter&&Getter-----------------------------
	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}

	public List<Missile> getMissiles() {
		return missiles;
	}

	public void setMissiles(List<Missile> missiles) {
		this.missiles = missiles;
	}

	public static int getFRAME_WIDTH() {
		return FRAME_WIDTH;
	}

	public static int getFRAME_HEIGHT() {
		return FRAME_HEIGHT;
	}

	public List<Bomb> getBombs() {
		return bombs;
	}

	public void setBombs(List<Bomb> bombs) {
		this.bombs = bombs;
	}

	// ------------------------------Bussiness_Method-------------------------------------
	/**
	 * 创建窗口并显示
	 */
	public void lunchFrame() {

		for (int i = 0; i < 10; i++) {
			Tank tank = new Tank(50 + 40 * (i + 1), 50, Color.BLUE, 30, false,
					Direction.D, this);
			tanks.add(tank);
		}

		this.setBounds(50, 50, FRAME_WIDTH, FRAME_HEIGHT);
		// 添加窗口关闭事件的处理
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// System.out.println(e.getSource());
				System.exit(0);
			}
		});

		// 添加键盘监听事件
		this.addKeyListener(new TankKeyAdapter());

		this.setTitle("|My Tank Practice|");
		// 设置背景颜色
		this.setBackground(Color.GREEN);
		this.setResizable(false);
		this.setVisible(true);

		new Thread(new RepaintThread()).start();
	}

	@Override
	public void paint(Graphics g) {// paint方法自动调用
		g.drawString("程序子弹数量:" + missiles.size(), 40, 40);
		g.drawString("击毁的坦克数量:" + bombs.size(), 40, 60);
		g.drawString("健在坦克数量:" + tanks.size(), 40, 80);

		for (int i = 0; i < missiles.size(); i++) {

			if (missiles.get(i).isLive()) {
				missiles.get(i).hitTanks(tanks);
				missiles.get(i).hitTank(tank);
			}
			missiles.get(i).draw(g);
		}

		for (int i = 0; i < bombs.size(); i++) {
			bombs.get(i).draw(g);
		}

		tank.draw(g);
		for (int i = 0; i < tanks.size(); i++) {
			// if (tanks.get(i).isLive()) {
			tanks.get(i).draw(g);
			// }
		}
	}

	/**
	 * 使用双缓冲技术解决屏幕闪烁的问题
	 */
	@Override
	public void update(Graphics g) {
		if (backImage == null) {
			backImage = this.createImage(FRAME_WIDTH, FRAME_HEIGHT);// 创建一个Image
		}
		Graphics bimageg = backImage.getGraphics();// 获得图片的画笔
		Color c = bimageg.getColor();
		bimageg.setColor(Color.GREEN);
		bimageg.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		bimageg.setColor(c);// 设置画笔颜色
		paint(bimageg);
		g.drawImage(backImage, 0, 0, null);// 将图片画至屏幕上
	}

	/**
	 * BackFrame的内部类 <b>用来使得画面重画</b>
	 * 
	 * @author Fatyu
	 * 
	 */
	private class RepaintThread implements Runnable {

		public void run() {
			for (;;) {
				repaint();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 键盘监听类-->内部类的再次使用
	 */
	private class TankKeyAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			tank.keyPressed(e);// 调用Tank类的keyPressed方法
		}

		@Override
		public void keyReleased(KeyEvent e) {
			tank.keyReleased(e);// 调用Tank类的keyReleased方法
		}

	}

	public List<Tank> getTanks() {
		return tanks;
	}

	public void setTanks(List<Tank> tanks) {
		this.tanks = tanks;
	}
}
