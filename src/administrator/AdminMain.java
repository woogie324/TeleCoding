package administrator;

import java.io.IOException;
import java.util.Scanner;

import dao.ProductDAO;
import run.MovieInfoMain;

public class AdminMain {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		ProductDAO a = new ProductDAO();
		
		System.out.println("=====관리자 메뉴=====");
		System.out.println("1. 회원 목록 조회");
		System.out.println("2. 상품 관리");
		System.out.println("3. 영화 관리");
		System.out.print("메뉴선택 : ");
		
		int num = sc.nextInt();
		sc.nextLine();
		
		PrintMembers printMembers = new PrintMembers();
		ProductManage prodManage = new ProductManage();
		MovieInfoMain movieManage = new MovieInfoMain();
		
		// 메뉴 선택 시 실행되는 메소드
		switch(num) {
		case 1 : //전체 회원 목록 조회 (DB 조회)
			printMembers.allMembers();
			break;
		case 2 : // 상품관리 (상품 수정 및 조회)
			prodManage.productManage();
			break;
		case 3 :
			movieManage.main(null);
			break;
		default : 
		}
		
		
		
	}

}
