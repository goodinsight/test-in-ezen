package kr.co.dong;

import javax.swing.JOptionPane;

public class ArrayTest21 {
	public static void main(String[] args) {
		String[][] words = {{"chair", "����"}, {"computer","��ǻ��"}, {"integer", "����"}};
		for (int i =0; i<words.length; i++) {
			String ans = JOptionPane.showInputDialog(words[i][0]+"�� ����?\n ���� �Է��ϼ���.");
			if (ans.equals(words[i][1])) {
				JOptionPane.showMessageDialog(null, "�����Դϴ�.");
			}else {
				JOptionPane.showMessageDialog(null, "Ʋ�Ƚ��ϴ�.\n ������ "+words[i][1] +" �Դϴ�");
			}
		}
	}
}
