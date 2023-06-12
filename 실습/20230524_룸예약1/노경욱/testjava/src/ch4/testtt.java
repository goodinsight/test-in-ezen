package ch4;

public class testtt {

	public static void main(String[] args) {
//		4-2
//		int hap = 0;
//		for (int i = 1; i<=20; i++){
//			if (i % 2 != 0 || i % 3 != 0) {
//				hap = hap + i;
//			}
//		}
//		System.out.println(hap);
//		System.out.println(sum);

//		4-3
//		int sum = 0, jun = 0;
//		for (int i = 0; i <= 10; i++) {
//			sum = sum + i;
//			jun = jun + sum;
//		}
//		System.out.println(jun);

//		4-4
//		int sum = 0, num = 0;
//		while (num < 100) {
//			sum++;
//			if (sum % 2 == 0) {
//				num = num - sum;
//			}else {
//				num = num + sum;
//			}
//		}

//		4-5
//		int num = 100;
//		int dum = 0;
//		while (num != 0) {
//			num--;
//			System.out.print("*");
//			dum++;
//			if (dum == 10) {
//				System.out.println();
//				dum = 0;
//			}
//		}

//		4-8
//		for (int i = 0; i <= 10; i++) {
//			for (int j = 0; j <= 10; j++) {
//				if (2 * i + 4 * j ==10) {
//					System.out.printf("x=%d, y=%d\n", i, j);
//				}
//			}
//		}

//		4-9
//		String str = "12345";
//		int sum = 0;
//
//		for (int i = 0; i < str.length(); i++) {
//			sum = sum + (int)str.charAt(i) - 48;
//		}
//		System.out.println("sum=" + sum);

//		4-10
//		int num = 12345;
//		int hap = 0;
//		
//		hap = (num % 10) + (num % 100 / 10) + (num % 1000 / 100) + (num % 10000 / 1000) + (num % 100000 / 10000);
//		System.out.println(hap);

//		4-11
//		int num1 = 1, num2 = 1, num3 = 0;
//		System.out.print(num1 + " , " + num2);
//
//		for (int i = 0; i < 8; i++) {
//			num3 = num1 + num2;
//			System.out.print(" , " + num3);
//
//			num1 = num2;
//			num2 = num3;
//		}

//		4-13
//		String value = "12o34";
//		char ch = ' ';
//		boolean isNumber = true;
//		for (int i = 0; i < value.length(); i++) {
//			ch = value.charAt(i);
//			if (!('0' <= ch && ch <= '9')) {
//				isNumber = false;
//				break;
//			}
//		}
//		if (isNumber) {
//			System.out.println(value + "는 숫자입니다.");
//		} else {
//			System.out.println(value + "는 숫자가 아닙니다.");
//		}

//		4-14
//		int answer = (int) (Math.random() * 100) + 1;
//		int input = 0;
//		int count = 0;
//		java.util.Scanner s = new java.util.Scanner(System.in);
//		do {
//			count++;
//			System.out.print("1과 100사이의 값을 입력하세요 :");
//			input = s.nextInt(); 
//			if (answer > input) {
//				System.out.println("더 큰 수를 입력하세요.");
//			} else if (answer < input) {
//				System.out.println("더 작은 수를 입력하세요.");
//			} else {
//				System.out.println("맞췄습니다.");
//				System.out.println("시도횟수는 " + count + "번입니다.");
//				break;
//			}
//		} while (true); 

//		4-15
//		int number = 12321;
//		int tmp = number;
//		int result = 0; 
//		while (tmp != 0) {
//			result = result * 10 + tmp % 10;
//			tmp /= 10;
//		}
//		if (number == result)
//			System.out.println(number + "는 회문수 입니다.");
//		else
//			System.out.println(number + "는 회문수가 아닙니다.");
	}
}
