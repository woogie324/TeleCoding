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
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		this.mf = mf;
		this.prodMng = this;
		
		this.setLayout(null);
		this.setBounds(0, 0, 1200, 800);
		
		
		JLabel prodMngTitle = new JLabel("상품 관리");
		prodMngTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		prodMngTitle.setHorizontalAlignment(SwingConstants.CENTER);
		prodMngTitle.setLocation(0, 110);
		prodMngTitle.setSize(1200, 100);
		this.add(prodMngTitle);
		
		JButton btn1 = new JButton("상품명 수정");
		btn1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btn1.setBounds(702, 260, 200, 50);
		
		JButton btn2 = new JButton("상품가격 수정");
		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btn2.setBounds(702, 356, 200, 50);
		
		JButton btn3 = new JButton("상품 삭제");
		btn3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btn3.setBounds(702, 454, 200, 50);
		
		JButton btn4 = new JButton("상품 목록 초기화");
		btn4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btn4.setBounds(702, 553, 200, 50);
		
		JLabel label = new JLabel("선택된 항목 : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setSize(137, 30);
		label.setLocation(277, 616);
		this.add(label);
		
		JTextField selected = new JTextField(20);
		selected.setBackground(Color.WHITE);
		selected.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		selected.setSize(243, 30);
		selected.setLocation(428, 617);
		selected.setEditable(false);
		this.add(selected);
		
		JLabel label2 = new JLabel("가격 : ");
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		label2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label2.setSize(137, 30);
		label2.setLocation(277, 664);
		this.add(label2);
		
		JTextField selected2 = new JTextField(20);
		selected2.setBackground(Color.WHITE);
		selected2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		selected2.setSize(243, 30);
		selected2.setLocation(428, 665);
		selected2.setEditable(false);
		this.add(selected2);
		
		
		ProductDAO pDAO = new ProductDAO();
		ProductDTO pDTO = new ProductDTO();
		
		//================= 상품 목록 출력 (JList) ===================
		
			DefaultListModel listModel = new DefaultListModel();
			
			for(ProductDTO a : pDAO.readDB()) {
				listModel.addElement(a.getProductNum()+". "+a.getProductName());
			}
			
			JList prodList = new JList(listModel);
			prodList.setBorder(new LineBorder(Color.GRAY, 2, true));
			prodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			prodList.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			
			prodList.setBounds(277,260,394,343);
			
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
		JLabel btnBack = new JLabel();
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setHorizontalAlignment(SwingConstants.CENTER);
		btnBack.setIcon(new ImageIcon("img\\back-1.png"));
		btnBack.setBounds(40, 130, 50, 50);
		this.add(btnBack);
		
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\toplabel-1.png"));
		lblNewLabel.setBounds(0, 0, 1200, 100);
		add(lblNewLabel);
		
		
			
		
		
		
		
		
	}
}
