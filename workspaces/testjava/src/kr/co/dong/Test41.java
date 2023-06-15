package kr.co.dong;

public class Test41 {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		int[][] position = new int[12][2];
		position[0][0] = 3;
		position[0][1] = 1; // 0 ��ġ
		position[10][0] = 3;
		position[10][1] = 0; // �޼վ��� ��ġ
		position[11][0] = 3;
		position[11][1] = 2; // �����վ��� ��ġ

		for (int i = 1; i < 10; i++) { // 1~9���� ��ġ
			position[i][0] = (i - 1) / 3;
			position[i][1] = (i - 1) % 3;
			System.out.println(i +"�� ��ġ  = { " +position[i][0]+" , " + position[i][1] + " }");
		}
		System.out.print("�޼� ��ġ�� : * , ");
		System.out.println("������ ��ġ�� : #");
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
				System.out.println("�޼� ��ġ�� : " + numbers[i]);
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				position[11][0] = position[numbers[i]][0];
				position[11][1] = position[numbers[i]][1];
				System.out.println("������ ��ġ�� : " + numbers[i]);
			} else {
				System.out.println(numbers[i]+"�� ���� �޼��� �Ÿ��� " + leftDistance + ", �������� �Ÿ��� " + rightDistance);
//				����� �Ÿ��� ������
				if (leftDistance - rightDistance < 0) {
					answer += "L";
					position[10][0] = position[numbers[i]][0];
					position[10][1] = position[numbers[i]][1];
					System.out.println("�޼� ��ġ�� : " + numbers[i]);

				} else if (leftDistance - rightDistance > 0) {
					answer += "R";
					position[11][0] = position[numbers[i]][0];
					position[11][1] = position[numbers[i]][1];
					System.out.println("������ ��ġ�� : " + numbers[i]);
				} else {
					if (hand.equals("right")) {
						System.out.println(hand);
						answer += "R";
						position[11][0] = position[numbers[i]][0];
						position[11][1] = position[numbers[i]][1];
						System.out.println("������ ��ġ�� : " + numbers[i]);
					} else {
						System.out.println(hand);
						answer += "L";
						position[10][0] = position[numbers[i]][0];
						position[10][1] = position[numbers[i]][1];
						System.out.println("�޼� ��ġ�� : " + numbers[i]);
					}
				}
			}
		}
		System.out.println(answer);
	}
}
