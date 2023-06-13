package kr.co.dong.room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RoomFunc {
	FileWriter fw = null;
	Scanner scan = new Scanner(System.in);
	int choice = 0;
	String input = null;
	public int menu(){
		System.out.println("(1)�����ϱ�, (2)�������, (3)������, (4)��������, (0)����");
		System.out.print("���� : ");
		return scan.nextInt();
	}
	// ����
	public void Res(List<Room> list) {
		showRoom(list);
		System.out.print("������ ȣ��(�� �̸�) ���� : ");
		input = scan.next();
		boolean check = false;
		Room data = null;
		for(Room index : list) {
			if(String.valueOf(index.getrNo()).equals(input) || index.getrName().equals(input)) {
				check = true;
				data = index;
				break;
			}
		}
			if(check) {
				if(data.isrState() != false) {
					System.out.println("�̹� ����Ǿ��ִ� ���Դϴ�.");
				}else {
					System.out.print("�����ڸ� �Է� : ");
					data.setCustomer(scan.next());
					System.out.print("�����ڵ� �Է� : ");
					data.setResCode(scan.next());
					data.setrState(true);
					try {
						fw = new FileWriter("log.txt", true);
						fw.write("(�� �����)" + data.getCustomer() + "���� " + data.getrNo() + "ȣ�� ���� \n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(data.getrNo() + "ȣ�� " + data.getrName() + "���� " + data.getCustomer() + "�� �̸����� ����Ǿ����ϴ�. \n");
				}
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
	}
	
	// ���� ���
	public void ResCancel(List<Room> list) {
		showRoom(list);
		System.out.print("������ ����� ȣ�� ���� : ");
		choice = scan.nextInt();
		Room data = findrNo(choice, list);
			if(data != null) {
				if(data.isrState() == false) {
					System.out.println("����Ǿ����� ���� ���Դϴ�.");
				}else {
					System.out.print("�����ڵ� �Է� :");
					String input = scan.next();
					if(!(input.equals(data.getResCode()))) {
						System.out.println("�߸��� �����ڵ��Դϴ�.");
					}else {
						try {
							fw = new FileWriter("log.txt", true);
							fw.write("(�� ���� ��ҵ�)" + data.getCustomer() + "���� " + data.getrNo() + "ȣ�� ���� ��� \n");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							try {
								fw.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						data.setCustomer(null);
						data.setResCode(null);
						data.setrState(false);
						
						System.out.println(data.getrNo() + "ȣ�� " + data.getrName() + "���� ���� ��ҵǾ����ϴ�.");

					}
				}
			}
	}
	
	// 3�� ���� �� ��ü ��, ���� �� ����
	public void Check(List<Room> list) {
		System.out.print("(1)��� �� Ȯ��, (2)�� ����Ȯ�� : ");
		choice = scan.nextInt();
		if(choice == 1) {
			AllRoomCheck(list);
		} else if(choice == 2){
			RoomCheck(list);
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}
	
	// ��ü �� ����
	public void AllRoomCheck(List<Room> list) {
		showRoom(list);
		try {
			fw = new FileWriter("log.txt", true);
			fw.write("��� �� Ȯ�ε� \n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// ���� �� ����
	public void RoomCheck(List<Room> list) {
		showRoom(list);
		System.out.print("Ȯ���� ȣ�� : ");
		choice = scan.nextInt();
		Room data = findrNo(choice, list);
		if(data != null) {
				String state = null;
				if(data.isrState() == true) {
					state = "�����";
				} else {
					state = "���డ��";
				}
				System.out.println("ȣ�� : " + data.getrNo() + " �� �̸� : " + data.getrName() + " ���� : " + data.getrPrice() + " ������� : " + state);
				try {
					fw = new FileWriter("log.txt", true);
					fw.write(data.getrNo() + "�� �� Ȯ�ε� \n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
	}
	
	// ���� Ȯ��
	public void ResCheck(List<Room> list) {
		showRoom(list);
		System.out.print("������ Ȯ���� ȣ�� : ");
		choice = scan.nextInt();
		Room data = findrNo(choice, list);
			if(data != null) {
				if(data.isrState() != true) {
					System.out.println("������ �����ϴ�.");
				}else {
					System.out.println(data.getCustomer() + "�� �̸����� ����Ǿ��ֽ��ϴ�.");
				}
				try {
					fw = new FileWriter("log.txt", true);
					fw.write(data.getrNo() + "�� �� ���� Ȯ�ε� \n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
	
	public void showRoom(List<Room> list) {
		if(list == null) {
			System.out.println("���� �����ϴ�. �����ڿ��� �����ϼ���.");
		} else {
			for(Room data : list) {
				String state = null;
				if(data.isrState() == true) {
					state = "�����";
				} else {
					state = "���డ��";
				}
				System.out.println("ȣ�� : " + data.getrNo() + " �� �̸� : " + data.getrName() + " ���� : " + data.getrPrice() + " ������� : " + state);
			}
		}
	}
	
	// ���ȣ�� ã��
	Room findRoom(String name, List<Room> list) {
		int index = -1;
		
		for(int i = 0; i < list.size(); i++) {
			list.get(i).getrName(); // ����Ʈ ���� �� �̸�
			if(name.equals(list.get(i).getrName())) {
				index = i;
				break;
			}
		}
		return list.get(index);
	}
	
	
	Room findrNo(int rNo, List<Room> list) {
		Room index = null;
		for(Room data : list) {
			if(data.getrNo() == rNo) {
				index = data;
				break;
			}
		}
		return index;
	}	
	
	public void sort(List<Room> roomList) {
		for(int i = 0; i < roomList.size()-1; i++) {
			if(roomList.get(i).getrNo() > roomList.get(i+1).getrNo()) {
				Room data = roomList.get(i+1);
				roomList.set(i+1, roomList.get(i));
				roomList.set(i, data);
				i = -1;
			}
		}
	
	}
	
}
