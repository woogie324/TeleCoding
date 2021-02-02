package run.member;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import member.MemberManager;
import run.ChangePanel;
import run.MainFrame;

public class Join extends JPanel{

	private MainFrame mf;
	private JPanel join;
	private int idC = 0;
	private int pwC = 0;
	private char gender = '남';
	private MemberManager memberManager = new MemberManager();
	private JTextField idText;
	private JTextField nameText;
	private JTextField birthText;
	private JTextField addrText;
	private JPasswordField pwText;
	private JPasswordField pwCheckText;
	
	public Join(MainFrame mf) {
		this.mf = mf;
		this.join = this;
		join.setBackground(new Color(153, 50, 204));
		join.setBounds(0, 0, 1184, 820);
		join.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(new Color(255, 255, 255));
		white.setBounds(300, 130, 600, 500);
		join.add(white);
		white.setLayout(null);
		
		JLabel title = new JLabel("회원가입");
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(246, 79, 127, 41);
		white.add(title);
		
		// Label 
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 15));
		idLabel.setBounds(110, 148, 98, 25);
		white.add(idLabel);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setFont(new Font("굴림", Font.BOLD, 15));
		pwLabel.setBounds(110, 185, 98, 25);
		white.add(pwLabel);
		
		JLabel pwCheckLabel = new JLabel("비밀번호 확인");
		pwCheckLabel.setFont(new Font("굴림", Font.BOLD, 15));
		pwCheckLabel.setBounds(110, 220, 98, 25);
		white.add(pwCheckLabel);
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(new Font("굴림", Font.BOLD, 15));
		nameLabel.setBounds(110, 255, 98, 25);
		white.add(nameLabel);
		
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setFont(new Font("굴림", Font.BOLD, 15));
		birthLabel.setBounds(110, 290, 98, 25);
		white.add(birthLabel);
		
		JLabel genderLabel = new JLabel("성별");
		genderLabel.setFont(new Font("굴림", Font.BOLD, 15));
		genderLabel.setBounds(110, 325, 98, 25);
		white.add(genderLabel);
		
		JLabel addrLabel = new JLabel("주소");
		addrLabel.setFont(new Font("굴림", Font.BOLD, 15));
		addrLabel.setBounds(110, 360, 98, 25);
		white.add(addrLabel);
		
		// Text
		idText = new JTextField();
		idText.setBounds(220, 148, 200, 25);
		idText.setColumns(20);
		white.add(idText);
		
		pwText = new JPasswordField();
		pwText.setColumns(20);
		pwText.setBounds(220, 185, 200, 25);
		white.add(pwText);		
		
		pwCheckText = new JPasswordField();
		pwCheckText.setColumns(20);
		pwCheckText.setBounds(220, 220, 200, 25);
		white.add(pwCheckText);
		
		nameText = new JTextField();
		nameText.setColumns(20);
		nameText.setBounds(220, 255, 200, 25);
		white.add(nameText);
		
		birthText = new JTextField("ex)20210101",20);
		birthText.setBounds(220, 290, 200, 25);
		white.add(birthText);
		
		addrText = new JTextField();
		addrText.setColumns(20);
		addrText.setBounds(220, 360, 200, 25);
		white.add(addrText);
		
		// Radio
		JRadioButton btnM = new JRadioButton("남자");
		btnM.setBackground(Color.WHITE);
		btnM.setBounds(220, 326, 80, 23);
		white.add(btnM);
		btnM.setSelected(true);
		
		JRadioButton btnW = new JRadioButton("여자");
		btnW.setBackground(Color.WHITE);
		btnW.setBounds(340, 326, 80, 23);
		white.add(btnW);
		
		ButtonGroup gdButton = new ButtonGroup();
        gdButton.add(btnM);
        gdButton.add(btnW);
		
		// Button
		JButton btnIdCheack = new JButton("중복확인");
		btnIdCheack.setBounds(426, 150, 90, 25);
		white.add(btnIdCheack);
		
		JButton btnPwCheack = new JButton("확인");
		btnPwCheack.setBounds(426, 220, 90, 25);
		white.add(btnPwCheack);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBounds(110, 412, 396, 25);
		white.add(btnJoin);
		
		// Anonymous Class
        btnM.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	gender = '남';
            }
            
        });
        
        btnW.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	gender = '여';
            }
            
        });
        
        btnIdCheack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(idText.getText().equals("")) {
            		JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
				}else if(memberManager.doubleCheck(idText.getText())) {
            		JOptionPane.showMessageDialog(null, "이미 사용중인 ID입니다.");
            		idC = 0;
            	}else {
					JOptionPane.showMessageDialog(null, "사용 가능한 ID입니다.");
            		idC++;
            	}
            }
            
        });
        
        btnPwCheack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(pwText.getText().equals("") || pwCheckText.getText().equals("")) {
            		JOptionPane.showMessageDialog(null, "PW를 입력해주세요.");
				}else if(pwText.getText().equals(pwCheckText.getText())){
					JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
					pwC++;
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					pwC = 0;
				}	
            }
            
        });
        
        btnJoin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(idC == 0) {
            		JOptionPane.showMessageDialog(null, "ID 중복확인을 해주세요.");
				}else if(pwC == 0) {
            		JOptionPane.showMessageDialog(null, "비밀번호가 일치하는지 확인해주세요.");
				}else if(nameText.getText().equals("") || birthText.getText().equals("") || birthText.getText().equals("ex)20210101") || addrText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸없이 입력해주세요.");
				}else if(birthText.getText().length() != 8) {
					JOptionPane.showMessageDialog(null, "양식에 맞춰 입력해주세요");
				}else if(memberManager.join(idText.getText(), pwText.getText(), nameText.getText(), birthText.getText(), gender, addrText.getText())) {
					JOptionPane.showMessageDialog(null, "회원가입 성공!");
					ChangePanel.changePanel(mf, join, new Login(mf));
				}else {
					JOptionPane.showMessageDialog(null, "회원가입 실패!");
				}
            }
            
        });
        
	}
}