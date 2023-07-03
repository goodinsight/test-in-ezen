package kr.co;

public class Test16 {
	public static void main(String[] args) {
		int[] array = {3, 10, 28};
		int n = 20;
		int[] tmp = new int[array.length];
        for(int i = 0; i<tmp.length; i++)
            tmp[i] = Math.abs(array[i] - n);
        for(int i = 0; i<tmp.length; i++)
        	System.out.println(tmp[i]);
        int min = 100;
        int minIdx1 = 0;
        int minIdx2 = 0;
        int minIdx = 0;
        for(int i = 0; i<tmp.length; i++){
            if(min>tmp[i]){
                min = tmp[i];
                minIdx1 = i;
            }
        }
        System.out.println(min);
        System.out.println(minIdx1);
        for(int i = tmp.length-1; i>=0; i--){
            if(min>tmp[i]){
                min = tmp[i];
                minIdx2 = i;
            }
        }
        System.out.println(min);
        System.out.println(minIdx1);
        minIdx =array[minIdx1] > array[minIdx2] ? minIdx2: minIdx1;
        int answer = array[minIdx];
        System.out.println(answer);
	}
}
