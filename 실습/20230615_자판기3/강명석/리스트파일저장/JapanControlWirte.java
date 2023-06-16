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
	static String file = "nowSalesReport.txt"; // 판매저장 파일
	
	public static void main(String[] args) {
	
		init(product, money); // data 초기화
		
		boolean OnOff = false;
		
		while(!OnOff) {
			
			showMenu(product); // 화면 호출 디스플레이
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
				System.out.println("시스템을 종료합니다. ");
				OnOff = true;
				break;			
			default:
				System.out.println("요청한 내용을 파악할 수 없습니다. 메뉴로 돌아갑니다. ");
				break;
			}
		}
	}

	private static boolean check(List<Money> money) {
		// 입금액 체크
		boolean OK = false;
		Money m0 = money.get(0);
		
		if(m0.getInMoney() < Integer.parseInt(product.get(0).getpPrice()) ) {
			System.out.println("제품을 구매하기 위한 잔액이 부족합니다. 돈을 먼저 넣어 주세요");
			System.out.printf("현재 잔액은 %s 입니다. \n", m0.getInMoney());
			OK = true; 
		}
		else {
			OK = false;
		}	
		return OK;
	}

	private static void controlMode() {
		// 관리자 모드
		int menu = showControlMenu();
			switch (menu) {
			case 1: // 전체 판매 제품 보기 ( 이름, 재고, 가곡)
				System.out.println("-------------------- 전체 제품을 보여드립니다. -------------------");
				for(int i=0; i<product.size(); i++) {
					System.out.printf("제품%d : [제품명: %s], [가격: %s], [재고량: %s], [판매량: %s] \n", i+1,
							                   product.get(i).getpName(), product.get(i).getpPrice(),
							                   product.get(i).getgCount(), product.get(i).getsCount() );
				}
				break;
			case 2: // 현재까지 판매 내역 보기(이룸, 개수, 가격) + 총 매출액
				// 매출 저장 파일
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
		        		System.out.printf("제품%d : [제품명: %s], [가격: %s], [판매량: %s] \n", i+1,
							                       product.get(i).getpName(), product.get(i).getpPrice(),
							                       product.get(i).getsCount() );
				        System.out.println("현재 날짜와 시간: " + dateTimeStr);		
				        
//		        		writer.write("판매" + i + " : " + product.get(i).getpName() + "  " + product.get(i).getpPrice() + "  " + product.get(i).getsCount());
//		        		writer.write("현재 날짜와 시간: " + dateTimeStr );
//		                writer.newLine(); // 다음 줄로 넘어가기 위해 개행 문자를 씁니다.	   
		        	}
//			    } catch (IOException e) {
//			            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
//			    }
		        
				int totalCount = 0;
				for(int i=0; i<product.size(); i++) {
					totalCount = totalCount + Integer.parseInt(product.get(i).getsCount()); 
				}
				int totalPrice = 0;
				for(int i=0; i<product.size(); i++) {
					totalPrice = totalPrice + ( Integer.parseInt(product.get(i).getsCount()) * Integer.parseInt(product.get(i).getpPrice()) ); 
				}					 
				System.out.printf(" [총 판매 수량 =  %d] 이고 [총 매출 = %d] 입니다. \n", totalCount, totalPrice);
				System.out.println();
				break;
			case 3: // 변경하기(이름, 개수, 가격)
				boolean OnOff3 = false;
				while(!OnOff3) {
					System.out.println("제품 변경 메뉴에 들어 오셨습니다. 원하는 변경 메뉴를 말씀해주세요 ");
					showProduct(product);
					System.out.println("1. 이름 변경 2. 재고수량 변경 3.가격 변경 4. 수정 종료  ");	
					int scanMenu = scan.nextInt();
					String tmpStr1 = null;					
					String tmpStr2 = null;	
					
					switch (scanMenu) {
					case 1:
						System.out.println("제품명 변경========================");						
						System.out.println("변경하고 싶은 제품 이름을 입력해 주세요 >");
						tmpStr1 = scan.next();
						if(serchProduct(product, tmpStr1) >= 0) {	
							int index = serchProduct(product, tmpStr1);
							System.out.println("변경할 이름을 입력해 주세요 >");
							tmpStr2 = scan.next();
							product.get(index).setpName(tmpStr2);
							System.out.println("제품명을 -" + tmpStr1 + "-에서 -" + product.get(index).getpName() + "-로 변경하였습니다.");
							System.out.println();
						}
						else {
							System.out.println("제품명이 없습니다. 다시 변경 시도 부탁드립니다.");
							System.out.println();
							break;
						}
						break;
					case 2:
						System.out.println("재고 수량 변경=====================");
						System.out.println("변경하고 싶은 제품 이름을 입력해 주세요 >");
						tmpStr1 = scan.next();
						if(serchProduct(product, tmpStr1) >= 0) {	
							int index = serchProduct(product, tmpStr1);
							System.out.println("지금 재고량은 " + product.get(index).getgCount()+ "개입니다.");
							tmpStr1 = product.get(index).getgCount();
							System.out.println("새로운 재고 수량을 입력해 주세요");
							tmpStr2 = scan.next();
							product.get(index).setgCount(tmpStr2);
							System.out.println("제품수량을 " + tmpStr1 + "개 에서 " + product.get(index).getgCount() + "개로 변경하였습니다.");
							System.out.println();
						}
						else {
							System.out.println("제품명이 없습니다. 다시 변경 시도 부탁드립니다.");
							System.out.println();
							break;
						}						
						break;
					case 3:
						System.out.println("제품 가격 변경=====================");
						System.out.println("변경하고 싶은 제품 이름을 입력해 주세요 >");
						tmpStr1 = scan.next();
						if(serchProduct(product, tmpStr1) >= 0) {	
							int index = serchProduct(product, tmpStr1);
							System.out.println("지금 가격은 " + product.get(index).getpPrice()+ "원입니다.");
							tmpStr1 = product.get(index).getpPrice();
							System.out.println("새로운 재품 가격을 입력해 주세요");
							tmpStr2 = scan.next();
							product.get(index).setpPrice(tmpStr2);
							System.out.println("제품가격을 " + tmpStr1 + "원 에서 " + product.get(index).getpPrice() + "원으로 변경하였습니다.");
							System.out.println();
						}
						else {
							System.out.println("제품명이 없습니다. 다시 변경 시도 부탁드립니다.");
							System.out.println();
							break;
						}							
						break;
					case 4:
						System.out.println("수정 메뉴를 종료합니. ");
						OnOff3 = true;
						break;
					default:
						System.out.println("요청한 내용을 확인할수 없습니다. 다시 수정부탁드립니다. ");
						break;
					}
				}

				break;
			case 4: // 잔돈점검
				Money m1 = money.get(1);
				System.out.println("========= 시스템 내부 잔돈 개수 확인 ========= ");
				System.out.printf("5만원권 개수는 %3d장 총액은 %9d원 입니다. \n", m1.getM50000(), m1.getM50000()*50000 );
				System.out.printf("1만원권 개수는 %3d장 총액은 %9d원 입니다. \n", m1.getM10000(), m1.getM10000()*10000 );
				System.out.printf("5천원권 개수는 %3d장 총액은 %9d원 입니다. \n", m1.getM5000(), m1.getM5000()*5000 );
				System.out.printf("1천원권 개수는 %3d장 총액은 %9d원 입니다. \n", m1.getM1000(), m1.getM1000()*1000 );
				System.out.printf("5배액원 개수는 %3d개 총액은 %9d원 입니다. \n", m1.getM500(), m1.getM500()*500 );
				System.out.println("========= 시스템 내부 잔돈 개수 확인 ========= ");
				System.out.println();
				break;
			case 5: // 저장
				System.out.println("판매되고 있는 모든 물품과 재고를 현재 시점으로 저장합니다. ");
				saveList(product, money);				
				break;
			case 6: // 종료
				System.out.println("관리자 모드를 종료합니다. ");
			default:
				System.out.println("잘못된 접근입니다. 메뉴를 다시 선택해 주십시요.");
				break;
			}
	}

	private static void saveList(List<Product> product, List<Money> money2) {
		// List 저장파일로 저장한다.
		
		String filePath = "saleProduct.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i=0; i<product.size(); i++) {
                writer.write("상품" + i + " : " + product.get(i).getpName() + "  " + product.get(i).getgCount() + "  " + product.get(i).getpPrice());
                writer.newLine(); // 다음 줄로 넘어가기 위해 개행 문자를 씁니다.
            }
            System.out.println("파일 저장이 완료되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
		
	}

	private static int serchProduct(List<Product> product2, String tmpStr) {
		// 제품의 index를 추출합니다.
		int idx = -1;
		
		for(int i=0; i<product.size(); i++) {
			if( tmpStr.equals(product.get(i).getpName())) {
				idx = i;
			}
		}
		return idx;
	}

	private static void returnMoney() {
		// 잔돈 환불
		Money m1 = money.get(1);
		Money m0 = money.get(0);
		
		System.out.printf("귀하의 잔액은 %s 입니다. 환불은 1번, 취소는 2번을 눌러 주세요", m0.getInMoney());
		if(scan.nextInt() ==1 && m0.getInMoney() >=100) {
			System.out.println("환불 금액 : " + m0.getInMoney());
			int tmpMoney = m0.getInMoney();
			
			int count = 0;

			count = tmpMoney/50000;
			m0.setM50000(count);
			m1.setM50000( m1.getM50000() - count); // 재고 잔고에서 환불개수 만큼 차감
			tmpMoney = tmpMoney - 50000*m0.getM50000();

			count = tmpMoney/10000;
			m0.setM10000(count);
			m1.setM10000( m1.getM10000() - count); // 재고 잔고에서 환불개수 만큼 차감
			tmpMoney = tmpMoney - 10000*m0.getM10000();
			
			count = tmpMoney/5000;
			m0.setM5000(count);
			m1.setM5000( m1.getM5000() - count); // 재고 잔고에서 환불개수 만큼 차감
			tmpMoney = tmpMoney - 5000*m0.getM5000();
			
			count = tmpMoney/1000;
			m0.setM1000(count);
			m1.setM1000( m1.getM1000() - count); // 재고 잔고에서 환불개수 만큼 차감
			tmpMoney = tmpMoney - 1000*m0.getM1000();
			
			count = tmpMoney/500;
			m0.setM500(count);
			m1.setM500( m1.getM500() - count); // 재고 잔고에서 환불개수 만큼 차감
			tmpMoney = tmpMoney - 500*m0.getM500();
			
			System.out.println("잔돈은 아래와 같습니다. 찾아가세요~~");
			if(m0.getM50000()>0)
				System.out.printf("5만원권 %d 장 \n", m0.getM50000());
			if(m0.getM10000()>0)
				System.out.printf("1만원권 %d 장 \n", m0.getM10000());
			if(m0.getM5000()>0)
				System.out.printf("오천원권 %d 장 \n", m0.getM5000());
			if(m0.getM1000()>0)
				System.out.printf("일천원권 %d 장 \n", m0.getM1000());
			if(m0.getM500()>0)
				System.out.printf("오백동전 %d 개 \n", m0.getM500());
			System.out.printf("백원동전 %d 개 입니다. \n", tmpMoney/100);
			System.out.printf("== [ 총 환불 금액 : %d ] ==", m0.getInMoney());
		}
		else {
			System.out.printf("== [ 총 환불 금액 : %d ] == \n", m0.getInMoney());			
			System.out.println("메인화면으로 돌아갑니다. ");
			System.out.println();
		}
	}

	private static void buyProduct(List<Product> product2, List<Money> money, List<Sale> sale) {
		// 제품 구입
		boolean OnOff = false;
		int select = 0;
		Money m0 = money.get(0);
		
		while(!OnOff) { 
			
			if(m0.getInMoney() < Integer.parseInt(product.get(0).getpPrice()) ) {
				System.out.println("금액이 부족하여 제품을 구입할수 없습니다. 메뉴로이동 합니다. ");
				OnOff = true;
				break;
			} else {
				System.out.println("제품을 준비하겠습니다. 원하는 메뉴를 선택해 주세요");
				showProduct(product);
				System.out.println("어떤 제품을 구입하시겠습니까?");
				System.out.printf("[1. %s]  [2. %s]  [3. %s] [4. 구매종료] \n", product.get(0).getpName(), product.get(1).getpName(), product.get(2).getpName() );
				System.out.println("제품 선택 >>>");
				select = scan.nextInt();
		
				// Sting => int  Integer.parseInt(null)      int => STring   String.valueOf();	
				
								
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		        String detailedDateTimeStr = now.format(formatter);
				
				switch (select) {
			
				case 1:
					System.out.printf("%s 를 구매하셨습니다. \n", product.get(0).getpName() );
					//돈처리, 재고 처리, 매출 만패 제품 처리(list 확장)
					m0.setInMoney( m0.getInMoney() - Integer.parseInt(product.get(0).getpPrice()) );
					System.out.printf("잔액은 %s 입니다.", m0.getInMoney() );
					product.get(0).setgCount(String.valueOf(Integer.parseInt(product.get(0).getgCount()) - 1 )); // 재고 감소
					product.get(0).setsCount(String.valueOf(Integer.parseInt(product.get(0).getsCount()) + 1 )); // 판매수량 증가
					// 판매 제품 리스트 생성 및 추가
					sale.add(new Sale(product.get(0).getpName(), 1, Integer.parseInt(product.get(0).getpPrice() ))); // 판매수량 리스트 저장
					System.out.println();					        
					
					BufferedWriter writer1 = null;
					try {
						writer1 = new BufferedWriter(new FileWriter(file, true));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer1.write("판매" + buyCounter + " : " + product.get(0).getpName() + "  " 
					                  + product.get(0).getpPrice() + "  " + product.get(0).getsCount() + " 판매시간" + detailedDateTimeStr);
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
					}  // 새로운 줄로 이동
					try {
						writer1.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					break;
				case 2:
					System.out.printf("%s 를 구매하셨습니다. \n", product.get(1).getpName() );
					//돈처리, 재고 처리, 매출 만패 제품 처리(list 확장)
					m0.setInMoney( m0.getInMoney() - Integer.parseInt(product.get(1).getpPrice()) );
					System.out.printf("잔액은 %s 입니다.", m0.getInMoney() );
					product.get(1).setgCount(String.valueOf(Integer.parseInt(product.get(1).getgCount()) - 1 )); // 재고 감소
					product.get(1).setsCount(String.valueOf(Integer.parseInt(product.get(1).getsCount()) + 1 )); // 판매수량 증가
					// 판매 제품 리스트 생성 및 추가
					sale.add(new Sale(product.get(1).getpName(), 1, Integer.parseInt(product.get(1).getpPrice() ))); // 판매수량 리스트 저장
					System.out.println();
			        
					BufferedWriter writer2 = null;
					try {
						writer2 = new BufferedWriter(new FileWriter(file, true));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer2.write("판매" + buyCounter + " : " + product.get(1).getpName() + "  " + product.get(1).getpPrice() 
								      + "  " + product.get(1).getsCount()  + " 판매시간" + detailedDateTimeStr );
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
					}  // 새로운 줄로 이동
					try {
						writer2.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					break;
				case 3:
					System.out.printf("%s 를 구매하셨습니다. \n", product.get(2).getpName() );
					//돈처리, 재고 처리, 매출 만패 제품 처리(list 확장)
					m0.setInMoney( m0.getInMoney() - Integer.parseInt(product.get(2).getpPrice()) );
					System.out.printf("잔액은 %s 입니다.", m0.getInMoney() );
					product.get(2).setgCount(String.valueOf(Integer.parseInt(product.get(2).getgCount()) - 1 )); // 재고 감소
					product.get(2).setsCount(String.valueOf(Integer.parseInt(product.get(2).getsCount()) + 1 )); // 판매수량 증가
					// 판매 제품 리스트 생성 및 추가
					sale.add(new Sale(product.get(2).getpName(), 1, Integer.parseInt(product.get(2).getpPrice() ))); // 판매수량 리스트 저장
					System.out.println();
			        
					BufferedWriter writer3 = null;
					try {
						writer3 = new BufferedWriter(new FileWriter(file, true));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						writer3.write("판매" + buyCounter + " : " + product.get(2).getpName() + "  " 
					                  + product.get(2).getpPrice() + "  " + product.get(2).getsCount() + " 판매시간" + detailedDateTimeStr);
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
					}  // 새로운 줄로 이동
					try {
						writer3.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					break;
				case 4:
					System.out.printf("제품구매를 완료하였습니다.");	
					System.out.println();
					OnOff = true;
					break;
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다. ");
					OnOff = true;
					break;
				} // end of switch
			}	
		}	
	}

	private static void insertMoney(List<Product> product, List<Money> money) {
		// 동전 투입
		boolean OnOff1 = false;
		boolean OnOff2 = false;
		Money m0 = money.get(0);
		
		while (!OnOff1) {
			System.out.printf("돈을 넣어 주세요.> \n");
			int tmpmoney = scan.nextInt();
			m0.setInMoney(m0.getInMoney() + tmpmoney );
			savejandon(money, tmpmoney);
			
			if( m0.getInMoney() < Integer.parseInt(product.get(0).getpPrice())) { // 최소 입력 금액 확인
				System.out.println("돈이 부족합니다. ");
				System.out.printf("현재 잔액은 %s 입니다. \n", m0.getInMoney());
			}
			else {
				while(!OnOff1) {
					if( m0.getInMoney() >= Integer.parseInt(product.get(2).getpPrice())) {
						System.out.println("구매할수 있는 제품이 아래와 같습니다. ");
						System.out.printf("[%s]  [%s]  [%s] \n", product.get(0).getpName(), product.get(1).getpName(), product.get(2).getpName() );
					} else if(m0.getInMoney() >= Integer.parseInt(product.get(1).getpPrice())) {
						System.out.println("구매할수 있는 제품이 아래와 같습니다. ");
						System.out.printf("[%s]  [%s] \n", product.get(0).getpName(), product.get(1).getpName() );
					} else if(m0.getInMoney() >= Integer.parseInt(product.get(0).getpPrice())) {
						System.out.println("구매할수 있는 제품이 아래와 같습니다. ");
						System.out.printf("[%s] \n", product.get(0).getpName());	
					}	
					while(!OnOff2) {
						System.out.println("제품 구입으로 가실거면 1번, 추가 입금은 2번을 눌러 주세요");
							if(scan.nextInt() == 1) {
								OnOff1 = true;
								System.out.println("제품 구입 메인화면으로 이동합니다. ");							
								System.out.println();
								showMenu(product);
								break;
							}
							else {
								System.out.printf("돈을 넣어 주세요.> \n");
								int tmpmoney1 = scan.nextInt();
								m0.setInMoney(m0.getInMoney() + tmpmoney1 );
								System.out.printf("현재 잔액은 %s 입니다. \n", m0.getInMoney());
								
								savejandon(money, tmpmoney);
							}
					} 
				} 
			}
		}
	}	

	private static void savejandon(List<Money> money, int totalMoney) {
		// 잔돈을 저장합니다. 
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
		// 제품선택 시 제품만 보여 주는 디스플레이 화면
		System.out.println("--------------------------- 제품 선택 ------------------------");
		System.out.printf("%s(잔여수량%s)      %s(잔여수량%s)         %s(잔여수량%s) \n",
						   product.get(0).getpName() , product.get(0).getgCount(),
						   product.get(1).getpName() , product.get(1).getgCount(),
						   product.get(2).getpName() , product.get(2).getgCount());
		System.out.printf("    %s원                %s원                    %s원     \n", 
						   product.get(0).getpPrice(), product.get(1).getpPrice(), product.get(2).getpPrice());
		System.out.println("------------------------------------------------------------");
	}
	
	private static void showMenu(List<Product> product) {
		// 자판기 화면 호출
		System.out.println("----------------------------- Menu -------------------------");
		System.out.println(" 1. 돈 넣기       2. 돈 돌려받기       99. 종료       90. 관리자모드");
		System.out.println("----------------------> 11. 제품 구입 <-----------------------"); /*12. 제품 설명*/
		showProduct(product);
		System.out.println("입력해 주세요 >>>");
	}	
	
	private static int showControlMenu() {
		// 관리자 메뉴 호출
		System.out.println("------------------------ admin Menu ------------------------");
		System.out.println("1. 전체 판매 제품 보기");
		System.out.println("2. 현재 판매내역 보기");
		System.out.println("3. 변경 하기(제품명, 재고, 가격)");
		System.out.println("4. 잔돈 점검 ");
		System.out.println("5. 원하는 리스트 저장하기");
		System.out.println("6. 종료");
		System.out.println("------------------------------------------------------------");
		System.out.println("원하는 관리번호를 눌러주세요>");
		return scan.nextInt();
	}
	
	private static void init(List<Product> product, List<Money> money) {
		// 기본 값을 생성 할것 ( Product, Inventory, Money, Sales => prodect와 m로 통합
		product.add(new Product("콜라캔", "500", "10", "0"));
		product.add(new Product("환타캔", "1000", "10", "0"));
		product.add(new Product("소주팩", "1500", "10", "0"));
		
		money.add(new Money(0, 0, 0, 0, 0, 0, 0, 0, 0)); //잔돈 계산 index0
		money.add(new Money(1000, 200, 100, 50, 10, 2, 0, 0, 0)); //보관 잔돈 index1
	}
	
	
}
