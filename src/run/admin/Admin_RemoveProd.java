package run.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ProductDAO;
import dto.ProductDTO;

public class Admin_RemoveProd extends JFrame{
	
	private ProductDTO pDTO = new ProductDTO();
	private ProductDAO pDAO = new ProductDAO();
	
	public Admin_RemoveProd(String selected) {
		
		JFrame rempf = new JFrame("상품 삭제");
		rempf.setBounds(200,200,420,200);

		JPanel panel = new JPanel();

		JLabel removeQ = new JLabel(selected + "(을)를 삭제하시겠습니까?");
		removeQ.setHorizontalAlignment(SwingConstants.CENTER);
		removeQ.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		removeQ.setBounds(0, 13, 414, 21);

		JButton okay = new JButton("확인");
		okay.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		okay.setLocation(111, 57);
		okay.setSize(78, 44);

		JButton cancel = new JButton("닫기");
		cancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		cancel.setLocation(228, 57);
		cancel.setSize(78, 44);

		JLabel result = new JLabel();
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		result.setBounds(0, 125, 414, 36);

		okay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

//				ProductDTO b = null;
				for(ProductDTO a : pDAO.readDB()) {
					if(selected.equals(a.getProductNum()+". "+a.getProductName())) {
						pDAO.prodRemove(a);
					}
				}

				okay.setEnabled(false);
				result.setText(selected + "가 삭제되었습니다.");
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rempf.dispose();
			}
		});

		panel.setLayout(null);


		panel.add(removeQ);
		panel.add(result);
		panel.add(okay);
		panel.add(cancel);
		rempf.getContentPane().add(panel);
		rempf.setLocationRelativeTo(null);
		rempf.setResizable(false);
		rempf.setVisible(true);
		rempf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}

}
