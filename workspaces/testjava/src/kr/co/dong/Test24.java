package kr.co.dong;
import java.util.ArrayList;
public class Test24 {
	public static void main(String[] args) {
		String polynomial = "3x + 7 + x";
		ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String[] tmp = polynomial.split(" \\+ ");
        for (int i = 0; i< tmp.length; i++){
            list.add(tmp[i]);
        }
        print(tmp);
        printArray(list);
        for (int i = 0; i<list.size(); i++){
            char[] ch = list.get(i).toCharArray();
            int count = 0;
            for (int j = 0 ; j< ch.length; j++){
                if(!(ch[j] >='0' && ch[j] <= '9')){
                    count++;
                }
            }
            if (count != 0){    // list1에 x가 존재하는 항을 담는다
                list1.add(list.get(i));
            }else{  // list2에는 숫자만 존재하는 항을 담는다
                list2.add(list.get(i));
            }
        }
        for (int i = 0; i<list1.size(); i++){   //list1에서 x를 1x로 바꿈
        	if (list1.get(i).equals("x"))
        		list1.set(i, "1x");
        }
        for (int i = 0; i<list1.size(); i++){   //list1에서 x를 지우고 변수앞 숫자만 남김
            list1.set(i, list1.get(i).substring(0,list1.get(i).length()-1));
        }
        printArray(list1);
        printArray(list2);
        int sumList1 = 0;
        for (int i = 0; i<list1.size(); i++){
       		sumList1 += Integer.parseInt(list1.get(i));           
        }
        String ans1;
        if(sumList1 != 1)
        	ans1 = Integer.toString(sumList1) + "x";
        else
        	ans1 = "x";
        int sumList2 = 0;
        for (int i = 0; i<list2.size(); i++){
            sumList2 += Integer.parseInt(list2.get(i));           
        }
        String ans2 = Integer.toString(sumList2);;
        String answer;
        if(list2.size() == 0){
            answer = ans1;
        }else if(list1.size() == 0) {
        	answer = ans2; 
        }
        else{
            answer = ans1 +" + " + ans2;
        }
        System.out.println(answer);
	}
	public static void printArray(ArrayList tmp) {
		for (int i = 0 ; i < tmp.size() ; i++) {
			System.out.print(tmp.get(i)+ ", ");
		}
		System.out.println();
	}
	public static void printArray(int[][] tmp) {
		for (int i = 0 ; i < tmp.length ; i++) {
			for (int j = 0; j < tmp[0].length ; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void print(char[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	static void print(int[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	static void print(String[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	static void print(String obj) {
		for (int i = 0; i < obj.length(); i++)
			System.out.print(obj.charAt(i)+ ", ");
	}
}
