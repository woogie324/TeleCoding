package run.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dto.MemberDTO;
import run.ChangePanel;
import run.MainFrame;
import run.member.Login;
import run.member.*;

public class Admin_MainPg extends JPanel{
	
	private MainFrame mf;
	private JPanel adminMain;

	public Admin_MainPg(MainFrame mf) {
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
		memberPanel.setBounds(24, 369, 300, 150);
		white.add(memberPanel);
		memberPanel.setLayout(null);
		
		JLabel memberLabel = new JLabel("회원 관리");
		memberLabel.setBounds(0, 25, 300, 100);
		memberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		memberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberPanel.add(memberLabel);
		
		JPanel moviePanel = new JPanel();
		moviePanel.setBounds(350, 369, 300, 150);
		white.add(moviePanel);
		moviePanel.setLayout(null);
		
		JLabel movieLabel = new JLabel("영화 관리");
		movieLabel.setBounds(0, 25, 300, 100);
		movieLabel.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		movieLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moviePanel.add(movieLabel);
		
		JPanel payPanel = new JPanel();
		payPanel.setBounds(675, 369, 300, 150);
		white.add(payPanel);
		payPanel.setLayout(null);
		
		JLabel payLabel = new JLabel("상품 관리");
		payLabel.setBounds(0, 25, 300, 100);
		payLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payLabel.setFont(new Font("맑은 고딕", Font.BOLD, 36));
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
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBounds(100, 54, 121, 36);
		adminMain.add(btnLogout);
		
		memberLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel.changePanel(mf, adminMain, new Admin_AllMembers(mf));
			}
		});
		
		movieLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel.changePanel(mf, adminMain, new Admin_MovieMng(mf));
			}
		});
		
		payLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel.changePanel(mf, adminMain, new Admin_ProdMngPg(mf));
			}
		});

		btnLogout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	ChangePanel.changePanel(mf, adminMain, new Login(mf));
            }
            
        });

	}
}
