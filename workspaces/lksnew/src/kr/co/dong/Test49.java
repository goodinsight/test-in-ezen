package kr.co.dong;

public class Test49 {
	public static void main(String[] args) {
//		ArrayList<Integer> indexOfStar = new ArrayList<Integer>();
//        ArrayList<Integer> indexOfSharp = new ArrayList<Integer>();
//        ArrayList<Integer> indexForSplit = new ArrayList<Integer>();
//            
//        for(int i = 0; i < dartResult.length(); i++){
//            if(dartResult.charAt(i) == '*'){
//                indexOfStar.add(i);
//                indexForSplit.add(i);
//            }else if(dartResult.charAt(i) == '#'){
//                indexOfSharp.add(i);
//                indexForSplit.add(i);
//            }
//        }
//        String[] resultSplited = new String[indexForSplit.size()+1];
//        for(int i = 0; i<resultSplited.length; i++){
//            if(i==0){
//                if(resultSplited.length != 1)
//                    resultSplited[i] = dartResult.substring(i,indexForSplit.get(i));
//                else
//                    resultSplited[i] = dartResult;
//            }else{
//                if(i != resultSplited.length-1)
//                    resultSplited[i] = dartResult.substring(indexForSplit.get(i-1)+1,indexForSplit.get(i));
//                else
//                    resultSplited[i] = dartResult.substring(indexForSplit.get(i)+1);
//            }
//        }
//        
//        
//        
//        
//        
//        
//        
//        
////        ==================================================
        String dartResult = "1D2S#10S";
        int answer = 0;
        String[] num1 = {"","",""};
        int[] num2 = new int[3];
        int idx = 0;
        for(int i = 0 ; i<dartResult.length(); i++){
            if(dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
                num1[idx] +=dartResult.charAt(i);
            }else if(dartResult.charAt(i) == 'S'){
                num2[idx] = Integer.parseInt(num1[idx]);
                System.out.println("num2["+idx+"] = "+num2[idx]);
                if(i != dartResult.length() -1 && dartResult.charAt(i+1) != '*' && dartResult.charAt(i+1) != '#')
                    idx++;
            }else if(dartResult.charAt(i) == 'D'){
                num2[idx] = (int)Math.pow(Integer.parseInt(num1[idx]),2);
                System.out.println("num2["+idx+"] = "+num2[idx]);
                if(i != dartResult.length() -1 && dartResult.charAt(i+1) != '*' && dartResult.charAt(i+1) != '#')
                    idx++;
            }else if(dartResult.charAt(i) == 'T'){
                num2[idx] = (int)Math.pow(Integer.parseInt(num1[idx]),3);
                System.out.println("num2["+idx+"] = "+num2[idx]);
                if(i != dartResult.length() -1 && dartResult.charAt(i+1) != '*' && dartResult.charAt(i+1) != '#')
                    idx++;
            }else{
                if(dartResult.charAt(i) == '*'){
                    if(idx == 0){
                        num2[0] *= 2;
                        System.out.println("num2[0] = "+num2[0]);
                        idx++;
                    }else if(idx == 1){
                        num2[0] *= 2;
                        System.out.println("num2[0] = "+num2[0]);
                        num2[1] *= 2;
                        System.out.println("num2[1] = "+num2[1]);
                        idx++;
                    }else{
                        num2[1] *= 2;
                        System.out.println("num2[1] = "+num2[1]);
                        num2[2] *= 2;
                        System.out.println("num2[2] = "+num2[2]);
                        idx++;
                    }
                    
                }else if(dartResult.charAt(i) == '#'){
                    num2[idx] *= -1;
                    System.out.println("num2["+idx+"] = "+num2[idx]);
                    idx++;
                }
            }
        }
        answer = num2[0] + num2[1] + num2[2];
        System.out.println(answer);
	}
}
