package kr.co.dong;

import java.util.Scanner;

import javax.swing.text.Position.Bias;

public class ArrayTest20 {
	public static void main(String[] args) {
		final int SIZE = 5;
		int[][] bingo = new int[SIZE][SIZE];
		int[] tmp = new int[SIZE*SIZE];
		int sum = 0;
		int bingoCount = 0;
		
		tmp[0] = (int)(Math.random()*SIZE*SIZE + 1);
		for (int i = 1; i< tmp.length; i++) {
			tmp[i] = (int)(Math.random()*SIZE*SIZE + 1);
			for(int j =0; j< i; j++) {
				if (tmp[i] == tmp[j]) {
					i--;
				}
			}
			
		}
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bingo[i][j] = tmp[i*SIZE+j];
			}
		}
		
		while(true) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.printf("%2d ",bingo[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("���ڸ� �Է�:");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			if (num>0 && num<26) {
				for (int i = 0; i < SIZE; i++) {
					for (int j = 0; j < SIZE; j++) {
						if(num == bingo[i][j]) {
							bingo[i][j] = 0;
						}
					}
				}
			} else {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (bingo[i][j] == 0) {
						sum += 1;
						if (sum == SIZE) {
							bingoCount +=1;
						}
					}
					
				}
				sum = 0;
			}
			for (int j = 0; j < SIZE; j++) {
				for (int i = 0; i < SIZE; i++) {
					if (bingo[i][j] == 0) {
						sum += 1;
						if (sum == SIZE) {
							bingoCount +=1;
						}
					}
					
				}
				sum = 0;
			}
			for (int i =0; i<SIZE; i++) {
				if (bingo[i][i] == 0) {
					sum += 1;
					if (sum == SIZE) {
						bingoCount +=1;
					}
				}
			}
			sum = 0;
			for (int i =0; i<SIZE; i++) {
				if (bingo[i][SIZE-i-1] == 0) {
					sum += 1;
					if (sum == SIZE) {
						bingoCount +=1;
					}
				}
			}
			sum = 0;
			System.out.println("������� ���� �� ������ "+bingoCount);
			if (bingoCount >= 5) {
				System.out.println("����!�� ��ġ����");
				break;
			}
			bingoCount = 0;
		}
		
		
	}
}
