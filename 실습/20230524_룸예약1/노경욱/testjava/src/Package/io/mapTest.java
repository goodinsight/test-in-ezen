package Package.io;

import java.util.HashMap;
import java.util.Map;

public class mapTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Map ������ ������. Map�� K V
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("���ѹα�", "����");
		map.put("�̱�", "������");
		map.put("�Ϻ�", "����");
		
		System.out.println("�츮������ ������ " + map.get("���ѹα�"));
	}
}
