/**
 * �л� ���� �߰�, ��ȸ, ����, ����
 */
package kr.co.dong.jdbc;

public interface StudentCrud {
	public abstract void insertStd();	//�л��߰�
	public abstract void allSearchStd();	//�л���ü��ȸ
	public abstract void oneSearchStd();	//�л���ȸ(���� or �й� or �̸�����)
	public abstract void updateStd();	//�л�����
	public abstract void deleteStd();	//�л�����

}
