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

public class Admin_SelecNoti extends JFrame {
	
	public Admin_SelecNoti() {
	
		JFrame selecNoti = new JFrame("알림");
		selecNoti.setBounds(200,200,300,160);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JLabel label1 = new JLabel("목록을 선택해주세요!!");
		label1.setForeground(Color.DARK_GRAY);
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
				selecNoti.dispose();
			}
		});
		
		
		panel.setLayout(null);
		
		panel.add(label1);
		panel.add(close);
		
		selecNoti.getContentPane().add(panel);
		selecNoti.setLocationRelativeTo(null);
		selecNoti.setVisible(true);
		selecNoti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}	
		
}
