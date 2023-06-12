package kr.co.dong.ioclasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TokenTest02 {
	public static void main(String[] args) {
//		student.txt ������ �о �޸��� �����ϰ� ����ϱ�

		BufferedReader br = null;
		String filename = "student.txt";
		
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				String tmp;
				tmp = br.readLine();

				if(tmp == null)
					break;
				StringTokenizer st = new StringTokenizer(tmp,",");
				int cnt = st.countTokens();
				for(int i = 0; i < cnt; i++) {
					System.out.print(st.nextToken()+" ");
				}
				System.out.println();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
