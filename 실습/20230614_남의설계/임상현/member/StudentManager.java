/* �л� ���� �ý��� Ver1.0
*/

package member;

import java.io.FileWriter;
import java.io.IOException;

public class StudentManager {

	public static void main(String[] args) {
		
		StudentControl stu = new StudentControl();
		String sel = "";
		stu.fw = null;
		try {
			stu.fw = new FileWriter("memberLog.txt", false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stu.init_a(); // �ʱ�ȭ
		
		while (!sel.equals("5")) {
			sel = stu.menuView();
			
			stu.studentPlay(sel);
		}
		
	}
	
	
}
