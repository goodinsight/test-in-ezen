package kr.co.dong.vendingMachine;

public interface Menuable {
	public static final String topLine = "==============================================";
	public static final String bottomLine = "==============================================";
	public static final boolean power = false;
	
	public abstract void showTitle(); // �޴� ��ܿ� ������ �����ش�
	public abstract void getMenu(); // �޴��� ������ (���?) �޾� �´�
	public abstract void showMenu(); // �޾ƿ� ������ console�� �����ش�
	public abstract void askChoice(); // �޴��� �������� ����� �������� �����
	
	
}
