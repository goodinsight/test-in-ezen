package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomControl {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		List<Room> list = new ArrayList<>();
		boolean done = false;
		boolean stop = false;
		Customer customer = null;
		LogIn login = null;
		
//		ȣ���� �� ������ �ʱ�ȭ�ϰ� ����
		list = init();
		
		main:
		while (true) {

//			ȸ������ �� �α��� �޴�
			while (!done) {
				login = new LogIn();
				int select = login.showLogin();
				switch (select) {
				case 1:
					// ó�� �湮�� ȸ������
					int tmp = login.showSetMenu();
					if (tmp == 1) {
						customer = login.setCustomer(customer); 
						login.saveCustomer(customer);	// �ʱ�ȭ ���� ȸ�������Ͽ� ����
						done = true;
						stop = false;
					}
					if (tmp == 2) {
						done = true;
						break main; // ���α׷� ���� ����
					}
					break;
				case 2:
					// ���� ȸ���� �α����ϱ�
					customer = login.logIn(customer);
					if (customer.getId() != null && customer.getPassword() != null) {
						done = true;
						stop = false;
					}
					break;
				case 3:
					// ���̵� ��� ã��
					login.findCustomer();
					break;
				default:
					break;
				}
			} // �α��� �޴� ��

//			���� roomcontrol
			while (!stop) {
				int sel = menu();

				switch (sel) {
				case 1: // �� �����ϱ�
					revRoom(list, customer);
					break;
				case 2: // �� ���� ���
					cancelRoom(list, customer);
					break;
				case 3: // �� ��üȮ�� / ����Ȯ��
					printRoom(list);
					break;
				case 4: // ������ ����Ȯ��
					inforCustomer(list);
					break;
				case 5:
					System.out.println("�α׾ƿ��Ǿ����ϴ�.");
					stop = true;
					done = false;
					break;
				default:
					break;
				}
			} // roomcontrol ��
		}
		System.out.println("���α׷��� �����մϴ�.");
	}

	private static int findRoom(int rNumber, List<Room> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
//			list.get(i).getrName() => ����Ʈ���� ���̸�
			if (list.get(i).getrNumber() == rNumber) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static void inforCustomer(List<Room> list) {
		try {
			int sel = inputM("������ ������ ���Ͻô� �� ȣ���� �Է��ϼ��� : ");
			System.out.println(sel + "ȣ���� �����ڸ� : " + list.get(findRoom(sel, list)).getCustomer() + ", �����ڵ� : "
					+ list.get(findRoom(sel, list)).getRevCode() + " �Դϴ�.");
		} catch (Exception e) {
			System.out.println("�� ȣ���� ����� �Է��ϼ���");
			scan.nextLine();
		}
	}

	private static void cancelRoom(List<Room> list, Customer customer) {
		try {
			int sel = inputM("������� �ϰ��� �ϴ� �� ȣ���� �Է��ϼ��� : ");
			if (list.get(findRoom(sel, list)).isCheck() == true) {
				System.out.println(sel + "ȣ���� ������Ұ� �����մϴ�.");
				System.out.println("���� �ڵ带 �Է��ϼ��� : ");
				if (list.get(findRoom(sel, list)).getRevCode().equals(scan.next())) {
					list.get(findRoom(sel, list)).setCheck(false);
					list.get(findRoom(sel, list)).setCustomer(null);
					list.get(findRoom(sel, list)).setRevCode(null);
					System.out.println(sel + "ȣ���� ������ ��ҵǾ����ϴ�.");
					cancelResevation(sel, list, customer);
				} else {
					System.out.println("�����ڵ尡 Ʋ���ϴ�.");
				}

			} else {
				System.out.println("������ �Ǿ����� �ʾ� ������Ұ� �Ұ��մϴ�.");
			}
		} catch (Exception e) {
			System.out.println("�� ȣ���� ����� �Է��ϼ���");
			scan.nextLine();
		}
	}

	private static void revRoom(List<Room> list, Customer customer) {
		try {
			int sel = inputM("�����ϰ��� �ϴ� �� ȣ���� �Է��ϼ��� : ");
			if (list.get(findRoom(sel, list)).isCheck() == false) {
				System.out.println(sel + "ȣ���� ������ �����մϴ�.");
				list.get(findRoom(sel, list)).setCustomer(customer.getName());
				list.get(findRoom(sel, list)).setRevCode(customer.getCode());
				list.get(findRoom(sel, list)).setCheck(true);
				System.out.println(sel + "ȣ���� ������ : " + list.get(findRoom(sel, list)).getCustomer() + ", ���� �ڵ�(������ȣ) : "
						+ list.get(findRoom(sel, list)).getRevCode() + " ��  ���� �Ǿ����ϴ�.");
				saveResevation(sel, list, customer);
			} else {
				System.out.println("������ �Ұ��մϴ�.");
			}
		} catch (Exception e) {
			System.out.println("�� ȣ���� ����� �Է��ϼ���");
			scan.nextLine();
		}
	}

	private static int menu() {
		System.out.println("========================================================");
		System.out.println("1. �濹���ϱ� 2. �� ���� ��� 3. �� ��üȮ��/����Ȯ�� 4. ������ ����Ȯ�� 5.�α׾ƿ�");
		System.out.println("========================================================");
		int sel;
		try {
			sel = inputM("�޴��� �����ϼ��� : ");
			return sel;
		} catch (Exception e) {
			System.out.println("�޴��� ����� �Է��ϼ���");
			scan.nextLine();
			return 0;
		}
	}

	private static int inputM(String string) {
		System.out.println(string);
		try {
			int r = scan.nextInt();
			return r;
		} catch (Exception e) {
			System.out.println("���ڷ� �Է��ϼ���");
			scan.nextLine();
			return 0;
		}
	}

	private static void printRoom(List<Room> list) {
		try {
			int sel = inputM("1. ��üȣ�� Ȯ�� 2. ����ȣ�� Ȯ��");

			if (sel == 1) {
				for (Room rm : list) {
					System.out.println(rm);
				}
			} else if (sel == 2) {
				int r = inputM("Ȯ���Ͻ� ���� ȣ���� �Է��ϼ��� : ");
				System.out.println(list.get(findRoom(r, list)));
			} else {
				System.out.println("�޴��� ����� �Է��ϼ���");
			}
		} catch (Exception e) {
			System.out.println("�޴��� ����� �Է��ϼ���");
			scan.nextLine();
		}
	}

	private static List<Room> init() {
		// ���Ͽ��� �� ���� �ҷ��ͼ� �ʱ� �����ϱ�
		List<Room> list = new ArrayList<>();
		String fileName = "roomInfor.txt";
		BufferedReader br;
		Room r;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(", ");
				r = new Room(Integer.parseInt(tmp[0]), tmp[1], Integer.parseInt(tmp[2]), tmp[3]);
				list.add(r);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	private static void saveResevation(int sel, List<Room> list, Customer customer) {
		// ������ �� ������ ���Ͽ� �����ϱ�
		String fileName = "reservation.txt";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write("���� ���� �����Ͽ����ϴ�.");
			bw.write("������̸� : " + list.get(findRoom(sel, list)).getrName() + ", ");
			bw.write("�����ID : " + customer.getId() + ", ");
			bw.write("������� : " + customer.getName() + ", ");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void cancelResevation(int sel, List<Room> list, Customer customer) {
		// ����� �� ������ ���Ͽ� �����ϱ�
		String fileName = "reservation.txt";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write("���� ���� ����Ͽ����ϴ�.");
			bw.write("������̸� : " + list.get(findRoom(sel, list)).getrName() + ", ");
			bw.write("�����ID : " + customer.getId() + ", ");
			bw.write("������� : " + customer.getName() + ", ");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
