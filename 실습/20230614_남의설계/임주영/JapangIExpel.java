package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class JapangIExpel {		// 제품 삭제

	List<Japangi> exjapangi;
	
	public JapangIExpel() {
		exjapangi = new ArrayList<Japangi>();
	}
	
	public void addexjapang(Japangi japangi) {
		exjapangi.add(new Japangi(japangi.getjName(), japangi.getjPrice(), japangi.getjCount()));
		System.out.println(japangi.getjName() + "제품이 삭제되었습니다.");
	}
	
	
}
