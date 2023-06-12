package kr.co.dong.func;

public class Human extends Animal implements Sportable{
//	인간의 속성
	String think;
	String blood;
	
//	인간의 기능
	void 생각한다() {
		System.out.println("나는 생각을 한다.");
	}

	@Override
	public void workOut() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	void 달린다() {
		System.out.println("===");
		System.out.println("===");
		System.out.println("===");
	}
	
		
		
	
}
