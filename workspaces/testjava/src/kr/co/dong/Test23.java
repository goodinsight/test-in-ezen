package kr.co.dong;
import java.util.ArrayList;
public class Test23 {
	public static void main(String[] args) {
		String my_string = "9sf32sdg3edgve35";
		ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        char[] ch = my_string.toCharArray();
        for (int i = 0 ; i< ch.length; i++){
            if(ch[i] >='0' && ch[i] <= '9'){
                list.add(ch[i]+"");
            }else{
                list.add(" ");
            }
        }
        printArray(list);
        String tmp = "";
        for (int i = 0; i<list.size(); i++){
            if(list.get(i).equals(" ")){
            	if(!tmp.equals("")){
                    list2.add(tmp);
                    tmp = "";
                 
            	}else
            		System.out.println("2 : "+ tmp);
            		continue;
            }else{
            	System.out.println("3 : "+ tmp);
                tmp += list.get(i);
                if(i==list.size()-1) {
                	list2.add(tmp);
                }
            }
        }
        printArray(list2);
        
        
        
        int answer = 0;
        for (int i = 0; i<list2.size(); i++){
            answer += Integer.parseInt(list2.get(i));
            System.out.println(answer);
            
        }
        System.out.println(answer);
	}
	public static void printArray(ArrayList tmp) {
		for (int i = 0 ; i < tmp.size() ; i++) {
			System.out.print(tmp.get(i)+ ", ");
		}
		System.out.println();
	}
}
