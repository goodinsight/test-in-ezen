/* �л� ���� �ý��� Ver1.0
*/

package member;

public class StudentManager {

	public static void main(String[] args) {
		
		StudentControl stu = new StudentControl();
		
		String sel = "";
		
		stu.init_a(); // �ʱ�ȭ
		
		while (!sel.equals("5")) {
			
			sel = stu.menuView();
			
			stu.studentPlay(sel);
		}
	}
}
