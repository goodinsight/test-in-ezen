package kr.co.dong.vendingMachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileControl implements FileInOutable {
	String FileName = "vendingMachineProduct.txt";
	
	@Override
	public List<Product> init() {
		// File���� ��ǰ ������ �ҷ��´�.
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
				p = new Product(Integer.parseInt(tmp[0].trim()), tmp[1].trim(), tmp[2].trim(), Integer.parseInt(tmp[3].trim()), tmp[4].trim(), Integer.parseInt(tmp[5].trim()));
				Product.serialNumber++;
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
		// ���� �о�ͼ� ���� �����ֱ�
		BufferedReader br = null;
		Product p = null;

		try {
			br = new BufferedReader(new FileReader(FileName));
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				p = new Product(Integer.parseInt(tmp[0].trim()), tmp[1].trim(), tmp[2].trim(), Integer.parseInt(tmp[3].trim()), tmp[4].trim(), Integer.parseInt(tmp[5].trim()));
				System.out.println(p.toString());
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


	public void updateFile(List<Product> list) {
		// ���Ͽ� �ִ� ���� �����ϱ� => ������ list�� file�� �����
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(FileName));
			for (Product str : list) {
				bw.write(String.valueOf(str.getSerialNo()) + ",");
				bw.write(str.getCategory() + ",");
				bw.write(str.getName() + ",");
				bw.write(String.valueOf(str.getPrice()) + ",");
				bw.write(str.getContents() + ",");
				bw.write(String.valueOf(str.getNumberOfProduct()));
				bw.newLine();
			}

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
	public void deleteFile(Product product) {
		// ���Ͽ� �ִ� �ش� ��ǰ�� �����ϱ�
		BufferedReader br = null;
		BufferedWriter bw = null;
		List<Product> list = null;
		int check = product.getSerialNo();

		try {
			br = new BufferedReader(new FileReader(FileName));
			list = new ArrayList<Product>();
			while (true) {
				String data = br.readLine();
				if (data == null)
					break;
				String[] tmp = data.split(",");
				Product temp = new Product(Integer.parseInt(tmp[0].trim()), tmp[1].trim(), tmp[2].trim(),
						Integer.parseInt(tmp[3].trim()), tmp[4].trim(), Integer.parseInt(tmp[5].trim()));
				if (temp.getSerialNo() != check)
					list.add(temp);
			}
			bw = new BufferedWriter(new FileWriter(FileName));
			for (Product str : list) {
				bw.write(String.valueOf(str.getSerialNo()) + ",");
				bw.write(str.getCategory() + ",");
				bw.write(str.getName() + ",");
				bw.write(String.valueOf(str.getPrice()) + ",");
				bw.write(str.getContents() + ",");
				bw.write(String.valueOf(str.getNumberOfProduct()));
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeFile(Product str) {
		// ���Ͽ� ��ǰ�� �߰��Ͽ� �ֱ�
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(FileName, true));
			bw.write(String.valueOf(str.getSerialNo()) + ",");
			bw.write(str.getCategory() + ",");
			bw.write(str.getName() + ",");
			bw.write(String.valueOf(str.getPrice()) + ",");
			bw.write(str.getContents() + ",");
			bw.write(String.valueOf(str.getNumberOfProduct()));
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
	public void deleteFile(Object obj) {
		if(obj instanceof Product)
			deleteFile(obj);
	}

	@Override
	public void writeFile(Object obj) {
		if(obj instanceof Product)
			writeFile(obj);		
	}

	@Override
	public void updateFile(Object obj) {
		if(obj instanceof List)
			updateFile(obj);		
	}

}
