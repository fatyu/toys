package com.fatyu;

/**
 * 开发流程:
 * <li>1.1 创建窗口并设置背景色和监听处理窗口关闭事件-->掌握事件监听模式</li>
 * <li>1.2 让坦克根据键盘按下动起来-->掌握使用线程重画和内部类的使用</li>
 * <li>1.3 使用双缓冲技术解决屏幕闪烁的问题-->掌握repaint方法的执行过程 repaint->update<b>{拦截}</b>->paint</li>
 * <li>1.4 第一次重构代码并实现按键事件的处理[控制tank移动方向]-->掌握final static 常量的定义</li>
 * <li>1.5 使用OOAD思想对代码第二次重构 使用Tank类来减少代码的重复使用率</li>
 * <li>1.6 使得坦克可以朝任何方向运动-->掌握枚举的使用</li>
 * <li>1.7 添加坦克发射子弹功能 -->掌握其他对象的引用 使用新的变量管理其他对象的属性</li>
 * <li>1.8 解决子弹和坦克的出界问题-->掌握debug的使用</li>
 * <li>1.9 使用碰撞检测技术实现子弹碰到坦克时坦克被击毁-->使用Rectangle类中方法</li>
 * <li>2.0 创建一个新类用来实现坦克被击毁后的爆炸特效-->Bomb</li>
 * <li>2.1 添加多辆坦克</li>
 * <li>2.2 使得坦克可以进行攻击和躲避</li>
 * 
 * @author Fatyu
 * 
 */
public class TankWar {

	/**
	 * 主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BackFrame bf = new BackFrame();
		bf.lunchFrame();
	}

}
