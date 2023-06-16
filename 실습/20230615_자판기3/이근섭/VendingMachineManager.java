/*
 *  음료 자판기 Ver 1.0
 */

package kr.co.dong.vendingMachine;

public class VendingMachineManager {
	public static void main(String[] args) {
		
		VendingMachineControl vmc = new VendingMachineControl();
		String sel = "";
		
		vmc.init();
		
		while(!sel.equals("5")) {
			sel = vmc.menuView();
			
			vmc.vendingMachinePlay(sel);
		}
	}
}
