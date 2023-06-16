package kr.co.dong.japangi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class JapanControlWirte {

	static Scanner scan = new Scanner(System.in);
	static List<Product> product = new ArrayList<Product>();
	static List<Money> money = new ArrayList<Money>();
	static List<Sale> sale = new ArrayList<Sale>();
	static int filecount = 1;
	static int buyCounter =0;
	static String file = "nowSalesReport.txt"; // �Ǹ����� ����
	
	public static void main(String[] args) {
	
		init(product, money); // data �ʱ�ȭ
		
		boolean OnOff = false;
		
		while(!OnOff) {
			
			showMenu(product); // ȭ�� ȣ�� ���÷���
			int inMenu = scan.nextInt();
			
			switch (inMenu) {
			case 1:
				insertMoney(product, money);
				break;
			case 11:
				if(check(money)) {
					break;
				}
				else {
					buyProduct(product, money, sale);			
				}
				break;	
			case 2:
				returnMoney();
				break;
			case 90:
				controlMode();
				break;
			case 99:
				System.out.println("�ý����� �����մϴ�. ");
				OnOff = true;
				break;			
			default:
				System.out.println("��û�� ������ �ľ��� �� �����ϴ�. �޴��� ���ư��ϴ�. ");
				break;
			}
		}
	}

	private static boolean check(List<Money> money) {
		// �Աݾ� üũ
		boolean OK = false;
		Money m0 = money.get(0);
		
		if(m0.getInMoney() < Integer.parseInt(product.get(0).getpPrice()) ) {
			System.out.println("��ǰ�� �����ϱ� ���� �ܾ��� �����մϴ�. ���� ���� �־� �ּ���");
			System.out.printf("���� �ܾ��� %s �Դϴ�. \n", m0.getInMoney());
			OK = true; 
		}
		else {
			OK = false;
		}	
		return OK;
	}

	private static void controlMode() {
		// ������ ���
		int menu = showControlMenu();
			switch (menu) {
			case 1: // ��ü �Ǹ� ��ǰ ���� ( �̸�, ���, ����)
				System.out.println("-------------------- ��ü ��ǰ�� �����帳�ϴ�. -------------------");
				for(int i=0; i<product.size(); i++) {
					System.out.printf("��ǰ%d : [��ǰ��: %s], [����: %s], [���: %s], [�Ǹŷ�: %s] \n", i+1,
							                   product.get(i).getpName(), product.get(i).getpPrice(),
							                   product.get(i).getgCount(), product.get(i).getsCount() );
				}
				break;
			case 2: // ������� �Ǹ� ���� ����(�̷�, ����, ����) + �� �����
				// ���� ���� ����
				filecount++;
				String file = "SalesWrite";
				file = file + String.valueOf(filecount);
				String name =".txt";
				file = file + name;	
				
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String dateTimeStr = now.format(formatter);

				
//		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		        	for(int i=0; i<product.size(); i++) {
		        		System.out.printf("��ǰ%d : [��ǰ��: %s], [����: %s], [�Ǹŷ�: %s] \n", i+1,
							                       product.get(i).getpName(), product.get(i).getpPrice(),
							                       product.get(i).getsCount() );
				        System.out.println("���� ��¥�� �ð�: " + dateTimeStr);		
				        
//		        		writer.write("�Ǹ�" + i + " : " + product.get(i).getpName() + "  " + product.get(i).getpPrice() + "  " + product.get(i).getsCount());
//		        		writer.write("���� ��¥�� �ð�: " + dateTimeStr );
//		                writer.newLine(); // ���� �ٷ� �Ѿ�� ���� ���� ���ڸ� ���ϴ�.	   
		        	}
//			    } catch (IOException e) {
//			            System.out.println("���� ���� �� ������ �߻��߽��ϴ�: " + e.getMessage());
//			    }
		        
				int totalCount = 0;
				for(int i=0; i<product.size(); i++) {
					totalCount = totalCount + Integer.parseInt(product.get(i).getsCount()); 
				}
				int totalPrice = 0;
				for(int i=0; i<product.size(); i++) {
					totalPrice = totalPrice + ( Integer.parseInt(product.get(i).getsCount()) * Integer.parseInt(product.get(i).getpPrice()) ); 
				}					 
				System.out.printf(" [�� �Ǹ� ���� =  %d] �̰� [�� ���� = %d] �Դϴ�. \n", totalCount, totalPrice);
				System.out.println();
				break;
			case 3: // �����ϱ�(�̸�, ����, ����)
				boolean OnOff3 = false;
				while(!OnOff3) {
					System.out.println("��ǰ ���� �޴��� ��� ���̽��ϴ�. ���ϴ� ���� �޴��� �������ּ��� ");
					showProduct(product);
					System.out.println("1. �̸� ���� 2. ������ ���� 3.���� ���� 4. ���� ����  ");	
					int scanMenu = scan.nextInt();
					String tmpStr1 = null;					
					String tmpStr2 = null;	
					
					switch (scanMenu) {
					case 1:
						System.out.println("��ǰ�� ����========================");						
						System.out.println("�����ϰ� ���� ��ǰ �̸��� �Է��� �ּ��� >");
						tmpStr1 = scan.next();
						if(serchProduct(product, tmpStr1) >= 0) {	
							int index = serchProduct(product, tmpStr1);
							System.out.println("������ �̸��� �Է��� �ּ��� >");
							tmpStr2 = scan.next();
							product.get(index).setpName(tmpStr2);
							System.out.println("��ǰ���� -" + tmpStr1 + "-���� -" + product.get(index).getpName() + "-�� �����Ͽ����ϴ�.");
							System.out.println();
						}
						else {
							System.out.println("��ǰ���� �����ϴ�. �ٽ� ���� �õ� ��Ź�帳�ϴ�.");
							System.out.println();
							break;
						}
						break;
					case 2:
						System.out.println("��� ���� ����=====================");
						System.out.println("�����ϰ� ���� ��ǰ �̸��� �Է��� �ּ��� >");
						tmpStr1 = scan.next();
						if(serchProduct(product, tmpStr1) >= 0) {	
							int index = serchProduct(product, tmpStr1);
							System.out.println("���� ����� " + product.get(index).getgCount()+ "���Դϴ�.");
							tmpStr1 = product.get(index).getgCount();
							System.out.println("���ο� ��� ������ �Է��� �ּ���");
							tmpStr2 = scan.next();
							product.get(index).setgCount(tmpStr2);
							System.out.println("��ǰ������ " + tmpStr1 + "�� ���� " + product.get(index).getgCount() + "���� �����Ͽ����ϴ�.");
							System.out.println();
						}
						else {
							System.out.println("��ǰ���� �����ϴ�. �ٽ� ���� �õ� ��Ź�帳�ϴ�.");
							System.out.println();
							break;
						}						
						break;
					case 3:
						System.out.println("��ǰ ���� ����=====================");
						System.out.println("�����ϰ� ���� ��ǰ �̸��� �Է��� �ּ��� >");
						tmpStr1 = scan.next();
						if(serchProduct(product, tmpStr1) >= 0) {	
							int index = serchProduct(product, tmpStr1);
							System.out.println("���� ������ " + product.get(index).getpPrice()+ "���Դϴ�.");
							tmpStr1 = product.get(index).getpPrice();
							System.out.println("���ο� ��ǰ ������ �Է��� �ּ���");
							tmpStr2 = scan.next();
							product.get(index).setpPrice(tmpStr2);
							System.out.println("��ǰ������ " + tmpStr1 + "�� ���� " + product.get(index).getpPrice() + "������ �����Ͽ����ϴ�.");
							System.out.println();
						}
						else {
							System.out.println("��ǰ���� �����ϴ�. �ٽ� ���� �õ� ��Ź�帳�ϴ�.");
							System.out.println();
							break;
						}							
						break;
					case 4:
						System.out.println("���� �޴��� �����մ�. ");
						OnOff3 = true;
						break;
					default:
						System.out.println("��û�� ������ Ȯ���Ҽ� �����ϴ�. �ٽ� ������Ź�帳�ϴ�. ");
						break;
					}
				}

				break;
			case 4: // �ܵ�����
				Money m1 = money.get(1);
				System.out.println("========= �ý��� ���� �ܵ� ���� Ȯ�� ========= ");
				System.out.printf("5������ ������ %3d�� �Ѿ��� %9d�� �Դϴ�. \n", m1.getM50000(), m1.getM50000()*50000 );
				System.out.printf("1������ ������ %3d�� �Ѿ��� %9d�� �Դϴ�. \n", m1.getM10000(), m1.getM10000()*10000 );
				System.out.printf("5õ���� ������ %3d�� �Ѿ��� %9d�� �Դϴ�. \n", m1.getM5000(), m1.getM5000()*5000 );
				System.out.printf("1õ���� ������ %3d�� �Ѿ��� %9d�� �Դϴ�. \n", m1.getM1000(), m1.getM1000()*1000 );
				System.out.printf("5��׿� ������ %3d�� �Ѿ��� %9d�� �Դϴ�. \n", m1.getM500(), m1.getM500()*500 );
				System.out.println("========= �ý��� ���� �ܵ� ���� Ȯ�� ========= ");
				System.out.println();
				break;
			case 5: // ����
				System.out.println("�Ǹŵǰ� �ִ� ��� ��ǰ�� ��� ���� �������� �����մϴ�. ");
				saveList(product, money);				
				break;
			case 6: // ����
				System.out.println("������ ��带 �����մϴ�. ");
			default:
				System.out.println("�߸��� �����Դϴ�. �޴��� �ٽ� ������ �ֽʽÿ�.");
				break;
			}
	}

	private static void saveList(List<Product> product, List<Money> money2) {
		// List �������Ϸ� �����Ѵ�.
		
		String filePath = "saleProduct.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i=0; i<product.size(); i++) {
                writer.write("��ǰ" + i + " : " + product.get(i).getpName() + "  " + product.get(i).getgCount() + "  " + product.get(i).getpPrice());
                writer.newLine(); // ���� �ٷ� �Ѿ�� ���� ���� ���ڸ� ���ϴ�.
            }
            System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
        } catch (IOException e) {
            System.out.println("���� ���� �� ������ �߻��߽��ϴ�: " + e.getMessage());
        }
		
	}

	private static int serchProduct(List<Product> product2, String tmpStr) {
		// ��ǰ�� index�� �����մϴ�.
		int idx = -1;
		
		for(int i=0; i<product.size(); i++) {
			if( tmpStr.equals(product.get(i).getpName())) {
				idx = i;
			}
		}
		return idx;
	}

	private static void returnMoney() {
		// �ܵ� ȯ��
		Money m1 = money.get(1);
		Money m0 = money.get(0);
		
		System.out.printf("������ �ܾ��� %s �Դϴ�. ȯ���� 1��, ��Ҵ� 2���� ���� �ּ���", m0.getInMoney());
		if(scan.nextInt() ==1 && m0.getInMoney() >=100) {
			System.out.println("ȯ�� �ݾ� : " + m0.getInMoney());
			int tmpMoney = m0.getInMoney();
			
			int count = 0;

			count = tmpMoney/50000;
			m0.setM50000(count);
			m1.setM50000( m1.getM50000() - count); // ��� �ܰ��� ȯ�Ұ��� ��ŭ ����
			tmpMoney = tmpMoney - 50000*m0.getM50000();

			count = tmpMoney/10000;
			m0.setM10000(count);
			m1.setM10000( m1.getM10000() - count); // ��� �ܰ��� ȯ�Ұ��� ��ŭ ����
			tmpMoney = tmpMoney - 10000*m0.getM10000();
			
			count = tmpMoney/5000;
			m0.setM5000(count);
			m1.setM5000( m1.getM5000() - count); // ��� �ܰ��� ȯ�Ұ��� ��ŭ ����
			tmpMoney = tmpMoney - 5000*m0.getM5000();
			
			count = tmpMoney/1000;
			m0.setM1000(count);
			m1.setM1000( m1.getM1000() - count); // ��� �ܰ��� ȯ�Ұ��� ��ŭ ����
			tmpMoney = tmpMoney - 1000*m0.getM1000();
			
			count = tmpMoney/500;
			m0.setM500(count);
			m1.setM500( m1.getM500() - count); // ��� �ܰ��� ȯ�Ұ��� ��ŭ ����
			tmpMoney = tmpMoney - 500*m0.getM500();
			
			System.out.println("�ܵ��� �Ʒ��� �����ϴ�. ã�ư�����~~");
			if(m0.getM50000()>0)
				System.out.printf("5������ %d �� \n", m0.getM50000());
			if(m0.getM10000()>0)
				System.out.printf("1������ %d �� \n", m0.getM10000());
			if(m0.getM5000()>0)
				System.out.printf("��õ���� %d �� \n", m0.getM5000());
			if(m0.getM1000()>0)
				System.out.printf("��õ���� %d �� \n", m0.getM1000());
			if(m0.getM500()>0)
				System.out.printf("���鵿�� %d �� \n", m0.getM500());
			System.out.printf("������� %d �� �Դϴ�. \n", tmpMoney/100);
			System.out.printf("== [ �� ȯ�� �ݾ� : %d ] ==", m0.getInMoney());
		}
		else {
			System.out.printf("== [ �� ȯ�� �ݾ� : %d ] == \n", m0.getInMoney());			
			System.out.println("����ȭ������ ���ư��ϴ�. ");
			System.out.println();
		}
	}

	private static void buyProduct(List<Product> product2, List<Money> money, List<Sale> sale) {
		// ��ǰ ����
		boolean OnOff = false;
		int select = 0;
		Money m0 = money.get(0);
		
		while(!OnOff) { 
			
			if(m0.getInMoney() < Integer.parseInt(product.get(0).getpPrice()) ) {
				System.out.println("�ݾ��� �����Ͽ� ��ǰ�� �����Ҽ� �����ϴ�. �޴����̵� �մϴ�. ");
				OnOff = true;
				break;
			} else {
				System.out.println("��ǰ�� �غ��ϰڽ��ϴ�. ���ϴ� �޴��� ������ �ּ���");
				showProduct(product);
				System.out.println("� ��ǰ�� �����Ͻðڽ��ϱ�?");
				System.out.printf("[1. %s]  [2. %s]  [3. %s] [4. ��������] \n", product.get(0).getpName(), product.get(1).getpName(), product.get(2).getpName() );
				System.out.println("��ǰ ���� >>>");
				select = scan.nextInt();
		
				// Sting => int  Integer.parseInt(null)      int => STring   String.valueOf();	
				
								
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		        String detailedDateTimeStr = now.format(formatter);
				
				switch (select) {
			
				case 1:
					System.out.printf("%s �� �����ϼ̽��ϴ�. \n", product.get(0).getpName() );
					//��ó��, ��� ó��, ���� ���� ��ǰ ó��(list Ȯ��)
					m0.setInMoney( m0.getInMoney() - Integer.parseInt(product.get(0).getpPrice()) );
					System.out.printf("�ܾ��� %s �Դϴ�.", m0.getInMoney() );
					product.get(0).setgCount(String.valueOf(Integer.parseInt(product.get(0).getgCount()) - 1 )); // ��� ����
					product.get(0).setsCount(String.valueOf(Integer.parseInt(product.get(0).getsCount()) + 1 )); // �Ǹż��� ����
					// �Ǹ� ��ǰ ����Ʈ ���� �� �߰�
					sale.add(new Sale(product.get(0).getpName(), 1, Integer.parseInt(product.get(0).getpPrice() ))); // �Ǹż��� ����Ʈ ����
					System.out.println();					        
					
					BufferedWriter writer1 = null;
					try {
						writer1 = new BufferedWriter(new FileWriter(file, true));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer1.write("�Ǹ�" + buyCounter + " : " + product.get(0).getpName() + "  " 
					                  + product.get(0).getpPrice() + "  " + product.get(0).getsCount() + " �ǸŽð�" + detailedDateTimeStr);
						buyCounter++;
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer1.newLine();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}  // ���ο� �ٷ� �̵�
					try {
						writer1.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					break;
				case 2:
					System.out.printf("%s �� �����ϼ̽��ϴ�. \n", product.get(1).getpName() );
					//��ó��, ��� ó��, ���� ���� ��ǰ ó��(list Ȯ��)
					m0.setInMoney( m0.getInMoney() - Integer.parseInt(product.get(1).getpPrice()) );
					System.out.printf("�ܾ��� %s �Դϴ�.", m0.getInMoney() );
					product.get(1).setgCount(String.valueOf(Integer.parseInt(product.get(1).getgCount()) - 1 )); // ��� ����
					product.get(1).setsCount(String.valueOf(Integer.parseInt(product.get(1).getsCount()) + 1 )); // �Ǹż��� ����
					// �Ǹ� ��ǰ ����Ʈ ���� �� �߰�
					sale.add(new Sale(product.get(1).getpName(), 1, Integer.parseInt(product.get(1).getpPrice() ))); // �Ǹż��� ����Ʈ ����
					System.out.println();
			        
					BufferedWriter writer2 = null;
					try {
						writer2 = new BufferedWriter(new FileWriter(file, true));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer2.write("�Ǹ�" + buyCounter + " : " + product.get(1).getpName() + "  " + product.get(1).getpPrice() 
								      + "  " + product.get(1).getsCount()  + " �ǸŽð�" + detailedDateTimeStr );
						buyCounter++;
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer2.newLine();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}  // ���ο� �ٷ� �̵�
					try {
						writer2.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					break;
				case 3:
					System.out.printf("%s �� �����ϼ̽��ϴ�. \n", product.get(2).getpName() );
					//��ó��, ��� ó��, ���� ���� ��ǰ ó��(list Ȯ��)
					m0.setInMoney( m0.getInMoney() - Integer.parseInt(product.get(2).getpPrice()) );
					System.out.printf("�ܾ��� %s �Դϴ�.", m0.getInMoney() );
					product.get(2).setgCount(String.valueOf(Integer.parseInt(product.get(2).getgCount()) - 1 )); // ��� ����
					product.get(2).setsCount(String.valueOf(Integer.parseInt(product.get(2).getsCount()) + 1 )); // �Ǹż��� ����
					// �Ǹ� ��ǰ ����Ʈ ���� �� �߰�
					sale.add(new Sale(product.get(2).getpName(), 1, Integer.parseInt(product.get(2).getpPrice() ))); // �Ǹż��� ����Ʈ ����
					System.out.println();
			        
					BufferedWriter writer3 = null;
					try {
						writer3 = new BufferedWriter(new FileWriter(file, true));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer3.write("�Ǹ�" + buyCounter + " : " + product.get(2).getpName() + "  " 
					                  + product.get(2).getpPrice() + "  " + product.get(2).getsCount() + " �ǸŽð�" + detailedDateTimeStr);
						buyCounter++;
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer3.newLine();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}  // ���ο� �ٷ� �̵�
					try {
						writer3.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					break;
				case 4:
					System.out.printf("��ǰ���Ÿ� �Ϸ��Ͽ����ϴ�.");	
					System.out.println();
					OnOff = true;
					break;
				default:
					System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. ");
					OnOff = true;
					break;
				} // end of switch
			}	
		}	
	}

	private static void insertMoney(List<Product> product, List<Money> money) {
		// ���� ����
		boolean OnOff1 = false;
		boolean OnOff2 = false;
		Money m0 = money.get(0);
		
		while (!OnOff1) {
			System.out.printf("���� �־� �ּ���.> \n");
			int tmpmoney = scan.nextInt();
			m0.setInMoney(m0.getInMoney() + tmpmoney );
			savejandon(money, tmpmoney);
			
			if( m0.getInMoney() < Integer.parseInt(product.get(0).getpPrice())) { // �ּ� �Է� �ݾ� Ȯ��
				System.out.println("���� �����մϴ�. ");
				System.out.printf("���� �ܾ��� %s �Դϴ�. \n", m0.getInMoney());
			}
			else {
				while(!OnOff1) {
					if( m0.getInMoney() >= Integer.parseInt(product.get(2).getpPrice())) {
						System.out.println("�����Ҽ� �ִ� ��ǰ�� �Ʒ��� �����ϴ�. ");
						System.out.printf("[%s]  [%s]  [%s] \n", product.get(0).getpName(), product.get(1).getpName(), product.get(2).getpName() );
					} else if(m0.getInMoney() >= Integer.parseInt(product.get(1).getpPrice())) {
						System.out.println("�����Ҽ� �ִ� ��ǰ�� �Ʒ��� �����ϴ�. ");
						System.out.printf("[%s]  [%s] \n", product.get(0).getpName(), product.get(1).getpName() );
					} else if(m0.getInMoney() >= Integer.parseInt(product.get(0).getpPrice())) {
						System.out.println("�����Ҽ� �ִ� ��ǰ�� �Ʒ��� �����ϴ�. ");
						System.out.printf("[%s] \n", product.get(0).getpName());	
					}	
					while(!OnOff2) {
						System.out.println("��ǰ �������� ���ǰŸ� 1��, �߰� �Ա��� 2���� ���� �ּ���");
							if(scan.nextInt() == 1) {
								OnOff1 = true;
								System.out.println("��ǰ ���� ����ȭ������ �̵��մϴ�. ");							
								System.out.println();
								showMenu(product);
								break;
							}
							else {
								System.out.printf("���� �־� �ּ���.> \n");
								int tmpmoney1 = scan.nextInt();
								m0.setInMoney(m0.getInMoney() + tmpmoney1 );
								System.out.printf("���� �ܾ��� %s �Դϴ�. \n", m0.getInMoney());
								
								savejandon(money, tmpmoney);
							}
					} 
				} 
			}
		}
	}	

	private static void savejandon(List<Money> money, int totalMoney) {
		// �ܵ��� �����մϴ�. 
		int count = 0;
		Money m0 = money.get(0);
		Money m1 = money.get(1);
				
		if(totalMoney >=50000) {
			count = totalMoney/50000;
			totalMoney = totalMoney- 50000*count;
			m0.setM50000(m0.getM50000() + count);
			m1.setM50000(m1.getM50000() + count);
		}
		if(totalMoney >=10000) {
			count = totalMoney/10000;
			totalMoney = totalMoney- 10000*count;
			m0.setM10000(m0.getM10000() + count);
			m1.setM10000(m1.getM10000() + count);
		}
		if(totalMoney >=5000) {
			count = totalMoney/5000;
			totalMoney = totalMoney- 5000*count;
			m0.setM5000(m0.getM5000() + count);
			m1.setM5000(m1.getM5000() + count);
		}
		if(totalMoney >=1000) {
			count = totalMoney/1000;
			totalMoney = totalMoney- 1000*count;
			m0.setM1000(m0.getM1000() + count);
			m1.setM1000(m1.getM1000() + count);
		}
		if(totalMoney >=500) {
			count = totalMoney/500;
			totalMoney = totalMoney- 500*count;
			m0.setM500(m0.getM500() + count);
			m1.setM500(m1.getM500() + count);
		}
			count = totalMoney/100;
			m0.setM100(m0.getM100() + count);
			m1.setM100(m1.getM100() + count);				
	}

	private static void showProduct(List<Product> product) {
		// ��ǰ���� �� ��ǰ�� ���� �ִ� ���÷��� ȭ��
		System.out.println("--------------------------- ��ǰ ���� ------------------------");
		System.out.printf("%s(�ܿ�����%s)      %s(�ܿ�����%s)         %s(�ܿ�����%s) \n",
						   product.get(0).getpName() , product.get(0).getgCount(),
						   product.get(1).getpName() , product.get(1).getgCount(),
						   product.get(2).getpName() , product.get(2).getgCount());
		System.out.printf("    %s��                %s��                    %s��     \n", 
						   product.get(0).getpPrice(), product.get(1).getpPrice(), product.get(2).getpPrice());
		System.out.println("------------------------------------------------------------");
	}
	
	private static void showMenu(List<Product> product) {
		// ���Ǳ� ȭ�� ȣ��
		System.out.println("----------------------------- Menu -------------------------");
		System.out.println(" 1. �� �ֱ�       2. �� �����ޱ�       99. ����       90. �����ڸ��");
		System.out.println("----------------------> 11. ��ǰ ���� <-----------------------"); /*12. ��ǰ ����*/
		showProduct(product);
		System.out.println("�Է��� �ּ��� >>>");
	}	
	
	private static int showControlMenu() {
		// ������ �޴� ȣ��
		System.out.println("------------------------ admin Menu ------------------------");
		System.out.println("1. ��ü �Ǹ� ��ǰ ����");
		System.out.println("2. ���� �Ǹų��� ����");
		System.out.println("3. ���� �ϱ�(��ǰ��, ���, ����)");
		System.out.println("4. �ܵ� ���� ");
		System.out.println("5. ���ϴ� ����Ʈ �����ϱ�");
		System.out.println("6. ����");
		System.out.println("------------------------------------------------------------");
		System.out.println("���ϴ� ������ȣ�� �����ּ���>");
		return scan.nextInt();
	}
	
	private static void init(List<Product> product, List<Money> money) {
		// �⺻ ���� ���� �Ұ� ( Product, Inventory, Money, Sales => prodect�� m�� ����
		product.add(new Product("�ݶ�ĵ", "500", "10", "0"));
		product.add(new Product("ȯŸĵ", "1000", "10", "0"));
		product.add(new Product("������", "1500", "10", "0"));
		
		money.add(new Money(0, 0, 0, 0, 0, 0, 0, 0, 0)); //�ܵ� ��� index0
		money.add(new Money(1000, 200, 100, 50, 10, 2, 0, 0, 0)); //���� �ܵ� index1
	}
	
	
}
