package vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealVendingMachine {
	Scanner scan = new Scanner(System.in);
	vendingMachineControl2 cont2 = new vendingMachineControl2();
	AdminControl adcont = new AdminControl();
//	List<vendingMachine> list = new ArrayList<vendingMachine>();

	void start() {
		cont2.init();
		boolean power = false;
		while (!power) {
			switch (cont2.menu()) {
			case "1":	// ����޴�
				cont2.drinkMenu();
				break;
			case "2":	// ����
				cont2.payMent();
				break;
			case "3":	// �ܵ���ȯ
				cont2.refund();
				break;
			case "4":	// ����
				System.out.println("����");
				power = true;
				break;
			case "77":	// �����ڸ��
				adminMenu();
				break;
			default :
				System.out.println("���ڸ� �Է��ϼ���.");	
			}
		}
	}
//	������ �޴�
	private void adminMenu() {
		boolean check = false;
		int pass = cont2.choice("��й�ȣ �Է� : ");
		if (pass != adcont.password(pass)) {
			System.out.println("��й�ȣ Ʋ��.");
		} else {
			while (!check) {
				System.out.println("1.�����߰� 2.�������� 3.���ᰡ�ݺ��� 4.���Ẹ�� 5.������Ȳ 6.���������� 7.������");
				String sel = adcont.strChoice("��ȣ �Է� : ");
				switch (sel) {
				case "1": // �����߰�
					adcont.addDrink(cont2.drink);
					break;
				case "2": // ��������
					adcont.deleteDrink(cont2.drink);
					break;
				case "3": // ���ᰡ�ݺ���
					adcont.editPrice(cont2.drink);
					break;
				case "4": // ���Ẹ��
					adcont.view(cont2.drink);
					break;
				case "5": // ������Ȳ
					adcont.selling(cont2.drink);
					break;
				case "6":
					adcont.plusDrink(cont2.drink);
					break;
				case "7":
					System.out.println("������");
					check = true;
					break;
				default:
					System.out.println("���ڸ� �Է��ϼ���.");
				}
			}
		}
	}
	
	
}
