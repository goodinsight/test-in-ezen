package ch6;

public class MonitorTest {
	public static void main(String[] args) {
		
		Monitor m1 = new Monitor();
		m1.name = "삼성";
		m1.color = "빨강";
		m1.resol = "고해상";
		m1.setName("삼성");
		
//		VO -> 보여주기 (getter존재)
//		DTO -> 데이터전송오브젝트
		System.out.println(m1.name);
		System.out.println(m1.color);
		System.out.println(m1.resol);
		System.out.println(m1.getName());
	}
	
	
}
