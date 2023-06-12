/*
 * 주클래스
 * FileReader
 * 보조클래스
 * BufferReader
 * 
 */

package kr.co.dong.ioclasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
	public static void main(String[] args) {
//		FileReader fr = null;
		BufferedReader br = null;
		String str = null;
		
		try {
//			fr = new FileReader("poem.txt");
//			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader("poem.txt"));
			
			while(true) {
				str = br.readLine();
				if (str == null)
					break;
				System.out.println(str);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
