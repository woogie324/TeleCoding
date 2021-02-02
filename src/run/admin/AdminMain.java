package run.admin;

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

public class AdminMain extends JPanel{
	
	private MainFrame mf;
	private JPanel adminMain;

	public AdminMain(MainFrame mf) {
		this.mf = mf;
		this.adminMain = this;
		
		adminMain.setBounds(0, 0, 1184, 820);
		adminMain.setBackground(new Color(153, 50, 204));
		adminMain.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(Color.WHITE);
		white.setBounds(100, 100, 1000, 600);
		adminMain.add(white);
		white.setLayout(null);
		
		JPanel memberPanel = new JPanel();
		memberPanel.setBounds(25, 300, 300, 218);
		white.add(memberPanel);
		memberPanel.setLayout(null);
		
		JLabel memberLabel = new JLabel("회원 관리");
		memberLabel.setFont(new Font("굴림", Font.BOLD, 40));
		memberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberLabel.setBounds(0, 10, 300, 198);
		memberPanel.add(memberLabel);
		
		JPanel moviePanel = new JPanel();
		moviePanel.setBounds(350, 300, 300, 218);
		white.add(moviePanel);
		moviePanel.setLayout(null);
		
		JLabel movieLabel = new JLabel("영화 관리");
		movieLabel.setFont(new Font("굴림", Font.BOLD, 40));
		movieLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movieLabel.setBounds(0, 10, 300, 198);
		moviePanel.add(movieLabel);
		
		JPanel payPanel = new JPanel();
		payPanel.setBounds(675, 300, 300, 218);
		white.add(payPanel);
		payPanel.setLayout(null);
		
		JLabel payLabel = new JLabel("상품 관리");
		payLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payLabel.setFont(new Font("굴림", Font.BOLD, 40));
		payLabel.setBounds(0, 10, 300, 198);
		payPanel.add(payLabel);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\logo.JPG"));
		logo.setBounds(386, 28, 224, 261);
		white.add(logo);
		
		JLabel userName = new JLabel("관리자님 반갑습니다.");
		userName.setHorizontalAlignment(SwingConstants.RIGHT);
		userName.setFont(new Font("굴림", Font.BOLD, 27));
		userName.setForeground(Color.WHITE);
		userName.setBounds(777, 42, 323, 48);
		adminMain.add(userName);
		
		memberLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				ChangePanel.changePanel(mf, adminMain, 영화관리);
			}
		});
		
		movieLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				ChangePanel.changePanel(mf, adminMain, 영화관리);
			}
		});
		
		payLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				ChangePanel.changePanel(mf, adminMain, 상품관리);
			}
		});

	}
}
