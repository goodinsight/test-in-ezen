package kr.co;

public class Test26 {
	public static void main(String[] args) {
		String a = "18446744073709551643655555262436236236236366723472372347324734272347234723473427234734272347234732473247324734274734723472347234723472347324732474237234732472347324723473247234723472347237237415";
		String b = "287346502836570928366";
		System.out.println(a.length());
		System.out.println(b.length());
		if(a.length() > b.length()) {
			for(int i =0; i<a.length()-b.length(); i++)
				b = "0" + b;
		}else {
			for(int i =0; i<b.length()-a.length(); i++)
				a = "0" + a;
		}
		System.out.println(a.length());
		System.out.println(b.length());
		System.out.println(a);
		System.out.println(b);
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
        System.out.println(ff);
	}
}
