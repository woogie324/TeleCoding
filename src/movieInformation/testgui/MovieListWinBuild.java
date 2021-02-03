package movieInformation.testgui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MovieListWinBuild extends JPanel{


	private JPanel superPanel;
	private MainFrame mf;

	private JTextField movName;
	private JTextField story;
	private JTextField actor;
	private JTextField drtor;
	private JTextField vsitor;


	
	public MovieListWinBuild(MainFrame mf) {
		this.mf = mf;
		this.superPanel = this;

		superPanel.setBackground(Color.WHITE);
		superPanel.setBounds(0, 0, 1200, 800);
		superPanel.setLayout(null);
		
		/* 모든 걸 담는 값 메인 패널 */
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 1200, 800);
		mainPanel.setLayout(null);
		
		/* 상단 소개란 */
		JPanel info = new JPanel();
		info.setBounds(10, 10, 1164, 34);
		info.setBackground(Color.MAGENTA);
		mainPanel.add(info);
		
		JTextArea mpText = new JTextArea("텔레코딩 영화관");
		mpText.setFont(new Font("굴림", Font.PLAIN, 13));
		mpText.setBounds(510, 10, 101, 24);
		mpText.setEditable(false);
		mpText.setBackground(Color.MAGENTA);
		info.add(mpText);
		
		
		/* 영화 정보 : 제목, 감독, 관람 수 */
		JPanel infoPanel1 = new JPanel();
		infoPanel1.setBackground(SystemColor.menu);
		infoPanel1.setBounds(172, 54, 738, 165);
		mainPanel.add(infoPanel1);
		infoPanel1.setLayout(null);
		
		movName = new JTextField();
		movName.setFont(new Font("굴림", Font.PLAIN, 15));
		movName.setEditable(false);
		movName.setBounds(12, 10, 96, 21);
		movName.setBackground(Color.MAGENTA);
		movName.setText("영화제목 :");
		infoPanel1.add(movName);
		movName.setColumns(10);
		
		drtor = new JTextField();
		drtor.setFont(new Font("굴림", Font.PLAIN, 15));
		drtor.setEditable(false);
		drtor.setBounds(12, 51, 96, 21);
		drtor.setBackground(Color.MAGENTA);
		drtor.setText("감독 :");
		infoPanel1.add(drtor);
		drtor.setColumns(10);
		
		vsitor = new JTextField();
		vsitor.setFont(new Font("굴림", Font.PLAIN, 15));
		vsitor.setEditable(false);
		vsitor.setBounds(12, 96, 96, 21);
		vsitor.setBackground(Color.MAGENTA);
		vsitor.setText("관람수 : "); 
		infoPanel1.add(vsitor);
		vsitor.setColumns(10);

		
		/* 영화 정보 : 줄거리, 배우 */
		JPanel infoPanel2 = new JPanel();
		infoPanel2.setBackground(SystemColor.menu);
		infoPanel2.setBounds(10, 227, 900, 442);
		mainPanel.add(infoPanel2);
		infoPanel2.setLayout(null);
		
		story = new JTextField();
		story.setFont(new Font("굴림", Font.PLAIN, 15));
		story.setEditable(false);
		story.setBounds(12, 10, 96, 21);
		story.setBackground(Color.MAGENTA);
		story.setText("줄거리 :");
		infoPanel2.add(story);
		story.setColumns(10);
		
		actor = new JTextField();
		actor.setFont(new Font("굴림", Font.PLAIN, 15));
		actor.setEditable(false);
		actor.setBounds(12, 200, 96, 21);
		actor.setBackground(Color.MAGENTA);
		actor.setText("배우 :");
		infoPanel2.add(actor);
		actor.setColumns(10);
		
		
		
		/* 영화별 이미지(바뀌어야 됨) */
		JPanel movieImg = new JPanel();
		
		movieImg.setBackground(Color.RED);
		movieImg.setBounds(10, 54, 150, 165);
		mainPanel.add(movieImg);
		
		
		/* 예매 버튼 */
		JPanel RsvPanel = new JPanel();
		RsvPanel.setBounds(922, 460, 252, 165);
		mainPanel.add(RsvPanel);
		RsvPanel.setLayout(null);

		JButton RsvBtn = new JButton("(현재작)예매");
		RsvBtn.setFont(new Font("굴림", Font.PLAIN, 25));
		RsvBtn.setToolTipText("");
		RsvBtn.setBounds(12, 5, 228, 150);
		RsvPanel.add(RsvBtn);
		RsvBtn.setBackground(Color.MAGENTA);
		
		
		/* 뒤로가기 버튼 */
		JButton bakBtn = new JButton("뒤로 가기");
		bakBtn.setBounds(1074, 635, 100, 34);
		mainPanel.add(bakBtn);
		bakBtn.setBackground(Color.LIGHT_GRAY);

		
		bakBtn.addMouseListener(new  MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MainWinBuild(mf));
				
			}
		});

		RsvBtn.addMouseListener(new  MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MainWinBuild(mf));
				
			}
		});
		
		

		
		superPanel.add(mainPanel);
		
	}
}
