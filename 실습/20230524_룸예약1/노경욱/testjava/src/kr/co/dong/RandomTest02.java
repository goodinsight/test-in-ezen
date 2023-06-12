package kr.co.dong;

public class RandomTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	주사위 2개의 눈(임의의 수)의 합이 10 이하이면 당첨, 아니면 당첨이 아님
		int dice1 = (int)(Math.random() * 6) + 1;
		int dice2 = (int)(Math.random() * 6) + 1;
		int hap = dice1 + dice2;
		String result = "abc";
		
		if (hap <= 10) {
			result = "당첨";
		}else {
			result = "당첨이 아닙니다.";
		}
		
		System.out.println("주사위1:" + dice1 + " "+ "주사위2:" + dice2 + " " + "\n두개의 주사위의 합:" + hap + "\n결과:" + result);
	}

}
