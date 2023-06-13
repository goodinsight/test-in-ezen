package kr.co.dong.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RoomControl {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		RoomFunc rf = new RoomFunc();
		Admin ad = new Admin();
		List<Room> list = new ArrayList<Room>();
		boolean stop = false;
		ad.listCheck(list);
		
		while(!stop) {
			int sel = rf.menu();
			
			switch(sel) {
			
			case 0:
				stop = true;
				System.out.println("�����մϴ�.");
			
			case 1: // �� �����ϱ�
				rf.Res(list);
				break;
				
			case 2: // �� ���� ���
				rf.ResCancel(list);
				break;
				
			case 3: // �� ��üȮ��/����Ȯ��
				rf.Check(list);
				break;
				
			case 4: // ������ ����Ȯ��
				rf.ResCheck(list);
				break;
				
			case 77: // ������ ���
				int admin_sel = ad.Pwd();
				
				switch(admin_sel) {
				case 0:
					break;
					
				case 1:
					ad.RoomAdd(list);
					break;
					
				case 2:
					ad.RoomDel(list);
					break;
					
				case 3:
					ad.RoomSet(list);
					break;
					
				case 4:
					ad.resCheck(list);
					break;
					
				case 5:
					ad.PwdSet();
					break;
					
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				}
				break;
				
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
				
			}
		}
	}	
}
