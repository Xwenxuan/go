package go;

import java.util.Scanner;

import javax.swing.JFrame;

public class AppFrame extends JFrame {

	private GoPanel goPanel;
	public AppFrame() {
	    iniUi();
	}
	private void iniUi() {
		setTitle("五子棋");
		setSize(506,540);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入你想要的模式：1.2.3");
//		int a = sc.nextInt();
		goPanel = new GoPanel();
		add(goPanel);
	}
	
}
