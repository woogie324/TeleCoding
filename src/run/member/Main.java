package run.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dto.MemberDTO;
import run.ChangePanel;
import run.MainFrame;

public class Main extends JPanel{
	
	private MainFrame mf;
	private JPanel main;

	public Main(MainFrame mf, MemberDTO memberInfo) {
		this.mf = mf;
		this.main = this;
		
		main.setBounds(0, 0, 1184, 820);
		main.setBackground(new Color(153, 50, 204));
		main.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(Color.WHITE);
		white.setBounds(100, 100, 1000, 600);
		main.add(white);
		white.setLayout(null);
		
		JPanel moviePanel = new JPanel();
		moviePanel.setBounds(67, 328, 394, 218);
		white.add(moviePanel);
		moviePanel.setLayout(null);
		
		JLabel movieLabel = new JLabel("영화 소개");
		movieLabel.setFont(new Font("굴림", Font.BOLD, 40));
		movieLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movieLabel.setBounds(12, 10, 370, 198);
		moviePanel.add(movieLabel);
		
		JPanel payPanel = new JPanel();
		payPanel.setBounds(536, 328, 394, 218);
		white.add(payPanel);
		payPanel.setLayout(null);
		
		JLabel payLabel = new JLabel("예매하기");
		payLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payLabel.setFont(new Font("굴림", Font.BOLD, 40));
		payLabel.setBounds(12, 10, 370, 198);
		payPanel.add(payLabel);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\logo.JPG"));
		logo.setBounds(386, 28, 224, 261);
		white.add(logo);
		
		JLabel userName = new JLabel(memberInfo.getName() + "님 반갑습니다.");
		userName.setHorizontalAlignment(SwingConstants.RIGHT);
		userName.setFont(new Font("굴림", Font.BOLD, 27));
		userName.setForeground(Color.WHITE);
		userName.setBounds(777, 42, 323, 48);
		main.add(userName);
		
		payLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				ChangePanel.changePanel(mf, main, 예매페이지);
			}
		});
		
		movieLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				ChangePanel.changePanel(mf, main, 소개페이지);
			}
		});
	}
}
