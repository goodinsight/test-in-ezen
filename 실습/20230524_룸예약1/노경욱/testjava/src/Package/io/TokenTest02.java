package Package.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TokenTest02 {
	public static void main(String[] args) {
//		student.txt파일을 읽어서 콤마를 제외하고 출력하기
		BufferedReader br = null;
		StringTokenizer strT = null;

		try {
			br = new BufferedReader(new FileReader("student.txt"));

			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}

//				한줄읽어서 ,콤바 분리
				strT = new StringTokenizer(str, ",");

				int cnt = strT.countTokens();

				for (int i = 0; i < cnt; i++) {
					String data = strT.nextToken();
					System.out.print(data + " ");
				}
				System.out.println();

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
