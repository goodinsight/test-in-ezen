package kr.co.dong.shopping;

import java.util.List;
import java.util.Scanner;

public class Menu {
	Scanner scan = new Scanner(System.in);
	
	public int menu() {
		System.out.println("======���ϳ� ���ϰ���======");
		System.out.println("1. �մԸ��");
		System.out.println("2. �����ڸ��");
		System.out.println("99. �����ϱ�");
		System.out.println("======================");	
		return Etc.inputMD("�޴��� �Է����ּ��� : ");
	}

	public int cMode(String name) {
		System.out.println("======ȯ���մϴ� "+name+"��=======");
		System.out.println("1. ��ǰ Ȯ��");
		System.out.println("2. ��ǰ ����");
		System.out.println("3. ��ǰ ���");
		System.out.println("88. ���ư���");
		System.out.println("==========================");	
		return Etc.inputMD("�޴��� �Է����ּ��� : ");
	}
	
	public void cMode1(List<Product> pList) {
		System.out.println("==========================");
		for(int i=0; i<pList.size(); i++) {
			System.out.println(pList.get(i));
		}
	}
	
	
	
	
}