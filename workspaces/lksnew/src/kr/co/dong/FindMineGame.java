package kr.co.dong;

import java.util.Scanner;

public class FindMineGame {
	public static void main(String[] args) {
		int[][] board = new int[9][9];
		char[][] shipboard = new char[10][10];
		int count = 0;
		int mine = 10;
		int result = 0;
		Scanner scan = new Scanner(System.in);
//		모든곳에 -1입력
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = -1;
			}
		}

		ans: while (true) {
//		지뢰에 0 입력
			board[(int)(Math.random()*9)][(int)(Math.random()*9)] = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 0) {
						count++;
						if (count >= mine) {
							break ans;
						}
					}
				}
			}
			count = 0;
		}
//		정답지
		System.out.println("정답지 입니다.");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0 ; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

		for (int i = 1; i < shipboard.length; i++) {
			shipboard[0][i] = (char) (i + '0');
			shipboard[i][0] = (char) (i + '0');
		}
		game: while (true) {
			for (int i = 0; i < shipboard.length; i++) {
				for (int j = 0; j < shipboard[0].length; j++) {
					System.out.print(shipboard[i][j]);
				}
				System.out.println();
			}

			System.out.printf("지뢰의 총 갯수는 %d 입니다.%n", mine);
			while (true) {
				for (int i = 1; i < shipboard.length; i++) {
					for (int j = 1; j < shipboard[0].length; j++) {
						if (shipboard[i][j] == 'O') {
							result++;
						}
					}
				}
				if (result < count) {
					break;
				} else {
					System.out.printf("현재까지 찾은 갯수는 %d 입니다.%n", result);
					break game;
				}

			}
			System.out.printf("현재까지 찾은 갯수는 %d 입니다.%n", result);
			result = 0;
			System.out.println("좌표를 입력하세요:(종료는 00)");
			String input = scan.nextLine();

			if (input.length() !=2) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			if (input.length() ==2) {
				char x = input.charAt(0);
				char y = input.charAt(1);
				if (x=='0' && y=='0') 
					break;
				shipboard[x - '0'][y - '0'] = board[x - '1'][y - '1'] == 0 ? 'O' : 'X';
				
			}

		}
		if(result == count) {
			System.out.println("모든 지뢰를 찾으셨습니다. 게임을 종료합니다.");
		}else {
			System.out.println("게임을 종료합니다.");
		}

	}
}
