package movieInformation.testgui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() {
		
		this.setBounds(100, 100, 1200, 800);
		
		new MainWinBuild(this);
		
		/* 추가해도 실행 안됨*/
//		new MovieListWinBuild(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
