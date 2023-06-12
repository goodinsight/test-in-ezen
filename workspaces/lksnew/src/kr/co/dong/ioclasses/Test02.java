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
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.out.println("������ �������� �����ϴ�.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("������ �������� �����ϴ�.");
			}
		}
		
	}
}
