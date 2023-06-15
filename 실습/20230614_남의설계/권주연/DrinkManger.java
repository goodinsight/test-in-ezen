// 음료 자판기 구현하기
// 1. 음료 종류, 가격, 재고
// 2. 구매하기, 판매하기, 금액지불하기, 잔돈주기, 재고&가격&종류 수정하기
package jpg;

public class DrinkManger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DrinkControl stu = new DrinkControl();
		String sel = "";
		stu.init();
		while (!sel.equals("6")) {
			sel = stu.manu();
			
			stu.drinkPlay(sel);
			
			
		}
		
	}

}
