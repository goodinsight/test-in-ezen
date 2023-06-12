/* 주클래스
 * FileReader
 * 보조클래스
 * BufferReader
 */
package Package.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		String str = null;

		try {
			fr = new FileReader("poem.txt");
			br = new BufferedReader(fr);

			while (true) {
				str = br.readLine();
				if (str == null) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
