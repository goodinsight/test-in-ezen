package kr.co.dong.ioclasses;

import java.io.*;

public class Test01 {
	public static void main(String[] args) {
		FileReader f = null;
		try {
			f = new FileReader("poem.txt");
			
			while(true) {
				int data = f.read();
				if(data < 0)
					break;
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("END!!!!");
	}
}
