package kr.co.dong;

public class SwitchTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		
		switch (num) {
		case 10:
			viewPrint();
			break;
		case 20:
			System.out.println("20�Դϴ�");
			break;
		case 30:
			System.out.println("30�Դϴ�");
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���");
			break;
		}
	}

	private static void viewPrint() {
		// TODO Auto-generated method stub
		System.out.println("���Ⱑ ȣ��Ǿ� �����մϴ�.");
		System.out.println("10�Դϴ�");
		System.out.println("10�Դϴ�");
		System.out.println("10�Դϴ�");
		System.out.println("10�Դϴ�");
		System.out.println("10�Դϴ�");
		System.out.println("10�Դϴ�");
		System.out.println("���� �� �����մϴ�.");
	}

}
