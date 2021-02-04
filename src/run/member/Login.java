package run.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dto.MemberDTO;
import member.MemberManager;
import run.ChangePanel;
import run.MainFrame;
import run.admin.Admin_MainPg;
import javax.swing.SwingConstants;

public class Login extends JPanel {

	private MainFrame mf;
	private JPanel login;
	private JTextField idText;
	private JPasswordField pwText;
	private MemberManager memberManager = new MemberManager();
	
	public Login(MainFrame mf) {
		this.mf = mf;
		this.login = this;

		login.setBackground(new Color(153, 50, 204));
		login.setBounds(0, 0, 1184, 820);
		login.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(new Color(255, 255, 255));
		white.setBounds(300, 200, 600, 400);
		login.add(white);
		white.setLayout(null);
		
		JLabel title = new JLabel("Login");
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(272, 85, 81, 41);
		white.add(title);
		
		// Label

		
		JLabel idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel.setBounds(182, 153, 41, 25);
		white.add(idLabel);
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwLabel.setFont(new Font("굴림", Font.BOLD, 20));
		pwLabel.setBounds(181, 204, 42, 25);
		white.add(pwLabel);
		
		// Text
		
		idText = new JTextField();
		idText.setBounds(235, 155, 200, 25);
		white.add(idText);
		idText.setColumns(20);
		
		pwText = new JPasswordField();
		pwText.setColumns(20);
		pwText.setBounds(235, 204, 200, 25);
		white.add(pwText);
		
		// Button
		
		JButton btnSearchId = new JButton("ID찾기");
		btnSearchId.setBounds(181, 239, 80, 25);
		white.add(btnSearchId);
		
		JButton btnSearchPw = new JButton("PW찾기");
		btnSearchPw.setBounds(273, 239, 80, 25);
		white.add(btnSearchPw);
		
		JButton btnJoin = new JButton("JOIN");
		btnJoin.setBounds(365, 240, 80, 25);
		white.add(btnJoin);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(181, 274, 264, 25);
		white.add(btnLogin);
		
		 // Anonymous Class
        btnSearchId.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SerchID();
            }
            
        });
        
        btnSearchPw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SerchPW();
            }
            
        });
        
        btnJoin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	ChangePanel.changePanel(mf, login, new Join(mf));
            }
            
        });
        
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	MemberDTO memberInfo = memberManager.login(idText.getText(), pwText.getText());
            	if(idText.getText().equals("admin") && pwText.getText().equals("admin")) {
            		ChangePanel.changePanel(mf, login, new Admin_MainPg(mf));
            	} else {
	            	if(memberInfo != null) {
	            		JOptionPane.showMessageDialog(null, "로그인 성공");
	            		ChangePanel.changePanel(mf, login, new Main(mf, memberInfo));
	            	} else {
	            		JOptionPane.showMessageDialog(null, "ID 혹은 PW가 다릅니다.");
	            	}
            	}
            }
            
        });
		
		mf.getContentPane().add(login);
	}
}
