package kr.co.dong.vendingMachine;

public class vendingControl {
	public static void main(String[] args) {
		vendingFunc vf = new vendingFunc();
		vendingAdmin va = new vendingAdmin();
		boolean power = false;
			while(!power) {
				switch (vf.menu()) {
				case 0 :
					power = true;
					System.out.println("Á¾·á");
					break;
					
				case 1:
					vf.buy();
					break;
					
				case 2:
					vf.inputMoney();
					break;
					
				case 3:
					vf.change();
					break;
					
				case 77:
					int sel = va.admin_Menu();
					switch (sel) {
					case 1:
						va.addMenu();
						break;
						
					case 2:
						va.setMenu();
						break;
						
					case 3:
						va.delMenu();
						break;
						
					default:
						break;
						
					}
					
				default:
					break;
				}//swtich
			}//while
	}
}
