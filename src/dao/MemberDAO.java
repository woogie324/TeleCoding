package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dto.MemberDTO;
import dto.PaymentDTO;
import member.MyOutPutStream;

public class MemberDAO {
	
	ObjectOutputStream osOut = null;
	ObjectInputStream osIn = null;

	/* insert */
	public boolean insert(MemberDTO insertMember) {
		
		boolean yesNo = true;

		try {
			if(new File("DB/memberDB.txt").exists()) {
				osOut = new MyOutPutStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",true)));
			}else {
				osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",true)));
			}
			osOut.writeObject(insertMember);
			osOut.flush();
		} catch (Exception e) {
			e.printStackTrace();
			yesNo = false;
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
		return yesNo;
		
	}
	
	/* update */
	public void update(MemberDTO memberInfo) {

		ArrayList<MemberDTO> dummy = new ArrayList<MemberDTO>();
		
		for(MemberDTO m : Member()) {
			if(memberInfo.getId().equals(m.getId())) {
				dummy.add(memberInfo);		
			}else {
				dummy.add(m);
			}	
		}
		
		try {
			osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",false)));
			
			for(MemberDTO object : dummy) {
				osOut.writeObject(object);
				osOut.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
	}
	
	/* delete */
	public void delete(MemberDTO memberInfo) {

		ArrayList<MemberDTO> dummy = new ArrayList<MemberDTO>();
		
		for(MemberDTO m : Member()) {
			if(memberInfo.getId().equals(m.getId()) && memberInfo.getPw().equals(m.getPw())) {
				continue;				
			}else {
				dummy.add(m);
			}	
		}
		
		try {
			osOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/memberDB.txt",false)));
			
			for(MemberDTO object : dummy) {
				osOut.writeObject(object);
				osOut.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			if(osOut != null) try{osOut.close();}catch(IOException e){}	
		}
		
	}
	
	/* 여기서부터 select 부분 */
	/* member */
	public ArrayList<MemberDTO> Member() {
		ArrayList<MemberDTO> member = new ArrayList<>();
		try {
			osIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/memberDB.txt")));
			
			while(true) {
				MemberDTO selectMember = (MemberDTO)osIn.readObject();
				member.add(selectMember);
			}
			
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(osIn != null) try{osIn.close();}catch(IOException e){}	
		}
		return member;
	}
	
	// Login
	public MemberDTO login(String id, String pw) {
		
		MemberDTO loginOnOff = null;

		for(MemberDTO m : Member()) {
			if(m.getId().equals(id) && m.getPw().equals(pw)) {
				loginOnOff = m;
			}
		}

		return loginOnOff;
	}
	
	// searchID
	public String searchId(String name) {
		
		String searchId = null;
			
		for(MemberDTO m : Member()) {
			if(name.equals(m.getName())) {
				searchId = m.getId();
			}
		}
			
		return searchId;
	}
	
	// searchPW
	public String searchPw(String name, String id) {
		
		String searchPw = null;
			
		for(MemberDTO m : Member()) {
			if(name.equals(m.getName()) && id.equals(m.getId())) {
				searchPw = m.getPw();
			}
		}
			
		return searchPw;
	}

	public boolean doubleCheck(String id) {
		boolean yesNo = false;
		
		for(MemberDTO m : Member()) {
			if(id.equals(m.getId())) {
				yesNo = true;
			}
		}
		
		return yesNo;
	}

	/* payment */
	public ArrayList<PaymentDTO> Payment() {
		
		ArrayList<PaymentDTO> payment = new ArrayList<>();
		try {
			osIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/payment.txt")));
			
			while(true) {
				PaymentDTO selectPayment = (PaymentDTO)osIn.readObject();
				payment.add(selectPayment);
			}
			
		} catch (EOFException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(osIn != null) try{osIn.close();}catch(IOException e){}	
		}
		return payment;
	}
	
	// 영화 내역 추출
	public ArrayList<String> showMovie(MemberDTO memberInfo) {
		
		String id = memberInfo.getId();
		ArrayList<String> show = new ArrayList<>();
		for(PaymentDTO p : Payment()) {
			if(id.equals(p.getNickName())) {
				show.add(p.getMovie() + ", " + p.getToDay());
			}
		}
		
		return show;
	}

	// 결제 내역 추출
	public ArrayList<PaymentDTO> showPayment(MemberDTO memberInfo) {
		
		String id = memberInfo.getId();
		ArrayList<PaymentDTO> show = new ArrayList<>();
		
		for(PaymentDTO p : Payment()) {
			if(id.equals(p.getNickName())) {
				show.add(p);
			}
		}
		
		return show;
	}
	
}
