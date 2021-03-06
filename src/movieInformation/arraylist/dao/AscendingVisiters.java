package movieInformation.arraylist.dao;

import java.util.Comparator;

import movieInformation.arraylist.dto.MovieDTO;

public class AscendingVisiters implements Comparator<MovieDTO>{
		/* (Comparator)비교 인터페이스를 현 클래스에 구현함*/
		/* MovieDTO의 내림차순에 관한 클래스이다. */
		
		@Override
		public int compare(MovieDTO o1, MovieDTO o2) {
			
			/* 오름차순 */
			return -(o1.getVisitors() - o2.getVisitors());

		}	// method 종료.

}			// Class 종료.
