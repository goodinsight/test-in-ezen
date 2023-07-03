package kr.co;

public class Test19 {
	public static void main(String[] args) {
		int[][] score = {{80, 70}, {70, 80}, {70, 80}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
		int[] tmp = new int[score.length];
        for(int i =0; i<score.length; i++){
            tmp[i] = score[i][0] + score[i][1];
        }
        int[] tmp2 = tmp.clone();
        for(int i =0; i<tmp2.length; i++){
            for(int j = 0; j<i; j++){
                if(tmp2[i]>tmp2[j]){
                    int t = tmp2[i];
                    tmp2[i] = tmp2[j];
                    tmp2[j] = t;
                }
            }
        }
        int[] tmp3 = new int[tmp2.length];
        for(int i = 0 ; i<tmp.length; i++){
            for(int j = 0; j<tmp.length; j++){
                if(tmp2[i] == tmp[j]){
                    tmp3[j] = i+1;
                }
            } 
        }
        for(int i = 0 ; i<tmp.length; i++)
        	System.out.println(tmp3[i]);
        String tmp4 = "";
        for(int i = 0; i<tmp3.length; i++){
        	tmp4 += Integer.toString(tmp3[i]);
        }
        System.out.println(tmp4);
        int[] count = new int[tmp4.length()];
        for (int i =0; i<tmp4.length(); i++) 
        	count[i]= tmp4.length() - tmp4.replace(tmp4.charAt(i)+"","").length(); 
        for(int i = 0 ; i<tmp.length; i++)
        	System.out.println(count[i]-1);
        
	}
}
