package kr.co.dong.vendingMachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LogFileControl implements FileInOutable{
	String FileName = "vendingMachineSale.txt";
	HashMap<String, Integer> map1 = null; // 해당 음료별 누적 판매갯수
	HashMap<String, Integer> map2 = null; // 해당 음료, 가격
	int sum = 0;
	
	@Override
	public List<Product> init() {
		// File에서 팔린 제품의 정보를 불러온다. -> 매출 계산
		List<Product> list = new ArrayList<Product>();
		BufferedReader br;
		Product p;
		try {
			br = new BufferedReader(new FileReader(FileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				p = new Product(tmp[0], Integer.parseInt(tmp[1]));
				sum = Integer.parseInt(tmp[2]);
				list.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void readFile() {
		// 파일 읽어와서 팔린 정보를 보여주기
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(FileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				System.out.println("이름: " +tmp[0] +", 가격: " + tmp[1] + ", 누적 매출: " + tmp[2]);
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

	public void writeFile(Product str) {
		// 파일에 팔린 제품 추가해서 넣기
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(FileName, true));
			bw.write(str.getName() + ",");
			bw.write(String.valueOf(str.getPrice()) + ",");
			this.sum += str.getPrice();
			bw.write(String.valueOf(this.sum));
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateFile(Object obj) {
		// 파일에 있는 정보 수정하기
		System.out.println("장부 조작 금지!!");
	}

	@Override
	public void deleteFile(Object obj) {
		// 파일에 있는 정보 지우기
		System.out.println("로그라 지우면 안됨");
	}
	
	@Override
	public void writeFile(Object obj) {
		if(obj instanceof Product)
			writeFile(obj);		
	}
	
	public void showBeverageSaleNum() {
		// 음료별 판매 현황
		BufferedReader br = null;
		map1 = new HashMap<String, Integer>();
		map2 = new HashMap<String, Integer>();
		try {
			br = new BufferedReader(new FileReader(FileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				if(!map1.containsKey(tmp[0])) {
					map1.put(tmp[0], 1);
					map2.put(tmp[0], Integer.parseInt(tmp[1]));
				}else {
					int num = map1.get(tmp[0]);
					map1.replace(tmp[0], num+1);
				}		
			}
			Iterator<String> iterator = map1.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println("이름: " + key +", 누적판매갯수: " + map1.get(key));
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
	
	public void showBeverageSaleMoney() {
		// 음료별 매출 현황
		BufferedReader br = null;
		map1 = new HashMap<String, Integer>();
		map2 = new HashMap<String, Integer>();
		try {
			br = new BufferedReader(new FileReader(FileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				if(!map1.containsKey(tmp[0])) {
					map1.put(tmp[0], 1);
					map2.put(tmp[0], Integer.parseInt(tmp[1]));
				}else {
					int num = map1.get(tmp[0]);
					map1.replace(tmp[0], num+1);
				}		
			}
			Iterator<String> iterator = map1.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println("이름: " + key +", 누적 매출: " + map1.get(key)*map2.get(key));
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
