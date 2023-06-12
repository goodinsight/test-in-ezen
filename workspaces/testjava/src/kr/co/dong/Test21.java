package kr.co.dong;

public class Test21 {
	public static void main(String[] args) {
		String a = "18446744073709551615";
		String b = "287346502836570928366";
		if(a.length() > b.length()) {
			for(int i =0; i<b.length()-a.length(); i++)
				b = "0" + b;
		}else {
			for(int i =0; i<b.length()-a.length(); i++)
				a = "0" + a;
		}
		StringBuffer sa = new StringBuffer(a);
		StringBuffer sb = new StringBuffer(b);
		sa.reverse();
		sb.reverse();
		a = sa.toString();
		b = sb.toString();
		char[] c = a.toCharArray();
		char[] d = b.toCharArray();
		int[] e = new int[d.length];
		for (int i = 0; i< d.length; i++) {
			e[i] = d[i] - '0';
		}
		char[] f = new char[d.length+1];
		for (int i = 0; i<f.length; i++)
			f[i] = '0';
		for (int i = 0; i< d.length; i++) {
			if(f[i] - '0' + e[i] + c[i]>=48 && f[i] - '0' + e[i] + c[i]<=57) {
				f[i] = (char)(f[i] - '0' + e[i] + c[i]);
			}else {
				f[i] = (char)(f[i] - '0' + e[i] + c[i] - 10);
				f[i+1] = '1'; 
			}
		}
		String ff = new String(f);
		StringBuffer sf = new StringBuffer(ff);
		if (f[f.length -1] == '0')
			sf.deleteCharAt(f.length - 1);
		sf.reverse();
		ff = sf.toString();
		print(ff);
		System.out.println();
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        print(temp);
//        for(int i = 0; i<numlist.length; i++){
//        	for(int j = 0; j<numlist.length; j++) {
//        		if(temp2[i] == (temp[j])){
//        			listIdx[i] = j; 
//        		}	
//        	}
//        }
//        print(listIdx);
//        int[] answer = new int[numlist.length];
//        for(int i = 0; i<numlist.length; i++) {
//        	answer[i] = numlist[listIdx[i]];
//        }
//        print(answer);
//        
//        
	}
	static void print(char[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	static void print(int[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	static void print(String[] obj) {
		for (int i = 0; i < obj.length; i++)
			System.out.print(obj[i]+ ", ");
	}
	static void print(String obj) {
		for (int i = 0; i < obj.length(); i++)
			System.out.print(obj.charAt(i)+ ", ");
	}
	

}
