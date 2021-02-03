package run.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
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
import run.admin.movie.now.*;
import run.member.Login;
import run.ChangePanel;
import run.admin.movie.ex.*;

public class MovieManagement {

	private JFrame frame;
	private JTextField textFieldNow;
	private JTextField textFieldEx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieManagement window = new MovieManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MovieManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 50, 204));
		panel.setBounds(0, 0, 1200, 800);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(Color.WHITE);
		white.setBounds(200, 80, 800, 600);
		panel.add(white);
		white.setLayout(null);

		// label
		JLabel title = new JLabel("영화 관리");
		title.setFont(new Font("굴림", Font.BOLD, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(266, 42, 279, 54);
		white.add(title);
		
		JLabel nowTitle = new JLabel("현재 상영 영화");
		nowTitle.setHorizontalAlignment(SwingConstants.CENTER);
		nowTitle.setBounds(235, 106, 158, 15);
		white.add(nowTitle);
		
		JLabel exTitle = new JLabel("상영 예정 영화");
		exTitle.setHorizontalAlignment(SwingConstants.CENTER);
		exTitle.setBounds(419, 106, 158, 15);
		white.add(exTitle);
		
		// 결과
		// label
		JLabel lblNewLabel = new JLabel("선택 :");
		lblNewLabel.setBounds(235, 543, 33, 15);
		white.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("선택 :");
		lblNewLabel_1.setBounds(419, 543, 33, 15);
		white.add(lblNewLabel_1);
		
		// textfield
		textFieldNow = new JTextField();
		textFieldNow.setBounds(277, 537, 116, 21);
		white.add(textFieldNow);
		textFieldNow.setColumns(10);
		textFieldNow.setEditable(false);
		
		
		textFieldEx = new JTextField();
		textFieldEx.setColumns(10);
		textFieldEx.setBounds(461, 537, 116, 21);
		white.add(textFieldEx);
		textFieldEx.setEditable(false);
		
		// 제목 가져오기
		MovieInfoManager movieManager = new MovieInfoManager();
		
		ArrayList<String> now = new ArrayList<String>();
		for(NowMovieInfoDTO n : movieManager.NowShow()) {
			now.add(n.getTitle());
		}
		
		ArrayList<String> ex = new ArrayList<String>();
		for(ExMovieInfoDTO n : movieManager.ExShow()) {
			ex.add(n.getTitle());
		}
		
		// list
		JList nowList = new JList(now.toArray());
		nowList.setBorder(new LineBorder(new Color(0, 0, 0)));
		nowList.setBounds(235, 131, 158, 404);
		white.add(nowList);
		
		JList exList = new JList(ex.toArray());
		exList.setBorder(new LineBorder(new Color(0, 0, 0)));
		exList.setBounds(419, 131, 158, 404);
		white.add(exList);
		
		// btn ex
		JButton btnAddEX = new JButton("추가");
		btnAddEX.setBounds(619, 131, 111, 54);
		white.add(btnAddEX);
		btnAddEX.setFont(new Font("굴림", Font.BOLD, 20));
		
		JButton btnUpEX = new JButton("수정");
		btnUpEX.setBounds(619, 318, 111, 54);
		white.add(btnUpEX);
		btnUpEX.setFont(new Font("굴림", Font.BOLD, 20));
		
		JButton btnDelEX = new JButton("삭제");
		btnDelEX.setBounds(619, 504, 111, 54);
		white.add(btnDelEX);
		btnDelEX.setFont(new Font("굴림", Font.BOLD, 20));
		
		// btn now
		JButton btnAddNow = new JButton("추가");
		btnAddNow.setFont(new Font("굴림", Font.BOLD, 20));
		btnAddNow.setBounds(73, 131, 111, 54);
		white.add(btnAddNow);
		
		JButton btnUpNow = new JButton("수정");
		btnUpNow.setFont(new Font("굴림", Font.BOLD, 20));
		btnUpNow.setBounds(73, 318, 111, 54);
		white.add(btnUpNow);
		
		JButton btnDelNow = new JButton("삭제");
		btnDelNow.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelNow.setBounds(73, 504, 111, 54);
		white.add(btnDelNow);
		
		// anonymous class
		// 리스트 선택 결과
		nowList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textFieldNow.setText(((String) nowList.getSelectedValue()));
			}
			
		});
		
		exList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textFieldEx.setText(((String) exList.getSelectedValue()));
			}
			
		});
		
		// 버튼
		// now
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
		
		// ex
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
		
	}
}
