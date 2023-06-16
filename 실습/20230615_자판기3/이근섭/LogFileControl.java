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
	HashMap<String, Integer> map1 = null; // �ش� ���Ằ ���� �ǸŰ���
	HashMap<String, Integer> map2 = null; // �ش� ����, ����
	int sum = 0;
	
	@Override
	public List<Product> init() {
		// File���� �ȸ� ��ǰ�� ������ �ҷ��´�. -> ���� ���
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
		// ���� �о�ͼ� �ȸ� ������ �����ֱ�
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(FileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				System.out.println("�̸�: " +tmp[0] +", ����: " + tmp[1] + ", ���� ����: " + tmp[2]);
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
		// ���Ͽ� �ȸ� ��ǰ �߰��ؼ� �ֱ�
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
		// ���Ͽ� �ִ� ���� �����ϱ�
		System.out.println("��� ���� ����!!");
	}

	@Override
	public void deleteFile(Object obj) {
		// ���Ͽ� �ִ� ���� �����
		System.out.println("�α׶� ����� �ȵ�");
	}
	
	@Override
	public void writeFile(Object obj) {
		if(obj instanceof Product)
			writeFile(obj);		
	}
	
	public void showBeverageSaleNum() {
		// ���Ằ �Ǹ� ��Ȳ
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
				System.out.println("�̸�: " + key +", �����ǸŰ���: " + map1.get(key));
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
		// ���Ằ ���� ��Ȳ
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
				System.out.println("�̸�: " + key +", ���� ����: " + map1.get(key)*map2.get(key));
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
