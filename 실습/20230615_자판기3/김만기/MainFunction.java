package vendingmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainFunction implements Function{
	
	List<MoneyCount> moneyCounts =  new ArrayList<MoneyCount>();
	List<Product> products = new ArrayList<Product>();
	
	public void init_a() {
		products.add(new Product("사이다", 500, 10));
		products.add(new Product("콜라", 600, 10));
		products.add(new Product("환타", 700, 10));
		products.add(new Product("밀키스", 800, 10));
		init_b();
	}
	
	public void init_b() {
		moneyCounts.add(new MoneyCount(100, 10));
		moneyCounts.add(new MoneyCount(500, 10));
		moneyCounts.add(new MoneyCount(1000, 10));
		moneyCounts.add(new MoneyCount(5000, 10));
		moneyCounts.add(new MoneyCount(10000, 10));
		moneyCounts.add(new MoneyCount(50000, 10));
	}
	
	public void mainManu() {
		System.out.println("메인메뉴");
		Iterator<Product> iterator = products.iterator();
		int i = 1;
		while(iterator.hasNext()) {
			System.out.print((i++)+"."+iterator.next()+"\t");
		}
		System.out.print("[5.반환] \t [99.종료]");
		System.out.println("\n잔액 : "+MoneyCount.getMoneySum());
		System.out.println("금액을 투입하거나 메뉴를 입력해주세요.");
	}
	
	public void sale(int input) {
		if(products.get(input-1).getAmount() == 0) {
			System.out.println("품절입니다.");	
		} else if(MoneyCount.getMoneySum() < products.get(input-1).getPrice()) {
			System.out.println("잔액이 부족합니다.");
		} else {
			MoneyCount.setMoneySum(MoneyCount.getMoneySum() - products.get(input-1).getPrice());
			products.get(input-1).setAmount(products.get(input-1).getAmount() - 1);
			System.out.println("주문하신 "+products.get(input-1).getName()+" 나왔습니다.");
		}
	}
	
	public void insertMoney(int insert) {
		for(int i=0; i<moneyCounts.size(); i++) {
			int num = moneyCounts.get(i).getMoneyType();
			if(insert == num) {
				moneyCounts.get(i).setmTypeAmount(moneyCounts.get(i).getmTypeAmount() + 1);
				MoneyCount.setMoneySum(MoneyCount.getMoneySum() + insert);
				return;
			}
			
		}
		System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
	}
	
	public void moneyOutput() {
		for(int i=moneyCounts.size()-1; i>=0; i--) {
			if(moneyCounts.get(i).getMoneyType() <= MoneyCount.getMoneySum()) {
				System.out.println(moneyCounts.get(i).getMoneyType()+"원 "+MoneyCount.getMoneySum() / moneyCounts.get(i).getMoneyType()+" 개");
				MoneyCount.setMoneySum(MoneyCount.getMoneySum() % moneyCounts.get(i).getMoneyType());
			}
		}
	}
}
