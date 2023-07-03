package kr.co;
import java.util.ArrayList;
public class Test12 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		int a = 0;
		ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<arr.length; i++){
            list.add(arr[i]);
        }
        if(list.size()<=2){
            
        }else if(list.size()<=4){
            for(int i =0; i<4-arr.length;i++)
                list.add(a);
        }else if(list.size()<=8){
            for(int i =0; i<8-arr.length;i++){
                list.add(a);
            }
        }else if(list.size()<=16){
            for(int i =0; i<16-arr.length;i++)
                list.add(0);
        }else if(list.size()<=32){
            for(int i =0; i<32-arr.length;i++)
                list.add(0);
        }else if(list.size()<=64){
            for(int i =0; i<64-arr.length;i++)
                list.add(0);
        }else if(list.size()<=128){
            for(int i =0; i<128-arr.length;i++)
                list.add(0);
        }else if(list.size()<=256){
            for(int i =0; i<256-arr.length;i++)
                list.add(0);
        }else if(list.size()<=512){
            for(int i =0; i<512-arr.length;i++)
                list.add(0);
        }else if(list.size()<=1024){
            for(int i =0; i<1024-arr.length;i++)
                list.add(0);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
}
}
