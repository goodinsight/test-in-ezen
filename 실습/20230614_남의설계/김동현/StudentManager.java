/* 학생 관리 시스템 Ver1.0
*/

package member;

public class StudentManager {

	public static void main(String[] args) {
		
		StudentControl stu = new StudentControl();
		String sel = "";
		
		stu.init_a(); // 초기화
		
		while (!sel.equals("5")) {//5가아니면 나머지 번호들로 가서 보여줌??! 그다음 셸로간다??~~!!
			sel = stu.menuView();
			
			stu.studentPlay(sel);
		}
		
	}
	
	
}
