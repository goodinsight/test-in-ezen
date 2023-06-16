package kr.co.dong.vendingMachine;

import java.util.Arrays;

public class MoneyChanger {
	public static String[] moneyName = { "5만원", "1만원", "5천원", "1천원", "5백원", "1백원" };
	public static int[] moneyValue = { 50000, 10000, 5000, 1000, 500, 100 };
	public int[] moneyCount = { 0, 0, 0, 0, 0, 0 };
	
	public MoneyChanger() {
	}
	
	public MoneyChanger(int[] moneyCount){
		this.moneyCount = moneyCount;
	}
	
	public void changeLowerMoney(int moneyValue) {
//	돈이 들어오면 하위 화폐로 바꿔준다?
		for (int i = 0; i < MoneyChanger.moneyValue.length - 1; i++) {
			if (moneyValue == MoneyChanger.moneyValue[i]) {
				this.moneyCount[i] -= 1;
				this.moneyCount[i + 1] += 5;
			}
		}
		if (moneyValue == MoneyChanger.moneyValue[MoneyChanger.moneyValue.length - 1]) {
			System.out.println("1백원은 최소단위입니다.");
		}
	}
	
	public void insertMoney(int money) {
		// 돈이 들어오면  moneyCount에 넣어줌
		for(int i = 0; i< moneyCount.length; i++) {
			if(money == moneyValue[i]) {
				moneyCount[i]++;
			}
		}
	}
	
	
	public int[] returnOfChange(int money) {
//		잔돈을 거슬러 주는데 moneyCount에서 화폐가 모자라더라도 하위 화폐로 반환해서 지급하는 메소드
		int[] moneyCount = { 0, 0, 0, 0, 0, 0 };
		int num = 100000;
		for (int j = 0; j <= 5; j++) { // 5만원 부터 차례대로 money와 비교하여 거슬러줄 화폐별 갯수를 구함
			if (j % 2 == 0) {
				num /= 2;
			} else {
				num /= 5;
			}
			if (money / num > 0) { // 보유 moneyConut가 거슬러 줘야할 화페보다 작으면 0을 만들고 하위 화폐로 거슬러줌
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
		
		System.out.printf("거스름돈은 50000원권 %d장, 10000원권 %d장, 5000원권 %d장, 1000원권 %d장, 500원 %d개, 100원 %d개 입니다. %n", moneyCount[0], moneyCount[1], moneyCount[2], moneyCount[3], moneyCount[4], moneyCount[5]);

		return moneyCount;
	}

	@Override
	public String toString() {
		return "현재 거스름돈 수량은 50000원권 "+ moneyCount[0] +"장, 10000원권 "+ moneyCount[1] +"장, 5000원권 "+ moneyCount[2] +"장, 1000원권 "+ moneyCount[3] +"장, 500원 "+ moneyCount[4] +"개, 100원 "+ moneyCount[5] +"개 입니다.";
	}
	
	
}
