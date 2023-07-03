package kr.co;

import java.util.ArrayList;

public class Test23 {
	public static void main(String[] args) {
		String[] dic = {"def", "dww", "dzx", "loveaw"};
		String[] spell = {"z", "d", "x"};
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i<dic.length; i++)
			list.add(dic[i]);
		boolean b = true;
		for(int i = 0; i<list.size(); i++) {
			b = true;
			for(int j = 0; j< spell.length; j++) {
				if(list.get(i).indexOf(spell[j]) == -1)
					b=false;
			}
			if (b) {
			list.set(i, list.get(i).substring(0,list.get(i).indexOf(spell[0]))+list.get(i).substring(list.get(i).indexOf(spell[0])+1));
			System.out.println(list.get(i));
			list.set(i, list.get(i).substring(0,list.get(i).indexOf(spell[1]))+list.get(i).substring(list.get(i).indexOf(spell[1])+1));
			System.out.println(list.get(i));
			list.set(i, list.get(i).substring(0,list.get(i).indexOf(spell[2]))+list.get(i).substring(list.get(i).indexOf(spell[2])+1));
			System.out.println(list.get(i));
			}
		}
		for(int i = 0; i<list.size(); i++)
			System.out.println(list.get(i)); 
	}
}
