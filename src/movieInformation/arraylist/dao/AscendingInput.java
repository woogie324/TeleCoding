package movieInformation.arraylist.dao;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;
import movieInformation.arraylist.dto.MovieDTO;

public class AscendingInput {

   public static void main(String[] args) {
      
	   
      ObjectInputStream objIn = null;
      ArrayList<MovieDTO> movieList = new ArrayList<MovieDTO>();
   
      try {
         objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/movielist.txt")));
         
         int i = 0;
         while(true) {
        	MovieDTO m = (MovieDTO)objIn.readObject();
        	movieList.add(m);
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
      System.out.println("==============");

      movieList.sort(new AscendingVisiters());		
      int i = 0;
		for(MovieDTO b : movieList) {
			i += 1;
			System.out.println(i + "위 : "+ b.getMovie() + ", 조회수 : " + b.getVisitors());
		}

   }

}