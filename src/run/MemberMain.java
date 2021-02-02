package run;

import java.util.Scanner;

import dto.MemberDTO;
import dto.PaymentDTO;
import member.MemberManager;

public class MemberMain {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberManager memberManager = new MemberManager();
		int no;
		String id;
		String pw;
		String name;
		String birth;
		char gender;
		String addr;
		
		while(true) {
			System.out.println("원하는 명령을 선택하세요.");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 아이디 찾기");
			System.out.println("4. 비밀번호 찾기");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("입력 : ");
			no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
				case 1 : 
					
					while(true) {
						System.out.print("아이디 : ");
						id = sc.nextLine();
						if(id.equals("") || id.equals(null) || id.equals(" ")) {
							System.out.println("아이디를 입력해주세요!");
						}else if(memberManager.doubleCheck(id)){
							System.out.println("이미 존재하는 아이디입니다.");
						}else {
							break;
						}
					}
					
					while(true) {
						System.out.print("비밀번호 : ");
						pw = sc.nextLine();
						if(pw.equals("") || pw.equals(null) || pw.equals(" ")) {
							System.out.println("비밀번호를 입력해주세요!");
						}else {
							break;
						}
					}
						
					while(true) {
						System.out.print("이름 : ");
						name = sc.nextLine();
						if(name.equals("") || name.equals(null) || name.equals(" ")) {
							System.out.println("이름을 입력해주세요!");
						}else {
							break;
						}
					}
						
					while(true) {
						System.out.print("생년월일 ex)20210125 : ");
						birth = sc.nextLine();
						if(birth.equals("") || birth.equals(null) || birth.equals(" ")) {
							System.out.println("생년월일을 입력해주세요!");
						}else if(birth.length() < 8 || birth.length() > 8){
							System.out.println("양식에 맞춰 적어주세요!");
						}else {
							break;
						}
					}
						
					while(true) {
						System.out.print("성별 : ");
						gender = sc.nextLine().charAt(0);
						if(birth.equals("") || birth.equals(null) || birth.equals(" ")) {
							System.out.println("성별을 입력해주세요!");
						}else if(gender == '남' || gender == '여') {
							break;
						}else {
							System.out.println("\"남\" 혹은 \"여\"를 입력해주세요!");
							
						}
					}
					
					while(true) {
						System.out.print("주소 : ");
						addr = sc.nextLine();
						if(addr.equals("") || addr.equals(null) || addr.equals(" ")) {
							System.out.println("주소를 입력해주세요!");
						}else {
							break;
						}
					}
						
					if(memberManager.join(id, pw, name, birth, gender, addr)) {
						System.out.println("환영합니다!");
					}else {
						System.out.println("회원가입에 실패했습니다.");
					}
					break;
					
				case 2 : 
					System.out.print("아이디를 입력해주세요 : ");
					id = sc.next();
					System.out.print("비밀번호를 입력해주세요 : ");
					pw = sc.next();
					MemberDTO memberInfo = memberManager.login(id, pw);
					if(memberInfo != null) {
						System.out.println(memberInfo.getId() + "님 반갑습니다.");
						while(true) {
							System.out.println("원하는 명령을 선택하세요.");
							System.out.println("1. 계정관리");
							System.out.println("2. 예매내역");
							System.out.println("0. 로그아웃");
							
							System.out.print("입력 : ");
							no = sc.nextInt();
							switch(no) {
								case 1 : 
									// 계정관리
									while(true) {
										System.out.println("원하는 명령을 선택하세요.");
										System.out.println("1. 회원정보수정");
										System.out.println("2. 회원탈퇴");
										System.out.println("3. 관람내역");
										System.out.println("0. 로그아웃");
										
										System.out.print("입력 : ");
										no = sc.nextInt();
										switch(no) {
											case 1 : 
												System.out.println("1. pw : " + memberInfo.getPw());
												System.out.println("2. name : " + memberInfo.getName());
												System.out.println("3. gender : " + memberInfo.getGender());
												System.out.println("4. addr : " + memberInfo.getAddr());		
												System.out.println("0. 취소하기");
												
												System.out.print("수정할 번호를 입력해주세요 : ");
												no = sc.nextInt();
												sc.nextLine();
												switch(no) {
													case 1 : 
														System.out.print("변경할 pw : ");
														pw = sc.nextLine();
														memberInfo.setPw(pw);
//														memberManager.update(memberInfo);
														break;
													case 2 : 
														System.out.print("변경할 name : ");
														name = sc.nextLine();
														memberInfo.setName(name);
//														memberManager.update(memberInfo);
														break;
													case 3 : 
														System.out.print("변경할 gender : ");
														gender = sc.nextLine().charAt(0);
														memberInfo.setGender(gender);
//														memberManager.update(memberInfo);
														break;
													case 4 : 
														System.out.print("변경할 addr : ");
														addr = sc.nextLine();
														memberInfo.setAddr(addr);
//														memberManager.update(memberInfo);
														break;
													case 0 : 
														System.out.println("취소되었습니다."); return;
													default : 
														System.out.println("잘못된 번호가 입력됐습니다.");
												}
												System.out.println("수정이 완료되었습니다.");
												System.out.println("회원정보수정으로인해 로그아웃되었습니다.");
												return;
												
											case 2 : 
												memberManager.delete(memberInfo);
												System.out.println("삭제가 완료되었습니다.");
												System.out.println("그동안 이용해 주셔서 감사합니다.");
												return;
											case 3 : 
												// 결제내역DB 연동 (송준원)
												for(String s : memberManager.showMovie(memberInfo)) {
													System.out.println(s);
												}
												break;
											case 0 : return;
											default : System.out.println("잘못된 번호 입력");
										}
									}

								case 2 : {
									//예매내역
									while(true) {
										System.out.println("원하는 명령을 선택하세요.");
										System.out.println("1. 관람평등록");
										System.out.println("2. QR티켓 및 결제내역");
										System.out.println("0. 로그아웃");
										
										System.out.print("입력 : ");
										no = sc.nextInt();
										switch(no) {
											case 1 : 
												// 영화DB 및 결제내역DB 연동 (박정서, 송준원)
												break;
											case 2 : 
												// 결제내역DB 연동 (송준원)
												for(PaymentDTO p : memberManager.showPayment(memberInfo)) {
													System.out.println("영화 : " + p.getMovie() + ", 사용하신 카드 : " + p.getCardName() + ", 결제금액 : " + p.getPay());
												}
												break;
											case 0 : return;
											default : System.out.println("잘못된 번호 입력");
										}
									}
								}
								case 0 : return;
								default : System.out.println("잘못된 번호 입력");
							}
						}
					} else {
						System.out.println("로그인 실패");
					}
					break;

				case 3 :
					System.out.print("이름을 입력해주세요 : ");
					name = sc.nextLine();
					String checkId = memberManager.searchId(name);
					if(checkId != null) {
						System.out.println("회원님의 id는 \"" + checkId + "\"입니다.");
					} else {
						System.out.println("일치하는 회원이 존재하지 않습니다.");
					}
					break;
				case 4 :
					System.out.print("이름을 입력해주세요 : ");
					name = sc.nextLine();
					System.out.print("ID를 입력해주세요 : ");
					id = sc.nextLine();
					String checkPw = memberManager.searchPw(name, id);
					if(checkPw != null) {
						System.out.println("회원님의 pw는 \"" + checkPw + "\"입니다.");
					} else {
						System.out.println("일치하는 회원이 존재하지 않습니다.");
					}
					break;
				case 0 : return;
				default : System.out.println("잘못된 번호 입력");
			}
		}
	}
}

