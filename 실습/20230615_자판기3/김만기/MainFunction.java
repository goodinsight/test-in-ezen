package vendingmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainFunction implements Function{
	
	List<MoneyCount> moneyCounts =  new ArrayList<MoneyCount>();
	List<Product> products = new ArrayList<Product>();
	
	public void init_a() {
		products.add(new Product("���̴�", 500, 10));
		products.add(new Product("�ݶ�", 600, 10));
		products.add(new Product("ȯŸ", 700, 10));
		products.add(new Product("��Ű��", 800, 10));
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
		System.out.println("���θ޴�");
		Iterator<Product> iterator = products.iterator();
		int i = 1;
		while(iterator.hasNext()) {
			System.out.print((i++)+"."+iterator.next()+"\t");
		}
		System.out.print("[5.��ȯ] \t [99.����]");
		System.out.println("\n�ܾ� : "+MoneyCount.getMoneySum());
		System.out.println("�ݾ��� �����ϰų� �޴��� �Է����ּ���.");
	}
	
	public void sale(int input) {
		if(products.get(input-1).getAmount() == 0) {
			System.out.println("ǰ���Դϴ�.");	
		} else if(MoneyCount.getMoneySum() < products.get(input-1).getPrice()) {
			System.out.println("�ܾ��� �����մϴ�.");
		} else {
			MoneyCount.setMoneySum(MoneyCount.getMoneySum() - products.get(input-1).getPrice());
			products.get(input-1).setAmount(products.get(input-1).getAmount() - 1);
			System.out.println("�ֹ��Ͻ� "+products.get(input-1).getName()+" ���Խ��ϴ�.");
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
		System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
	}
	
	public void moneyOutput() {
		for(int i=moneyCounts.size()-1; i>=0; i--) {
			if(moneyCounts.get(i).getMoneyType() <= MoneyCount.getMoneySum()) {
				System.out.println(moneyCounts.get(i).getMoneyType()+"�� "+MoneyCount.getMoneySum() / moneyCounts.get(i).getMoneyType()+" ��");
				MoneyCount.setMoneySum(MoneyCount.getMoneySum() % moneyCounts.get(i).getMoneyType());
			}
		}
	}
}
