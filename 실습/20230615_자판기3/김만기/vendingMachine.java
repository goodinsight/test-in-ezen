package vendingmachine;

import java.util.Scanner;

public class vendingMachine {
	public static void main(String[] args) {
		Scanner scan = null;
		
		boolean done = true;
		
		MainFunction mainFunction = new MainFunction();
		
		mainFunction.init_a();
		
		while(done) {
			String input = "";
			mainFunction.mainManu();
			scan = new Scanner(System.in);
			
			input = scan.next();
			switch(input) {
			case "1": case "2": case "3": case "4":
				mainFunction.sale(Integer.parseInt(input));
				break;
			case "5":
				mainFunction.moneyOutput();
				break;
			case "99":
				mainFunction.moneyOutput();
				System.out.println("프로그램을 종료합니다");
				done = !done;
				break;
			default:
				mainFunction.insertMoney(Integer.parseInt(input));
			}
		}
	}
}