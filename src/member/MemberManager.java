package member;

import java.util.ArrayList;
import java.util.Date;

import dao.MemberDAO;
import dto.MemberDTO;
import dto.PaymentDTO;

public class MemberManager {
	
	MemberDAO dao = new MemberDAO();
	
	public MemberDTO login(String id, String pw) {
		
		MemberDTO login = dao.login(id, pw);
		return login;
	}

	public boolean join(String id, String pw, String name, String birth, char gender, String addr) {
		
		MemberDTO insert = new MemberDTO(id,pw,name,birth,gender,addr, new java.util.Date());
		boolean yesNo = dao.insert(insert);
		
		return yesNo;
	}

	public String searchId(String name) {
		
		String searchId = dao.searchId(name);
		return searchId;
	}
	
	public String searchPw(String name, String id) {
		
		String searchPw = dao.searchPw(name, id);
		return searchPw;
	}

	public void delete(MemberDTO memberInfo) {
		
		dao.delete(memberInfo);
	}

	public void update(String id, String pw, String name, String birth, char gender, String addr, Date date) {
		MemberDTO memberInfo = new MemberDTO(id,pw,name,birth,gender,addr,date);
		dao.update(memberInfo);
	}

	public boolean doubleCheck(String id) {
		
		boolean yesNo = dao.doubleCheck(id);
		return yesNo;
	}

	public ArrayList<String> showMovie(MemberDTO memberInfo) {
		
		ArrayList<String> show = dao.showMovie(memberInfo);
		return show;
	}

	public ArrayList<PaymentDTO> showPayment(MemberDTO memberInfo) {
		
		ArrayList<PaymentDTO> show = dao.showPayment(memberInfo);
		return show;
	}
	
}