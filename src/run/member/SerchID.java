package run.member;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import member.MemberManager;

public class SerchID extends JFrame {

	private MemberManager memberManager = new MemberManager();
	
	public SerchID() {
        setTitle("ID 찾기");

        
        JPanel searchP = new JPanel();
        searchP.setBackground(new Color(153, 50, 204));
        searchP.setLayout(null);
        setContentPane(searchP);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(12, 35, 210, 161);
        searchP.add(panel);
        panel.setLayout(null);
        
        JLabel searchL = new JLabel("회원님의 이름을 입력해주세요.");
        searchL.setBounds(18, 10, 174, 25);
        panel.add(searchL);
        
        JLabel nmLabel = new JLabel("NAME : ");
        nmLabel.setBounds(6, 49, 80, 25);
        panel.add(nmLabel);
        
        JTextField nmText = new JTextField(20);
        nmText.setBounds(106, 49, 100, 25);
        panel.add(nmText);
        
        JButton btnSearch = new JButton("ID 찾기");
        btnSearch.setBounds(6, 89, 200, 25);
        panel.add(btnSearch);
        
        JLabel value = new JLabel();
        value.setBounds(6, 126, 200, 25);
        panel.add(value);
        
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//               JLabel 안에 변수명 입력해야함
//            	value.setText("사용자의 아이디값");
            	String checkId = memberManager.searchId(nmText.getText());
				if(checkId != null) {
					value.setText("회원님의 id는 \"" + checkId + "\"입니다.");
				} else {
					value.setText("일치하는 회원이 존재하지 않습니다.");
				}
            }
            
        });
        
        setBounds(200, 200, 250, 259);
        setResizable(false);
        setVisible(true);
	}
}
