package kr.co.dong.vendingMachine;

public interface Productable {
	public static final String category = "";	// ��ǰ�� ���� ������ �־��ش�?
	public static final String name = "";	// ��ǰ�� �̸�
	public static final int price = 0;	// ��ǰ�� ����
	public static final String contents = "";	// ��ǰ�� ���� ����
	
	public abstract void buy();	// ��ǰ�� ��� -> ���Ǳ⿡�� �̴´�? -> ����(���)�� �پ���?
	public abstract void sell();	// ��ǰ�� �Ǵ� -> ����
	public abstract void refund();	// ��ǰ�� ȯ���Ѵ�
	
	
	
}
