package kr.co.dong;

public class Test06 {
	public static void main(String[] args) {
//		점심 메뉴를 랜덤하게 뽑아보자
		String[] menu = {"덮밥","돈까스", "라멘", "중식", "한식", "일식", "분식", "짜장"};
		int choice = (int)(Math.random()*7);
		System.out.println(menu[choice]);
		
	}
}