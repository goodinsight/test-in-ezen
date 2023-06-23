package kr.co.dong;

public class Test43 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		
		int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == (i+1) % 5){
                cnt1++;
            }else if((i+1) % 5 == 0 && answers[i] == 5){
                cnt1++;
            }
            if(i % 2 == 0 && answers[i] == 2){
                cnt2++;
            }else if((i+1) % 8 == 2 && answers[i] == 1){
                cnt2++;
            }else if((i+1) % 8 == 4 && answers[i] == 3){
                cnt2++;
            }else if((i+1) % 8 == 6 && answers[i] == 4){
                cnt2++;
            }else if((i+1) % 8 == 8 && answers[i] == 5){
                cnt2++;
            }
            if((i+1) % 10 == 1 && answers[i] == 3 || (i+1) % 10 == 2 && answers[i] == 3){
                cnt3++;
            }else if((i+1) % 10 == 3 && answers[i] == 1 || (i+1) % 10 == 4 && answers[i] == 1){
                cnt3++;
            }else if((i+1) % 10 == 5 && answers[i] == 2 || (i+1) % 10 == 6 && answers[i] == 2){
                cnt3++;
            }else if((i+1) % 10 == 7 && answers[i] == 4 || (i+1) % 10 == 8 && answers[i] == 4){
                cnt3++;
            }else if((i+1) % 10 == 9 && answers[i] == 5 || (i+1) % 10 == 0 && answers[i] == 5){
                cnt3++;
            }
        }
        
        System.out.println("cnt1:" +cnt1 + ", cnt2:"+cnt2 + ", cnt3:"+cnt3);
        
        if(cnt1 == cnt2 && cnt2 == cnt3){
            int[] answer = {1, 2, 3};
//            return answer;
        }else if(cnt1 == cnt2){
            int[] answer = {1, 2};
//            return answer;
        }else if(cnt2 == cnt3){
            int[] answer = {2, 3};
//            return answer;
        }else if(cnt1 == cnt3){
            int[] answer = {1, 3};
//            return answer;
        }
        else{
            if(Math.max(cnt1, Math.max(cnt2,cnt3)) == cnt1){
                int[] answer = {1};
//                return answer;
            }else if(Math.max(cnt1, Math.max(cnt2,cnt3)) == cnt2){
                int[] answer = {2};
//                return answer;
            }else{
                int[] answer = {3};
//                return answer;
            }
        }
	}
}
