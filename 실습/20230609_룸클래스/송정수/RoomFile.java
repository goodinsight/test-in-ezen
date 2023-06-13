package kr.co.dong.room;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RoomFile {
	public static void main(String[] args) {
		String str = "";
		BufferedReader br = null;
		StringTokenizer tr = null;
		
		try {
			br = new BufferedReader(new FileReader("Room.txt"));
			str = br.readLine();
			tr = new StringTokenizer(str, ",");
			Room r1 = new Room();
			r1.setrNo(Integer.parseInt(tr.nextToken()));
			r1.setrName(tr.nextToken());
			r1.setRprice(Integer.parseInt(tr.nextToken()));
			r1.setrdescription(tr.nextToken());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
