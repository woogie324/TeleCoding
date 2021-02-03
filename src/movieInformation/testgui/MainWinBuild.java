package movieInformation.testgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dto.MemberDTO;
import run.MainFrame;
import run.ChangePanel;

import java.awt.Image;


public class MainWinBuild extends JPanel {

	// 패널
	
	private JPanel superPanel;
	private MainFrame mf;

	
	public MainWinBuild(MainFrame mf, MemberDTO memberInfo) {
		this.mf = mf;
		this.superPanel = this;
		
		
		superPanel.setBackground(Color.WHITE);
		superPanel.setBounds(0, 0, 1200, 800);
		superPanel.setLayout(null);
			
		
		/* 상단 소개 */
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.MAGENTA);
		mainPanel.setBounds(12, 10, 1162, 34);
		superPanel.add(mainPanel);
		mainPanel.setLayout(null);
		
		JTextArea mpText = new JTextArea("텔레코딩 영화관");
		mpText.setEditable(false);
		mpText.setFont(new Font("굴림", Font.PLAIN, 13));
		mpText.setBounds(510, 10, 101, 24);
		mpText.setBackground(Color.MAGENTA);
		mainPanel.add(mpText);
		
		
		/* 차트 */
		JPanel ascMovPanel = new JPanel();
		ascMovPanel.setBackground(SystemColor.menu);
		ascMovPanel.setBounds(110, 50, 900, 210);
		superPanel.add(ascMovPanel);
		ascMovPanel.setLayout(null);
		
		JButton btnAscMovies = new JButton("영화순위 보기");
		btnAscMovies.setBounds(400, 0, 115, 23);
		ascMovPanel.add(btnAscMovies);
		btnAscMovies.setForeground(Color.BLACK);
		btnAscMovies.setBackground(Color.MAGENTA);

		JLabel ascMovies1 = new JLabel();
		ascMovies1.setIcon(new ImageIcon("movimages/movie2.jpg"));
		ascMovies1.setBounds(57, 35, 150, 165);
		ascMovPanel.add(ascMovies1);
		
		JLabel ascMovies2 = new JLabel();
		ascMovies2.setIcon(new ImageIcon("movimages/movie5.jpg"));
		ascMovies2.setBounds(219, 35, 150, 165);
		ascMovPanel.add(ascMovies2);
		
		JLabel ascMovies3 = new JLabel();
		ascMovies3.setIcon(new ImageIcon("movimages/movie4.jpg"));
		ascMovies3.setBounds(381, 35, 150, 165);
		ascMovPanel.add(ascMovies3);

		JLabel ascMovies4 = new JLabel();
		ascMovies4.setIcon(new ImageIcon("movimages/movie3.jpg"));
		ascMovies4.setBounds(543, 35, 150, 165);
		ascMovPanel.add(ascMovies4);
		
		JLabel ascMovies5 = new JLabel();
		ascMovies5.setIcon(new ImageIcon("movimages/movie1.jpg"));
		ascMovies5.setBounds(705, 35, 150, 165);
		ascMovPanel.add(ascMovies5);
		
		
		/* 영화 상영작 */
		/* 패널*/
		JPanel movMainPanel = new JPanel();
		movMainPanel.setBackground(SystemColor.menu);
		movMainPanel.setBounds(110, 270, 900, 210);
		superPanel.add(movMainPanel);
		movMainPanel.setLayout(null);
		
		/* 버튼 */
		JButton btnMovies = new JButton("상영작");
		btnMovies.setForeground(Color.BLACK);
		btnMovies.setBounds(400, 0, 115, 23);
		btnMovies.setBackground(Color.MAGENTA);
		movMainPanel.add(btnMovies);
		
		/* 영화 라벨들 */
		JLabel movie1 = new JLabel();
		movie1.setIcon(new ImageIcon("movimages/movie1.jpg"));
		movie1.setBounds(57, 35, 150, 165);
		movMainPanel.add(movie1);
		
		JLabel movie2 = new JLabel();
		movie2.setIcon(new ImageIcon("movimages/movie2.jpg"));
		movie2.setBounds(219, 35, 150, 165);
		movMainPanel.add(movie2);
		
		JLabel movie3 = new JLabel();
		movie3.setIcon(new ImageIcon("movimages/movie3.jpg"));
		movie3.setBounds(381, 35, 150, 165);
		movMainPanel.add(movie3);
		
		JLabel movie4 = new JLabel();
		movie4.setIcon(new ImageIcon("movimages/movie4.jpg"));
		movie4.setBounds(543, 35, 150, 165);
		movMainPanel.add(movie4);
		
		JLabel movie5 = new JLabel();
		movie5.setIcon(new ImageIcon("movimages/movie5.jpg"));
		movie5.setBounds(705, 35, 150, 165);
		movMainPanel.add(movie5);
		
		
		/* 상영 예정작 */
		JPanel schMovMainPanel = new JPanel();
		schMovMainPanel.setBackground(SystemColor.menu);
		schMovMainPanel.setBounds(110, 490, 900, 210);
		superPanel.add(schMovMainPanel);
		schMovMainPanel.setLayout(null);
		
		/* 버튼 */
		JButton btnSchMovies = new JButton("상영 예정작");
		btnSchMovies.setForeground(Color.BLACK);
		btnSchMovies.setBounds(400, 0, 115, 23);
		btnSchMovies.setBackground(Color.MAGENTA);
		schMovMainPanel.add(btnSchMovies);
		
		/* 예정영화 라벨들 */
		JLabel schMovies1 = new JLabel();
		schMovies1.setIcon(new ImageIcon("movimages/schmovie1.jpg"));
		schMovies1.setBounds(218, 35, 150, 165);
		schMovMainPanel.add(schMovies1);
		
		JLabel schMovies2 = new JLabel();
		schMovies2.setIcon(new ImageIcon("movimages/schmovie2.jpg"));
		schMovies2.setBounds(380, 35, 150, 165);
		schMovMainPanel.add(schMovies2);
		
		JLabel schMovies3 = new JLabel();
		schMovies3.setIcon(new ImageIcon("movimages/schmovie3.jpg"));
		schMovies3.setBounds(542, 35, 150, 165);
		schMovMainPanel.add(schMovies3);

		
		/* 뒤로가기 버튼 */
		JButton bakBtn = new JButton("뒤로 가기");
		bakBtn.setBounds(1074, 665, 100, 34);
		superPanel.add(bakBtn);
		bakBtn.setBackground(Color.LIGHT_GRAY);
		
		
		
		
		
		/* 클릭시 영화 정보 및 예매하기로 넘어가는 마우스액션 */
		movie1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));
			}
		});
		
		movie2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));

			}
		});
		movie3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));
				
			}
		});
		movie4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));
				
			}
		});
		movie5.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));
				
			}
		});

		
		
		
		/* 클릭 시 예정 영화 정보로 넘어가는 마우스액션 */
		schMovies1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));
				
			}
		});
		schMovies2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));
				
			}
		});
		schMovies3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));

			}
		});
		
		
		
		/* 뒤로가기 마우스액션 */
		bakBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, superPanel, new MovieListWinBuild(mf, memberInfo));
				
			}
		});
		

		
		mf.getContentPane().add(superPanel);
		
		
			
	}		// initialize 종료
	
	
}			// 클래스 종료

