package kr.co.dong.ioclasses;

public interface Calable {
	// 두수의 계산기에 필요한 기능을 설계
	int sum (int n1, int n2);
	int minus (int n1, int n2);
	int multiply (int n1, int n2);
	public abstract double divide (int n1, int n2) throws Exception;
	int clear(int c);
}
