package kr.co.dong;

public class Test03 {

	public static void main(String[] args) {
		int star = 0;
		int starCount = 3;
		String[] plate = new String[starCount];
		String[] result = new String[starCount];
		plate[0] = "***";
		result[0] = " ";
		for (int i = 1; i< starCount; i++) {
			plate[i] = plate [i-1] + "**"; 
		}
		for (int i = 0; i< starCount; i++) {
			System.out.println(plate[i]);
		}
		for (int i = 0; i< starCount; i++) {
			result[i] = result[i] + result[i] +plate[i] + result[i] + result[i];
		}

	}

}
