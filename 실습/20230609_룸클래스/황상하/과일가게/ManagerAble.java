package kr.co.dong.shopping;

import java.util.List;

public class ManagerAble {
	//���� Ȯ��
	//��ǰ ����(��ǰ�̸�)
	//��ǰ ����(��ǰ����)
	//��ǰ ����(��ǰ����)
	public void init(List<Product> pList) { // ��ǰ�ʱ�ȭ
		pList.add(new Product("����", 1000, 40));
		pList.add(new Product("����", 3000, 30));
		pList.add(new Product("����", 5000, 20));
		pList.add(new Product("�޷�", 7000, 10));
	}
}
