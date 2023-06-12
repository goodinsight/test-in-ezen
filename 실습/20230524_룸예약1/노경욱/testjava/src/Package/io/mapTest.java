package Package.io;

import java.util.HashMap;
import java.util.Map;

public class mapTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Map 사용법을 익히자. Map은 K V
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("대한민국", "서울");
		map.put("미국", "워싱턴");
		map.put("일본", "몰라");
		
		System.out.println("우리나라의 수도는 " + map.get("대한민국"));
	}
}
