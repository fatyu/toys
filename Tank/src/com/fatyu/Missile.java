package com.fatyu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 * 炮弹类
 * 
 * @author Fatyu
 * 
 */
public class Missile {

	private final static int MISSILE_SIZE = 10;// 子弹的大小
	private final static int MISSILE_SPEED = 10;// 子弹的速度

	private int x;// 起始位置x坐标
	private int y;// 起始位置y坐标

	private boolean good;// 子弹的发出者是敌人或者自己
	private Direction md;// 子弹的方向
	private BackFrame bf;// 获得大管家的引用-->使用了Mediator模式
	private boolean live = true;

	// ----------------------Setter&Getter-----------------------------------
	public Direction getMd() {
		return md;
	}

	public void setMd(Direction md) {
		this.md = md;
	}

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

	public static int getSize() {
		return MISSILE_SIZE;
	}

	public boolean isLive() {
		return live;
	}

	public BackFrame getBf() {
		return bf;
	}

	public void setBf(BackFrame bf) {
		this.bf = bf;
	}

	public boolean isGood() {
		return good;
	}

	// ----------------------Constructors-----------------------------------
	public Missile() {
	}

	public Missile(int x, int y, Direction md) {
		this.x = x;
		this.y = y;
		this.md = md;
	}

	public Missile(int x, int y, Direction md, boolean good,BackFrame bf) {
		this(x, y, md);
		this.good = good;
		this.bf = bf;
	}

	// --------------------------------Bussiness_Method-------------------------------
	/**
	 * 在背景窗口中画出一个子弹
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		if (!live) {
			bf.getMissiles().remove(this);
			return;
		}

		// 首先获得默认的画笔颜色
		Color c = g.getColor();
		// 画出子弹
		g.fillOval(x, y, MISSILE_SIZE, MISSILE_SIZE);
		// 将原来的前景色还原
		g.setColor(c);
		move();
	}

	/**
	 * 子弹的move方法
	 */
	public void move() {
		switch (md) {
		case L:
			x -= MISSILE_SPEED;
			break;
		case R:
			x += MISSILE_SPEED;
			break;
		case U:
			y -= MISSILE_SPEED;
			break;
		case D:
			y += MISSILE_SPEED;
			break;
		case LU:
			x -= MISSILE_SPEED;
			y -= MISSILE_SPEED;
			break;
		case LD:
			x -= MISSILE_SPEED;
			y += MISSILE_SPEED;
			break;
		case RU:
			x += MISSILE_SPEED;
			y -= MISSILE_SPEED;
			break;
		case RD:
			x += MISSILE_SPEED;
			y += MISSILE_SPEED;
			break;
		}

		if (this.x < 0 || this.y < 0 || this.x > BackFrame.getFRAME_WIDTH()
				|| this.y > BackFrame.getFRAME_HEIGHT()) {
			this.live = false;
			// bf.getMissiles().remove(this);
		}
	}

	/**
	 * 获得子弹的外切矩形
	 * 
	 * @return
	 */
	public Rectangle getRectangle() {
		return new Rectangle(x, y, MISSILE_SIZE, MISSILE_SIZE);
	}

	public void hitTank(Tank tank) {
		if (isLive()&&this.getRectangle().intersects(tank.getRectangle())
				&& tank.isLive()&&this.good!=tank.isGood()) {
			tank.setLive(false);
			this.live = false;
			Bomb bomb = new Bomb(this.x, this.y, this.bf);
			bf.getBombs().add(bomb);

		}
	}

	public void hitTanks(List<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			hitTank(tanks.get(i));
		}
	}
}