// ���� ���Ǳ� �����ϱ�
// 1. ���� ����, ����, ���
// 2. �����ϱ�, �Ǹ��ϱ�, �ݾ������ϱ�, �ܵ��ֱ�, ���&����&���� �����ϱ�
package jpg;

public class DrinkManger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DrinkControl stu = new DrinkControl();
		String sel = "";
		stu.init();
		while (!sel.equals("6")) {
			sel = stu.manu();
			
			stu.drinkPlay(sel);
			
			
		}
		
	}

}
