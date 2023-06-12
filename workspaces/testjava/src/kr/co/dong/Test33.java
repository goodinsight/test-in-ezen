package kr.co.dong;
import java.util.ArrayList;
public class Test33 {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		ArrayList<Character> list = new ArrayList<>();
        char[] sChar = s.toCharArray();
        char[] skipChar = skip.toCharArray();

        for(int i = 0 ;i <26; i++){
            list.add((char)(i+97));
        }
        System.out.println(list.toString());
        for(int i = 0 ; i < skipChar.length; i++)
            list.remove(list.indexOf(skipChar[i]));
        System.out.println(list.toString());
	}
	static void print(int[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	static void print(char[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
}
