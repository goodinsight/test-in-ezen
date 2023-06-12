package kr.co.dong;

public class OperatorEx3 {

	public static void main(String[] args) {
		int i = 5;
		int j = 0;
		
		j = ++i;
		System.out.println("j=++i 실행후, i="+i+", j="+j);
		
		i = 5;
		j = 0;
		
		j = i++;
		System.out.println("j=i++ 실행후, i="+i+", j="+j);
		
		i = 5;
		j = 0;
		++i;
		j = i;
		System.out.println("i="+i+", j="+j);
		
		i = 5;
		j = 0;
		j = i;
		i++;
		System.out.println("i="+i+", j="+j);
	}

}
