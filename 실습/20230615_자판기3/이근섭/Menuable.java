package kr.co.dong.vendingMachine;

public interface Menuable {
	public static final String topLine = "========================================================================";
	public static final String bottomLine = "------------------------------------------------------------------------";
	
	public abstract void showTitle(String str); // �޴� ��ܿ� ������ �����ش�
//	public abstract void showMenu(); // �޾ƿ� ������ console�� �����ش�
	public abstract String askChoice(String str); // ����� ���� ����� �ش� index�� ����
	
	
}
