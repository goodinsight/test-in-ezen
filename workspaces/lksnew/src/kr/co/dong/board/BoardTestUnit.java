package kr.co.dong.board;

public class BoardTestUnit {
	public static void main(String[] args) {
		BoardDAOimpl b = new BoardDAOimpl();
		BoardBean bb = new BoardBean("������", "�۳���", "���ۼ���");
		int r = b.insert(bb);
		if(r>0)
			System.out.println("sucess");
		else
			System.out.println("failed");
	}
}
