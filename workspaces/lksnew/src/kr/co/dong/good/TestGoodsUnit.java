package kr.co.dong.good;

import java.util.ArrayList;
import java.util.List;

public class TestGoodsUnit {
	public static void main(String[] args) {
//		DAO 메소드 테스트 하기 (단위테스트)
		GoodsDAOImpl gs = new GoodsDAOImpl();
		
//		1.전체목록 테스트
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		list = gs.listAll();
		for(GoodsBean g : list) {
			System.out.println(g);
		}
		
//		2.상품추가테스트
		GoodsBean g = new GoodsBean("비빔밥", "맛있음", 4, "4점");
		int r = gs.insert(g);
		if(r>0) {
			System.out.println("추가");
		}else
			System.out.println("실패");
		
		
	}
}
