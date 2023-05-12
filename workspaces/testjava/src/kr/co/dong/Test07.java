package kr.co.dong;

import java.util.Scanner;

public class Test07 {
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
//		hanoiTower(str1, str2, str3, ringNum);
		ringMoveUp(str1, str2, str3);
		printStr(str1);
		printStr(str2);
		printStr(str3);
		System.out.println();
		ringMoveUp(str1, str2, str3);
		printStr(str1);
		printStr(str2);
		printStr(str3);
		System.out.println();
		ringMoveUp(str1, str2, str3);
		printStr(str1);
		printStr(str2);
		printStr(str3);
		System.out.println();
		ringMoveUp(str1, str2, str3);
		printStr(str1);
		printStr(str2);
		printStr(str3);
		System.out.println();
		ringMoveUp(str1, str2, str3);
		printStr(str1);
		printStr(str2);
		printStr(str3);
		System.out.println();
		ringMoveUp(str1, str2, str3);
		printStr(str1);
		printStr(str2);
		printStr(str3);

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
		existInStr1: for (int a : str1) {
			if (a != 0) {

				for (int b : str2) {
					if (b != 0) {

						if (a < b) {
							ringMove(str1, str2);
							break existInStr1;
						} else if (a > b) {

							for (int c : str3) {
								if (c != 0) {
									if (a < c) {
										ringMove(str1, str3);
										break existInStr1;
									} else if (a > c) {
										if (b < c) {
											ringMove(str2, str3);
											break existInStr1;
										} else {
											ringMove(str3, str2);
											break existInStr1;
										}
									}
								} else if (str3[str3.length - 1] == 0) {
									ringMove(str1, str3);
									break existInStr1;
								}
							}
						}
					} else if (str2[str2.length - 1] == 0) {
						ringMove(str1, str2);
						break existInStr1;
					}
				}
			} else if (str1[str1.length - 1] == 0) {
				existInStr2: for (int b : str2) {
					if (b != 0) {
						for (int c : str3) {
							if (c != 0) {
								if (b < c) {
									ringMove(str2, str3);
									break existInStr2;
								} else {
									ringMove(str3, str1);
									break existInStr2;
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