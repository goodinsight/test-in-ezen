package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub //���Ǳⱸ�� ,����3���� ����,���������� ����
		// ���۰� ���ÿ� ȭ�鿡 �޴� �����ֱ� , ���������� ���� ,����,�Ž�������ȯ,���Է� ���Ǳ� ����,99�̿� ���ڸ� ȭ��޴� �������
		boolean power = false; // �����Ӵϴ�
		// �޴��Է� , ���̶� �����̸���1,2,3 ,����1,����2,����3 , �Ž�����
		Scanner scan = new Scanner(System.in);
		int money, menu, ch = 0, bt = 0; // ���� �޴� �� �Ž������� ��ư�� ����

		int col = 800, sunny = 1000, apple = 1500;// �ݶ�800�� ,������1000�� ���1500��
		int cun, five, one = 0;//õ�� ����� ���
		System.out.println("�����Է��ϼ���");
		money = scan.nextInt();

		System.out.println("�޴������ϼ���");
		System.out.println("1.�ݶ�,2�����,3���");
		menu = scan.nextInt();
		ch = money - menu;// �Ž�����

		
			if (menu==1&&money>col) {
				ch=money-col;
			} else if (menu==2&&money>sunny) {
				ch=money-sunny;
			} else if (menu==3&&money>apple) {
				ch=money-apple;
			}else if(money<menu) {
				System.out.println("�ܵ��Է��ϼ���");
			}else {
				ch=money;
				System.out.println("���ư���");
				if(bt!=99) {
					System.out.println("������");
				}else {
					System.out.println("���ε�");
				}
			}
			System.out.println("�ܵ� ="+ch + "��" );
			
			cun=money/1000;
			five=money%500;
			one=money%100;
			System.out.println("õ�� ="+cun + "" );
			System.out.println("��õ�� ="+five + "");
			System.out.println("��� ="+one + "");
		}

	}


