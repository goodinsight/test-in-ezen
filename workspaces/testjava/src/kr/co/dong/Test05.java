package kr.co.dong;
import java.util.Scanner;
public class Test05 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String result = "int";
        String l = "long ";
        for (int i = 4; i<=N ; i +=4){
            result = l + result;
        }
        System.out.print(result);
	}

}
