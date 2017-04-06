package go;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.sun.java.swing.plaf.motif.MotifGraphicsUtils;

/**
 * 面板
 * 
 * @author xiaowenxuan
 *
 */
public class GoPanel extends JPanel {

	private int a;
	int[] x1 = new int[13];
	int[] y1 = new int[13];

	/**
	 * 图片
	 */
	private BufferedImage image;
	/**
	 * 存棋子的列表
	 */
	private List<Piece> pieces = new ArrayList<>();

	/**
	 * 构造方法
	 */
	public GoPanel() {
		for (int i = 0; i < 13; i++) {
			x1[i] = 22 + i * 38;
			y1[i] = 22 + i * 38;
		}
		// this.a = a;
		// 读图片
		try {
			// switch(a){
			// case 1:
			// 从(22,22)开始 一格38
			image = ImageIO.read(new File("res/Blank_Go_board_13x13.png"));
			// break;
			// case 2:
			// image = ImageIO.read(new File("Blank_Go_board_13x13.png"));
			// break;
			// case 3:
			// image = ImageIO.read(new File("res/Blank_Go_board_19x19.png"));
			// break;
			// }

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 注册一个监听器
		addMouseListener(new PanelLisner());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		/**
		 * 画背景
		 */
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		/**
		 * 画棋子
		 */
		for (Piece p : pieces) {
			// g.fillOval(p.getX(), p.getY(),30,30);
			p.draw(g);
		}
	}

	/**
	 * 鼠标适配器
	 * 
	 * @author xiaowenxuan
	 *
	 */
	class PanelLisner extends MouseAdapter {
		boolean isWhite = true;

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			int x = e.getX();
			int y = e.getY();

			for (int i = 0; i < 13; i++) {
				if (Math.abs(y1[i] - y) < 19) {
					y = y1[i];
					break;
				}
			}
			for (int j = 0; j < 13; j++) {
				if (Math.abs(x1[j] - x) < 19) {
					x = x1[j];
					break;
				}
			}
//			System.out.printf("(%d,%d)\n", e.getX(), e.getY());
//			System.out.printf("(%d,%d)\n", x, y);
			Piece piece = new Piece(x, y, isWhite);
			Piece pieceA = new Piece(x-38, y -38, !isWhite);
			// System.out.println(piece);
			pieces.add(piece);
			pieces.add(pieceA);
//			isWhite = !isWhite;

			// 画布重新绘制
			repaint();

			// TODO
			// 局部重绘
			// repaint(e.getX(), e.getY(),0,0);
			// 图形的绘制（）
		}
	}
}
