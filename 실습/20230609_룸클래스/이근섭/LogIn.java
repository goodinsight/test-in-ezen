package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LogIn{
	Scanner scan = new Scanner(System.in);
	
	int showLogin() {
		// 회원가입을 위한 초기 화면 세팅
		System.out.println("================================");
		System.out.println(" 1. 처음 방문시 회원가입             ");
		System.out.println(" 2. 기존 회원시 로그인하기           ");
		System.out.println(" 3. 아이디 비번 찾기                ");
		System.out.println("=================================");
		int sel;
		try {
			sel = inputM("메뉴를 선택하세요 : ");
			return sel;
		} catch (Exception e) {
			System.out.println("메뉴를 제대로 입력하세요");
			scan.nextLine();
			return 0;
		}
	}
	
	Customer logIn(Customer customer) {
		// customer.txt에서 고객정보를 불러와서 로그인하기
		customer = new Customer();
		String fileName = "customer.txt";
		System.out.println("로그인 id를 입력하세요");
		String temp = scan.next();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String data = br.readLine();
				if (data == null) {
					System.out.println("일치하는 id가 없습니다. 회원가입을 하세요");
					break;
				}
				String[] tmp = data.split(",");
				if (tmp[0].equals(temp)) {
					customer.setId(temp);
					System.out.println("password를 입력하세요");
					String temp2 = scan.next();
					if (tmp[1].equals(temp2)) {
						System.out.println("로그인이 성공적으로 되었습니다.");
						customer.setId(tmp[0]);
						customer.setPassword(tmp[1]);
						customer.setName(tmp[2]);
						customer.setCode(tmp[3]);// 생성 객체에 해당 고객의 이름과 민증번호를 넣어줌
						break;
					} else {
						System.out.println("password가 틀려 로그인 하실수 없습니다.");
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return customer;
	}
	
	void findCustomer() {
		// 아이디 비번이 기억안날때 이름과 민증번호로 id와 pw를 반환해줌
		String fileName = "customer.txt";
		System.out.println("회원가입하셨을때 입력하신 이름을 넣으세요");
		String temp = scan.next();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String data = br.readLine();
				if (data == null) {
					System.out.println("일치하는 이름이 없습니다. 회원가입을 하세요");
					break;
				}
				String[] tmp = data.split(",");
				if (tmp[2].equals(temp)) {
					System.out.println("민증번호를 넣으세요");
					String temp2 = scan.next();
					if (tmp[3].equals(temp2)) {
						System.out.println("id와 pw를 알려드리겠슴");
						System.out.println("당신의 id는 " + tmp[0] + "입니다.");
						System.out.println("당신의 pw는 " + tmp[1] + "입니다.");
						break;
					} else {
						System.out.println("민증번호가 틀려 id와 pw를 안알랴쥼");
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Customer setCustomer(Customer customer) {
		// 회원 정보 받아서 객체 생성
		customer = new Customer();
		System.out.println("===================================");
		System.out.println("     <회원 가입>           ");
		System.out.println(" <약관> 1. 블라블라         ");
		System.out.println("       2. 잘 지키십시오     ");
		System.out.println();
		System.out.println("회원 가입을 위해서는 4가지 정보");
		System.out.println(" id, pw, 이름, code 필요합니다");
		System.out.println("===================================");
		System.out.println();
		System.out.println("1. 로그인 하실 id를 입력하세요");
		customer.setId(scan.next());
		System.out.println("2. 로그인 password를 입력하세요");
		customer.setPassword(scan.next());
		System.out.println("3. 예약시 본인확인을 위한 이름을 입력하세요");
		customer.setName(scan.next());
		System.out.println("4. 본인의 민쯩번호를 입력하세요");
		customer.setCode(scan.next());

		return customer;
	}
	
	int showSetMenu() {
		// 회원가입 초기메뉴
		System.out.println("===================================");
		System.out.println(" ~~저희 호텔을 찾아주셔서 감사합니다~~    ");
		System.out.println(" <안내> 처음 오신 고객님은 회원가입 이후 ");
		System.out.println("       본 호텔의 룸 예약 서비스를 이용하실");
		System.out.println("       수 있습니다.                  ");
		System.out.println(" 1. 회원 가입하기                    ");
		System.out.println(" 2. 그냥 나가기                      ");
		System.out.println("===================================");

		int sel;
		try {
			sel = inputM("메뉴를 선택하세요 : ");
			return sel;
		} catch (Exception e) {
			System.out.println("메뉴를 제대로 입력하세요");
			scan.nextLine();
			return 0;
		}
	}
	
	void saveCustomer(Customer customer) {
		// 회원가입한 정보를 파일에 저장하기
		String fileName = "customer.txt";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write(customer.getId() + ",");
			bw.write(customer.getPassword() + ",");
			bw.write(customer.getName() + ",");
			bw.write(customer.getCode());
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
	
	int inputM(String string) {
		System.out.println(string);
		try {
			int r = scan.nextInt();
			return r;
		} catch (Exception e) {
			System.out.println("숫자로 입력하세요");
			scan.nextLine();
			return 0;
		}
	}
}
