package kr.co.dong;

public class Test26 {
	public static void main(String[] args) {
		int balls = 30;
		int share = 1;
		for (share = 1; share <= balls ; share++) {
			Double b = (double) balls;
			Double s = (double) share;
			int answer = (int) (factorial(b) / (factorial(s) * factorial(b - s))) ;
			System.out.println("share = "+ share +"ÀÏ¶§ answer ="+answer);
		}
    }
    static double factorial(double a){
    	double f = 1d;
        for (int i = 1; i<=a ; i++)
            f *= i;
        return f;
    }
}
