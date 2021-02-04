package run.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Admin_ProdInit extends JFrame {
	
	public Admin_ProdInit() {
		
		JFrame initNoti = new JFrame("알림");
		initNoti.setBounds(200,200,300,160);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("목록이 초기화 되었습니다.");
//		label1.setForeground(new Color(220, 20, 60));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label1.setBounds(0, 13, 282, 43);
		
		JButton close = new JButton("닫기");
		close.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		close.setLocation(70, 69);
		close.setSize(134, 29);
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				initNoti.dispose();
			}
		});
		
		
		panel.setLayout(null);
		
		panel.add(label1);
		panel.add(close);
		
		initNoti.getContentPane().add(panel);
		initNoti.setLocationRelativeTo(null);
		initNoti.setVisible(true);
		initNoti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}

}
