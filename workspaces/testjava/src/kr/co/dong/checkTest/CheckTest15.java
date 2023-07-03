/*
 *  �ۼ��� : ������	 ��¥ : 2023.05.25
 *  
 * 
 */

/*
 * 
 * �ʱ� ����
 * 
 * 0 : menu �ʱ�ȭ��
 * 1 : ����
 * 		11 : ���� ���� ���� 
 * 		12 : �����ڸ� & ���� ��ȣ �Է�
 * 
 * 2 : ���� ���
 * 		21 : �����ڸ� & ���� ��ȣ �Է�
 * 		22 : ���� ���� ���� �� ������� Ȯ��.
 * 		
 * 3 : ���� ��Ȳ
 * 		31 : �� �̸� off
 * 		32 : �� �̸� on
 * 
 * 
 * 8(4) : ������ ��� 
 *		80 : ������ ��� �޴� ����
 *		81 : ���� ���� ���� (���� ���� ����)
 *			810: ���� ���� ����(���� �޴�)
 *			811: ���� �̸� ����
 *			812: ���� ���� �ο� ����
 *			813: ���� ���� ����
 *			814: �����ڸ� ����("" �˻�)
 *			815: ���� ��ȣ ����("" �˻�)
 *			�� ���� �� ����?
 *		82 : ���� ���� ���� -> ���� ������ ������ �׳� ���� ����/��Ҷ� �ٸ��� ����.
 *		83 : ���� ��Ȳ ǥ������ ����?
 *
 * 99(5) : ����
 *
 *
 *
 * ���� �����ڸ� ���� �����ȣ��??
 * 
 * 
 * 
 * 
 * 
 * <�߰�����> 
 * ���� �Ը�� ���۰� ���ÿ� �Է�
 * 
 * ȣ�� �� ��ȣ / ȣ�ڹ�� / �����ο�/ ����
 * ����� �����ڸ�/�����ȣ(��ҽ� �ʿ�) ��
 * 
 */
package kr.co.dong.checkTest;

import java.util.Arrays;
import java.util.Scanner;

public class CheckTest15 {
	public static void main(String[] args) {

		int roomMax = 0;//���� �Ը�
		
		boolean[] room = null;//���࿩��
		
		String[] roomName = null;//ȣ�� ���
		
		int[] roomCap = null;//���� ���� ���� �ο�
		
		int[] roomPrice = null;//���� ����
		
		String[] reserveName = null;//������ �̸�
		
		String[] reservePass = null;//���� ��ȣ(��й�ȣ)
		
//		String[] menuList = null;
		
		
		int menu;
		
		int view;
		
		int input;
		
		int targetIdx;
		
		boolean power;
		
		Scanner scan;
		
		int yn;
		String tmpStr;
		int tmpint;
		//�ʱ�ȭ
		
		menu = 0;
		
		view = 1;
		
		targetIdx = 0;
		
		power = false;
		
		scan = new Scanner(System.in);
		
		yn = 0;
		
		//���� �⵿�� ����
		System.out.println("�ý��� �ʱ� ������ �����ϰڽ��ϴ�.\n");

		boolean tmpflag = false;
		
		while(!tmpflag) {
			try {
				System.out.print("�ִ� ���� ���� �Է����ּ���\n>>");
				roomMax = scan.nextInt();
				if(roomMax <= 0) {
					throw new Exception();
				}
				tmpflag = true;
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�.");
				scan.nextLine();
			}
		}
		
		//�� �迭 ũ�� ������ �ʱ�ȭ
		room = new boolean[roomMax];//���࿩��
		Arrays.fill(room, false);
		
		roomName = new String[roomMax];//ȣ�� ���
		Arrays.fill(roomName, "");
		
		roomCap = new int[roomMax];//���� ���� ���� �ο�
		Arrays.fill(roomCap, 0);
		
		roomPrice = new int[roomMax];//���� ����
		Arrays.fill(roomPrice, 0);
		
		reserveName = new String[roomMax];
		Arrays.fill(reserveName, "");
		
		reservePass = new String[roomMax];
		Arrays.fill(reservePass, "");
		
//		�ʱ� ���� ����
		
		tmpflag = false;
		int rinit = 0;
		int tmpswitch = 1;
		while(!tmpflag) {
			if(rinit < roomMax) {
				try {
					System.out.println();
					switch(tmpswitch) {
					case 1://ȣ�� ��� ����
						scan.nextLine();
						System.out.print((rinit+1)+"�� ������ �̸��� �������ּ���.\n>>");
						roomName[rinit] = scan.nextLine();
						tmpswitch++;
					case 2://���� ���� ���� �ο� ����
						System.out.print((rinit+1)+"�� ������ ���� ���� �ο��� �������ּ���.\n>>");
						roomCap[rinit] = scan.nextInt();
						if(roomCap[rinit] <= 0) throw new Exception();
						tmpswitch++;
					case 3://���� ���� ����
						System.out.print((rinit+1)+"�� ������ ������ �������ּ���.\n>>");
						roomPrice[rinit] = scan.nextInt();
						if(roomCap[rinit] <= 0) throw new Exception();
						tmpswitch++;
					case 4://Ȯ��
						System.out.println("\n----------------------------------------");
						System.out.println((rinit+1)+"�� ����");
						System.out.println("�����̸� : " + roomName[rinit]);
						System.out.println("�����ο� : " + roomCap[rinit]);
						System.out.println("���డ�� : " + roomPrice[rinit]);
						System.out.println("----------------------------------------");
						System.out.println("\n�� �������� �����Ͻðڽ��ϱ�?(1: yes / 0: no)");
						yn = scan.nextInt();
						if(yn == 1) rinit++;
						else if(yn != 0) throw new Exception();
						
						tmpswitch = 1;
						
					}
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
			}else {
				
				tmpflag = true;
			}
		}
		
		tmpflag = false;

//		�ʱ� ���� ���� END

		while(!power) {
			switch(menu) {
			case 0://�ʱ�ȭ��
				
				/*
				//���� �������
				// 3�� ȣ�� Ȯ�� �߰��� ����
				System.out.println("\n\n== ���� ���� ���� ======================");
				
				tmpStr = "";
				for(int i = 0; i < roomMax; i++) {
					
					String star = room[i] ? "��":"��";
					tmpStr += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmpStr += "\n";
				}
				System.out.println(tmpStr);
				
				System.out.println("====================================");
				System.out.println("�� : ���� �Ұ�, �� : ���� ����");
				*/
				//�޴� �ȳ�
				System.out.println("\n�Է� �ȳ�\n"
						+ "1\t: ����\n"
						+ "2\t: ���� ���\n"
						+ "3\t: ���� ��Ȳ ��ȸ\n"
						+ "4\t: ������ ���\n"
						+ "99\t: ����");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					
					switch(input) {
						case 1 ://����
							menu = 11;
							break;
						case 2 ://���� ���
							menu = 21;
							break;
						case 3 ://
							menu = 30 + view;
							break;
						case 4 ://������ �޴���
							menu = 80;
							break;
						case 99://����
							menu = 99;
							break;
						default :
							throw new Exception();
					}
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
				
			case 11://���ఴ�� ����

				System.out.println("\n�����Ͻð� ���� �� ��ȣ�� �Է����ּ���.(��� : 99)");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					if(input == 99) {//��� 
						menu = 0;
					}else if(room[input-1]) {//���� �Ұ�
						System.out.println("�̹� ����Ǿ��ִ� ���Դϴ�.");
					}else {//���� ����

						System.out.println("\n== ���� ���� =============================");
						System.out.println((input)+"�� ��");
						System.out.println("�����̸� : " + roomName[input-1]);
						System.out.println("�����ο� : " + roomCap[input-1]);
						System.out.println("���డ�� : " + roomPrice[input-1]);
						System.out.println("=======================================\n");
						
						System.out.println("������ ������ ���Դϴ�.");
						System.out.print("�����Ͻðڽ��ϱ�? (1: yes / 0: no)\n>>");
						yn = scan.nextInt();
						if(yn == 1) {
							targetIdx = input-1;
							menu = 12;							
						}else if(yn != 0) {
							throw new Exception();
						}
					}
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
				
			case 12://�����ڸ� & �����ȣ �Է�
				
				try {
					System.out.print("������ ���� �Է����ּ���.\n>>");
					reserveName[targetIdx] = scan.next();
					System.out.print("���� ��ȣ�� �Է����ּ���.(���� ����)\n>>");					
					reservePass[targetIdx] = scan.next();
					room[targetIdx] = true;
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("�� �� ���� ����.");
					scan.nextLine();
				}
				
				break;//�����ڸ� & �����ȣ �Է� end
				
			case 21://�������
				
				try {
//					���� ���� ���� Ȯ��
					System.out.print("���� ��� ������ �����Ͻðڽ��ϱ�? (1: yes / 0: no) \n>> ");
					yn = scan.nextInt();
					if(yn == 0) {
						menu = 0;
						break;
					}else if(yn != 1) {
						throw new Exception();
					}
					
//					�䱸���� �Է�
					System.out.print("������ ���� �Է����ּ���.\n>>");
					String tmp1 = scan.next();
					System.out.print("���� ��ȣ�� �Է����ּ���.(���� ����)\n>>");					
					String tmp2 = scan.next();
					
//					��ġ�ϴ��� �˻�
					targetIdx = -1;
					for(int i = 0; i < roomMax; i++) {
						if(reserveName[i].equals(tmp1) && reservePass[i].equals(tmp2)) {
							targetIdx = i;
							break;
						}
					}
//					����ġ��
					if(targetIdx == -1) {
						System.out.println("�ش��ϴ� �����ڰ� ���ų� �����ȣ�� ��ġ���� �ʽ��ϴ�.");
						break;
					}
					
//					��ġ�� ��� Ȯ�� ������
					menu = 22;
					
				} catch (Exception e) {
					
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
				
			case 22://�������� ���� �� ������� Ȯ��
				
				System.out.println("== ���� ���� =============================");
				System.out.println((targetIdx+1)+"�� ��");
				System.out.println("�����̸� : " + roomName[targetIdx]);
				System.out.println("�����ο� : " + roomCap[targetIdx]);
				System.out.println("���డ�� : " + roomPrice[targetIdx]);
				System.out.println("=======================================\n");
				
				try {
					System.out.print("�ش� ������ ������ ����Ͻðڽ��ϱ�? (1: yes / 0: no)\n>>");
					yn = scan.nextInt();
					if(yn == 0) {
						menu = 21;
						break;
					}else if(yn != 1) {
						throw new Exception();
					}
					
					room[targetIdx] = false;
					reserveName[targetIdx] = "";
					reservePass[targetIdx] = "";
					System.out.println("\n������ ��ҵǾ����ϴ�.\n");
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
			
			case 31://���� ��Ȳ(�� �̸� off)
				
				System.out.println("\n\n== ���� ���� ���� ======================");
				
				tmpStr = "";
				for(int i = 0; i < roomMax; i++) {
					
					String star = room[i] ? "��":"��";
					tmpStr += String.format("%-2d: %s |", i+1, star);
					if(i%5 == 4) tmpStr += "\n";
				}
				System.out.println(tmpStr);
				
				System.out.println("====================================");
				System.out.println("�� : ���� �Ұ�, �� : ���� ����");
				
				menu = 0;
				
				break;//���� ��Ȳ(�� �̸� off) END
				
			case 32://���� ��Ȳ(�� �̸� on)
				try {
					System.out.println("\n�Է¾ȳ�"
							+ "\n1\t: ������ �Ǿ��ִ� ����"
							+ "\n2\t: ������ �Ǿ����� ���� ����"
							+ "\n3\t: ��� ����"
							+ "\n99\t: ���");
					System.out.print("���Ͻô� ��¹���� �������ּ���.\n>>");
					input = scan.nextInt();
					
					boolean notflag = false;
					boolean allflag = false;
					
					switch(input) {
						case 1:
							break;
						case 2:
							notflag = true;
							break;
						case 3:
							allflag = true;
							break;
						case 99:
							menu = 0;
							break;
						default:
							throw new Exception();
					}
					
					if(input == 99) break;
					
					System.out.println("\n\n== ���� ���� ���� ======================");
					for(int i = 0; i < roomMax; i++) {
						if((notflag^room[i])||allflag) {
							
							tmpStr = "";
							
							tmpStr += String.format("%2d�� ���� [%s] ", (i+1), roomName[i]);
							
							if(allflag) {
								tmpStr += ": " + (room[i] ? "��":"��");
							}
							
							System.out.println(tmpStr);
							
						}
					}
					System.out.println("====================================");
					if(allflag) {
						System.out.println("�� : ���� �Ұ�, �� : ���� ����");
					}
					
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				break;//���� ��Ȳ(�� �̸� on) END
				
			case 80://������ ��� �޴�����
				System.out.println("\n==������ ��� �Դϴ�.================");
				//�޴� �ȳ�
				System.out.println("�Է� �ȳ�\n"
						+ "1\t: ���� �� ���� ���� ����\n"
//						+ "2\t: ���� ���� ����\n"
						+ "3\t: ���� ��Ȳ ǥ������ ����\n"
						+ "99\t: ����");
				System.out.println("================================");
				
				try {
					System.out.print(">> ");
					input = scan.nextInt();
					
					switch(input) {
						case 1 : //���� �� ���� ���� ����
							menu = 81;
							break;
//						case 2 : //���� ���� ����
						case 3 : //ǥ�� ���� ����
							menu = 83;
							break;
						case 99://���
							menu = 0;
							break;
						default :
							throw new Exception();
					}
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;//������ ��� �޴����� END
				
			case 81://���� ���� ����

				try {
//					���� ����
					System.out.print("\n�����Ͻð� ���� �� ��ȣ�� �Է����ּ���.(��� : 99)\n>>");
					input = scan.nextInt();
					
					if(input == 99) {//��� 
						menu = 80;//������ ��� �޴���
						break;
					}else if(input <= 0 || input > roomMax) {
						throw new Exception();
					}
					
					targetIdx = input-1;
					menu = 810;
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;//���� ���� ���� END
				
			case 810://���� ���� ����
					
				try {
					boolean resflag = false;
					System.out.println("\n== ���� ���� =============================");
					System.out.println((targetIdx+1)+"�� ��");
					System.out.println("�����̸� : " + roomName[targetIdx]);
					System.out.println("�����ο� : " + roomCap[targetIdx]);
					System.out.println("���డ�� : " + roomPrice[targetIdx]);					
					if(room[targetIdx]) {
						System.out.println("---------------------------------------");
						System.out.println("�����ڸ� : " + reserveName[targetIdx]);
						System.out.println("�����ȣ : " + reservePass[targetIdx]);
						resflag = true;
					}
					System.out.println("=======================================\n");
					
					//�޴� �ȳ�
					System.out.println("�Է� �ȳ�\n"
							+ "1\t: �����̸� ����\n"
							+ "2\t: �����ο� ����\n"
							+ "3\t: ���డ�� ����");
					
					if(room[targetIdx]) {
						System.out.print("4\t: �����ڸ� ����\n");
						System.out.print("5\t: �����ȣ ����\n");
					}
					
					System.out.println("99\t: ���");
					
					System.out.print(">> ");
					input = scan.nextInt();
					
					if(!resflag &&(input == 3 || input ==4)) {
						input = -1;
					}
					
					
					switch(input) {
						case 1: case 2: case 3: case 4: case 5:
							menu = 810 + input;
							break;
						/*
						case 1 ://�����̸� ����
							menu = 811;
							break;
						case 2 ://�����ο� ����
							menu = 822;
							break;
						case 3 ://���డ�� ����
							menu = 823;
							break;
						case 4 ://�����ڸ� ����
							menu = 824;
							break;
						case 5 ://�����ȣ ����
							menu = 825;
							break;
					 	*/
						case 99 ://���
							menu = 80;
							break;
						default :
							throw new Exception();
					}
					
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;//���� ���� ���� END
				
			case 811://���� �̸� ����
				
				try {
					System.out.println("���� ���� �̸��� ["+roomName[targetIdx]+"] �Դϴ�.");
					System.out.print("�̸��� �����Ͻðڽ��ϱ�? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpStr = roomName[targetIdx];
						scan.nextLine();
						System.out.print("�����Ͻð� ���� �̸��� �Է����ּ��� \n>>");
						roomName[targetIdx] = scan.nextLine();
						
						System.out.println((targetIdx+1)+"�� ������ �̸��� ["+tmpStr+"]���� \n["+roomName[targetIdx]+"](��)�� ����Ǿ����ϴ�.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//������ �޴���
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				
				break;//���� �̸� ���� END
				
			case 812://���� �����ο� ����
				
				try {
					System.out.println("���� ���� �����ο��� ["+roomCap[targetIdx]+"] �Դϴ�.");
					System.out.print("�����ο��� �����Ͻðڽ��ϱ�? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpint = roomCap[targetIdx];
						System.out.print("�����Ͻð� ���� �����ο��� �Է����ּ��� \n>>");
						roomCap[targetIdx] = scan.nextInt();
						
						System.out.println((targetIdx+1)+"�� ������ �����ο��� ["+tmpint+"]���� \n["+roomCap[targetIdx]+"](��)�� ����Ǿ����ϴ�.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//������ �޴���
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;//���� �����ο� ���� END
				
			case 813://���� ���డ�� ����
				
				try {
					System.out.println("���� ���� ���డ���� ["+roomPrice[targetIdx]+"] �Դϴ�.");
					System.out.print("���డ���� �����Ͻðڽ��ϱ�? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpint = roomPrice[targetIdx];
						System.out.print("�����Ͻð� ���� ���డ���� �Է����ּ��� \n>>");
						roomPrice[targetIdx] = scan.nextInt();
						
						System.out.println((targetIdx+1)+"�� ������ ���డ���� ["+tmpint+"]���� \n["+roomPrice[targetIdx]+"](��)�� ����Ǿ����ϴ�.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//������ �޴���
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;//���� ���డ�� ���� END
				
			case 814://�����ڸ� ����
				
				try {
					System.out.println("���� ������ �����ڸ��� ["+reserveName[targetIdx]+"] �Դϴ�.");
					System.out.print("�����ڸ��� �����Ͻðڽ��ϱ�? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpStr = reserveName[targetIdx];
						scan.nextLine();
						System.out.print("�����Ͻð� ���� �����ڸ��� �Է����ּ��� \n>>");
						reserveName[targetIdx] = scan.nextLine();
						
						System.out.println((targetIdx+1)+"�� ������ �����ڸ��� ["+tmpStr+"]���� \n["+reserveName[targetIdx]+"](��)�� ����Ǿ����ϴ�.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//������ �޴���
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;//�����ڸ� ���� END
				
			case 815://�����ȣ ����
				
				try {
					System.out.println("���� ������ �����ȣ�� ["+reservePass[targetIdx]+"] �Դϴ�.");
					System.out.print("�����ȣ�� �����Ͻðڽ��ϱ�? (1: yes / 0: no) \n>>");
					yn = scan.nextInt();
					if(yn == 1) {//yes
						tmpStr = reservePass[targetIdx];
						scan.nextLine();
						System.out.print("�����Ͻð� ���� �����ȣ�� �Է����ּ��� \n>>");
						reservePass[targetIdx] = scan.nextLine();
						
						System.out.println((targetIdx+1)+"�� ������ �����ȣ�� ["+tmpStr+"]���� \n["+reservePass[targetIdx]+"](��)�� ����Ǿ����ϴ�.");
						
					}else if(yn != 0) {
						throw new Exception();
					}
					
					menu = 80;//������ �޴���
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;//�����ȣ ���� END
				
				
			case 83:
				try {
					System.out.println("\n�Է¾ȳ�"
							+ "\n1\t: ���� �̸� ǥ�� OFF"
							+ "\n2\t: ���� �̸� ǥ�� ON");
					
					System.out.print("���Ͻô� ǥ�� ������ �������ּ���.\n>>");
					input = scan.nextInt();
					
					switch(input) {
						case 1 :
							view = 1;
							break;
						case 2 :
							view = 2;
							break;
						default :
							throw new Exception();
					}
					
					menu = 0;
					
				} catch (Exception e) {
					System.out.println("�߸��� �Է��Դϴ�.");
					scan.nextLine();
				}
				
				break;
				
			case 99://����
				System.out.println("���α׷��� �����մϴ�.");
				power = true;
				break;
				
			}
		}
		
		scan.close();
		
	}

}
