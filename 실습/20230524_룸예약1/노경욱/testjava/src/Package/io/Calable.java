package Package.io;

public interface Calable {
// �μ��� ���� �ʿ��� ����� ����
//�żҵ� => Ŭ����: ���뼺
/*
 * 1. ��������(Ÿ��)
 * 2. �Ű������� ����(Ÿ��)
 */
	int sum(int n1, int n2);
	int minus(int n1, int n2);
	int mul(int n1, int n2);
	double div(int n1, int n2) throws Exception;
	int clear(char c);
	
}
