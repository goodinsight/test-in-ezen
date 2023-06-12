package kr.co.dong;

import java.util.ArrayList;

public class Test34 {
	public static void main(String[] args) {
		String today = 	"2020.01.01";
		String[] terms = { "Z 3", "D 5"};
		String[] privacies = { "2019.10.02 Z", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" };

		String[][] termS = new String[terms.length][2];
		String[][] privacieS = new String[privacies.length][2];

		for (int i = 0; i < terms.length; i++) {
			String[] tmp = terms[i].split(" ");
			termS[i][0] = tmp[0];
			termS[i][1] = tmp[1];
		}
		for (int i = 0; i < privacies.length; i++) {
			String[] tmp = privacies[i].split(" ");
			privacieS[i][0] = tmp[0];
			privacieS[i][1] = tmp[1];
		}
		
		String[] ans = new String[privacies.length];

		
		// for문으로 탐색해 가면서 하나씩 리턴값을 ans 배열에 집어넣고 ======> today와 비교하여 날짜 지났는지 확인하면 됨
		for (int i = 0; i < privacieS.length; i++) {
			for (int j = 0; j < termS.length; j++)
				if (privacieS[i][1].equals(termS[j][0])) {
					ans[i] = deleteLimitDate(privacieS[i][0], termS[j][1]);
					System.out.println(ans[i]);
				}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < privacies.length; i++) {
			for (int j = 0; j < ans[i].length(); j++) {
				if (today.charAt(j) - ans[i].charAt(j) > 0) {
					list.add(i+1);
					break;
				}else if(today.charAt(j) - ans[i].charAt(j) < 0){
                    break;
                }else if(j == ans[i].length()-1 && today.charAt(j) - ans[i].charAt(j) == 0) {
                	break;
                }
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
			System.out.print(answer[i]+ ", ");
		}
		
	}

	private static String deleteLimitDate(String date, String month) {
		String[] tempDate = date.split("\\.");
		int year = Integer.parseInt(tempDate[0]);
		int mon = Integer.parseInt(tempDate[1]);
		int day = Integer.parseInt(tempDate[2]);

		if (mon + Integer.parseInt(month) > 12) {
			year += (mon + Integer.parseInt(month) -1) / 12;
			mon = ((mon + Integer.parseInt(month)- 1) % 12) +1;
			day--;
		}else {
			mon = mon + Integer.parseInt(month);
			day--;
		}
		if (mon != 1 && day == 0) {
			day = 28;
			mon--;
		} else if (mon == 1 && day == 0) {
			year--;
			mon = 12;
			day = 28;
		}
				
		String str = String.valueOf(year) + "." +(mon>=1 && mon<=9 ? "0" : "") +String.valueOf(mon) + "." +(day>=1 && day<=9 ? "0" : "") +String.valueOf(day);
		return str;
	}
}
