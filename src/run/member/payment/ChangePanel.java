package run.member.payment;

import javax.swing.JPanel;

import run.MainFrame;

public class ChangePanel {
	public static void changePanel(test test, JPanel op, JPanel np) {
		test.remove(op);
		test.add(np);
		test.repaint();		// 중요 : remove 후 add를 하면 꼭 repaint를 해줘야한다.
	}
}
