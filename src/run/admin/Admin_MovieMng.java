package run.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dto.ExMovieInfoDTO;
import dto.NowMovieInfoDTO;
import movieinfo.MovieInfoManager;
import run.ChangePanel;
import run.MainFrame;
import run.admin.movie.ex.ExAdd;
import run.admin.movie.ex.ExUpdate;
import run.admin.movie.now.NowAdd;
import run.admin.movie.now.NowUpdate;

public class Admin_MovieMng extends JPanel{
	
	private MainFrame mf;
	private JPanel movieMng;
	private final JLabel lblNewLabel = new JLabel("");
	
	public Admin_MovieMng(MainFrame mf) {
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		
		this.mf = mf;
		this.movieMng = this;
		
		this.setLayout(null);
		this.setBounds(0, 0, 1200, 800);
		
		JLabel nowTitle = new JLabel("현재 상영 영화");
		nowTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		nowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		nowTitle.setBounds(302, 223, 158, 25);
		this.add(nowTitle);
		
		JLabel exTitle = new JLabel("상영 예정 영화");
		exTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		exTitle.setHorizontalAlignment(SwingConstants.CENTER);
		exTitle.setBounds(727, 223, 158, 25);
		this.add(exTitle);
		
		JLabel label1 = new JLabel("선택 :");
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label1.setBounds(246, 574, 80, 30);
		this.add(label1);
		
		JLabel label2 = new JLabel("선택 :");
		label2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		label2.setBounds(671, 574, 80, 30);
		this.add(label2);
		
		JTextField selectedNow = new JTextField();
		selectedNow.setBackground(Color.WHITE);
		selectedNow.setColumns(10);
		selectedNow.setBounds(302, 574, 214, 30);
		selectedNow.setEditable(false);
		this.add(selectedNow);
		
		JTextField selectedEx = new JTextField();
		selectedEx.setBackground(Color.WHITE);
		selectedEx.setColumns(10);
		selectedEx.setBounds(727, 574, 214, 30);
		selectedEx.setEditable(false);
		this.add(selectedEx);
		
		//========================제목 가져오기=========================
		MovieInfoManager movieManager = new MovieInfoManager();
		
		ArrayList<String> now = new ArrayList<String>();
		for(NowMovieInfoDTO n : movieManager.NowShow()) {
			now.add(n.getTitle());
		}
		
		ArrayList<String> ex = new ArrayList<String>();
		for(ExMovieInfoDTO n : movieManager.ExShow()) {
			ex.add(n.getTitle());
		}
		
		//========================List=========================
		JList nowList = new JList(now.toArray());
		nowList.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		nowList.setBorder(new LineBorder(Color.GRAY, 2, true));
		nowList.setBounds(246, 261, 270, 300);
		this.add(nowList);
		
		JList exList = new JList(ex.toArray());
		exList.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		exList.setBorder(new LineBorder(Color.GRAY, 2, true));
		exList.setBounds(671, 261, 270, 300);
		this.add(exList);
		
		//========================btn ex====================
		JButton btnAddEX = new JButton("추가");
		btnAddEX.setBounds(671, 633, 80, 50);
		this.add(btnAddEX);
		btnAddEX.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JButton btnUpEX = new JButton("수정");
		btnUpEX.setBounds(765, 633, 80, 50);
		this.add(btnUpEX);
		btnUpEX.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JButton btnDelEX = new JButton("삭제");
		btnDelEX.setBounds(861, 633, 80, 50);
		this.add(btnDelEX);
		btnDelEX.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		//========================btn now====================
		JButton btnAddNow = new JButton("추가");
		btnAddNow.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnAddNow.setBounds(246, 633, 80, 50);
		this.add(btnAddNow);
		
		JButton btnUpNow = new JButton("수정");
		btnUpNow.setFont(new Font("굴림", Font.BOLD, 16));
		btnUpNow.setBounds(342, 633, 80, 50);
		this.add(btnUpNow);
		
		JButton btnDelNow = new JButton("삭제");
		btnDelNow.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnDelNow.setBounds(436, 633, 80, 50);
		this.add(btnDelNow);
		
		//=======================리스트 선택 결과====================
		nowList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectedNow.setText(((String) nowList.getSelectedValue()));
			}
			
		});
		
		exList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectedEx.setText(((String) exList.getSelectedValue()));
			}
			
		});
		
		//=======================btn action(now)====================
		btnAddNow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NowAdd();
			}
		});
		btnUpNow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NowUpdate(((String) nowList.getSelectedValue()));
				
			}
		});
		btnDelNow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieInfoManager movie = new MovieInfoManager();
            	movie.NowDelete((String) nowList.getSelectedValue());
            	JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");			
			}
		});
			
		//=======================btn action(Ex)====================
		btnAddEX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ExAdd();
			}
		});
		btnUpEX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new ExUpdate(((String) exList.getSelectedValue()));
			}
		});
		btnDelEX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieInfoManager movie = new MovieInfoManager();
            	movie.ExDelete((String) exList.getSelectedValue());
            	JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");			
			}
		});
		
		//=======================뒤로가기 버튼====================
		JLabel btnBack = new JLabel();
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setHorizontalAlignment(SwingConstants.CENTER);
		btnBack.setIcon(new ImageIcon("img\\back-1.png"));
		btnBack.setBounds(40, 130, 50, 50);
		this.add(btnBack);
		
		JLabel movieMngTitle = new JLabel("영화 관리");
		movieMngTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		movieMngTitle.setHorizontalAlignment(SwingConstants.CENTER);
		movieMngTitle.setBounds(0, 110, 1200, 100);
		this.add(movieMngTitle);
		lblNewLabel.setIcon(new ImageIcon("img\\toplabel-1.png"));
		lblNewLabel.setBounds(0, 0, 1200, 100);
		add(lblNewLabel);
		
		btnBack.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel.changePanel(mf, movieMng, new Admin_MainPg(mf));
				
			}
		});
		
	}
	
}
