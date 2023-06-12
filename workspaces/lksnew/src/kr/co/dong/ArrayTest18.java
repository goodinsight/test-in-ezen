package kr.co.dong;

public class ArrayTest18 {
	public static void main(String[] args) {
		int sumOfKorean = 0;
		int sumOfEnglish = 0;
		int sumOfMath = 0;
		int[][] score = {
				{100,100,100},{20,20,20},{30,30,30},{40,40,40},{50,50,50}
				};
		System.out.println("===========================");
		System.out.println("¹øÈ£  ±¹¾î  ¿µ¾î  ¼öÇÐ  ÃÑÁ¡   Æò±Õ");
		for(int i = 0; i < score.length; i++) {
			System.out.printf("%3d ",i+1);
			int sum = 0;
			for(int j = 0; j < score[i].length; j++) {
				System.out.printf("%3d  ",score[i][j]); 
				sum += score[i][j]; 
			}
			System.out.printf("%3d ",sum);
			System.out.printf("%5.1f ",sum / (float)score[i].length);
			System.out.println();
			sumOfKorean += score[i][0];
			sumOfEnglish += score[i][1];
			sumOfMath += score[i][2];
		}
		System.out.println("===========================");
		
		System.out.printf("ÃÑÁ¡:%3d  %3d  %3d", sumOfKorean, sumOfEnglish, sumOfMath);
	}
}
