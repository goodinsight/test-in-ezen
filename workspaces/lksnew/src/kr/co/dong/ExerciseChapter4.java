package kr.co.dong;

import java.util.Scanner;

public class ExerciseChapter4 {
	public static void main(String[] args) {

		int x = 0;
		boolean b = false;
		Scanner scan = new Scanner(System.in);

//		4-1번 문제
		System.out.println("input x: ");
		x = scan.nextInt();
		b = (x > 10 && x < 20) ? true : false;
		System.out.println("x가 10보다 크고 20보다 작은가? : " + b);
		System.out.println();

		char ch = ' ';

		System.out.println("input ch: ");
		x = scan.nextInt(); // x == 9 || x== 32 ;
		ch = (char) x;
		b = !(ch == ' ' || ch == ' ') ? true : false;

		System.out.println("ch가 공백이나 탭 아닌가? : " + b);

//		4-2번 문제
		int num = 20;
		int sum = 0;

		for (int i = 1; i <= num; i++) {
			if (!(i % 2 == 0 || i % 3 == 0)) {
				sum += i;
			}
		}
		System.out.printf("1부터 %d까지의 합은 %d 입니다.", num, sum);

//		4-3번 문제
		int count = 0, arr = 0, end = 10;

		sum = 0;

		for (arr = 1; arr <= end; arr++) {
			if (arr >= 2) {
				System.out.print('(');
			}

			for (int i = 1; i <= arr; i++) {
				sum += i;
				System.out.print(i);
				if (i != arr) {
					System.out.print('+');
				}
			}

			if (arr >= 2) {
				System.out.print(')');
			}

			if (arr != end) {
				System.out.print('+');
			}
		}
		System.out.printf("= %d", sum);

		// 4-4번 문제
		num = 0;
		sum = 0;
		end = 100;

		for (int i = 1; i <= 1000000; i++) {
			num = i;
			sum = sum + i * (i % 2 == 0 ? -1 : 1);

			if (i % 2 == 0) {
				System.out.print('(');
			}
			System.out.print(i * (i % 2 == 0 ? -1 : 1));

			if (i % 2 == 0) {
				System.out.print(')');
			}
			if (sum != end) {
				System.out.print('+');
			}

			if (sum == end) {
				break;
			}
		}
		System.out.printf("= %d%n", sum);
		System.out.printf("따라서 %d까지 더해야 합이 %d이상이 된다%n", num, end);

//		 4-5번 문제
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		int l = 0;
		int m = 0;
		while (l <= 10) {
			l++;
			while (m < l) {
				m++;
				System.out.print("*");
			} // end of while(m < l)
			m = 0;
			System.out.println();
		} // end of while(l <= 10)

//		 4-6번 문제

		int dice1 = 0, dice2 = 0;
		sum = 0;

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				dice1 = i;
				dice2 = j;
				sum = dice1 + dice2;
				if (sum == 6) {
					System.out.printf("1번 주사위가 %d이고, 2번 주사위가 %d일때 합이 %d가 된다.%n", dice1, dice2, sum);
				}
			}
		}

//	    4-7번 문제

		int value = (int) (Math.random() * 6) + 1;
		System.out.println(value);

//	 	4-8번 문제

		x = 0;
		int y = 0;
		sum = 10;

		for (x = 0; x <= 10; x++) {
			for (y = 0; y <= 10; y++) {
				int tmp = 2 * x + 4 * y;
				if (tmp == sum) {
					System.out.printf("x=%d, y=%d%n", x, y);
				}
			}
		}

//	 	4-9번 문제
		String str = "12345";
		sum = 0;

		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println("sum=" + sum);

//		4-10번 문제 
		num = 12345;
		sum = 0;
		int tmp = num;
		for (int i = 1; tmp != 0; i++) {
			sum += tmp % 10;
			tmp /= 10;
		}
		System.out.println("sum=" + sum);

//	 	4-11번 문제
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1 + "," + num2);

		for (int i = 0; i < 8; i++) {
			num3 = num1 + num2;
			System.out.print("," + num3);
			num1 = num2;
			num2 = num3;
		}
		System.out.println();

//		 4-13번 문제

		String value1 = "12o34";
		char ch1 = ' ';
		boolean isNumber = true;

		// 반복문과 charAt(int i)를 이용해서 문자열의 문자를
		// 하나씩 읽어서 검사한다.
		for (int i = 0; i < value1.length(); i++) {
			ch1 = value1.charAt(i);
			if (!('0' <= ch1 && ch1 <= '9')) {
				isNumber = false;
			}
		}

		if (isNumber) {
			System.out.println(value1 + "는 숫자입니다.");
		} else {
			System.out.println(value1 + "는 숫자가 아닙니다.");
		}

//		4-14번 문제

		int answer = (int) (Math.random() * 100 + 1);
		int input = 0; // 사용자입력을 저장할 공간
		count = 0; // 시도횟수를 세기위한 변수
		java.util.Scanner s = new java.util.Scanner(System.in);
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요: ");
			input = s.nextInt();

			if (input > answer) {
				System.out.println("더 작은 수를 입력하세요.");
			} else if (input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.printf("맞췄습니다.%n시도횟수는 %d번입니다.%n", count);
				break;
			}

		} while (true);
		
		
//		4-15번 문제
		int number = 12321; 
		tmp = number;
		
		int result = 0;
		
		while (tmp != 0) {
			result *= 10;
			result += tmp % 10;
			tmp /= 10;
			
		}
		
		if(number == result)
			System.out.println(number + "는 회문수 입니다.");
		else
			System.out.println(number + "는 회문수가 아닙니다.");
		

	}
}
