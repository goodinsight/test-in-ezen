package Package.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberTest {
	public static void main(String[] args) {
//		파일을 읽어서 행번호 붙여서 콘솔에 출력해보자.
		LineNumberReader reader = null;

		try {
			reader = new LineNumberReader(new FileReader("poem.txt"));

			while (true) {
				String str = reader.readLine();
				if (str == null) { // 파일의 끝이라면
					break;
				}
				int lineNo = reader.getLineNumber();
				System.out.println(lineNo + " : " + str);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
