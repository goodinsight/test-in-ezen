package kr.co.dong;

public class Test18 {
	public static void main(String[] args) {
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		int answer = 0;
        for (int i = 0; i < babbling.length; i++){
            babbling[i] = babbling[i].replaceFirst("aya","1");
            System.out.println(babbling[i]);           
            babbling[i] = babbling[i].replaceFirst("ye","1");
            System.out.println(babbling[i]);           
            babbling[i] = babbling[i].replaceFirst("woo","1");
            System.out.println(babbling[i]);           
            babbling[i] = babbling[i].replaceFirst("ma","1");
            babbling[i] = babbling[i].replaceFirst("1","");
            System.out.println("ÃÖÁ¾:" +babbling[i]);           
            if(babbling[i].length() == 0)
                answer ++;
        }
		System.out.println(answer);
		
	}
}
