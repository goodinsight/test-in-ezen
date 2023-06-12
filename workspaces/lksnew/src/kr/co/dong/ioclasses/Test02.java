package kr.co.dong.ioclasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) {
		FileReader reader = null;
		String fileName = "test.abc";
		
		
		try {
			reader = new FileReader(fileName);
			int data = 0;
			while((data=reader.read()) != -1) System.out.print((char)data);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽을수가 없습니다.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("파일을 닫을수가 없습니다.");
			}
		}
		
	}
}
