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
 * @author xiaowenxuan
 *
 */
public class GoPanel extends JPanel{

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

		try {
			//读图片
			image = ImageIO.read(new File("res/Blank_Go_board_19x19.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//注册一个监听器
		addMouseListener(new PanelLisner());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		/**
		 * 画背景
		 */
		g.drawImage(image, 0, 0, getWidth(),getHeight(),null);
		/**
		 * 画棋子
		 */
		for(Piece p : pieces){
//			g.fillOval(p.getX(), p.getY(),30,30);
			p.draw(g);
		}
	}
	
	/**
	 * 鼠标适配器
	 * @author xiaowenxuan
	 *
	 */
	class PanelLisner extends MouseAdapter {
		boolean isWhite = true;
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
//			System.out.printf("(%d,%d)\n",e.getX(),e.getY());
			Piece piece = new Piece(e.getX(),e.getY(),isWhite);
//			System.out.println(piece);
			pieces.add(piece);
			isWhite = !isWhite;
			
			//重新绘制
			repaint();
		}
	}
}
