/*
 * ∏µ ¿Ãµø
 * 
 */

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
		
		ringMove(str1, str2);

		printStr(str1);
		printStr(str2);
	}

	private static void ringMove(int[] a, int[] b) {
		a: for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				for (int j = 0; j < b.length; j++) {
					if (b[j] != 0) {
						int[] tmp = new int[1];
						tmp[0] = b[j - 1];
						b[j - 1] = a[i];
						a[i] = tmp[0];
						break a;
					} else if (j == b.length - 1) {
						int[] tmp = new int[1];
						tmp[0] = b[j];
						b[j] = a[i];
						a[i] = tmp[0];
						break a;
					}
				}
			}
		}

	}

	public static void printStr(int[] a) {
		System.out.print("{");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i < a.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("}");

	}
}