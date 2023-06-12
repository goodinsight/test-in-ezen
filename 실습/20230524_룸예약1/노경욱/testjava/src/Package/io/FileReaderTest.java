/*
 * 파일을 읽어오기
 * FileReader 클래스 
 */
package Package.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) {
		FileReader reader = null;

		try {
			reader = new FileReader("poem.txt");

			while (true) {
				int data = reader.read();
				if (data < 0) {
					break;
				}
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("END");
	}
}
