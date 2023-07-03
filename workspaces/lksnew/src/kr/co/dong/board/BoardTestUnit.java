package kr.co.dong.board;

public class BoardTestUnit {
	public static void main(String[] args) {
		BoardDAOimpl b = new BoardDAOimpl();
		BoardBean bb = new BoardBean("글제목", "글내용", "글작성자");
		int r = b.insert(bb);
		if(r>0)
			System.out.println("sucess");
		else
			System.out.println("failed");
	}
}
