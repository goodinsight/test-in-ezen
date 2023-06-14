package kr.co.dong.shopping;

import java.util.List;
import java.util.Scanner;

public class Menu {
	Scanner scan = new Scanner(System.in);
	
	public int menu() {
		System.out.println("======상하네 과일가게======");
		System.out.println("1. 손님모드");
		System.out.println("2. 관리자모드");
		System.out.println("99. 종료하기");
		System.out.println("======================");	
		return Etc.inputMD("메뉴를 입력해주세요 : ");
	}

	public int cMode(String name) {
		System.out.println("======환영합니다 "+name+"님=======");
		System.out.println("1. 상품 확인");
		System.out.println("2. 상품 구매");
		System.out.println("3. 상품 취소");
		System.out.println("88. 돌아가기");
		System.out.println("==========================");	
		return Etc.inputMD("메뉴를 입력해주세요 : ");
	}
	
	public void cMode1(List<Product> pList) {
		System.out.println("==========================");
		for(int i=0; i<pList.size(); i++) {
			System.out.println(pList.get(i));
		}
	}
	
	
	
	
}