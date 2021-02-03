package run.member.payment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.PaymentDAO;
import dto.PaymentDTO;

public class Paymentrun extends JPanel {

	private test test;
	private JPanel Payment;
	/* 배열 */
	ArrayList MovieList = new ArrayList();
	ArrayList areaList = new ArrayList();
	ArrayList areaList2 = new ArrayList();
	ArrayList dateList = new ArrayList();
	ArrayList timeList = new ArrayList();
	ArrayList seatList = new ArrayList();
	ArrayList productList = new ArrayList();
	ArrayList ProductListPrice = new ArrayList();
	
	PaymentDAO dao = new PaymentDAO();

	String nickName = "송준원";
	String movie = null; // 영화 이름 변수
	int movidPrice = 0; // 영화 가격 변수
	String movidArea = null; // 영화 장소 변수
	String date = null; // 영화 날짜 변수
	String time = null; // 영화 시간 변수
	String seat = ""; // 영화 좌석2 변수 DTO에 담아줄 변수
	int ticketPrice = 0; // 티켓 겟수를 알아내는 변수
	String product = ""; // 상품2 이름 변수 DTO에 담아줄 변수
	int productPrice = 0; // 상품 가격 변수
	String cardName = null; // 카드 이름 변수
	double cardDiscount = 0; // 카드 할인률 변수
	String toDay = null; // 시간 + 이름
	int viewer = 0;	//보는사람
	int pay = 0; // 총 금액
	int seatCount = 0; 				
	int movieNumber = 0;
	int movieNumber1 = 0;
	int movieNumber2 = 0;
	int movieNumber3 = 0;
	BufferedImage img = null;
	
	public Paymentrun(test test) {
		
		this.test = test;
		this.setSize(1200, 800);
		this.Payment = this;
		
		test.setSize(1200, 800);
		test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			img = ImageIO.read(new File("img/movie.jpg"));
		} catch (IOException e) {
			System.out.println("movie");
			System.exit(0);
		}
		
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1200, 850);
		Payment.setLayout(null);

		int hight1 = 10;
		int width1 = 240;

		JLabel title1 = new JLabel("영화선택");
		title1.setBounds(width1,hight1, 100, 50); //버튼 크기,위치 지정
		Payment.add(title1);
		hight1 += 80;
		JLabel title2 = new JLabel("지역선택");
		title2.setBounds(width1,hight1, 100, 50); //버튼 크기,위치 지정
		Payment.add(title2);
		hight1 += 80;
		JLabel title3 = new JLabel("날짜선택");
		title3.setBounds(width1,hight1, 100, 50); //버튼 크기,위치 지정
		Payment.add(title3);
		hight1 += 80;
		JLabel title4 = new JLabel("시간선택");
		title4.setBounds(width1,hight1, 100, 50); //버튼 크기,위치 지정
		Payment.add(title4);
		hight1 += 80;
		JLabel title5 = new JLabel("좌석선택");
		title5.setBounds(width1,hight1, 100, 50); //버튼 크기,위치 지정
		Payment.add(title5);
		hight1 += 90;
		JLabel title6 = new JLabel("상품선택");
		title6.setBounds(width1,hight1, 100, 50); //버튼 크기,위치 지정
		Payment.add(title6);
		hight1 += 110;
		JLabel title7 = new JLabel("카드선택");
		title7.setBounds(width1,hight1, 100, 50); //버튼 크기,위치 지정
		Payment.add(title7);
		
		MovieList = dao.MovieList();
		areaList = dao.MovieListArea((String) MovieList.get(0));
		dateList = dao.movieDate((String) MovieList.get(0), (String) areaList.get(0));
		timeList = dao.movieTime((String) MovieList.get(0), (String) areaList.get(0), (String) dateList.get(0));
		seatList = dao.movieSeat((String) MovieList.get(0), (String) areaList.get(0), (String) dateList.get(0),(String) timeList.get(0));
		productList = dao.ProductListName();
		ProductListPrice = dao.productPrice();
		int choiceMovie = 0;
		
		/* 영화선택 */
		int hight = 50;
		int width = 240;
		JButton[] btn1 = new JButton[MovieList.size()];
		for (int i = 0; i < MovieList.size(); i++) {
			String List = (String) MovieList.get(i);
			btn1[i] = new JButton(List);//버튼 초기화
			btn1[i].setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
			width += 150;
			Payment.add(btn1[i]);
			btn1[i].setBackground(Color.WHITE);
		}
		
		/* 장소선택 */
		width = 240;
		hight += 80;
		JButton[] btn2 = new JButton[MovieList.size()];
		for (int i = 0; i < areaList.size(); i++) {
			String List = (String) areaList.get(i);
			btn2[i]=new JButton(List);//버튼 초기화
			btn2[i].setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
			width += 150;
			btn2[i].setBackground(Color.WHITE);
			Payment.add(btn2[i]);
		}
		/* 날짜 선택 */
		width = 240;
		hight += 80;
		JButton[] btn3 = new JButton[dateList.size()];
		for (int i = 0; i < dateList.size(); i++) {
			String List = (String) dateList.get(i);
			btn3[i]=new JButton(List);//버튼 초기화
			btn3[i].setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
			width += 150;
			btn3[i].setBackground(Color.WHITE);
			Payment.add(btn3[i]);
		}
		/* 시간 선택 */
		JButton[] btn4 = new JButton[timeList.size()];
		width = 240;
		hight += 80;
		for (int i = 0; i < timeList.size(); i++) {
			String List = (String) timeList.get(i);
			btn4[i] = new JButton(List);// 버튼 초기화
			btn4[i].setBounds(width, hight, 150, 30); // 버튼 크기,위치 지정
			width += 150;
			btn4[i].setBackground(Color.WHITE);
			Payment.add(btn4[i]);
		}
		/* 좌석 선택 */
		width = 240;
		hight += 80;
		JButton[] btn5 = new JButton[seatList.size()];
		for (int i = 0; i < seatList.size()-1; i++) {
			String List = (String) seatList.get(i+1);
			btn5[i] = new JButton(List);// 버튼 초기화
			btn5[i].setBounds(width, hight, 150, 30); // 버튼 크기,위치 지정
			width += 150;
			Payment.add(btn5[i]);
			btn5[i].setBackground(Color.WHITE);
		}
		/* 상품 선택 */
		width = 240;
		hight += 60;
		JButton[] prd = new JButton[productList.size()];
		for (int i = 0; i < productList.size(); i++) {
			if(i % 5 == 0) {
				hight +=30;
				width = 240;
			}
			String List = (String) productList.get(i);
			prd[i]=new JButton(List);//버튼 초기화
			prd[i].setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
			width += 150;
			Payment.add(prd[i]);
			prd[i].setBackground(Color.WHITE);
		}
		
		/* 카드선택 */
		hight += 80;
		width = 240;
		JButton card1 = new JButton();
		JButton card2 = new JButton();
		JButton card3 = new JButton();
		JButton card4 = new JButton();
		card1=new JButton("카카오톡");//버튼 초기화
		card1.setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
		width += 150;
		Payment.add(card1);
		card1.setBackground(Color.WHITE);
	
		card2=new JButton("우리은행");//버튼 초기화
		card2.setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
		width += 150;
		Payment.add(card2);
		card2.setBackground(Color.WHITE);

		card3=new JButton("기업은행");//버튼 초기화
		card3.setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
		width += 150;
		Payment.add(card3);
		card3.setBackground(Color.WHITE);

		card4=new JButton("삼성페이");//버튼 초기화
		card4.setBounds(width,hight, 150, 30); //버튼 크기,위치 지정
		Payment.add(card4);
		card4.setBackground(Color.WHITE);
		
		card4=new JButton("결재하기");//버튼 초기화
		card4.setBounds(240,hight+80, 150, 30); //버튼 크기,위치 지정
		Payment.add(card4);
		card4.setBackground(Color.WHITE);
		Payment.add(panel);
		
	
		setVisible(true);
		/* 영화 버튼선택 하기 */
		btn1[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movie = (String) MovieList.get(0);
				movidPrice = dao.moviePrice(0);
				areaList2 = dao.MovieListArea((String) MovieList.get(0));
				for (int i = 0; i < areaList2.size(); i++) {
				String List2 = (String) areaList2.get(i);
				btn2[i].setText(List2);
				movieNumber = 0;
				}
			}
		});
		btn1[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movie = (String) MovieList.get(1);
				movidPrice = dao.moviePrice(1);
				areaList2 = dao.MovieListArea((String) MovieList.get(1));
				for (int i = 0; i < areaList2.size(); i++) {
				String List2 = (String) areaList2.get(i);
				btn2[i].setText(List2);
				movieNumber = 1;
				}
			}
		});
		btn1[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movie = (String) MovieList.get(2);
				movidPrice = dao.moviePrice(2);
				areaList2 = dao.MovieListArea((String) MovieList.get(2));
				for (int i = 0; i < areaList2.size(); i++) {
				String List2 = (String) areaList2.get(i);
				btn2[i].setText(List2);
				movieNumber = 2;
				}
			}
		});
		btn1[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movie = (String) MovieList.get(3);
				movidPrice = dao.moviePrice(3);
				areaList2 = dao.MovieListArea((String) MovieList.get(3));
				for (int i = 0; i < areaList2.size(); i++) {
				String List2 = (String) areaList2.get(i);
				btn2[i].setText(List2);
				movieNumber = 3;
				}
			}
		});
		btn1[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movie = (String) MovieList.get(4);
				movidPrice = dao.moviePrice(4);
				areaList2 = dao.MovieListArea((String) MovieList.get(4));
				for (int i = 0; i < areaList2.size(); i++) {
				String List2 = (String) areaList2.get(i);
				btn2[i].setText(List2);
				movieNumber = 4;
				System.out.println(movie);
				}
				
			}
			
		});
		
		/* 장소 선택 */
		btn2[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movidArea = (String) areaList2.get(0);
				dateList = dao.movieDate((String) MovieList.get(movieNumber), (String) areaList.get(0));
				for (int i = 0; i < dateList.size(); i++) {
				String List = (String) dateList.get(i);
				btn3[i].setText(List); 
				movieNumber2 = 0;
				}
			}
		});
		btn2[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movidArea = (String) areaList2.get(1);
				dateList = dao.movieDate((String) MovieList.get(movieNumber), (String) areaList.get(1));
				for (int i = 0; i < dateList.size(); i++) {
				String List = (String) dateList.get(i);
				btn3[i].setText(List); 
				movieNumber2 = 1;
				}
			}
		});
		btn2[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movidArea = (String) areaList2.get(2);
				dateList = dao.movieDate((String) MovieList.get(movieNumber), (String) areaList.get(2));
				for (int i = 0; i < dateList.size(); i++) {
				String List = (String) dateList.get(i);
				btn3[i].setText(List); 
				movieNumber2 = 2;
				}
			}
		});
		btn2[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movidArea = (String) areaList2.get(3);
				dateList = dao.movieDate((String) MovieList.get(movieNumber), (String) areaList.get(3));
				for (int i = 0; i < dateList.size(); i++) {
				String List = (String) dateList.get(i);
				btn3[i].setText(List);
				movieNumber2 = 3;
				}
			}
		});
		btn2[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				movidArea = (String) areaList2.get(4);
				dateList = dao.movieDate((String) MovieList.get(movieNumber), (String) areaList.get(4));
				for (int i = 0; i < dateList.size(); i++) {
				String List = (String) dateList.get(i);
				btn3[i].setText(List); 
				movieNumber2 = 4;
				System.out.println(movidArea);
				}
				
			}
			
		});
		/* 날짜 선택 */
		btn3[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				date = (String) dateList.get(0);
				timeList = dao.movieTime((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), (String) dateList.get(0));
				for (int i = 0; i < timeList.size(); i++) {
				String List = (String) timeList.get(i);
				btn4[i].setText(List); 
				movieNumber2 = 0;
				}
			}
		});
		btn3[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				date = (String) dateList.get(1);
				timeList = dao.movieTime((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), (String) dateList.get(1));
				for (int i = 0; i < timeList.size(); i++) {
				String List = (String) timeList.get(i);
				btn4[i].setText(List); 
				movieNumber2 = 1;
				}
			}
		});
		btn3[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				date = (String) dateList.get(2);
				timeList = dao.movieTime((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), (String) dateList.get(2));
				for (int i = 0; i < timeList.size(); i++) {
				String List = (String) timeList.get(i);
				btn4[i].setText(List); 
				movieNumber2 = 2;
				}
			}
		});
		btn3[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				date = (String) dateList.get(3);
				timeList = dao.movieTime((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), (String) dateList.get(3));
				for (int i = 0; i < timeList.size(); i++) {
				String List = (String) timeList.get(i);
				btn4[i].setText(List); 
				movieNumber2 = 3;
				}
			}
		});
		btn3[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				date = (String) dateList.get(4);
				timeList = dao.movieTime((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), (String) dateList.get(4));
				for (int i = 0; i < timeList.size(); i++) {
				String List = (String) timeList.get(i);
				btn4[i].setText(List); 
				movieNumber2 = 4;
				System.out.println(date);
				}
			}
		});
		
		/* 시간 선택 */
		btn4[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time = (String) timeList.get(0);
				seatList = dao.movieSeat((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), 
										 (String) dateList.get(movieNumber2),(String) timeList.get(0));
				for (int i = 0; i < seatList.size()-1; i++) {
					String List = (String) seatList.get(i+1);
				btn5[i].setText(List); 
				}
			}
		});
		btn4[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time = (String) timeList.get(1);
				seatList = dao.movieSeat((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), 
										 (String) dateList.get(movieNumber2),(String) timeList.get(1));
				for (int i = 0; i < seatList.size()-1; i++) {
					String List = (String) seatList.get(i+1);
				btn5[i].setText(List); 
				}
			}
		});
		btn4[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time = (String) timeList.get(2);
				seatList = dao.movieSeat((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), 
										 (String) dateList.get(movieNumber2),(String) timeList.get(2));
				for (int i = 0; i < seatList.size()-1; i++) {
				String List = (String) seatList.get(i+1);
				btn5[i].setText(List); 
				}
			}
		});
		btn4[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time = (String) timeList.get(3);
				seatList = dao.movieSeat((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), 
										 (String) dateList.get(movieNumber2),(String) timeList.get(3));
				for (int i = 0; i < seatList.size()-1; i++) {
					String List = (String) seatList.get(i+1);
				btn5[i].setText(List);  
				}
			}
		});
		btn4[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time = (String) timeList.get(4);
				seatList = dao.movieSeat((String) MovieList.get(movieNumber), (String) areaList.get(movieNumber1), 
										 (String) dateList.get(movieNumber2),(String) timeList.get(4));
				for (int i = 0; i < seatList.size()-1; i++) {
					String List = (String) seatList.get(i+1);
				btn5[i].setText(List); 
				System.out.println(time);
				}
			}
		});
		/* 좌석 선택 */
		btn5[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn5[0].equals("0")) {
				}else{
					seat += (String) seatList.get(1);
					ticketPrice += movidPrice;
					viewer += 1;
				}
				btn5[0].setText("0");
			}
		});
		btn5[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn5[2].equals("0")) {
				}else{
					seat += (String) seatList.get(2);
					ticketPrice += movidPrice;
					viewer += 1;
				}
				btn5[2].setText("0");
			}
		});
		btn5[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn5[2].equals("0")) {
					
				}else{
					seat += (String) seatList.get(3);
					ticketPrice += movidPrice;
					viewer += 1;
				}
				btn5[2].setText("0");
			}
		});
		btn5[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn5[3].equals("0")) {
					
				}else{
					seat += (String) seatList.get(4);
					ticketPrice += movidPrice;
					viewer += 1;
				}
				btn5[3].setText("0");  
			}
		});
		btn5[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn5[4].equals("0")) {
					
				}else{
					seat += (String) seatList.get(5);
					ticketPrice += movidPrice;
					viewer += 1;
				}
				btn5[4].setText("0"); 
				
			}
		});
		/* 상품선택 */
		prd[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				productPrice += (int) ProductListPrice.get(0);
				product +=  (String) productList.get(0) + " ";
			}
		});
		prd[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(1);
				product +=  (String) productList.get(1) + " ";
			}
		});
		prd[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(2);
				product +=  (String) productList.get(2) + " ";
			}
		});
		prd[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(3);
				product +=  (String) productList.get(3) + " ";
			}
		});
		prd[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(4);
				product +=  (String) productList.get(4) + " ";
			}
		});
		prd[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(5);
				product +=  (String) productList.get(5) + " ";
			}
		});
		prd[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(6);
				product +=  (String) productList.get(6) + " ";
			}
		});
		prd[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(7);
				product +=  (String) productList.get(7) + " ";
			}
		});
		prd[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productPrice += (int) ProductListPrice.get(8);
				product +=  (String) productList.get(8) + " ";
			}
		});
		
		card1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardName = "카카오톡";
				cardDiscount = 3.0;
				pay = movidPrice + productPrice;
				pay = (int)(pay - (pay * (cardDiscount / 100)));
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar time = Calendar.getInstance();
				toDay = format1.format(time.getTime())+"";
			}
		});
		card2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardName = "우리은행";
				cardDiscount = 5.0;
				pay = movidPrice + productPrice;
				pay = (int)(pay - (pay * (cardDiscount / 100)));
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar time = Calendar.getInstance();
				toDay = format1.format(time.getTime())+"";
			}
		});
		card3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardName = "기업은행";
				cardDiscount = 1.0;
				pay = movidPrice + productPrice;
				pay = (int)(pay - (pay * (cardDiscount / 100)));
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar time = Calendar.getInstance();
				toDay = format1.format(time.getTime())+"";
			}
		});
		card4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardName = "삼성페이";
				cardDiscount = 2.0;
				pay = movidPrice + productPrice;
				pay = (int)(pay - (pay * (cardDiscount / 100)));
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar time = Calendar.getInstance();
				toDay = format1.format(time.getTime())+"";
			}
		});
	
		card4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(movie+ " "+movidArea+ " "+date+ " "+ time + " "+seat+ " "+ticketPrice+ " "+cardName+ " "+cardDiscount+ " "+pay+ " "+toDay+" "+product+" "+productPrice);
				dao.print(nickName, movie, movidArea, date, time, seat, viewer+"", ticketPrice, product, productPrice+"", cardName, cardDiscount+"", pay, toDay);
			}
		});
		
		test.add(Payment);
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

	public String movie() {
		return movie;		
	}
		
	
}
