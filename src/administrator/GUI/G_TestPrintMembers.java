package administrator.GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import administrator.PrintMembers;
import dto.MemberDTO;

public class G_TestPrintMembers {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G_TestPrintMembers window = new G_TestPrintMembers();
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
	public G_TestPrintMembers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("회원 목록 조회");
		frame.setBounds(100, 100, 1200, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JTextArea printM = new JTextArea();
		printM.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		printM.setEditable(false);
		panel.add(printM, "Center");
		
		frame.getContentPane().add(panel, "Center");
		
		JLabel label1 = new JLabel("아이디 \t 이름 \t 성별 \t 생년월일 \t 주소\t 가입일\t");
		label1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		printM.add(label1);
		
		PrintMembers mem = new PrintMembers();
		
		for(MemberDTO a : mem.returnMembers()) {
			printM.append(a.getId() + "\t" + a.getName() + "\t" + a.getGender() + "\t" + a.getBirth() + "\t" + a.getAddr() + "\t" + a.getRegDate() + "\n");
		}
		
		
	}

}
