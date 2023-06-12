package ch5;

public class ArrayTest01 {
	public static void main(String[] args) {
//	public static void main(String[] args) throws Exception{
//		배열: 같은 타입의 종류를 모아놓기
//		선언 및 생성
		String[] dName = new String[4];
//		배열값 입력
		dName[0] = "콜라";
		dName[1] = "사이다";
		dName[2] = "커피";
		dName[3] = "생강차";
//		배열 값 출력
		System.out.println("dName[0] = " + dName[0]);
		System.out.println("dName[1] = " + dName[1]);
		System.out.println("dName[2] = " + dName[2]);
		System.out.println("dName[3] = " + dName[3]);
		System.out.println("==========================");
//		for문으로 출력
//		배열의 길이 -> 배열명.length
		for (int i = 0; i < dName.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("dName[%d] = %s\n", i, dName[i]);
		}

	}
}
