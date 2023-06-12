package kr.co.dong;

public class Test17 {
	public static void main(String[] args) {
		String myString = "dxccxbbbxxaaaa";
		String[] tmp = myString.split("x");
		for(int i = 0; i < tmp.length; i++)
			System.out.println(tmp[i]);
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (tmp[i].compareTo(tmp[j]) < 0) {
					String temp1 = tmp[i];
					tmp[i] = tmp[j];
					tmp[j] = temp1;
				}
			}
		}
		for(int i = 0; i < tmp.length; i++)
			System.out.println(tmp[i]);	
	}
}
