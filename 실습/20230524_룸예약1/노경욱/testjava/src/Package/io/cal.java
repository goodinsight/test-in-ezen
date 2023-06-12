package Package.io;

import java.util.concurrent.ExecutionException;

public class cal implements Calable{

	@Override
	public int sum(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1+n2;
	}

	@Override
	public int minus(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1-n2;
	}

	@Override
	public int mul(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1*n2;
	}

	@Override
	public double div(int n1, int n2) throws Exception{
		// TODO Auto-generated method stub
		double result = 0;
		try {
			result = (double)n1 / n2;
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return n1/n2;
	}

	@Override
	public int clear(char c) {
		// TODO Auto-generated method stub
		return 0;
	}

}