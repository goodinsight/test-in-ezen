package kr.co.dong;

public class Test14 {
	public static void main(String[] args) {
		int n = 4;
		int[] slicer = { 1, 5, 2 };
		int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[] tmp = new int[num_list.length];
		int len = 0;
		switch (n) {
		case 1:
			for (int i = 0; i <= slicer[1]; i++)
				tmp[i] = num_list[i];
			int[] answer = new int[slicer[1] + 1];
			len = answer.length;
			break;
		case 2:
			for (int i = slicer[0]; i < num_list.length; i++)
				tmp[i - slicer[0]] = num_list[i];
			answer = new int[num_list.length - slicer[0]];
			len = answer.length;
			break;
		case 3:
			for (int i = slicer[0]; i <= slicer[1]; i++)
				tmp[i - slicer[0]] = num_list[i];
			answer = new int[slicer[1] - slicer[0] + 1];
			len = answer.length;
			break;
		case 4:
			for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
				tmp[(i - slicer[0]) / slicer[2]] = num_list[i];
			}
			answer = new int[(slicer[1] - slicer[0] + slicer[2]) / slicer[2]];
			len = answer.length;
			break;
		}
		int[] ans = new int[len];
		for (int i = 0; i < ans.length; i++)
			ans[i] = tmp[i];
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

}
