package kr.co.dong.ioclasses;

public interface Calable {
	// �μ��� ���⿡ �ʿ��� ����� ����
	int sum (int n1, int n2);
	int minus (int n1, int n2);
	int multiply (int n1, int n2);
	public abstract double divide (int n1, int n2) throws Exception;
	int clear(int c);
}
