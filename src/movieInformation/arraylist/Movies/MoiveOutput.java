package movieInformation.arraylist.Movies;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import movieInformation.arraylist.dto.MovieDTO;

public class MoiveOutput {
	

	public void print(String movie, String story, String director, String actor, String work, String review,
			int visitors) {

		ObjectOutputStream obmout = null;
		String print = "예매완료";
		try {

			if (new File("DB/movielist.txt").exists()) {
				System.out.println("있을 때");
				/* 기존에 파일이 있을 경우 */
				obmout = new MyOutputStream(new BufferedOutputStream(new FileOutputStream("DB/movielist.txt", true)));
			} else {
				System.out.println("없을 때");
				/* 기존에 파일이 없을 경우 */
				obmout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/movielist.txt")));
			}


			MovieDTO paDto = new MovieDTO(movie, story, director, actor, work, review, visitors);
			obmout.writeObject(paDto);
			System.out.println("파일 저장 성공!");

		} catch (FileNotFoundException e) {
			
			System.out.println("성공");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (obmout != null) {
				try {
					obmout.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}	
}