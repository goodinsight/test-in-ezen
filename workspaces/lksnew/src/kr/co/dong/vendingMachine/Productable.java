package kr.co.dong.vendingMachine;

public interface Productable {
	public static final String category = "";	// 제품의 상위 구분을 넣어준다?
	public static final String name = "";	// 제품의 이름
	public static final int price = 0;	// 제품의 가격
	public static final String contents = "";	// 제품의 간단 설명
	
	public abstract void buy();	// 제품을 산다 -> 자판기에서 뽑는다? -> 수량(재고)가 줄어든다?
	public abstract void sell();	// 제품을 판다 -> 자판
	public abstract void refund();	// 제품을 환불한다
	
	
	
}
