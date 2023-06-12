package ch5;

public class ArrayTest05 {
	public static void main(String[] args) {
//		p197 ArrayEx7.java 코드를 해석해서 작성해보자
		int[] numArr = new int[10];

		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = i;
			System.out.print(numArr[i]);
		}
		
		System.out.println();

		for (int i = 0; i < 100; i++) {
			int n = (int) (Math.random() * 10); //랜덤 값 n 구함
			int tmp = numArr[0];               //tmp는 numArr에 0번째 값
			numArr[0] = numArr[n];			  //numArr[0]은 numArr[n]의 값으로
			numArr[n] = tmp;				 //numArr[n]는 numArr에 0번째 값  
		}								 	//0의 값은 tmp에 저장하고 / n번째 값을 0에 넣고 / 0의값인 tmp는 n번째 값에 넣는다
										   //0과 n번째 값을 바꾼다는 뜻
		
		for (int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
	}
}
