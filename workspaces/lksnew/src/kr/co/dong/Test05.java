package kr.co.dong;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ringNum = 3;
		int[] str1 = null;
		int[] str2 = null;
		
		str1 = new int[ringNum];
		for (int i = 0; i < ringNum; i++) {
			str1[i] = i + 1;
		}
		str2 = new int[ringNum];
		for (int i = 0; i < ringNum; i++) {
			str2[i] = 0;
		}
		System.out.println(str1.length);
		System.out.println(str2.length);
		a:
		for (int i = 0; i<=str1.length-1; i++) {
			if (str1[i] != 0) {
				for (int j = 0; j<=str2.length-1; j++) {
					if (str2[j] != 0) {
						int[] tmp = new int[1];
						tmp[0] = str2[j-1];
						str2[j-1] = str1[i];
						str1[i] = tmp[0];
						break a;
					}else if (j == str2.length-1) {
						int[] tmp = new int[1];
						tmp[0] = str2[j];
						str2[j] = str1[i];
						str1[i] = tmp[0];
						break a;
					}
				}
			}
		}
		printStr(str1);
		printStr(str2);
	}	

	public static void printStr(int[] a) {
		System.out.print("{");
		for (int i =0; i< a.length; i++) {
			System.out.print(a[i]);
			if (i < a.length-1) {
				System.out.print(",");
			}
		}
		System.out.print("}");
		
	}	
}
