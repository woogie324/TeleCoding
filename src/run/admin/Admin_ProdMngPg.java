package run.admin;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.ProductDAO;
import dto.ProductDTO;
import run.ChangePanel;
import run.MainFrame;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Admin_ProdMngPg extends JPanel {
	
	private MainFrame mf;
	private JPanel prodMng;
	
	public Admin_ProdMngPg(MainFrame mf) {
		this.mf = mf;
		this.prodMng = this;
		
		this.setLayout(null);
		this.setBounds(0, 0, 1200, 800);
		
		JLabel prodMngTitle = new JLabel("상품 관리");
		prodMngTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		prodMngTitle.setHorizontalAlignment(SwingConstants.CENTER);
		prodMngTitle.setLocation(346, 98);
		prodMngTitle.setSize(604, 57);
		this.add(prodMngTitle);
		
		JButton btn1 = new JButton("상품명 수정");
		btn1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn1.setBounds(750, 186, 200, 50);
		
		JButton btn2 = new JButton("상품가격 수정");
		btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn2.setBounds(750, 314, 200, 50);
		
		JButton btn3 = new JButton("상품 삭제");
		btn3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn3.setBounds(750, 442, 200, 50);
		
		JButton btn4 = new JButton("상품 목록 초기화");
		btn4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn4.setBounds(750, 570, 200, 50);
		
		JLabel label = new JLabel("선택된 항목 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setSize(120, 30);
		label.setLocation(346, 542);
		this.add(label);
		
		JTextField selected = new JTextField(20);
		selected.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		selected.setSize(243, 30);
		selected.setLocation(465, 542);
		selected.setEditable(false);
		this.add(selected);
		
		JLabel label2 = new JLabel("가격 : ");
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		label2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label2.setSize(120, 30);
		label2.setLocation(346, 590);
		this.add(label2);
		
		JTextField selected2 = new JTextField(20);
		selected2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		selected2.setSize(243, 30);
		selected2.setLocation(465, 590);
		selected2.setEditable(false);
		this.add(selected2);
		
		
		JLabel btnBack = new JLabel();
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setHorizontalAlignment(SwingConstants.CENTER);
		btnBack.setIcon(new ImageIcon("img\\back-1.png"));
		btnBack.setBounds(346, 98, 70, 70);
		this.add(btnBack);
		
		
		ProductDAO pDAO = new ProductDAO();
		ProductDTO pDTO = new ProductDTO();
		
		//================= 상품 목록 출력 (JList) ===================
		
			DefaultListModel listModel = new DefaultListModel();
			
			for(ProductDTO a : pDAO.readDB()) {
				listModel.addElement(a.getProductNum()+". "+a.getProductName());
			}
			
			JList prodList = new JList(listModel);
			prodList.setBorder(new LineBorder(new Color(105, 105, 105), 2, true));
			prodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			prodList.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			
			prodList.setBounds(346,186,362,343);
			
			this.add(prodList);
		
		
		//================= 선택항목 TxtField 설정  ===================
		
			prodList.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					
					selected.setText((String)prodList.getSelectedValue());
					
					for(ProductDTO a : pDAO.readDB()) {
						if(prodList.getSelectedValue().equals(a.getProductNum()+". "+a.getProductName())) {
							selected2.setText(Integer.toString(a.getProductPrice()) + "원");
						}
					}
					
				}
			});
		
		//================= 상품명 수정  ===================
		
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if((String)prodList.getSelectedValue() != null) { 
						new Admin_ChangeProdName((String)prodList.getSelectedValue());
					} else {
						new Admin_SelecNoti();
					}
				}
			});
		
		//================= 상품 가격 수정  ===================
			
			btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if((String)prodList.getSelectedValue() != null) { 
						new Admin_ChangeProdPrice((String)prodList.getSelectedValue());
					} else {
						new Admin_SelecNoti();
					}
				}
			});		
		
		//================= 상품 삭제  ===================
			
			btn3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if((String)prodList.getSelectedValue() != null) { 
						new Admin_RemoveProd((String)prodList.getSelectedValue());
					} else {
						new Admin_SelecNoti();
					}
					
				}
			});
		
		//==================목록 초기화 =================
			
			btn4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new ProductDAO().prodDB();
					new Admin_ProdInit();
					
				}
			});
			
		//================== 뒤로가기  =================
			
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					ChangePanel.changePanel(mf, prodMng, new Admin_MainPg(mf));
				};
			});
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btnBack);
		
		
			
		
		
		
		
		
	}
}
