package run.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dto.MemberDTO;
import member.MemberManager;
import run.MainFrame;

public class PayHistory extends JPanel{
	
	private MainFrame mf;
	private JPanel payHistory;
	private MemberManager memberManager = new MemberManager();

	public PayHistory(MainFrame mf, MemberDTO memberInfo) {
		this.mf = mf;
		this.payHistory = this;
		
		payHistory.setBackground(new Color(153, 50, 204));
		payHistory.setBounds(0, 0, 1200, 800);
		payHistory.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(Color.WHITE);
		white.setBounds(200, 80, 800, 600);
		payHistory.add(white);
		
		JList list = new JList(memberManager.showMovie(memberInfo).toArray());
		list.setBackground(Color.WHITE);
		
		list.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		JScrollPane scroller = new JScrollPane(list);
		scroller.setBounds(70, 150, 295, 400);
		
		scroller.setPreferredSize(new Dimension(300, 580));
		JTextField selected = new JTextField(20);
		selected.setBackground(Color.WHITE);
		selected.setBounds(435, 150, 295, 400);
		
		selected.setEditable(false);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				selected.setText((String)list.getSelectedValue());
			}
		});
		white.setLayout(null);

		
		white.add(scroller);
		white.add(selected);
		
		JLabel title = new JLabel("결제내역");
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(200, 53, 400, 70);
		white.add(title);
		
		JLabel arrow1 = new JLabel(">>");
		arrow1.setFont(new Font("굴림", Font.BOLD, 30));
		arrow1.setBounds(377, 194, 46, 70);
		white.add(arrow1);
		
		JLabel arrow2 = new JLabel(">>");
		arrow2.setFont(new Font("굴림", Font.BOLD, 30));
		arrow2.setBounds(377, 439, 46, 70);
		white.add(arrow2);
		
		JLabel back = new JLabel("<-Back");
		back.setFont(new Font("굴림", Font.BOLD, 16));
		back.setBounds(12, 10, 71, 28);
		white.add(back);

	}

}
