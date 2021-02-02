package administrator.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class G_TestAdminMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G_TestAdminMain window = new G_TestAdminMain();
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
	public G_TestAdminMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("관리자 메뉴");
		frame.setBounds(100, 100, 1200, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(242, 337, 165, 50);
		frame.getContentPane().add(panel1);
		
		JButton btn1 = new JButton("회원 목록 조회");
		btn1.setSize(250, 50);
		btn1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		
		JButton btn2 = new JButton("상품 관리");
		btn2.setSize(250, 50);
		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		
		JButton btn3 = new JButton("영화 관리");
		btn3.setSize(250, 50);
		btn3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		
		JPanel panel2 = new JPanel();
		panel2.setLocation(552, 337);
		panel2.setSize(165, 50);
		frame.getContentPane().add(panel2);
		panel2.add(btn2);
		
		
		JPanel panel3 = new JPanel();
		panel3.setLocation(830, 337);
		panel3.setSize(165, 50);
		frame.getContentPane().add(panel3);
		panel3.add(btn3);
		
		panel1.add(btn1, "Center");
		panel2.add(btn2, "Center");
		panel3.add(btn3, "Center");
		
		G_TestPrintMembers guiPrintM = new G_TestPrintMembers();
		G_TestProductManage guiProductM = new G_TestProductManage();
		
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guiPrintM.main(null);
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guiProductM.main(null);
				
			}
		});
		
	}

}
