/* �л� ���� �ý��� Ver1.0
*/
// main ���� ���� ã�� -> ��������

package member;

public class StudentManager {

	public static void main(String[] args) {
		
		StudentControl7 stu = new StudentControl7();
		String sel = "";
		
		stu.init_a(); // �ʱ�ȭ
		
		while (!sel.equals("5")) {		//sel�� 5�� ���� �ʴٸ� menuView�����ֱ�
			sel = stu.menuView();
			
			stu.studentPlay(sel);
		}
		
	}
	
	
}
