package run;

import javax.swing.JPanel;

public class ChangePanel {
	
	public static void changePanel(MainFrame mf, JPanel op, JPanel np) {
		mf.remove(op);
		mf.add(np);
		mf.repaint();		// 중요 : remove 후 add를 하면 꼭 repaint를 해줘야한다.
	}

}
