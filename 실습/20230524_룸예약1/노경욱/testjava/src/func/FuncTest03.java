/* ���: ���� �迭�� �ʱ�ȭ, �迭�� �Է�, �迭�� ����, �迭�� ���
 * initArr(�迭��), printArr(�迭��), sortArr(�迭��), inputArr(�迭��)
 */

package func;

public class FuncTest03 {
	public static void main(String[] args) {
//		10���� �迭�� ���� �Է�->����->����ϱ�
		int[] numArr = new int[10];

		initArr(numArr);
		printArr(numArr);
	}
	private static void printArr(int[] numArr) {
		// TODO Auto-generated method stub
		for(int i= 0; i < numArr.length;i++) {
			System.out.println(numArr[i]);
		}
	}
	static void initArr(int[] n) {
	
	}
}
