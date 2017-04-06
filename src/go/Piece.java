package go;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 棋子
 * @author xiaowenxuan
 *
 */
public class Piece {

	BufferedImage image;
	private int x;
	private int y;
	private int d = 38;
	private boolean isWhite = true;
	public Piece(int x, int y,boolean isWhite) {
		super();
		this.x = x - 19;
		this.y = y - 19;
		this.isWhite = isWhite;
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
	public boolean isWhite() {
		return isWhite;
	}
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	public int getD(){
		return d;
	}
	/**
	 * 绘制
	 * @param g
	 */
	public void draw(Graphics g) {

		g.setColor(isWhite ? Color.WHITE:Color.BLACK);
		g.fillOval(x, y,d,d);
	}
	
	
}
