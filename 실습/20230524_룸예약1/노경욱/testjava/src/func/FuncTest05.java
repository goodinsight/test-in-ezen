/*특수문자와 횟수를 입력받아서 그 횟수만큼 특수문자 반복출력
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
