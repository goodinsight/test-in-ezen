package kr.co.dong;

public class Test09 {
	public static void main(String[] args) {
		String my_string = "rermgorpsam";
		String answer = my_string;
		int[] index_list = new int[] {2, 3};
		int s = index_list[0];
		int e = index_list[1];
		
		StringBuffer sb1 = new StringBuffer(answer);
        String str = sb1.substring(s, e+1);
        StringBuffer sb2 = new StringBuffer(str);
        System.out.println("sb2="+sb2);
        sb2.reverse();
        StringBuffer str2 = sb2;
        System.out.println("str2="+str2);
        String str3 = str2.toString();
        sb1.replace(s, e+1, str3);
        answer = sb1.toString();
        System.out.println(answer);
	}
}
