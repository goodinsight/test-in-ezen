package kr.co.dong;

public class Test08 {
	public static void main(String[] args) {
		
//		bubble sort algorithm exercise
		
		int[] Arr = null;
		int size = 5;
		boolean changed;
		int count = 0;
		
		Arr = new int[size];
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = (int)(Math.random()*4 + 1);
		}
		for (int i = 0; i < Arr.length; i++) {
			System.out.print(Arr[i]+", ");
		}
		
		for (int i = 0; i < Arr.length-1; i++) {
			changed = false;
			for (int j = 0; j < Arr.length-1-i; j++) {
				int tmp = Arr[j];
				if (tmp > Arr[j+1]) {
					Arr[j] = Arr[j+1];
					Arr[j+1] = tmp;
					changed = true;
				}
			}
			count++;
			if (!changed) break;
		}
		System.out.println();
		for (int i = 0; i < Arr.length; i++) {
			System.out.print(Arr[i]+", ");
		}
		System.out.println();
		System.out.println(count);
		
	}
}
