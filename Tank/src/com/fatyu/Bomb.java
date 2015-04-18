package com.fatyu;

import java.awt.Color;
import java.awt.Graphics;

public class Bomb {
	private boolean live = true;

	private int x;
	private int y;

	private BackFrame bf;
	private int index = 0;
	private int[] circleRadius = { 1, 2, 4, 8, 16, 17, 18, 24,32,24, 17, 16, 10, 8,
			5, 2, 1 };// 使用静态赋值方式创建一个整形数组

	// -------------------------------Setter&&Getter----------------------------------------

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
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

	public BackFrame getBf() {
		return bf;
	}

	public void setBf(BackFrame bf) {
		this.bf = bf;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int[] getCircleRadius() {
		return circleRadius;
	}

	public void setCircleRadius(int[] circleRadius) {
		this.circleRadius = circleRadius;
	}

	// ----------------------------------Constructor---------------------------------
	public Bomb() {

	}

	public Bomb(int x, int y, BackFrame bf) {
		this.x = x;
		this.y = y;
		this.bf = bf;
	}

	// ---------------------------------BussinessMethod----------------------------------
	/**
	 * 使用drawString模拟爆炸
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		if (!this.live) {
			return;
		}

		if (index == circleRadius.length) {
			this.live = false;
			index = 0;
			return;
		}

		Color c = g.getColor();
		g.setColor(Color.RED);
		g.drawString("草你妈的!", x+circleRadius[index], y+circleRadius[index]);
		g.fillOval(x, y, circleRadius[index], circleRadius[index]);
		g.setColor(c);
		index++;
	}

}
