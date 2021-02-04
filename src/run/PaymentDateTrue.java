package run;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import dto.PaymentDTO;



public class PaymentDateTrue {

	public static void main(String[] args) {
	
		
		
		ObjectInputStream objIn = null;
		ArrayList<PaymentDTO> ProductList = new ArrayList<PaymentDTO>();
		ArrayList ProductListName = new ArrayList();
		ArrayList ProductListPrice = new ArrayList();
	
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/payment.txt")));
			
			int i = 0;
			while(true) {
				
				PaymentDTO m = (PaymentDTO)objIn.readObject();
				System.out.println(m);
				ProductList.add(m);
			}
			
			
		
		} catch (EOFException e) {
		
			System.out.println("파일 읽기 완료!");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		/* 읽어온 데이터를 담은 배열을 출력해 보자 */
//		System.out.println("==============");
//		for(int i = 0; i < ProductList.size(); i++) {
//			System.out.println(ProductList.get(i));
//		}

		
	}

}
