package vendingMachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class VendingFile {
	public static void main(String[] args) {
		
		String str = "";
		BufferedReader br = null;
		StringTokenizer tr = null;
		try {
			br = new BufferedReader(new FileReader("vending.txt"));
			str = br.readLine();
			tr = new StringTokenizer(str, ",");
			String name = tr.nextToken().trim();
			int price = Integer.parseInt(tr.nextToken().trim());
			int count = Integer.parseInt(tr.nextToken().trim());
			vendingMachine v = new vendingMachine(name, price, count, 0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
