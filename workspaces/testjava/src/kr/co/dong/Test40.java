package kr.co.dong;
import java.util.HashMap;
import java.util.ArrayList;
public class Test40 {
	public static void main(String[] args) {
		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k =3 ;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < id_list.length ; i++){
            map.put(id_list[i], i);
        }
        int[][] result = new int[id_list.length][id_list.length];
        for(int i = 0; i<report.length; i++){
            String[] tmp = report[i].split(" ");          
            result[map.get(tmp[0])][map.get(tmp[1])] += 1;
        }
        int[] answer = new int[id_list.length];
        for(int i = 0; i<result[0].length; i++){
            int sum = 0;
            for(int j =0; j<result.length; j++){
                sum += result[j][i]; 
            }
            if(sum >= k){
                for(int j =0; j<result.length; j++){ 
                    answer[j] += result[j][i];
                }
            }
                
        }
        for(int i = 0; i<answer.length; i++)
        	System.out.print(answer[i]+ ", ");

	}
}
