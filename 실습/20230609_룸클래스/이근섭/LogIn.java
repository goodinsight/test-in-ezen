package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LogIn{
	Scanner scan = new Scanner(System.in);
	
	int showLogin() {
		// ȸ�������� ���� �ʱ� ȭ�� ����
		System.out.println("================================");
		System.out.println(" 1. ó�� �湮�� ȸ������             ");
		System.out.println(" 2. ���� ȸ���� �α����ϱ�           ");
		System.out.println(" 3. ���̵� ��� ã��                ");
		System.out.println("=================================");
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
	
	Customer logIn(Customer customer) {
		// customer.txt���� �������� �ҷ��ͼ� �α����ϱ�
		customer = new Customer();
		String fileName = "customer.txt";
		System.out.println("�α��� id�� �Է��ϼ���");
		String temp = scan.next();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String data = br.readLine();
				if (data == null) {
					System.out.println("��ġ�ϴ� id�� �����ϴ�. ȸ�������� �ϼ���");
					break;
				}
				String[] tmp = data.split(",");
				if (tmp[0].equals(temp)) {
					customer.setId(temp);
					System.out.println("password�� �Է��ϼ���");
					String temp2 = scan.next();
					if (tmp[1].equals(temp2)) {
						System.out.println("�α����� ���������� �Ǿ����ϴ�.");
						customer.setId(tmp[0]);
						customer.setPassword(tmp[1]);
						customer.setName(tmp[2]);
						customer.setCode(tmp[3]);// ���� ��ü�� �ش� ���� �̸��� ������ȣ�� �־���
						break;
					} else {
						System.out.println("password�� Ʋ�� �α��� �ϽǼ� �����ϴ�.");
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return customer;
	}
	
	void findCustomer() {
		// ���̵� ����� ���ȳ��� �̸��� ������ȣ�� id�� pw�� ��ȯ����
		String fileName = "customer.txt";
		System.out.println("ȸ�������ϼ����� �Է��Ͻ� �̸��� ��������");
		String temp = scan.next();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String data = br.readLine();
				if (data == null) {
					System.out.println("��ġ�ϴ� �̸��� �����ϴ�. ȸ�������� �ϼ���");
					break;
				}
				String[] tmp = data.split(",");
				if (tmp[2].equals(temp)) {
					System.out.println("������ȣ�� ��������");
					String temp2 = scan.next();
					if (tmp[3].equals(temp2)) {
						System.out.println("id�� pw�� �˷��帮�ڽ�");
						System.out.println("����� id�� " + tmp[0] + "�Դϴ�.");
						System.out.println("����� pw�� " + tmp[1] + "�Դϴ�.");
						break;
					} else {
						System.out.println("������ȣ�� Ʋ�� id�� pw�� �Ⱦ˷���");
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Customer setCustomer(Customer customer) {
		// ȸ�� ���� �޾Ƽ� ��ü ����
		customer = new Customer();
		System.out.println("===================================");
		System.out.println("     <ȸ�� ����>           ");
		System.out.println(" <���> 1. �����         ");
		System.out.println("       2. �� ��Ű�ʽÿ�     ");
		System.out.println();
		System.out.println("ȸ�� ������ ���ؼ��� 4���� ����");
		System.out.println(" id, pw, �̸�, code �ʿ��մϴ�");
		System.out.println("===================================");
		System.out.println();
		System.out.println("1. �α��� �Ͻ� id�� �Է��ϼ���");
		customer.setId(scan.next());
		System.out.println("2. �α��� password�� �Է��ϼ���");
		customer.setPassword(scan.next());
		System.out.println("3. ����� ����Ȯ���� ���� �̸��� �Է��ϼ���");
		customer.setName(scan.next());
		System.out.println("4. ������ �����ȣ�� �Է��ϼ���");
		customer.setCode(scan.next());

		return customer;
	}
	
	int showSetMenu() {
		// ȸ������ �ʱ�޴�
		System.out.println("===================================");
		System.out.println(" ~~���� ȣ���� ã���ּż� �����մϴ�~~    ");
		System.out.println(" <�ȳ�> ó�� ���� ������ ȸ������ ���� ");
		System.out.println("       �� ȣ���� �� ���� ���񽺸� �̿��Ͻ�");
		System.out.println("       �� �ֽ��ϴ�.                  ");
		System.out.println(" 1. ȸ�� �����ϱ�                    ");
		System.out.println(" 2. �׳� ������                      ");
		System.out.println("===================================");

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
	
	void saveCustomer(Customer customer) {
		// ȸ�������� ������ ���Ͽ� �����ϱ�
		String fileName = "customer.txt";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(customer.getId() + ",");
			bw.write(customer.getPassword() + ",");
			bw.write(customer.getName() + ",");
			bw.write(customer.getCode());
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
	
	int inputM(String string) {
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
}
