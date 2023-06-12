package kr.co.dong;

import java.util.Scanner;

public class ExerciseChapter4 {
	public static void main(String[] args) {

		int x = 0;
		boolean b = false;
		Scanner scan = new Scanner(System.in);

//		4-1�� ����
		System.out.println("input x: ");
		x = scan.nextInt();
		b = (x > 10 && x < 20) ? true : false;
		System.out.println("x�� 10���� ũ�� 20���� ������? : " + b);
		System.out.println();

		char ch = ' ';

		System.out.println("input ch: ");
		x = scan.nextInt(); // x == 9 || x== 32 ;
		ch = (char) x;
		b = !(ch == ' ' || ch == ' ') ? true : false;

		System.out.println("ch�� �����̳� �� �ƴѰ�? : " + b);

//		4-2�� ����
		int num = 20;
		int sum = 0;

		for (int i = 1; i <= num; i++) {
			if (!(i % 2 == 0 || i % 3 == 0)) {
				sum += i;
			}
		}
		System.out.printf("1���� %d������ ���� %d �Դϴ�.", num, sum);

//		4-3�� ����
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

		// 4-4�� ����
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
		System.out.printf("���� %d���� ���ؾ� ���� %d�̻��� �ȴ�%n", num, end);

//		 4-5�� ����
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

//		 4-6�� ����

		int dice1 = 0, dice2 = 0;
		sum = 0;

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				dice1 = i;
				dice2 = j;
				sum = dice1 + dice2;
				if (sum == 6) {
					System.out.printf("1�� �ֻ����� %d�̰�, 2�� �ֻ����� %d�϶� ���� %d�� �ȴ�.%n", dice1, dice2, sum);
				}
			}
		}

//	    4-7�� ����

		int value = (int) (Math.random() * 6) + 1;
		System.out.println(value);

//	 	4-8�� ����

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

//	 	4-9�� ����
		String str = "12345";
		sum = 0;

		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println("sum=" + sum);

//		4-10�� ���� 
		num = 12345;
		sum = 0;
		int tmp = num;
		for (int i = 1; tmp != 0; i++) {
			sum += tmp % 10;
			tmp /= 10;
		}
		System.out.println("sum=" + sum);

//	 	4-11�� ����
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

//		 4-13�� ����

		String value1 = "12o34";
		char ch1 = ' ';
		boolean isNumber = true;

		// �ݺ����� charAt(int i)�� �̿��ؼ� ���ڿ��� ���ڸ�
		// �ϳ��� �о �˻��Ѵ�.
		for (int i = 0; i < value1.length(); i++) {
			ch1 = value1.charAt(i);
			if (!('0' <= ch1 && ch1 <= '9')) {
				isNumber = false;
			}
		}

		if (isNumber) {
			System.out.println(value1 + "�� �����Դϴ�.");
		} else {
			System.out.println(value1 + "�� ���ڰ� �ƴմϴ�.");
		}

//		4-14�� ����

		int answer = (int) (Math.random() * 100 + 1);
		int input = 0; // ������Է��� ������ ����
		count = 0; // �õ�Ƚ���� �������� ����
		java.util.Scanner s = new java.util.Scanner(System.in);
		do {
			count++;
			System.out.print("1�� 100������ ���� �Է��ϼ���: ");
			input = s.nextInt();

			if (input > answer) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			} else if (input < answer) {
				System.out.println("�� ū ���� �Է��ϼ���.");
			} else {
				System.out.printf("������ϴ�.%n�õ�Ƚ���� %d���Դϴ�.%n", count);
				break;
			}

		} while (true);
		
		
//		4-15�� ����
		int number = 12321; 
		tmp = number;
		
		int result = 0;
		
		while (tmp != 0) {
			result *= 10;
			result += tmp % 10;
			tmp /= 10;
			
		}
		
		if(number == result)
			System.out.println(number + "�� ȸ���� �Դϴ�.");
		else
			System.out.println(number + "�� ȸ������ �ƴմϴ�.");
		

	}
}
