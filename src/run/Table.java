package run;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MemberDAO;
import dto.MemberDTO;

public class Table {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		JFrame mf = new JFrame();
		mf.setBounds(100,100,500,300);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String[] head = {"아이디" , "비밀번호", "이름", "생년월일", "성별", "주소", "가입일자"};
		String[] title = {"아이디" , "비밀번호", "이름", "생년월일", "성별", "주소", "가입일자"};
		
		DefaultTableModel tableModel = new DefaultTableModel(head, 0);
		JTable table = new JTable(tableModel);
		tableModel.addRow(title);
		table.setSize(500, 300);
		
		for(MemberDTO m : dao.Member()) {
			String[]rows = {
				m.getId(),
				m.getPw(),
				m.getName(),
				m.getBirth(),
				String.valueOf(m.getGender()),
				m.getAddr(),
				date.format(m.getRegDate())
			};
			tableModel.addRow(rows);
		}
		
		mf.add(table);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
