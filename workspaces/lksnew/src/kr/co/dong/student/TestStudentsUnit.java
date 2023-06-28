package kr.co.dong.student;

public class TestStudentsUnit {
	public static void main(String[] args) {
		StudentDAOimpl sdao = new StudentDAOimpl();
		for(StudentBean b : sdao.selectOne("±æ"))
			System.out.println(b);
	}
}
