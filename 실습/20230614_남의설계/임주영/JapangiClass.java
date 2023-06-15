package VendingMachine;

public class JapangiClass {		// 자판기 메인

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JapangiControl jc = new JapangiControl();
		JapangiMenu jm = new JapangiMenu();
		
		int ja;
		jc.init();		// 초기값
		
		while(!false) {
			ja = jm.menu();
			
			jc.studentPlay(ja);
			
		}
		
		
	}

}
