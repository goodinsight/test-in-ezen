package kr.co.dong;
import java.util.ArrayList;
public class Test25 {
	public static void main(String[] args) {
		int n = 12;
		ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> primeNum = new ArrayList<>();// 10000미만의 소수 구하기
        primeNum.add(2) ;
        
        for(int i = 3; i < 10000; i++){ 
            primeNum.add(i);
            for (int j = 0; j < primeNum.size()-1; j++){
                if(i % primeNum.get(j) == 0){
                    primeNum.remove(primeNum.size()-1);
                    break;
                }   
            }
        }
        printArray(primeNum);
        printArray(ans);
        for (int i = 0 ; i<primeNum.size(); i++ ){
            if(n % primeNum.get(i) == 0){
                n /= primeNum.get(i);
                System.out.println(n);
                if(!ans.contains(primeNum.get(i))) {
                    ans.add(primeNum.get(i));
                }
                i--;
                printArray(ans);
            }
            if(n == 1)
                break;
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i< ans.size(); i++){
            answer[i] = ans.get(i);
        }
        print(answer);
	}
	static void print(int[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	public static void printArray(ArrayList tmp) {
		for (int i = 0 ; i < tmp.size() ; i++) {
			System.out.print(tmp.get(i)+ ", ");
		}
		System.out.println();
	}
}
