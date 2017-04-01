package go;

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
		
		goPanel = new GoPanel();
		add(goPanel);
	}
	
}
