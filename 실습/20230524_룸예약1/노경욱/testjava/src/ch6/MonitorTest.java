package ch6;

public class MonitorTest {
	public static void main(String[] args) {
		
		Monitor m1 = new Monitor();
		m1.name = "�Ｚ";
		m1.color = "����";
		m1.resol = "���ػ�";
		m1.setName("�Ｚ");
		
//		VO -> �����ֱ� (getter����)
//		DTO -> ���������ۿ�����Ʈ
		System.out.println(m1.name);
		System.out.println(m1.color);
		System.out.println(m1.resol);
		System.out.println(m1.getName());
	}
	
	
}
