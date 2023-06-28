/*
 * menuView() : 상품 메뉴 선택하는 기능(1. 상품추가 2.상품정보수정 ...)
 * displayMenu() : 1.상품추가하는 기능호출 2. 상품정보수정 기능호출
 */
package kr.co.dong.good;

import java.util.Scanner;

public class GoodsMenu {
	Scanner scan = new Scanner(System.in);
	GoodsControl gc = new GoodsControl();
	public void displayMenu() {
		while(true) {
//			메뉴보여주기
			String n = menuView();
			switch (n) {
			case "1":	//상품추가 : 입력 -> DB추가 -> 성공/실패
				gc.insert(add());
				break;
			case "2":	//상품수정
				gc.selectOne(GoodsId());
				gc.update(add(),GoodsId());
				break;
			case "3":	//상품전체조회
				gc.listAll();
				break;
			case "4":	//상품번호조회
				gc.selectOne(GoodsId());				
				break;
			case "5":	//상품명조회
				gc.selectOne(GoodsName());				
				break;	
			case "6":	//상품삭제
				gc.delete(GoodsId());				
				break;
			case "999":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("번호를 다시 입력해주세요");
				break;
			}
		}
	}
	

	private String GoodsName() {
		System.out.print("상품명 입력 : ");
		return scan.nextLine();
	}


	public String menuView() {
		System.out.println("=============== 상품 메뉴 ================");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 정보 수정");
		System.out.println("3. 상품 전체 목록 조회");
		System.out.println("4. 상품 아이디로 조회");
		System.out.println("5. 상품명으로 조회");
		System.out.println("6. 상품 삭제");
		System.out.println("999. 끝내기");
		System.out.println("========================================");
		System.out.println("번호 입력 : ");
		
		
		return scan.nextLine();
	}
	
	public GoodsBean add() {
		// 상품 입력(수정)하는 메소드
		GoodsBean g = null;
		System.out.println("======= 상품 추가 / 수정 ========");
		System.out.print("상품명 : ");
		String gname = scan.nextLine();
		System.out.print("상세 설명 : ");
		String gcontent = scan.nextLine();
		System.out.print("수량 : ");
		int gcnt = Integer.parseInt(scan.nextLine());
		System.out.print("부가 설명 : ");
		String getc = scan.nextLine();
		
		g = new GoodsBean(gname, gcontent, gcnt, getc);
		return g;
	}
	
	public int GoodsId() {
		System.out.print("상품 번호 입력 : ");
		return Integer.parseInt(scan.nextLine());
	}
}
