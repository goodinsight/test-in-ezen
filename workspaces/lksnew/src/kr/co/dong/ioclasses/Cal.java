package kr.co.dong.ioclasses;

public class Cal implements Calable{

	@Override
	public int sum(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1 + n2;
	}

	@Override
	public int minus(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1 - n2;
	}

	@Override
	public int multiply(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1 * n2;
	}

	@Override
	public double divide(int n1, int n2) throws Exception{
		// TODO Auto-generated method stub
		double result = 0;
//		try {
			result = (double)n1 / n2;
//		}catch(ArithmeticException e){
//			e.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		return result;
	}

	@Override
	public int clear(int c) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
