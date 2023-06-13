package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RoomControl_1 {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
//		ȣ�ڷ�(5��)�� ������ ���� -> List
		
		Map<Integer, Room> roomMap = new HashMap<Integer, Room>();
//		key: ���ǹ�ȣ, value: ��������
		
		Map<Integer, Reservation> revMap = new HashMap<Integer, Reservation>();
//		key: ���ǹ�ȣ, value : ���� ����
		
		Map<String, ArrayList<Integer>> revInfo = new HashMap<String, ArrayList<Integer>>();
//		key: �������̸� + " " + �����ȣ, value : ���ǹ�ȣ
		
		boolean stop = false;
		
		init(roomMap, "room.txt");
		
		int mode = 0;
		
		while(!stop) {
			
			switch(mode) {
				case 0: // �ʱ� �޴�
					mode = menu();
					break;
				case 1: // �� ����
					revRoom(roomMap, revMap, revInfo);
					mode = 0;
					break;
				case 2: // �� ���� ���
					cancelRoom(roomMap, revMap, revInfo);
					mode = 0;
					break;
				case 3:	// �� ��üȮ��/ ����Ȯ��
					printRoom(roomMap);
					mode = 0;
					break;
				case 4: // �������� Ȯ��
					printRevInfo(roomMap, revInfo);
					mode = 0;
					break;
				case 99: // ����
					stop = true;
					break;
				default: 
					System.out.println("�߸��� �Է��Դϴ�.");
					mode = 0;
			}
			
		}
		
	}






	private static int inputInt(String string) {
		
		boolean flag = true;
		int input = 0;
		while(flag) {
			try {
				System.out.print(string + "\n>>");
				input = scan.nextInt();				
				flag = false;
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				scan.next();
			}
		}
		
		return input;
	}
	
	private static int inputInt(String string, int range, boolean cancel) {
		
		boolean flag = true;
		int input = 0;
		while(flag) {
			try {
				System.out.print(string + "\n>>");
				input = scan.nextInt();	
				
				if((input >= 1 && input <= range)||(cancel && input == 99)) {
					flag = false;
				}else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
				
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				scan.next();
			}
		}
		
		return input;
	}

	private static String inputStr(String string) {

		System.out.print(string + "\n>>");
		String input = scan.nextLine();
		scan.next();
		
		return input;
	}

	private static int menu() {
		
		return inputInt("\n�Է� �ȳ�\n"
				+ "1\t: ����\n"
				+ "2\t: ���� ���\n"
				+ "3\t: ���� Ȯ��\n"
				+ "4\t: �������� Ȯ��\n"
				+ "99\t: ����");
	}

	private static void revRoom(Map<Integer, Room> roomMap, Map<Integer, Reservation> revMap, Map<String, ArrayList<Integer>> revInfo) {
		
		int roomNo = inputInt("\n�����Ͻð� ���� ���� ��ȣ�� �Է����ּ���.");
		
		if(!roomMap.containsKey(roomNo)) {
			System.out.println("�ش��ϴ� ��ȣ�� ������ �����ϴ�.");
		}else if(roomMap.get(roomNo).isrCheck()) {
			System.out.println("�̹� ����Ǿ��ִ� �����Դϴ�.");
		}else {
			System.out.println(roomMap.get(roomNo));
			int sel = inputInt("�ش� ������ �����Ͻðڽ��ϱ�? (1 : yes, 2 : no)", 2, false);
			
			if(sel == 1) {
			
				String cName = inputStr("������ ���� �Է����ּ���.");
				String rCode = inputStr("���� ��ȣ�� �Է����ּ���.");
				
				roomMap.get(roomNo).setrCheck(true);
				revMap.put(roomNo, new Reservation(roomNo, cName, rCode));
				
				String tmp = cName + " " + rCode;
				if(!revInfo.containsKey(tmp)) revInfo.put(tmp, new ArrayList<Integer>());
				revInfo.get(tmp).add(roomNo);
			}
			
		}
		
	}	
	


	private static void cancelRoom(Map<Integer, Room> roomMap, Map<Integer, Reservation> revMap, Map<String, ArrayList<Integer>> revInfo) {
		
		String cName = inputStr("������ ���� �Է����ּ���.");
		String rCode = inputStr("���� ��ȣ�� �Է����ּ���.");
		
		String tmp = cName + " " + rCode;
		
		if(!revInfo.containsKey(tmp)) {
			System.out.println("�ش��ϴ� �����ڰ� ���ų� ���� ��ȣ�� ��ġ���� �ʽ��ϴ�.");
		}else {
			
			List<Integer> removeList = new ArrayList<Integer>();
			
			for(Integer rNo : revInfo.get(tmp)) {
				System.out.println(roomMap.get(rNo));
				
				int sel = inputInt("�ش� ������ ������ ����Ͻðڽ��ϱ�? (1 : yes, 2: no)", 2, false);
				if(sel == 1) {
					removeList.add(rNo);
					
					revMap.remove(rNo);
					roomMap.get(rNo).setrCheck(false);
					System.out.println("������ ��ҵǾ����ϴ�.");
				}
			}
			
			for(Integer rNo : removeList) {
				revInfo.get(tmp).remove(rNo);
			}
			
			if(revInfo.get(tmp).size() == 0) {
				revInfo.remove(tmp);
			}
			
		}
		
	}

	private static void printRoom(Map<Integer, Room> map) {
		
		int sel = inputInt("1. ��ü ���� Ȯ�� \n"
				+ "2. ������ ���� Ȯ��\n"
				+ "3. ����Ǿ��ִ� ���� Ȯ��\n"
				+ "4. ����Ǿ����� ���� ���� Ȯ��\n"
				+ "Ȯ���Ͻð� ���� ������ ��ȣ�� �Է����ּ���.", 4, false);
	
		if(sel == 1) {
			for(Integer key : map.keySet()) {
				System.out.println(map.get(key));
			}
		}else if(sel == 2) {
			System.out.println(map.get(inputInt("Ȯ���Ͻð� ���� ������ ��ȣ�� �Է����ּ���.")));
			
		}else {
			boolean notflag = false;
			if(sel == 4) notflag = true;
			
			for(Integer key : map.keySet()) {
				if(notflag^map.get(key).isrCheck()) {
					System.out.println(map.get(key));
				}
			}
		}
		
		
	}
	
	

	private static void printRevInfo(Map<Integer, Room> roomMap, Map<String, ArrayList<Integer>> revInfo) {
		
		String cName = inputStr("������ ���� �Է����ּ���.");
		String rCode = inputStr("���� ��ȣ�� �Է����ּ���.");
		
		String tmp = cName + " " + rCode;
		
		if(!revInfo.containsKey(tmp)) {
			System.out.println("�ش��ϴ� �����ڰ� ���ų� ���� ��ȣ�� ��ġ���� �ʽ��ϴ�.");
		}else {
			System.out.println("���� ������ �������̽� ������ ������ �����ϴ�.");
			for(Integer rNo : revInfo.get(tmp)) {
				System.out.println(roomMap.get(rNo));
			}
		}
		
		
	}

	private static void init(Map<Integer, Room> map, String filename) {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filename));
			
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				String[] strArr = str.split(", ");
				map.put(Integer.valueOf(strArr[0]), new Room(Integer.valueOf(strArr[0]), strArr[1], Integer.valueOf(strArr[2]), strArr[3]));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
