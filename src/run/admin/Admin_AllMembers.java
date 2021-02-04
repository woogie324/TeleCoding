package run.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.MemberDAO;
import dto.MemberDTO;
import run.ChangePanel;
import run.MainFrame;
import javax.swing.JButton;

public class Admin_AllMembers extends JPanel {
	
	private MainFrame mf;
	private JPanel printAllMem;
	
	public Admin_AllMembers(MainFrame mf) {
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		this.mf = mf;
		this.printAllMem = this;
		
		this.setLayout(null);
		this.setBounds(0, 0, 1200, 800);
		
		JLabel pgTitle = new JLabel("전체 회원 목록 조회");
		pgTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pgTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		pgTitle.setLocation(0, 110);
		pgTitle.setSize(1200, 100);
		
		
		MemberDAO dao = new MemberDAO();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		
		String[] head = {"아이디" , "이름", "생년월일", "성별", "주소", "가입일자"};
		String[] title = {"아이디" , "이름", "생년월일", "성별", "주소", "가입일자"};
		
		DefaultTableModel tableModel = new DefaultTableModel(head, 0);
		
		JTable table = new JTable(tableModel);
		
		tableModel.addRow(title);
		
		for(MemberDTO m : dao.Member()) {
			String[] rows = {
				m.getId(),
				m.getName(),
				m.getBirth(),
				String.valueOf(m.getGender()),
				m.getAddr(),
				date.format(m.getRegDate())
			};
			tableModel.addRow(rows);
		}
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		table.setBounds(200, 263, 800, 400);
		table.setRowHeight(25);
		table.setPreferredSize(new Dimension(800,400));
		table.setFillsViewportHeight(true);
		table.getColumnModel().getColumn(0).setWidth(150);
		table.getColumnModel().getColumn(1).setWidth(100);
		table.getColumnModel().getColumn(2).setWidth(150);
		table.getColumnModel().getColumn(3).setWidth(50);
		table.getColumnModel().getColumn(4).setWidth(200);
		table.getColumnModel().getColumn(5).setWidth(150);
		
		
		//==================== 내용 가운데 정렬 ====================
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcmSchedule = table.getColumnModel();
			for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
			}
			
			
		//=======================뒤로가기 버튼 =====================
		
			JLabel btnBack = new JLabel("");
			btnBack.setIcon(new ImageIcon("img\\back-1.png"));
			btnBack.setBounds(40, 130, 50, 50);
			this.add(btnBack);
			
			btnBack.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					ChangePanel.changePanel(mf, printAllMem, new Admin_MainPg(mf));
					
				}
			});
			
		this.add(table);
		this.add(pgTitle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\toplabel-1.png"));
		lblNewLabel.setBounds(0, 0, 1200, 100);
		add(lblNewLabel);
		
	}
}
