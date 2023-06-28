package kr.co.dong.good;

import java.util.List;

public class GoodsMsg {
	
	
	public void goodsViewAll(List<GoodsBean> list) {
		System.out.println(">============상품 전체 목록 조회==============");
		for(GoodsBean b : list)
			System.out.println(b);
	}
	public void goodsView(GoodsBean gb) {
		System.out.println(">============상품 조회==============");
		System.out.println(gb);
	}

	public void goodErrorMsg(String string) {
		switch (string) {
		case "insert":
			System.out.println("상품정보추가 실패");
			break;
		case "update":
			System.out.println("상품정보수정 실패");
			break;
		case "selectOne":
			System.out.println("상품정보가 없습니다.");
			break;
		case "delete":
			System.out.println("상품정보삭제 실패");
			break;
		default:
			System.out.println("오류를 찾을 수 없습니다.");
			break;
		}
		
	}

}
