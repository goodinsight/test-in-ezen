package kr.co.dong.good;

import java.util.ArrayList;
import java.util.List;

public class TestGoodsUnit {
	public static void main(String[] args) {
//		DAO �޼ҵ� �׽�Ʈ �ϱ� (�����׽�Ʈ)
		GoodsDAOImpl gs = new GoodsDAOImpl();
		
//		1.��ü��� �׽�Ʈ
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		list = gs.listAll();
		for(GoodsBean g : list) {
			System.out.println(g);
		}
		
//		2.��ǰ�߰��׽�Ʈ
		GoodsBean g = new GoodsBean("�����", "������", 4, "4��");
		int r = gs.insert(g);
		if(r>0) {
			System.out.println("�߰�");
		}else
			System.out.println("����");
		
		
	}
}
