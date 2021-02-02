package administrator;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

public class PrintMembers { 
	
	public void allMembers() {
		
		ObjectInputStream objIn = null;	
		
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/memberDB.txt")));

			int i = 0;
			while(true) {
				System.out.println((MemberDTO)objIn.readObject());
			} 

		} catch (EOFException e) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(objIn != null) {
				try {
					objIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	// allMembers 종료


	public List<MemberDTO> returnMembers() {
		ObjectInputStream objIn = null;	
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/memberDB.txt")));

			int i = 0;
			while(true) {
				list.add((MemberDTO)objIn.readObject());
			} 

		} catch (EOFException e) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(objIn != null) {
				try {
					objIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}





}	// 클래스 종료
