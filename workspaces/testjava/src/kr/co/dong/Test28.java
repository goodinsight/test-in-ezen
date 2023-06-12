package kr.co.dong;
import java.util.ArrayList;
public class Test28 {
	public static void main(String[] args) {
		String[] wallpaper = {".....#"};
		int[] answer = new int[4];
		ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i< wallpaper.length; i++){
            for(int j = 0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        
        int minY = wallpaper[0].length()+100;
        int maxY = 0;
        int minX = wallpaper.length+100;
        int maxX = 0;
        
        for(int i = 0; i< list1.size(); i++){
            if(minY >list1.get(i)){
                minY = list1.get(i);
            }
            if(maxY <list1.get(i)){
                maxY = list1.get(i);
            }
            if(minX >list2.get(i)){
                minX = list2.get(i);
            }
            if(maxX <list2.get(i)){
                maxX = list2.get(i);
            }
        }
        System.out.println(minY);
        System.out.println(minX);
        System.out.println(maxY+1);
        System.out.println(maxX+1);
        
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY;
        answer[3] = maxX;
	}
}
