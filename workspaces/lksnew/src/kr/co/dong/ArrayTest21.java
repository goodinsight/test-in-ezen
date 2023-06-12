package kr.co.dong;

import javax.swing.JOptionPane;

public class ArrayTest21 {
	public static void main(String[] args) {
		String[][] words = {{"chair", "의자"}, {"computer","컴퓨터"}, {"integer", "정수"}};
		for (int i =0; i<words.length; i++) {
			String ans = JOptionPane.showInputDialog(words[i][0]+"의 뜻은?\n 답을 입력하세요.");
			if (ans.equals(words[i][1])) {
				JOptionPane.showMessageDialog(null, "정답입니다.");
			}else {
				JOptionPane.showMessageDialog(null, "틀렸습니다.\n 정답은 "+words[i][1] +" 입니다");
			}
		}
	}
}
