package Package.io;

public interface Calable {
// 두수의 계산기 필요한 기능을 설계
//매소드 => 클래스: 재사용성
/*
 * 1. 리턴유무(타입)
 * 2. 매개변수의 유무(타입)
 */
	int sum(int n1, int n2);
	int minus(int n1, int n2);
	int mul(int n1, int n2);
	double div(int n1, int n2) throws Exception;
	int clear(char c);
	
}
