package Package.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
//		poem.txt ������ �о 
//		������ output2.txt���Ϸ� �����ϼ���
		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new FileReader("poem.txt");
			writer = new FileWriter("output2.txt");
			
			int data = 0;
			while (data != -1) {
				data = reader.read();

				writer.write((char)data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("END");
	}
}
