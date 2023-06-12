package kr.co.dong.ioclasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) {
//		poem.txt ������ �о output2.txt ���Ϸ� �����ϼ���.
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
			System.out.println("������ ������ ���� �� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ������ ������ ���� �����ϴ�.");
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				System.out.println("��ü�� ���� ���� �����ϴ�.");
			}
		}
	}
}
