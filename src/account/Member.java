package account;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import dao.MemberDAO;
import dto.MemberDTO;

public class Member {
	Scanner sc = new Scanner(System.in);
	MemberDTO dto = new MemberDTO();
	MemberDAO dao = new MemberDAO();
	
	public int login() {
		int login = 0;
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.next();
		System.out.print("비밀번호를 입력해주세요 : ");
		String pw = sc.next();
		
		try {
			login = dao.login(id, pw);
			return login;
			
		} catch (IOException e) {
			e.printStackTrace();
			return login;
		}
	}

	public void join() throws IOException {
		//ID
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			if(dao.idCheck(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
			}else {
				dto.setId(id);
				
				if(dto.getId() != "" && dto.getId() != null) {
					break;
				}else {
					System.out.println("아이디를 입력해주세요.");
				}
			}
		}
		//PW
		while(true) {
			while(true) {
				System.out.print("비밀번호 : ");
				String pw = sc.nextLine();
				dto.setPw(pw);
				
				if(dto.getPw() != "" && dto.getPw() != null) {
					break;
				}else {
					System.out.println("비밀번호를 입력해주세요");
				}
			}
			System.out.print("비밀번호확인 : ");
			String pw2 = sc.nextLine();
			
			if(dto.getPw().equals(pw2)) {
				break;
			}else {
				System.out.println("입력하신 비밀번호와 다릅니다.");
			}
		}
		//Name
		while(true) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			dto.setName(name);
			if(dto.getName() != "" && dto.getName() != null) {
				break;
			}else {
				System.out.println("이름을 입력해주세요.");
			}
		}
		//Gender
		while(true) {
			System.out.print("성별 (남, 여) : ");
			String gender = sc.nextLine();
			dto.setGender(gender);
			
			if(dto.getGender() != "" && dto.getGender() != null) {
				if(dto.getGender().equals("남") || dto.getGender().equals("여")) {
					break;
				}else {
					System.out.println("\'남\' 혹은 \'여\' 로만 입력해주세요.");
				}
			}else {
				System.out.println("성별을 입력해주세요.");
			}
		}
		//Addr
		while(true) {
			System.out.print("주소 : ");
			String addr = sc.nextLine();
			dto.setAddr(addr);
			
			if(dto.getAddr() != "" && dto.getAddr() != null) {
				break;
			}else {
				System.out.println("주소를 입력해주세요.");
			}
		}
		
		dao.insert(dto.getId(),dto.getPw(),dto.getName(),dto.getGender(),dto.getAddr());
	}

	public void searchId() {
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		try {
			dao.searchId(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void searchPw() {
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		try {
			dao.searchPw(id, name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(MemberDTO log) throws IOException {
		System.out.println("1. id : " + log.getId());
		System.out.println("2. pw : " + log.getPw());
		System.out.println("3. name : " + log.getName());
		System.out.println("4. gender : " + log.getGender());
		System.out.println("5. addr : " + log.getAddr());		
		System.out.println("0. 취소하기");
		
		System.out.print("수정할 번호를 입력해주세요 : ");
		int no = sc.nextInt();
		sc.nextLine();
		switch(no) {
			case 1 : 
				System.out.print("변경할 id : ");
				String id = sc.nextLine();
				dao.update(log, 1, id); 
				break;
			case 2 : 
				System.out.print("변경할 pw : ");
				String pw = sc.nextLine();
				dao.update(log, 2, pw); 
				break;
			case 3 : 
				System.out.print("변경할 name : ");
				String name = sc.nextLine();
				dao.update(log, 3, name); 
				break;
			case 4 : 
				System.out.print("변경할 gender : ");
				String gender = sc.nextLine();
				dao.update(log, 4, gender); 
				break;
			case 5 : 
				System.out.print("변경할 addr : ");
				String addr = sc.nextLine();
				dao.update(log, 5, addr); 
				break;
			case 0 : 
				System.out.println("취소되었습니다."); break;
			default : 
				System.out.println("잘못된 번호가 입력됐습니다.");
		}
	}

	public void delete(MemberDTO log) throws IOException {
		System.out.print("정말 삭제하시겠습니까? Yes : 1, No : 0");
		int yesNo = sc.nextInt();
		if(yesNo == 1) {
			dao.delete(log);
		}else {
			System.out.println("삭제가 취소되었습니다.");
		}
		
	}

	public void showMovie(MemberDTO log) {
		/* Date를 String으로 변환하는법 */
		/*
		 * Date from = new Date();
		 * SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * String to = transFormat.format(from);
		 */
		String showMoive[][] = {
				{"아이언맨1", "2021-01-23 09:50:21"},
				{"아이언맨1", "2021-01-23 09:50:21"},
		};
		for(int i = 0; i < showMoive.length; i++) {
			System.out.println(Arrays.toString(showMoive[i]));
		}
		
	}


}
