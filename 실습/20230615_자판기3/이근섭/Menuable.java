package kr.co.dong.vendingMachine;

public interface Menuable {
	public static final String topLine = "========================================================================";
	public static final String bottomLine = "------------------------------------------------------------------------";
	
	public abstract void showTitle(String str); // 메뉴 상단에 제목을 보여준다
//	public abstract void showMenu(); // 받아온 구성을 console에 보여준다
	public abstract String askChoice(String str); // 어떤것을 고를지 물어보고 해당 index를 리턴
	
	
}
