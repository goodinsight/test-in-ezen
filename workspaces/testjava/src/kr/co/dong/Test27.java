package kr.co.dong;

public class Test27 {
	public static void main(String[] args) {
		String[] park = {"OSOOOOOXXOOOO",
						 "OOOXXXOOOOXXO",
						 "OXXOOOOXXXXOO",
						 "XXXOOOOOOOOOO",
						 "OOOOOOOXXXXOO",
						 "XXXXXOOOOOOOO"
						 };
		String[] routes = {"E 2","W 3","E 5","S 3","W 1","W 2","S 2","W 3","N 1","E 5","W 3","E 2","N 2","W 3","E 4","S 3","N 2","W 3","E 1","W 3","E 3","S 3","N 1","W 3","E 6","W 1","S 3"};
		int[] answer = new int[2];
		boolean okOrNotok = true;
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				if (park[i].charAt(j) == 'S') {
					answer[0] = i;
					answer[1] = j;
				}
			}
		}

		System.out.print(answer[0] + " , ");
		System.out.println(answer[1]);

		for (int i = 0; i < routes.length; i++) {
			String[] direction = routes[i].split(" ");
			if (direction[0].equals("E")) {
				for (int j = answer[1]; j <= Math.min(park[answer[0]].length() - 1, answer[1] + Integer.parseInt(direction[1])) ; j++) {
					if (park[answer[0]].charAt(j) == 'X'
							|| Integer.parseInt(direction[1]) > park[answer[0]].length() - answer[1] -1) {
						okOrNotok = false;
					}
				}
				if (okOrNotok == true)
					answer[1] += Integer.parseInt(direction[1]);
			} else if (direction[0].equals("W")) {
				for (int j = answer[1]; j >= Math.max(0, answer[1] - Integer.parseInt(direction[1])); j--) {
					if (park[answer[0]].charAt(j) == 'X' || Integer.parseInt(direction[1]) > answer[1]) {
						okOrNotok = false;
					}
				}
				if (okOrNotok == true)
					answer[1] -= Integer.parseInt(direction[1]);
			} else if (direction[0].equals("N")) {
				for (int j = answer[0]; j >= Math.max(0, answer[0] - Integer.parseInt(direction[1])); j--) {
					if (park[j].charAt(answer[1]) == 'X' || Integer.parseInt(direction[1]) > answer[0]) {
						okOrNotok = false;
					}
				}
				if (okOrNotok == true)
					answer[0] -= Integer.parseInt(direction[1]);
			} else if (direction[0].equals("S")) {
				for (int j = answer[0]; j <= Math.min(park.length - 1, answer[0] + Integer.parseInt(direction[1])); j++) {
					if (park[j].charAt(answer[1]) == 'X'
							|| Integer.parseInt(direction[1]) > park.length - answer[0] - 1) {
						okOrNotok = false;
					}
					if(j == park[answer[0]].length())
						break;
				}
				if (okOrNotok == true)
					answer[0] += Integer.parseInt(direction[1]);
			}
			okOrNotok = true;
			System.out.print(answer[0] + " , ");
			System.out.println(answer[1]);
		}
	}
}
