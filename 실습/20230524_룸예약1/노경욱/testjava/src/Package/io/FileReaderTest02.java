package Package.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest02 {
	public static void main(String[] args) {
		FileReader reader = null;

		try {
			reader = new FileReader("test.abc");
		
//			while (true) {
//				int data = reader.read();
//				if(data < 0) {
//					break;
//				}
//				System.out.print((char)data);
//			}
//			
			int data = 0;
			while (data != -1) {
				data = reader.read();
				System.out.print((char)data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 읽을 수 없습니다");
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
