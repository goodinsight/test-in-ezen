package kr.co.dong.ioclasses;

import java.io.FileWriter;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		FileWriter writer = null;
		
		try {
			writer= new FileWriter("output.txt");
			
			writer.write("������ ���ϴ�.\n");
			writer.write("������ ���ϴ�.");
			writer.write("������ ���ϴ�.");
			writer.write("������ ���ϴ�.");
			writer.write("������ ���ϴ�.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("END!!!!!");
		
		
	}
}
