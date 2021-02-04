package movieInformation.testgui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import run.member.payment.Paymentrun;
import dto.ExMovieInfoDTO;
import dto.MemberDTO;
import dto.NowMovieInfoDTO;
import movieinfo.MovieInfoManager;
import run.MainFrame;
import run.ChangePanel;

public class SchMovieListWinBuild extends JPanel{


	private JPanel superPanel;
	private MainFrame mf;
	private MovieInfoManager movieManager = new MovieInfoManager();

	private JTextField title;
	private JTextField story;
	private JTextField actor;
	private JTextField director;


	
	public SchMovieListWinBuild(MainFrame mf, MemberDTO memberInfo) {
		this.mf = mf;
		this.superPanel = this;

		
		String NickName = memberInfo.getName();

		
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
		
		title = new JTextField();
		title.setFont(new Font("굴림", Font.PLAIN, 15));
		title.setEditable(false);
		title.setBounds(12, 10, 96, 21);
		title.setBackground(Color.MAGENTA);
		title.setText("영화제목 :");
		infoPanel1.add(title);
		title.setColumns(10);
		
		director = new JTextField();
		director.setFont(new Font("굴림", Font.PLAIN, 15));
		director.setEditable(false);
		director.setBounds(12, 51, 96, 21);
		director.setBackground(Color.MAGENTA);
		director.setText("감독 :");
		infoPanel1.add(director);
		director.setColumns(10);

		
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
		
		
		
		
		/* 뒤로가기 버튼 */
		JButton bakBtn = new JButton("뒤로 가기");
		bakBtn.setBounds(1074, 635, 100, 34);
		mainPanel.add(bakBtn);
		bakBtn.setBackground(Color.LIGHT_GRAY);

		/* 뒤로가기 마우스액션 */
		bakBtn.addMouseListener(new  MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MainWinBuild(mf, memberInfo));
				
			}
		});

		
		
		
		
		
		
		
//		// JList
		ArrayList<ExMovieInfoDTO> ExMovieInfo = movieManager.ExShow();
		
		@SuppressWarnings("unchecked")
		JList<Object> list = new JList<Object>(movieManager.NowShow().toArray());
		list.setVisibleRowCount(20);
		list.setBackground(Color.WHITE);
		
		list.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		mainPanel.add(infoPanel2);
		
		superPanel.add(mainPanel);
		
//		list.addListSelectionListener(new ListSelectionListener() {
			
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				String[] payTime = ((String) list.getSelectedValue()).split(",");
//				String time = payTime[1];
////				
//				
//				for(ExMovieInfoDTO p : ExMovieInfo) {
//					if(time.equals(p.getTitle())) {
//						title.setText(p.getTitle());
//						story.setText(p.getStory());
//						actor.setText(p.getActor());
//						director.setText(p.getDirector());
////						vsitor.setCaret(p.getShowNum());
////						img.set
//					}
//				}
//			}
//		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		superPanel.add(mainPanel);
		
	}
}
