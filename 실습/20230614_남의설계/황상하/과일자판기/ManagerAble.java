package vendingMahchine;

import java.util.ArrayList;
import java.util.List;

public class ManagerAble {
	Fruit fruit;
	List<Fruit> fList;

	public ManagerAble() {
		fList = new ArrayList<Fruit>();
	}
	
	void init() {
		fList.add(new Fruit("����", 2000, 40));
		fList.add(new Fruit("����", 4000, 30));
		fList.add(new Fruit("����", 6000, 20));
		fList.add(new Fruit("�޷�", 8000, 0));
	}
	
	// ��ǰ�̸�����
	void changeName() {
		
	}
	// ��ǰ���ݺ���
	void changePrice() {
		
	}
	// ��ǰ��������
	void changeCount() {
		
	}
	// ����Ȯ��
	void checkSale() {
		
	}
}
