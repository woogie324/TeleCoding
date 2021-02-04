package run;

import javax.swing.JFrame;
import run.member.*;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		
		this.setBounds(200,100,1200,850);
		// setBounds(x좌표,y좌표,가로,세로)
		
		new Login(this);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}