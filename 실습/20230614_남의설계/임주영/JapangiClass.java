package VendingMachine;

public class JapangiClass {		// ���Ǳ� ����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JapangiControl jc = new JapangiControl();
		JapangiMenu jm = new JapangiMenu();
		
		int ja;
		jc.init();		// �ʱⰪ
		
		while(!false) {
			ja = jm.menu();
			
			jc.studentPlay(ja);
			
		}
		
		
	}

}
