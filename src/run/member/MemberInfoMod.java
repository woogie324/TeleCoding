package run.member;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.SwingConstants;

import dto.MemberDTO;

import javax.swing.JCheckBox;

public class MemberInfoMod extends JPanel{

	private MainFrame mf;
	private JPanel memberInfoMod;
	private int pwC = 1;
	private boolean yesNo = true;
	private boolean pwYesNo = true;
	private char gender;
	private MemberManager memberManager = new MemberManager();
	private JTextField idText;
	private JTextField nameText;
	private JTextField birthText;
	private JTextField addrText;
	private JPasswordField pwText;
	private JPasswordField pwCheckText;
	
	public MemberInfoMod(MainFrame mf,MemberDTO memberInfo) {
		this.mf = mf;
		this.memberInfoMod = this;
		this.gender = memberInfo.getGender();
		
		memberInfoMod.setBackground(new Color(153, 50, 204));
		memberInfoMod.setBounds(0, 0, 1184, 820);
		memberInfoMod.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(new Color(255, 255, 255));
		white.setBounds(300, 130, 600, 500);
		memberInfoMod.add(white);
		white.setLayout(null);
		
		JLabel title = new JLabel("회원정보수정");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(208, 79, 200, 41);
		white.add(title);
		
		JLabel back = new JLabel("<-Back");
		back.setFont(new Font("굴림", Font.BOLD, 16));
		back.setBounds(12, 10, 71, 28);
		white.add(back);
		
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
		idText = new JTextField(memberInfo.getId());
		idText.setBounds(220, 148, 200, 25);
		idText.setColumns(20);
		white.add(idText);
		idText.setEditable(false);
		
		pwText = new JPasswordField(memberInfo.getPw());
		pwText.setColumns(20);
		pwText.setBounds(220, 185, 200, 25);
		white.add(pwText);	
		pwText.setEditable(false);
		
		pwCheckText = new JPasswordField();
		pwCheckText.setColumns(20);
		pwCheckText.setBounds(220, 220, 200, 25);
		white.add(pwCheckText);
		pwCheckText.setEditable(false);
		
		nameText = new JTextField(memberInfo.getName());
		nameText.setColumns(20);
		nameText.setBounds(220, 255, 200, 25);
		white.add(nameText);
		nameText.setEditable(false);
		
		birthText = new JTextField(memberInfo.getBirth());
		birthText.setColumns(20);
		birthText.setBounds(220, 290, 200, 25);
		white.add(birthText);
		birthText.setEditable(false);
		
		addrText = new JTextField(memberInfo.getAddr());
		addrText.setColumns(20);
		addrText.setBounds(220, 360, 200, 25);
		white.add(addrText);
		addrText.setEditable(false);
		
		// Radio
		JRadioButton btnM = new JRadioButton("남자");
		btnM.setBackground(Color.WHITE);
		btnM.setBounds(220, 326, 80, 23);
		white.add(btnM);
		
		JRadioButton btnW = new JRadioButton("여자");
		btnW.setBackground(Color.WHITE);
		btnW.setBounds(340, 326, 80, 23);
		white.add(btnW);
		
		ButtonGroup gdButton = new ButtonGroup();
        gdButton.add(btnM);
        gdButton.add(btnW);
        if(memberInfo.getGender() == '남') {
        	btnM.setSelected(true);
        }else {
        	btnW.setSelected(true);
        }
        btnM.setEnabled(false);
        btnW.setEnabled(false);
		
        // Button
		JButton btnPwCheack = new JButton("확인");
		btnPwCheack.setBounds(442, 221, 64, 25);
		white.add(btnPwCheack);
        
		JButton btnInfoModify = new JButton("회원정보수정");
		btnInfoModify.setBounds(110, 412, 396, 25);
		white.add(btnInfoModify);
		
		JButton btnDelete = new JButton("회원탈퇴");
		btnDelete.setBounds(110, 447, 396, 25);
		white.add(btnDelete);
		
		// CheckBox
		JCheckBox pwCheck = new JCheckBox("선택");
		pwCheck.setBounds(442, 185, 64, 25);
		white.add(pwCheck);
		
		JCheckBox nameCheck = new JCheckBox("선택");
		nameCheck.setBounds(442, 256, 64, 25);
		white.add(nameCheck);
		
		JCheckBox birthCheck = new JCheckBox("선택");
		birthCheck.setBounds(442, 290, 64, 25);
		white.add(birthCheck);
		
		JCheckBox genderCheck = new JCheckBox("선택");
		genderCheck.setBounds(442, 326, 64, 25);
		white.add(genderCheck);
		
		JCheckBox addrCheck = new JCheckBox("선택");
		addrCheck.setBounds(442, 360, 64, 25);
		white.add(addrCheck);
		
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
        
        pwCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	pwText.setEditable(true);
            	pwCheckText.setEditable(true);
            	pwYesNo = false;
            	yesNo = false;
            }
            
        });
        
        nameCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	nameText.setEditable(true);
            	yesNo = false;
            }
            
        });
        
        birthCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	birthText.setEditable(true);
            	yesNo = false;
            }
            
        });
        
        genderCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	btnM.setEnabled(true);
            	btnW.setEnabled(true);
            	yesNo = false;
            }
            
        });
        
        addrCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	addrText.setEditable(true);
            	yesNo = false;
            }
            
        });
        
        btnPwCheack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(pwYesNo) {
            		JOptionPane.showMessageDialog(null, "PW체크박스를 선택하지 않았습니다.");
            	}else if(pwText.getText().equals("") || pwCheckText.getText().equals("")) {
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
        
        btnInfoModify.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(yesNo) {
            		JOptionPane.showMessageDialog(null, "변경된 값이 없습니다.");
            	}else if(pwC == 0) {
            		JOptionPane.showMessageDialog(null, "비밀번호가 일치하는지 확인해주세요.");
				}else if(nameText.getText().equals("") || birthText.getText().equals("") || birthText.getText().equals("ex)20210101") || addrText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸없이 입력해주세요.");
				}else if(birthText.getText().length() != 8) {
					JOptionPane.showMessageDialog(null, "양식에 맞춰 입력해주세요");
				}else {
					memberManager.update(idText.getText(), pwText.getText(), nameText.getText(), birthText.getText(), gender, addrText.getText(), memberInfo.getRegDate());
					JOptionPane.showMessageDialog(null, "회원정보수정으로 인해 로그아웃됩니다.");
					ChangePanel.changePanel(mf, memberInfoMod, new Login(mf));
				}
            }
            
        });
        
        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	int num = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
            	if(num == 0) {
            		memberManager.delete(memberInfo);
            		JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
            		ChangePanel.changePanel(mf, memberInfoMod, new Login(mf));
            	}
            }
            
        });
        
        back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel.changePanel(mf, memberInfoMod, new Main(mf,memberInfo));
			}
		});
        
        
        
	}
}