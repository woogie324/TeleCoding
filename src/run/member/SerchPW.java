package run.member;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import member.MemberManager;
import java.awt.Color;

public class SerchPW extends JFrame {

	private MemberManager memberManager = new MemberManager();
	
	public SerchPW() {
        setTitle("PW 찾기");

        
        JPanel searchP = new JPanel();
        searchP.setBackground(new Color(153, 50, 204));
        searchP.setLayout(null);
        setContentPane(searchP);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(12, 42, 224, 210);
        searchP.add(panel);
        panel.setLayout(null);
        
        JLabel searchL = new JLabel("회원님의 이름과 ID를 입력해주세요.");
        searchL.setBounds(12, 10, 200, 25);
        panel.add(searchL);
        
        JLabel nmLabel = new JLabel("NAME : ");
        nmLabel.setBounds(12, 50, 80, 25);
        panel.add(nmLabel);
        
        JLabel idLabel = new JLabel("ID : ");
        idLabel.setBounds(12, 90, 80, 25);
        panel.add(idLabel);
        
        JTextField nmText = new JTextField(20);
        nmText.setBounds(112, 50, 100, 25);
        panel.add(nmText);
        
        JTextField idText = new JTextField(20);
        idText.setBounds(112, 90, 100, 25);
        panel.add(idText);
        
        JButton btnSearch = new JButton("PW 찾기");
        btnSearch.setBounds(12, 130, 200, 25);
        panel.add(btnSearch);
        
        JLabel value = new JLabel();
        value.setBounds(12, 170, 200, 25);
        panel.add(value);
        
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//               JLabel 안에 변수명 입력해야함
				String checkPw = memberManager.searchPw(nmText.getText(), idText.getText());
				if(checkPw != null) {
					value.setText("회원님의 pw는 \"" + checkPw + "\"입니다.");
				} else {
					value.setText("일치하는 회원이 존재하지 않습니다.");
				}
            }
            
        });
        
        setBounds(200, 200, 264, 322);
        setResizable(false);
        setVisible(true);
	}
}
