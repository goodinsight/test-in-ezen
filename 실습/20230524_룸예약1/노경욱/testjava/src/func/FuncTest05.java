/*Ư�����ڿ� Ƚ���� �Է¹޾Ƽ� �� Ƚ����ŭ Ư������ �ݺ����
 * printView(10,"$");
 * -> "$$$$$$$$$$"
 */
package func;

public class FuncTest05 {
	public static void main(String[] args) {
		printView(10, "$");
		printView(3, "&");
		printView(5, "%#");
	}

	static void printView(int a, String b) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= a; i++) {
			System.out.print(b);
		}
		System.out.println();
	}
}
