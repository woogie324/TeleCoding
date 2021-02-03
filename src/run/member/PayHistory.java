package run.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import dto.PaymentDTO;
import member.MemberManager;
import run.ChangePanel;
import run.MainFrame;

public class PayHistory extends JPanel{
	
	private MainFrame mf;
	private JPanel payHistory;
	private MemberManager memberManager = new MemberManager();
	private JTextField movieTitle;
	private JTextField placeTimeSeat;
	private JTextField moviePrice;
	private JTextField productName;
	private JTextField productPrice;
	private JTextField discount;
	private JTextField totalPrice;
	private JTextField paymentTime;

	public PayHistory(MainFrame mf, MemberDTO memberInfo) {
		this.mf = mf;
		this.payHistory = this;
		
		payHistory.setBackground(new Color(153, 50, 204));
		payHistory.setBounds(0, 0, 1200, 820);
		payHistory.setLayout(null);
		
		JPanel white = new JPanel();
		white.setBackground(Color.WHITE);
		white.setBounds(200, 80, 800, 600);
		white.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(436, 107, 295, 443);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		// Label
		JLabel title = new JLabel("결제내역");
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(200, 27, 400, 70);
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
		
		
		movieTitle = new JTextField(20);
		movieTitle.setBounds(12, 46, 271, 21);
		panel.add(movieTitle);
		movieTitle.setBackground(Color.WHITE);
		movieTitle.setEditable(false);
		
		JLabel movieTitleLabel = new JLabel("영화명 :");
		movieTitleLabel.setBounds(12, 31, 271, 15);
		panel.add(movieTitleLabel);
		
		placeTimeSeat = new JTextField(20);
		placeTimeSeat.setEditable(false);
		placeTimeSeat.setBackground(Color.WHITE);
		placeTimeSeat.setBounds(12, 92, 271, 21);
		panel.add(placeTimeSeat);
		
		JLabel placeTimeSeatLabel = new JLabel("영화관명, 상영시간, 좌석 :");
		placeTimeSeatLabel.setBounds(12, 77, 271, 15);
		panel.add(placeTimeSeatLabel);
		
		moviePrice = new JTextField(20);
		moviePrice.setEditable(false);
		moviePrice.setBackground(Color.WHITE);
		moviePrice.setBounds(12, 138, 271, 21);
		panel.add(moviePrice);
		
		JLabel moviePriceLabel = new JLabel("표가격 :");
		moviePriceLabel.setBounds(12, 123, 271, 15);
		panel.add(moviePriceLabel);
		
		productName = new JTextField(20);
		productName.setEditable(false);
		productName.setBackground(Color.WHITE);
		productName.setBounds(12, 198, 271, 21);
		panel.add(productName);
		
		JLabel productNameLabel = new JLabel("상품명 : ");
		productNameLabel.setBounds(12, 183, 271, 15);
		panel.add(productNameLabel);
		
		productPrice = new JTextField(20);
		productPrice.setEditable(false);
		productPrice.setBackground(Color.WHITE);
		productPrice.setBounds(12, 244, 271, 21);
		panel.add(productPrice);
		
		JLabel productPriceLabel = new JLabel("상품가격 :");
		productPriceLabel.setBounds(12, 229, 271, 15);
		panel.add(productPriceLabel);
		
		discount = new JTextField(20);
		discount.setEditable(false);
		discount.setBackground(Color.WHITE);
		discount.setBounds(12, 303, 271, 21);
		panel.add(discount);
		
		JLabel discountLabel = new JLabel("할인율 :");
		discountLabel.setBounds(12, 288, 271, 15);
		panel.add(discountLabel);
		
		totalPrice = new JTextField(20);
		totalPrice.setEditable(false);
		totalPrice.setBackground(Color.WHITE);
		totalPrice.setBounds(12, 349, 271, 21);
		panel.add(totalPrice);
		
		JLabel totalPriceLabel = new JLabel("총 가격 :");
		totalPriceLabel.setBounds(12, 334, 271, 15);
		panel.add(totalPriceLabel);
		
		paymentTime = new JTextField(20);
		paymentTime.setEditable(false);
		paymentTime.setBackground(Color.WHITE);
		paymentTime.setBounds(12, 395, 271, 21);
		panel.add(paymentTime);
		
		JLabel paymentTimeLabel = new JLabel("결제시간 : ");
		paymentTimeLabel.setBounds(12, 380, 271, 15);
		panel.add(paymentTimeLabel);
		
		// JList
		ArrayList<PaymentDTO> payment = memberManager.showPayment(memberInfo);
		System.out.println(memberManager.showPayment(memberInfo).toString());
		JList list = new JList(memberManager.showMovie(memberInfo).toArray());
		list.setBackground(Color.WHITE);
		
		list.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		JScrollPane scroller = new JScrollPane(list);
		scroller.setBounds(70, 107, 295, 443);
		
		scroller.setPreferredSize(new Dimension(300, 580));
				
		white.add(scroller);
		white.add(panel);
		
		payHistory.add(white);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String[] payTime = ((String) list.getSelectedValue()).split(",");
				String time = payTime[1];
				
				for(PaymentDTO p : payment) {
					if(time.equals(p.getToDay())) {
						movieTitle.setText(p.getMovie());
						placeTimeSeat.setText(p.getArea()+","+p.getTime()+","+p.getSeat());
						moviePrice.setText(p.getViewer()+" = "+p.getTicketPrice()+"원");
						productName.setText(p.getProduct());
						productPrice.setText(p.getProductPrice());
						discount.setText(p.getCardDiscount() + "%");
						totalPrice.setText(p.getPay()+"원");
						paymentTime.setText(time);
					}
				}
			}
		});
		
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel.changePanel(mf, payHistory, new Main(mf,memberInfo));
			}
		});

	}
}
