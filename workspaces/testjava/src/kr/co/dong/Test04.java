package kr.co.dong;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		int ringNum = 3;
		int[] str1 = null;
		int[] str2 = null;
		int[] str3 = null;

		Scanner scan = new Scanner(System.in);
		System.out.println("몇개의 링을 옮기겠습니까?: ");
		ringNum = scan.nextInt();

		str1 = setting(str1, ringNum);
		str2 = settingZero(str2, ringNum);
		str3 = settingZero(str3, ringNum);
		printStr(str1);
		printStr(str2);
		printStr(str3);
		System.out.println();
		hanoiTower(str1, str2, str3, ringNum);
		scan.close();
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

	private static int[] setting(int[] str, int ringNum) {
		int[] tmp = new int[ringNum];
		for (int i = 0; i < ringNum; i++) {
			tmp[i] = i + 1;
		}
		str = tmp;
		return str;
	}

	private static int[] settingZero(int[] str, int ringNum) {
		int[] tmp = new int[ringNum];
		for (int i = 0; i < ringNum; i++) {
			tmp[i] = 0;
		}
		str = tmp;
		return str;
	}
	
	private static void ringMove(int[] a, int[] b) {
		move: for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				for (int j = 0; j < b.length; j++) {
					if (b[j] != 0) {
						int[] tmp = new int[1];
						tmp[0] = b[j - 1];
						b[j - 1] = a[i];
						a[i] = tmp[0];
						break move;
					} else if (j == b.length - 1) {
						int[] tmp = new int[1];
						tmp[0] = b[j];
						b[j] = a[i];
						a[i] = tmp[0];
						break move;
					}
				}
			}
		}
	}

	private static void ringMoveUp(int[] str1, int[] str2, int[] str3) {
		a: for (int i = 0; i < str1.length - 1; i++) {
			if (str1[i] != 0) {
				for (int j = 0; j <= str2.length - 1; j++) {
					if (str2[j] != 0) {
						if (str2[j - 1] > str1[i]) {
							int[] tmp = new int[1];
							tmp[0] = str2[j - 1];
							str2[j - 1] = str1[i];
							str1[i] = tmp[0];
							break a;
						} else if (str2[j - 1] > str1[i] || j == str2.length - 1) {
							int[] tmp = new int[1];
							tmp[0] = str2[j];
							str2[j] = str1[i];
							str1[i] = tmp[0];
							break a;
						} else {
							for (int k = 0; k <= str3.length - 1; k++) {
								if (str3[k] != 0) {
									int[] tmp = new int[1];
									tmp[0] = str3[k - 1];
									str3[k - 1] = str1[i];
									str1[i] = tmp[0];
									break a;
								} else if (k == str3.length - 1) {
									int[] tmp = new int[1];
									tmp[0] = str3[k];
									str3[k] = str1[i];
									str1[i] = tmp[0];
									break a;
								}
							}
						}

					}
				}
			}
		}

	}

	private static void hanoiTower(int[] str1, int[] str2, int[] str3, int ringNum) {
		if (ringNum != 1) {
			for (int i = ringNum; i >= 1; i--) {
				hanoiTower(str1, str3, str2, ringNum - 1);
				printStr(str1);
				printStr(str2);
				printStr(str3);
				System.out.println();
				ringMoveUp(str1, str3, str2);
				hanoiTower(str2, str1, str3, ringNum - 1);
				printStr(str1);
				printStr(str2);
				printStr(str3);
				System.out.println();
			}
		} else {
			ringMoveUp(str1, str2, str3);
		}
	}

}