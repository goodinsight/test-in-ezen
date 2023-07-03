package kr.co;

public class Test20 {
	public static void main(String[] args) {
		int[] numlist = {10000,20,36,47,40,6,10,7000};
		int n = 30;
		int[] distanceList = new int[numlist.length];
		
		for (int i = 0; i < numlist.length; i++) {
			distanceList[i] = Math.abs(numlist[i] - n);
		}
		int[] idx = sortIndex(distanceList);
		int[] count = new int[idx.length];
		print(idx);
        for(int i = 0; i<idx.length; i++){
            count[idx[i]]++;
        }
        for(int i = 0; i<idx.length; i++){
            for(int j = 0; j<idx.length; j++){
                if(i!=j && idx[i] == idx[j]){
                    if(numlist[i] > numlist[j])
                        idx[i]--;
                    else
                        idx[j]--;
                }
            }
        }
		print(idx);
		
		int[] answer = new int[numlist.length];
		for(int i =0; i<answer.length; i++){
            answer[idx[i]] = numlist[i];
            System.out.println("answer[idx["+i+"]��:"+idx[i]+"] = numlist["+i+"]��" +numlist[i]+"�� ��");
        }
		print(answer);
		
		
		
		
	}
	static int[] sortIndex (int[] a) {
		int[] idx = new int[a.length];
		int[] tmp = a.clone();
		sort(tmp);
		for(int i =0; i<a.length; i++) {
			for(int j =0; j<a.length; j++) {
				if (a[i] == tmp[j]) {
					idx[i] = j;
				}
			}
		}
		return idx;
	}
	
	static void sort (int[] a) {
		for (int i = 0; i < a.length; i++) {
			for(int j =0; j< i; j++) {
				if(a[i]<a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		print(a);
	}
	
	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}
	static int min (int[] a) {
		int m = 10000;
		for (int i = 0; i < a.length; i++) {
			if(a[i] < m)
				m = a[i];
		}
		System.out.println("�ּҰ� : "+ m);
		return m;
	}
	static int minIndex (int[] a) {
		int m = 10000;
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] < m) {
				m = a[i];
				idx = i;
			}
		}
		System.out.println("�ּҰ��� ��ġ : "+ idx);
		return idx;
	}
}
