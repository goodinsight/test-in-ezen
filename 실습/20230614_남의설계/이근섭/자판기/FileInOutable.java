package kr.co.dong.vendingMachine;

import java.util.List;

public interface FileInOutable {
	Object init();	//���Ϸ� �ʱ�ȭ
	void readFile(); 	//���� �о����
	void writeFile(Object obj);	//���� ����
	void updateFile(Object obj);	//���� ����
	void deleteFile(Object obj);	//���� �����	
}
