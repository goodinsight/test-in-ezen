package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class JapangIExpel {		// ��ǰ ����

	List<Japangi> exjapangi;
	
	public JapangIExpel() {
		exjapangi = new ArrayList<Japangi>();
	}
	
	public void addexjapang(Japangi japangi) {
		exjapangi.add(new Japangi(japangi.getjName(), japangi.getjPrice(), japangi.getjCount()));
		System.out.println(japangi.getjName() + "��ǰ�� �����Ǿ����ϴ�.");
	}
	
	
}
