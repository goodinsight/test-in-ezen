/*
 * Ư�����ڿ� Ƚ���� �Է¹޾Ƽ� �� Ƚ����ŭ Ư������ �ݺ� ���
 * printView(10, "$");
 * 
 * ==>"$$$$$$$$$$"
 * 
 * printView(3,"&")
 *  ===> "&&&"
 */
package kr.co.dong.func;

public class FuncT {

	public static void main(String[] args) {
		printView(10, "$");
		printView(5, "#");
		printView(3, "$");
		
	}
	static void printView(int count, String str) {
		for(int i =0; i<= count;i++)
			System.out.print(str);
	}
	
}
