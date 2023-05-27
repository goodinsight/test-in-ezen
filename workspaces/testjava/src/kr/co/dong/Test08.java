package kr.co.dong;

public class Test08 {
	public static void main(String[] args) {
		int a = 2, b =5, c=2, d=6;
		int answer = 1000*a + 100*b + 10*c + d;
		String tmp = Integer.toString(answer);
        int length_a = tmp.replace(tmp.valueOf(a),"").length();
        int length_b = tmp.replace(tmp.valueOf(b),"").length();
        int length_c = tmp.replace(tmp.valueOf(c),"").length();
        int length_d = tmp.replace(tmp.valueOf(d),"").length();
        
        int sumOfLength = length_a + length_b + length_c + length_d;
        
        if (sumOfLength == 0){
            answer = 1111*a;
        } else if(sumOfLength == 6){
            if (length_a == 3){
                answer = (10*b + a) * (10*b + a);
            }else if(length_b == 3){
                answer = (10*a + b) * (10*a + b);
            }else if(length_c == 3){
                answer = (10*a + c) * (10*a + c);
            }else{
                answer = (10*a + d) * (10*a + d);
            }
        } else if(sumOfLength == 8){
            if (a == b){
                if (a > c){
                    answer = a*a - c*c;
                }else answer = c*c - a*a;
             }else {
                if (a > b){
                    answer = a*a - b*b;
                }else answer = b*b - a*a;
            }
        } else if(sumOfLength == 10){
            if (a == b){
                answer = c*d;
            }else if(a == c){
                answer = b*d;
            }else if(a == d){
                answer = b*c;
            }else if(b == c){
                answer = a*d;
            }else if(b == d){
                answer = a*c;
            }else{
                answer = a*b;
            }
        } else{
            if (a>=3 && b>=3 && c>=3 && d>=3){
                answer = 3;
            }else if (a==1 || b==1 || c==1 || d==1){
                answer = 1;
            }else{
                answer = 2;
            }
        }
        System.out.println(answer);
	}
}
