package kr.co;

public class Test22 {
	public static void main(String[] args) {
		int[][] lines = {{0, 5}, {3, 9}, {1, 10}};

		int[] a = new int[lines[0][1] - lines[0][0]];
		int[] b = new int[lines[1][1] - lines[1][0]];
		int[] c = new int[lines[2][1] - lines[2][0]];
		for (int i = 0; i < lines[0][1]-lines[0][0]; i++ )
			a[i] = lines[0][0]+1+i;
		for (int i = 0; i < lines[1][1]-lines[1][0]; i++ )
			b[i] = lines[1][0]+1+i;
		for (int i = 0; i < lines[2][1]-lines[2][0]; i++ )
			c[i] = lines[2][0]+1+i;
		int count = 0;
		for (int i =0; i<a.length;i++) {
			for(int j=0; j<b.length; j++) {
				if(a[i] == b[j])
					count++;
			}
		}
		System.out.println(a.length);
		System.out.println(b.length);
		System.out.println(c.length);
		for (int i =0; i<b.length;i++) {
			for(int j=0; j<c.length; j++) {
				if(b[i] == c[j])
					count++;
			}
		}
		for (int i =0; i<c.length;i++) {
			for(int j=0; j<a.length; j++) {
				if(c[i] == a[j])
					count++;
			}
		}
		System.out.println(count);
		int cnt= 0;
		for (int i =0; i<a.length;i++) {
			for(int j=0; j<b.length; j++) {
				for(int k=0; k<c.length; k++) {
					if(a[i] == b[j] && b[j] == c[k])
						cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		int answer = count - 2*cnt;
		System.out.println(answer);
			
	}
}
