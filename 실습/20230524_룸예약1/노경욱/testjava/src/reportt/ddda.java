package reportt;

public class ddda {

	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5 };
		int[] answer = new int[num_list.length];
		int gett = num_list.length;

		for (int i = 0; i < num_list.length; i++) {
			answer[gett-1] = num_list[i];
			gett--;
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}