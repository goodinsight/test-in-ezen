package kr.co.dong.vendingMachine;

import java.util.Arrays;

public class MoneyChanger {
	public static String[] moneyName = { "5����", "1����", "5õ��", "1õ��", "5���", "1���" };
	public static int[] moneyValue = { 50000, 10000, 5000, 1000, 500, 100 };
	public int[] moneyCount = { 0, 0, 0, 0, 0, 0 };
	
	public MoneyChanger() {
	}
	
	public MoneyChanger(int[] moneyCount){
		this.moneyCount = moneyCount;
	}
	
	public void changeLowerMoney(int moneyValue) {
//	���� ������ ���� ȭ��� �ٲ��ش�?
		for (int i = 0; i < MoneyChanger.moneyValue.length - 1; i++) {
			if (moneyValue == MoneyChanger.moneyValue[i]) {
				this.moneyCount[i] -= 1;
				this.moneyCount[i + 1] += 5;
			}
		}
		if (moneyValue == MoneyChanger.moneyValue[MoneyChanger.moneyValue.length - 1]) {
			System.out.println("1����� �ּҴ����Դϴ�.");
		}
	}
	
	public void insertMoney(int money) {
		// ���� ������  moneyCount�� �־���
		for(int i = 0; i< moneyCount.length; i++) {
			if(money == moneyValue[i]) {
				moneyCount[i]++;
			}
		}
	}
	
	
	public int[] returnOfChange(int money) {
//		�ܵ��� �Ž��� �ִµ� moneyCount���� ȭ�� ���ڶ���� ���� ȭ��� ��ȯ�ؼ� �����ϴ� �޼ҵ�
		int[] moneyCount = { 0, 0, 0, 0, 0, 0 };
		int num = 100000;
		for (int j = 0; j <= 5; j++) { // 5���� ���� ���ʴ�� money�� ���Ͽ� �Ž����� ȭ�� ������ ����
			if (j % 2 == 0) {
				num /= 2;
			} else {
				num /= 5;
			}
			if (money / num > 0) { // ���� moneyConut�� �Ž��� ����� ȭ�亸�� ������ 0�� ����� ���� ȭ��� �Ž�����
				moneyCount[j] = money / num;
				if (moneyCount[j] >= this.moneyCount[j]) {
					moneyCount[j] = this.moneyCount[j];
					money -= this.moneyCount[j]*num;
					this.moneyCount[j] = 0;
				}else {
					money = money % num;
					this.moneyCount[j] -= moneyCount[j];
					if(num == 100) {
						money = 0;
					}
				}
			}
		}
		
		System.out.printf("�Ž������� 50000���� %d��, 10000���� %d��, 5000���� %d��, 1000���� %d��, 500�� %d��, 100�� %d�� �Դϴ�. %n", moneyCount[0], moneyCount[1], moneyCount[2], moneyCount[3], moneyCount[4], moneyCount[5]);

		return moneyCount;
	}

	@Override
	public String toString() {
		return "���� �Ž����� ������ 50000���� "+ moneyCount[0] +"��, 10000���� "+ moneyCount[1] +"��, 5000���� "+ moneyCount[2] +"��, 1000���� "+ moneyCount[3] +"��, 500�� "+ moneyCount[4] +"��, 100�� "+ moneyCount[5] +"�� �Դϴ�.";
	}
	
	
}
