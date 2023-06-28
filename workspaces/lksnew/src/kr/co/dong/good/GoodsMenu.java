/*
 * menuView() : ��ǰ �޴� �����ϴ� ���(1. ��ǰ�߰� 2.��ǰ�������� ...)
 * displayMenu() : 1.��ǰ�߰��ϴ� ���ȣ�� 2. ��ǰ�������� ���ȣ��
 */
package kr.co.dong.good;

import java.util.Scanner;

public class GoodsMenu {
	Scanner scan = new Scanner(System.in);
	GoodsControl gc = new GoodsControl();
	public void displayMenu() {
		while(true) {
//			�޴������ֱ�
			String n = menuView();
			switch (n) {
			case "1":	//��ǰ�߰� : �Է� -> DB�߰� -> ����/����
				gc.insert(add());
				break;
			case "2":	//��ǰ����
				gc.selectOne(GoodsId());
				gc.update(add(),GoodsId());
				break;
			case "3":	//��ǰ��ü��ȸ
				gc.listAll();
				break;
			case "4":	//��ǰ��ȣ��ȸ
				gc.selectOne(GoodsId());				
				break;
			case "5":	//��ǰ����ȸ
				gc.selectOne(GoodsName());				
				break;	
			case "6":	//��ǰ����
				gc.delete(GoodsId());				
				break;
			case "999":
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default:
				System.out.println("��ȣ�� �ٽ� �Է����ּ���");
				break;
			}
		}
	}
	

	private String GoodsName() {
		System.out.print("��ǰ�� �Է� : ");
		return scan.nextLine();
	}


	public String menuView() {
		System.out.println("=============== ��ǰ �޴� ================");
		System.out.println("1. ��ǰ �߰�");
		System.out.println("2. ��ǰ ���� ����");
		System.out.println("3. ��ǰ ��ü ��� ��ȸ");
		System.out.println("4. ��ǰ ���̵�� ��ȸ");
		System.out.println("5. ��ǰ������ ��ȸ");
		System.out.println("6. ��ǰ ����");
		System.out.println("999. ������");
		System.out.println("========================================");
		System.out.println("��ȣ �Է� : ");
		
		
		return scan.nextLine();
	}
	
	public GoodsBean add() {
		// ��ǰ �Է�(����)�ϴ� �޼ҵ�
		GoodsBean g = null;
		System.out.println("======= ��ǰ �߰� / ���� ========");
		System.out.print("��ǰ�� : ");
		String gname = scan.nextLine();
		System.out.print("�� ���� : ");
		String gcontent = scan.nextLine();
		System.out.print("���� : ");
		int gcnt = Integer.parseInt(scan.nextLine());
		System.out.print("�ΰ� ���� : ");
		String getc = scan.nextLine();
		
		g = new GoodsBean(gname, gcontent, gcnt, getc);
		return g;
	}
	
	public int GoodsId() {
		System.out.print("��ǰ ��ȣ �Է� : ");
		return Integer.parseInt(scan.nextLine());
	}
}
