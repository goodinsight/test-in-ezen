package kr.co.dong.ioclasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) {
//		poem.txt 파일을 읽어서 output2.txt 파일로 복사하세요.
		FileReader reader = null;
		FileWriter writer = null;
		String filename = "poem.txt";
		String writeFilename = "output2.txt";
		
		try {
			reader = new FileReader(filename);
			writer = new FileWriter(writeFilename);
			int data = 0;
			while(data != -1) {
				data = reader.read();
				writer.write((char) data);
			}
	
		} catch (FileNotFoundException e) {
			System.out.println("복사할 파일을 읽을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("읽은 파일을 복사할 수가 없습니다.");
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				System.out.println("객체를 닫을 수가 없습니다.");
			}
		}
	}
}
