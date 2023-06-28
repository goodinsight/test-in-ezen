package kr.co.dong.good;

import java.util.List;

public class GoodsMsg {
	
	
	public void goodsViewAll(List<GoodsBean> list) {
		System.out.println(">============��ǰ ��ü ��� ��ȸ==============");
		for(GoodsBean b : list)
			System.out.println(b);
	}
	public void goodsView(GoodsBean gb) {
		System.out.println(">============��ǰ ��ȸ==============");
		System.out.println(gb);
	}

	public void goodErrorMsg(String string) {
		switch (string) {
		case "insert":
			System.out.println("��ǰ�����߰� ����");
			break;
		case "update":
			System.out.println("��ǰ�������� ����");
			break;
		case "selectOne":
			System.out.println("��ǰ������ �����ϴ�.");
			break;
		case "delete":
			System.out.println("��ǰ�������� ����");
			break;
		default:
			System.out.println("������ ã�� �� �����ϴ�.");
			break;
		}
		
	}

}
