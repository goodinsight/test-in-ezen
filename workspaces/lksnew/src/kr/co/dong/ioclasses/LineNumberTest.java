package kr.co.dong.ioclasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberTest {
	public static void main(String[] args) {
		LineNumberReader reader = null;
		
		try {
			reader = new LineNumberReader(new FileReader("poem.txt"));
			
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				int lineNo = reader.getLineNumber();
				System.out.println(lineNo + " : " + str);
			}
			
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}
