package kr.co.dong.good;

import java.util.List;

public class GoodsControl {
	GoodServiceImpl gservice = new GoodServiceImpl();
	GoodsMsg gmsg = new GoodsMsg();
	
	public void listAll() {
		List<GoodsBean> list = gservice.listAll();
		
		if(list.isEmpty()) {
			System.out.println("조회 정보가 없습니다.");
		}else {
			gmsg.goodsViewAll(list);
		}
	}
	
	public void insert(GoodsBean add) {
		int r = gservice.insert(add);
		
		if(r>0) {
			System.out.println("상품 정보 추가 완료");
		}else
			gmsg.goodErrorMsg("insert");
	}

	public void update(GoodsBean add, int goodsId) {
		// TODO Auto-generated method stub
		GoodsBean gb = gservice.selectOne(goodsId);
		if(gb == null) {
			gmsg.goodErrorMsg("selectOne");
			return;
		}
		
		gmsg.goodsView(gb);
		
		add.setGid(goodsId);
		int r = gservice.update(add);
		
		if(r>0) {
			System.out.println("상품 정보 수정 완료");
		}else
			gmsg.goodErrorMsg("update");
	}

	public void selectOne(int goodsId) {
		// TODO Auto-generated method stub
		GoodsBean gb = gservice.selectOne(goodsId);
		
		if (gb == null) {
			gmsg.goodErrorMsg("selectOne");
		}else
			gmsg.goodsView(gb);;
	}
	public void selectOne(String goodsName) {
		// TODO Auto-generated method stub
		List<GoodsBean> list = gservice.selectOne(goodsName);
		
		if (list == null) {
			gmsg.goodErrorMsg("selectOne");
		}else
			gmsg.goodsViewAll(list);;
	}

	public void delete(int goodsId) {
		// TODO Auto-generated method stub
		GoodsBean gb = gservice.selectOne(goodsId);
		if(gb == null) {
			gmsg.goodErrorMsg("selectOne");
			return;
		}
		
		int r = gservice.delete(goodsId);
		
		if(r>0) {
			System.out.println("상품 정보 삭제 완료");
		}else
			gmsg.goodErrorMsg("delete");
		
		this.listAll();
		
	}

}
