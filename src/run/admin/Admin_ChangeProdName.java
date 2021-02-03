package run.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ProductDAO;
import dto.ProductDTO;

public class Admin_ChangeProdName extends JFrame {
	
	private ProductDTO pDTO = new ProductDTO();
	private ProductDAO pDAO = new ProductDAO();
	
	public Admin_ChangeProdName(String selected) {
		
		JFrame cpnf = new JFrame("상품명 수정");
		cpnf.setBounds(200,200,420,200);
		
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel("변경된 상품명을 입력하세요 : ");
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label1.setBounds(42, 13, 330, 36);
		
		JTextField text1 = new JTextField(20);
		text1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		text1.setHorizontalAlignment(SwingConstants.LEFT);
		text1.setBounds(76, 56, 263, 30);
		
		panel.setLayout(null);
		panel.add(label1);
		
		panel.add(text1);
		
		cpnf.getContentPane().add(panel);
		
		JButton btn1 = new JButton("수정");
		btn1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn1.setLocation(158, 99);
		btn1.setSize(98, 30);
		
		JLabel result = new JLabel("");
		result.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setLocation(0, 135);
		result.setSize(414, 30);
		
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ProductDTO b = null;
				for(ProductDTO a : pDAO.readDB()) {
					if(selected.equals(a.getProductNum()+". "+a.getProductName())) {
						a.setProductName(text1.getText());
						b = a;
					}
				}
				
				pDAO.prodUpdate(b);
				
				result.setText(text1.getText() + "로 수정 완료 되었습니다.");
				btn1.setText("닫기");
				btn1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						cpnf.dispose();
					}
				});
			}
		});
		
		
		panel.add(result);
		panel.add(btn1);
		cpnf.setLocationRelativeTo(null);
		cpnf.setResizable(false);
		cpnf.setVisible(true);
		cpnf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
