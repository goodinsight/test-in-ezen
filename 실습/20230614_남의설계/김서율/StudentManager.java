/* 학생 관리 시스템 Ver1.0
*/
// main 제일 먼저 찾기 -> 실행파일

package member;

public class StudentManager {

	public static void main(String[] args) {
		
		StudentControl7 stu = new StudentControl7();
		String sel = "";
		
		stu.init_a(); // 초기화
		
		while (!sel.equals("5")) {		//sel이 5랑 같지 않다면 menuView보여주기
			sel = stu.menuView();
			
			stu.studentPlay(sel);
		}
		
	}
	
	
}
