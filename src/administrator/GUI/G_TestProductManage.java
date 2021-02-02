package administrator.GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.ProductDAO;
import dto.ProductDTO;

public class G_TestProductManage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G_TestProductManage window = new G_TestProductManage();
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
	public G_TestProductManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ProductDTO pDTO = new ProductDTO();
		ProductDAO pDAO = new ProductDAO();
		
		frame = new JFrame("상품 관리");
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel productM = new JLabel("상품 관리");
		productM.setHorizontalAlignment(SwingConstants.CENTER);
		productM.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		productM.setLocation(543, 134);
		productM.setSize(439, 73);
		frame.getContentPane().add(productM,"Center");
		
		
		JList list = new JList();
		list.setBounds(194, 243, 302, 415);
		frame.getContentPane().add(list);
		
		
		
		
		
		
		
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
