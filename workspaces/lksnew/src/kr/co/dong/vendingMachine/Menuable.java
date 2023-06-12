package kr.co.dong.vendingMachine;

public interface Menuable {
	public static final String topLine = "==============================================";
	public static final String bottomLine = "==============================================";
	public static final boolean power = false;
	
	public abstract void showTitle(); // 메뉴 상단에 제목을 보여준다
	public abstract void getMenu(); // 메뉴의 구성을 (어디서?) 받아 온다
	public abstract void showMenu(); // 받아온 구성을 console에 보여준다
	public abstract void askChoice(); // 메뉴의 구성에서 어떤것을 선택할지 물어본다
	
	
}
