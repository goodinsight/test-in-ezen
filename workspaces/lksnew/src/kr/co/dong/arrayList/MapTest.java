package kr.co.dong.arrayList;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
//		Map ������ ������.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("���ѹα�", "����");
		map.put("�̱�","������");
		map.put("�Ϻ�","����");
		
		System.out.println("�츮������ ������ "+ map.get("���ѹα�"));
	}
}
