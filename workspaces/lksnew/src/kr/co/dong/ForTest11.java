package kr.co.dong;

public class ForTest11 {
	public static void main(String[] args) {
		for (int i =1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				for (int k=1; k<=3; k++) {
//					System.out.println(100*i+10*j+k);
					System.out.println(""+i+j+k);
				}
			}
		}
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				System.out.printf("[%d,%d] ",i,j);
			}
			System.out.println();
		}
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				if(i == j) {
					System.out.printf("[%d,%d]",i,j);
				}else {
					System.out.printf("     ",i,j);
					
				}
			}
			System.out.println();
		}
		
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for (int i = 0; i<arr.length ; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
		for (int a : arr) {
			System.out.printf("%d ", a);
			sum += a;
		}
		System.out.println();
		System.out.printf("sum = %d",sum);
	}
}
