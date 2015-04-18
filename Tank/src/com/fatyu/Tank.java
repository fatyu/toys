package com.fatyu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.util.Random;

/**
 * Tank类
 * 
 * @author Fatyu
 * 
 */
public class Tank {

	static Random random = new Random();
	private int x;// 初始x坐标
	private int y;// 初始y坐标
	private Color color;// 坦克颜色
	private static int size = 30;// 坦克大小
	private int blood;// 坦克的hp
	private boolean live = true;// 坦克是否健在

	private boolean good;
	private boolean btL, btR, btU, btD;// 标识方向键是否被按下

	private Direction td = Direction.S;// 标识坦克的运行方向 初始为停止
	private Direction bd = Direction.R;// 标识坦克的炮筒方向用来决定子弹的方向 初始为右
	int stepMove = random.nextInt(10) + 3;
	private BackFrame bf;

	// ----------------------------------Setter&&Getter-------------------------------
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public static void setSize(int size) {
		Tank.size = size;
	}

	public int getSize() {
		return size;
	}

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public Direction getTd() {
		return td;
	}

	public void setTd(Direction td) {
		this.td = td;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	// --------------------------------Constructor--------------------------
	public Tank() {
	}

	/**
	 * 传递坦克的坐标 颜色 大小 创建一个坦克
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param size
	 */
	public Tank(int x, int y, Color color, int size) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	/**
	 * 传递坦克的坐标 颜色 大小 背景 创建一个坦克
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param size
	 * @param bf
	 */
	public Tank(int x, int y, Color color, int size, boolean good,
			Direction td, BackFrame bf) {
		this(x, y, color, size);
		this.good = good;
		this.td = td;
		this.bf = bf;
	}

	// ------------------------------------Bussiness_Method-------------------------------
	/**
	 * 在背景窗口中画出一个坦克
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		if (!live) {
			if (!good) {
				bf.getTanks().remove(this);
			}
			return;
		}
		// 首先获得默认的画笔颜色
		Color c = g.getColor();
		// 设置画笔颜色为tank的颜色
		g.setColor(color);
		// 画出坦克
		g.fillOval(x, y, size, size);
		// 画出炮筒
		addBreeching(g);
		// 将原来的前景色还原
		g.setColor(c);
		// 移动坦克
		move(td);
	}

	/**
	 * 画出坦克的炮筒
	 * 
	 * @param g
	 */
	public void addBreeching(Graphics g) {
		switch (td) {
		case L:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x - 5, y
					+ Tank.size / 2);
			break;
		case R:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x + Tank.size + 5,
					y + Tank.size / 2);
			break;
		case U:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x + Tank.size / 2,
					y - 5);
			break;
		case D:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x + Tank.size / 2,
					y + 5 + Tank.size);
			break;
		case LU:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x, y);
			break;
		case LD:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x, y + Tank.size);
			break;
		case RU:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x + Tank.size, y);
			break;
		case RD:
			g.drawLine(x + Tank.size / 2, y + Tank.size / 2, x + Tank.size, y
					+ Tank.size);
			break;
		}
	}

	/**
	 * 根据坦克的移动方向 移动坦克
	 * 
	 * @param dir
	 */
	public void move(Direction td) {

		switch (td) {
		case L:
			x -= 5;
			break;
		case R:
			x += 5;
			break;
		case U:
			y -= 5;
			break;
		case D:
			y += 5;
			break;
		case LU:
			x -= 5;
			y -= 5;
			break;
		case LD:
			x -= 5;
			y += 5;
			break;
		case RU:
			x += 5;
			y -= 5;
			break;
		case RD:
			x += 5;
			y += 5;
			break;
		}
		// 确定炮筒的方向
		if (td != Direction.S) {
			this.bd = this.td;
		}
		/*
		 * 处理坦克出界问题
		 */
		if (x < 0) {
			x = BackFrame.getFRAME_WIDTH() - size;
		} else if (y < 30) {
			y = BackFrame.getFRAME_HEIGHT() - size;
		} else if (x > BackFrame.getFRAME_WIDTH()) {
			x = 0;
		} else if (y > BackFrame.getFRAME_HEIGHT()) {
			y = 30;
		}
		// 使得敌人的坦克可以自由移动
		if (!good) {

			Direction[] dirs = Direction.values();
			if (stepMove == 0) {
				stepMove = random.nextInt(10) + 2;
				int indexDir = random.nextInt(dirs.length);
				this.td = dirs[indexDir];
			}
			stepMove--;
			if (random.nextInt(100) > 98)
				this.fire();
		}
	}

	/**
	 * 键盘按键处理
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {

		case KeyEvent.VK_LEFT:
			btL = true;
			break;
		case KeyEvent.VK_RIGHT:
			btR = true;
			break;
		case KeyEvent.VK_UP:
			btU = true;
			break;
		case KeyEvent.VK_DOWN:
			btD = true;
			break;

		}
		checkDir();
	}

	/**
	 * 键盘抬起处理
	 * 
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_CONTROL:
			this.fire();
			break;
		case KeyEvent.VK_LEFT:
			btL = false;
			break;
		case KeyEvent.VK_RIGHT:
			btR = false;
			break;
		case KeyEvent.VK_UP:
			btU = false;
			break;
		case KeyEvent.VK_DOWN:
			btD = false;
			break;
		}
		checkDir();
	}

	/**
	 * 根据键盘按键判断坦克的方向
	 */
	private void checkDir() {
		if (btL == true && btR == false && btU == false && btD == false) {
			td = Direction.L;
		} else if (btL == false && btR == true && btU == false && btD == false) {
			td = Direction.R;
		} else if (btL == false && btR == false && btU == true && btD == false) {
			td = Direction.U;
		} else if (btL == false && btR == false && btU == false && btD == true) {
			td = Direction.D;
		} else if (btL == true && btR == false && btU == true && btD == false) {
			td = Direction.LU;
		} else if (btL == true && btR == false && btU == false && btD == true) {
			td = Direction.LD;
		} else if (btL == false && btR == true && btU == true && btD == false) {
			td = Direction.RU;
		} else if (btL == false && btR == true && btU == false && btD == true) {
			td = Direction.RD;
		} else if (btL == false && btR == false && btU == false && btD == false) {
			td = Direction.S;
		}
	}

	/**
	 * 模拟坦克发射子弹
	 * 
	 * @return Missile missle
	 */

	public void fire() {
		if (this.isLive()) {
			int x = this.x + Tank.size / 2 - Missile.getSize() / 2;
			int y = this.y + Tank.size / 2 - Missile.getSize() / 2;
			Missile missile = new Missile(x, y, bd, this.good, this.bf);
			this.bf.getMissiles().add(missile);
		}
	}

	/**
	 * 获得tank的外切矩形-->用于与子弹进行碰撞检测
	 * 
	 * @return
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, size, size);
	}

	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}
}
