package kr.co.dong;

public class FindMine {
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}};
		int[][] tmp = board.clone();
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				if(tmp[i][j] == 1) {
//					if(i != 0 && j != 0 && i != tmp.length-1 && j != tmp[0].length-1) {
						if(!(i == 0 || j == 0)) {
							if(tmp[i-1][j-1] != 1 && tmp[i-1][j-1] != 2) {
                                tmp[i-1][j-1] = 2;
                            }
                        }
						if(i != 0 ) {
							if(tmp[i-1][j] != 1 && tmp[i-1][j] != 2){
								tmp[i-1][j] = 2;
                            }
                        }
						if(!(i == 0 || j == tmp[0].length-1)) {
							if(tmp[i-1][j+1] != 1 && tmp[i-1][j+1] != 2){
								tmp[i-1][j+1] = 2;
                            }
                        }
						if(j != 0 ) {
							if(tmp[i][j-1] != 1 && tmp[i][j-1] != 2){
								tmp[i][j-1] = 2;
                            }
                        }
						if(j != tmp[0].length-1) {
							if(tmp[i][j+1] != 1 && tmp[i][j+1] != 2){
								tmp[i][j+1] = 2;
                            }
                        }
						if(!(j == 0 || i == tmp.length-1)) {
							if(tmp[i+1][j-1] != 1 && tmp[i+1][j-1] != 2){
								tmp[i+1][j-1] = 2;
                            }
                        }
						if(i != tmp.length-1) {
							if(tmp[i+1][j] != 1 && tmp[i+1][j] != 2){
								tmp[i+1][j] = 2;
                            }
                        }
						if(!(i == tmp.length-1 || j == tmp[0].length-1)) {
							if(tmp[i+1][j+1] != 1 && tmp[i+1][j+1] != 2){
								tmp[i+1][j+1] = 2;
                            }
                        }
//					}
					printArray(tmp);
					System.out.println("===============================");
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[0].length; j++) {
				if(tmp[i][j] == 0)
					answer++;
			}
		}
		System.out.println("answer : " +answer);
		System.out.println();
		printArray(tmp);
		System.out.println("END");
	}
	public static void printArray(int[][] tmp) {
		for (int i = 0 ; i < tmp.length ; i++) {
			for (int j = 0; j < tmp[0].length ; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
