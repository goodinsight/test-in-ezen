import java.util.Scanner;

public class Report22 {

	public static void main(String[] args) {
		
//		�迭�� dName, dPrice, dAmount
//		������ ������ �켱 3�����Դϴ�.
//		
//		ftp ������ �÷��ּ���.
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�
//		3-1. ������ ������ ����, ����, �Ž����� ��ȯ, �� �Է� ��
//			99. ���Ǳ� ����
//		4. 99 �̿��� ������ ��� ȭ��޴� �����ֱ�
		
		boolean power = false; // ����
//		�޴��Է°�, ���� ��, �����̸�123, ����123 , �Ž�����
		
		int menu = 0; // �޴� �Է°�
		int money = 0; // ���� ��
		int total_input = 0; // ���� �� �հ�
		
		int sel = 0; // �޴� ����
		
		String[] dname = new String[] {"�ݶ�","���̴�","�������꽺"};
		int[] dPrice = new int[] {500,1200,2500};
		int[] dAmount = new int[] {10,15,20};
		
		int user_choice = 0;
		
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
			
//			 1. �޴� �����ֱ�
			 System.out.println("====== [ menu ] ========");
			 for(int i=0; i<dname.length; i++) {
				 System.out.print((i+1)+". ���� �̸� : "+dname[i]+" / ");
				 System.out.print("��� : "+dAmount[i]+" / ");
				 System.out.println("���� : "+dPrice[i]);
			 }
			 System.out.println("5. �Ž����� ��ȯ 99. ����");
			 System.out.println("���� �Աݾ� : "+money);
			 System.out.println();
			 
			 // 0. �� �Է�
			 System.out.print("���� �ݾ� : ");
			 money = money + scan.nextInt(); // money ���� ��Ű��
			 
//			 2. �޴� ����
			 System.out.print("Select : ");
			 sel = scan.nextInt();
			 
//			3. ���ÿ� ���� �б�		 
			 switch (sel) {
				case 1: // �ݶ� ���ý�
					user_choice = 0;
					break;
				case 2: // ���̴� ���ý�
					user_choice = 1;
					break;
				case 3: // �������꽺 ���ý�
					user_choice = 2;
					break;
				case 5: // �Ž����� ��ȯ
					System.out.println("�Ž����� ��ȯ��");
					System.out.println("�ܵ� : "+money);
					System.out.println();
					break;
				case 99:
					power = true;
					System.out.println("�ý��� �ƿ�!");
					break;
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
					break;
				}
			 
			 if(sel>0 && sel<4) {
				 if(dPrice[sel-1]<money) {
					 money -= dPrice[user_choice];
					 dAmount[user_choice]--;	 
					 System.out.println(dname[user_choice]+"�� ���Խ��ϴ�.");
					 System.out.println();
				 }else {
					 System.out.println("���Աݾ��� �����մϴ�.");
					 System.out.println();
				 }
			 }
			 
			 
			 
		}
		
		System.out.println("���Ǳ� ����!!");

	}

}
