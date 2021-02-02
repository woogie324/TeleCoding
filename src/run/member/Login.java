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

public class Login extends JPanel {

	private MainFrame mf;
	private JPanel login;
	private JTextField idText;
	private JPasswordField pwText;
	private MemberManager memberManager = new MemberManager();

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login window = new Login();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public Login(MainFrame mf) {
		this.mf = mf;
		this.login = this;

		login.setBackground(new Color(153, 50, 204));
		login.setBounds(0, 0, 1184, 820);
		login.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(300, 200, 600, 400);
		login.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(272, 85, 81, 41);
		panel_1.add(lblNewLabel);
		
		// Label

		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel.setBounds(191, 153, 31, 25);
		panel_1.add(idLabel);
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setFont(new Font("굴림", Font.BOLD, 20));
		pwLabel.setBounds(191, 204, 32, 25);
		panel_1.add(pwLabel);
		
		// Text
		
		idText = new JTextField();
		idText.setBounds(235, 155, 200, 25);
		panel_1.add(idText);
		idText.setColumns(20);
		
		pwText = new JPasswordField();
		pwText.setColumns(20);
		pwText.setBounds(235, 204, 200, 25);
		panel_1.add(pwText);
		
		// Button
		
		JButton btnSearchId = new JButton("ID찾기");
		btnSearchId.setBounds(181, 239, 80, 25);
		panel_1.add(btnSearchId);
		
		JButton btnSearchPw = new JButton("PW찾기");
		btnSearchPw.setBounds(273, 239, 80, 25);
		panel_1.add(btnSearchPw);
		
		JButton btnJoin = new JButton("JOIN");
		btnJoin.setBounds(365, 240, 80, 25);
		panel_1.add(btnJoin);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(181, 274, 264, 25);
		panel_1.add(btnLogin);
		
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
            	if(memberInfo != null) {
            		JOptionPane.showMessageDialog(null, "로그인 성공");
            		ChangePanel.changePanel(mf, login, new Main(mf, memberInfo));
            	} else {
            		JOptionPane.showMessageDialog(null, "ID 혹은 PW가 다릅니다.");
            	}
            }
            
        });
		
		mf.add(login);
	}
}
