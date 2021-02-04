package dto;

import java.io.Serializable;

public class PaymentDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1786173601363444283L;
	private String nickName;		// 사용자 이름
	private String movie;			// 영화
	private String area;			// 장소
	private String date;			// 영화시간
	private String time;			// 영화시간
	private String seat;			// 영화 좌석
	private String viewer;			// 사람 명수
	private int ticketPrice;		// 티켓 가격
	private String product;			// 상품 선택
	private String productPrice;	// 상품 선택
	private String cardName;		// 카드 선택
	private String cardDiscount;	// 카드 할인률
	private int pay;				// 총가격
	private String toDay; 			// 티켓 구매 날짜

	
	public PaymentDTO() {}


	public PaymentDTO(String nickName, String movie, String area, String date, String time, String seat, String viewer,
			int ticketPrice, String product, String productPrice, String cardName, String cardDiscount, int pay,
			String toDay) {
		super();
		this.nickName = nickName;
		this.movie = movie;
		this.area = area;
		this.date = date;
		this.time = time;
		this.seat = seat;
		this.viewer = viewer;
		this.ticketPrice = ticketPrice;
		this.product = product;
		this.productPrice = productPrice;
		this.cardName = cardName;
		this.cardDiscount = cardDiscount;
		this.pay = pay;
		this.toDay = toDay;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getMovie() {
		return movie;
	}


	public void setMovie(String movie) {
		this.movie = movie;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getSeat() {
		return seat;
	}


	public void setSeat(String seat) {
		this.seat = seat;
	}


	public String getViewer() {
		return viewer;
	}


	public void setViewer(String viewer) {
		this.viewer = viewer;
	}


	public int getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public String getCardName() {
		return cardName;
	}


	public void setCardName(String cardName) {
		this.cardName = cardName;
	}


	public String getCardDiscount() {
		return cardDiscount;
	}


	public void setCardDiscount(String cardDiscount) {
		this.cardDiscount = cardDiscount;
	}


	public int getPay() {
		return pay;
	}


	public void setPay(int pay) {
		this.pay = pay;
	}


	public String getToDay() {
		return toDay;
	}


	public void setToDay(String toDay) {
		this.toDay = toDay;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "PaymentDTO [nickName=" + nickName + ", movie=" + movie + ", area=" + area + ", date=" + date + ", time="
				+ time + ", seat=" + seat + ", viewer=" + viewer + ", ticketPrice=" + ticketPrice + ", product="
				+ product + ", productPrice=" + productPrice + ", cardName=" + cardName + ", cardDiscount="
				+ cardDiscount + ", pay=" + pay + ", toDay=" + toDay + "]";
	}


	

}
