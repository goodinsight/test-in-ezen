package ch5;

public class ArrayTest01 {
	public static void main(String[] args) {
//	public static void main(String[] args) throws Exception{
//		�迭: ���� Ÿ���� ������ ��Ƴ���
//		���� �� ����
		String[] dName = new String[4];
//		�迭�� �Է�
		dName[0] = "�ݶ�";
		dName[1] = "���̴�";
		dName[2] = "Ŀ��";
		dName[3] = "������";
//		�迭 �� ���
		System.out.println("dName[0] = " + dName[0]);
		System.out.println("dName[1] = " + dName[1]);
		System.out.println("dName[2] = " + dName[2]);
		System.out.println("dName[3] = " + dName[3]);
		System.out.println("==========================");
//		for������ ���
//		�迭�� ���� -> �迭��.length
		for (int i = 0; i < dName.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("dName[%d] = %s\n", i, dName[i]);
		}

	}
}
