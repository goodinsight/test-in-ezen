package kr.co.dong;

public class ArrayTest01 {
	public static void main(String[] args) {
//		�迭 : ���� Ÿ���� ������ ��Ƴ���
//		���� �� ����
		String[] dName = new String[4];
//		�迭 �� �Է�
		dName[0] = "�ݶ�";
		dName[1] = "���̴�";
		dName[2] = "Ŀ��";
		dName[3] = "������";
//		�迭 �� ���
		System.out.printf("dName[0] = %s%n", dName[0]);
		System.out.printf("dName[1] = %s%n", dName[1]);
		System.out.printf("dName[2] = %s%n", dName[2]);
		System.out.printf("dName[3] = %s%n", dName[3]);

//		�迭 �� for������ ���
		for (int i = 0; i < 4; i++) {
			System.out.printf("dName[" + i + "] = %s%n", dName[i]);
		}
		
		for (int i = 0; i < dName.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("dName[" + i + "] = %s%n", dName[i]);
		}
	}
}
