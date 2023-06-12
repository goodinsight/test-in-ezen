package kr.co.dong.room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RoomFunc {
	FileWriter fw = null;
	Scanner scan = new Scanner(System.in);
	int choice = 0;
	public int menu(){
		System.out.println("(1)�����ϱ�, (2)�������, (3)������, (4)��������, (0)����");
		System.out.print("���� : ");
		return scan.nextInt();
	}
	// ����
	public void Res(List<Room> list) {
		showRoom(list);
		System.out.print("������ ȣ�� ���� : ");
		choice = scan.nextInt();
		for(Room data : list) {
			if(data.getrNo() == choice) {
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
				break;
			}
		}
		
	}
	// ���� ���
	public void ResCancel(List<Room> list) {
		showRoom(list);
		System.out.print("������ ����� ȣ�� ���� : ");
		choice = scan.nextInt();
		for(Room data : list) {
			if(data.getrNo() == choice) {
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
				break;
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
		for(Room data : list) {
			if(data.getrNo() == choice) {
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
				break;
			}
		}
		
	}
	// ���� Ȯ��
	public void ResCheck(List<Room> list) {
		showRoom(list);
		System.out.print("������ Ȯ���� ȣ�� : ");
		choice = scan.nextInt();
		for(Room data : list) {
			if(data.getrNo() == choice) {
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
				break;
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
}
