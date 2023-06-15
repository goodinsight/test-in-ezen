package com.javalec.ex;

public class TestEx4 {
	public static void main(String[] args) {

		int a = solution("<", "=", 20, 50);
		System.out.println(a);

	}

	private static int solution(String ineq, String eq, int n, int m) {
		int answer = 0;
		if (ineq.equals(">") && eq.equals("=")) {
			if (n >= m)
				answer = 1;
		} else if (ineq.equals("<") && eq.equals("=")) {
			if (n <= m)
				answer = 1;
		} else if (ineq.equals(">") && eq.equals("!")) {
			if (n > m)
				answer = 1;
		} else if (ineq.equals("<") && eq.equals("!")) {
			if (n < m)
				answer = 1;
		}
		return answer;
	}

}
