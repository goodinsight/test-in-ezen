package kr.co.dong;

public class Test41 {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		int[][] position = new int[12][2];
		position[0][0] = 3;
		position[0][1] = 1; // 0 위치
		position[10][0] = 3;
		position[10][1] = 0; // 왼손엄지 위치
		position[11][0] = 3;
		position[11][1] = 2; // 오른손엄지 위치

		for (int i = 1; i < 10; i++) { // 1~9까지 위치
			position[i][0] = (i - 1) / 3;
			position[i][1] = (i - 1) % 3;
			System.out.println(i +"의 위치  = { " +position[i][0]+" , " + position[i][1] + " }");
		}
		System.out.print("왼손 위치는 : * , ");
		System.out.println("오른손 위치는 : #");
		String answer = "";
		for (int i = 0; i < numbers.length; i++) {
			int leftDistance = Math.abs(position[numbers[i]][0] - position[10][0])
					+ Math.abs(position[numbers[i]][1] - position[10][1]);
			int rightDistance = Math.abs(position[numbers[i]][0] - position[11][0])
					+ Math.abs(position[numbers[i]][1] - position[11][1]);
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				position[10][0] = position[numbers[i]][0];
				position[10][1] = position[numbers[i]][1];
				System.out.println("왼손 위치는 : " + numbers[i]);
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				position[11][0] = position[numbers[i]][0];
				position[11][1] = position[numbers[i]][1];
				System.out.println("오른손 위치는 : " + numbers[i]);
			} else {
				System.out.println(numbers[i]+"로 부터 왼손의 거리는 " + leftDistance + ", 오른손의 거리는 " + rightDistance);
//				가까운 거리를 누를때
				if (leftDistance - rightDistance < 0) {
					answer += "L";
					position[10][0] = position[numbers[i]][0];
					position[10][1] = position[numbers[i]][1];
					System.out.println("왼손 위치는 : " + numbers[i]);

				} else if (leftDistance - rightDistance > 0) {
					answer += "R";
					position[11][0] = position[numbers[i]][0];
					position[11][1] = position[numbers[i]][1];
					System.out.println("오른손 위치는 : " + numbers[i]);
				} else {
					if (hand.equals("right")) {
						System.out.println(hand);
						answer += "R";
						position[11][0] = position[numbers[i]][0];
						position[11][1] = position[numbers[i]][1];
						System.out.println("오른손 위치는 : " + numbers[i]);
					} else {
						System.out.println(hand);
						answer += "L";
						position[10][0] = position[numbers[i]][0];
						position[10][1] = position[numbers[i]][1];
						System.out.println("왼손 위치는 : " + numbers[i]);
					}
				}
			}
		}
		System.out.println(answer);
	}
}
