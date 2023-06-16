package drink;

public class MenuCotrol {

	public static void main(String[] args) {
		
		boolean power = false;
		MenuView view = new MenuView();
		int sel;
		
		view.init();
		
		while(!power) {
			sel = view.MainMenu();
			switch(sel) {
			
			case 1: //구매
				view.buy();
				break;
			case 2: //충전
				view.charge();
				break;
			case 3: //반환
				view.change();
				break;
			case 4: // 관리자
				view.manager();
				break;
			case 99: //종료
				power= true;
			}
		}
	}

}
