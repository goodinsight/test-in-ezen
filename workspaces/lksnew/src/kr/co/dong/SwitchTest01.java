package kr.co.dong;

public class SwitchTest01 {
	public static void main(String[] args) {
		int num = 40;
		 
		switch (num) {
		case 10:
			viewPrint(); // function call
			break;
		case 20:
			System.out.println("20입니다.");
			break;
		case 30:
			System.out.println("30입니다.");			
			break;
		default:
			System.out.println("다시 입력하세요.");
			break;
		}
	}

	private static void viewPrint() {
		System.out.println("여기가 호출되어 실행합니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("10입니다.");
		System.out.println("리턴 즉 복귀합니다.");
		
	}
}
