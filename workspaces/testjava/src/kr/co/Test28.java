package kr.co;

public class Test28 {
	public static void main(String[] args) {
		
		String[] park = {"OSO","OOO","OXO","OOO"};
		String[] routes = {"E 2","S 3","W 1"};
		int[] answer = new int[2];
        boolean okOrNotok = true;
        for(int i = 0; i<park.length; i++){
            for(int j = 0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        System.out.print(answer[0]+ " , ");
        System.out.println(answer[1]);
        
        for (int i = 0; i < routes.length; i++){
            String[] direction = routes[i].split(" ");
            if (direction[0].equals("E")){
                for(int j = answer[0]; j<park[answer[1]].length(); j++){
                    if(park[answer[1]].charAt(j) == 'X' || Integer.parseInt(direction[1]) > park[answer[1]].length() - answer[0] -1){
                    	okOrNotok = false;
                    }
                }        
                if (okOrNotok == true)                        
                    answer[0] += Integer.parseInt(direction[1]);
            }else if(direction[0].equals("W")){
            	for(int j = answer[0]; j>=0; j--){
                    if(park[answer[1]].charAt(j) == 'X' || Integer.parseInt(direction[1]) > answer[0] ){
                    	okOrNotok = false;
                    }
                }     
            	if (okOrNotok == true)
            		answer[0] -= Integer.parseInt(direction[1]);
            }else if(direction[0].equals("N")){
            	for(int j = answer[1]; j>=0; j--){
                    if(park[j].charAt(answer[0]) == 'X' || Integer.parseInt(direction[1]) > answer[1] ){
                    	okOrNotok = false;
                    }
                }   
            	if (okOrNotok == true)
            		answer[1] -= Integer.parseInt(direction[1]);
            }else if(direction[0].equals("S")){
            	for(int j = answer[1]; j<park.length; j++){
                    if(park[j].charAt(answer[0]) == 'X' || Integer.parseInt(direction[1]) > park.length - answer[1] -1){
                    	okOrNotok = false;
                    }
                }   
            	if (okOrNotok == true)
            		answer[1] += Integer.parseInt(direction[1]);
            }
            okOrNotok = true;
            System.out.print(answer[0]+ " , ");
            System.out.println(answer[1]);
        }
	}
}
