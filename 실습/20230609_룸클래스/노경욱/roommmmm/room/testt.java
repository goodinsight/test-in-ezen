package room;

import java.util.ArrayList;
import java.util.List;

public class testt {
	public static void main(String[] args) {
		List<Room> list = new ArrayList<Room>();


		Room r1 = new Room(101, "소나무", 20000, "1가", false);
		Room r2 = new Room(102, "참나무", 20000, "2가", false);
		Room r3 = new Room(103, "동백나무", 20000, "3가", false);
		Room r4 = new Room(104, "벛나무", 20000, "4가", false);
		Room r5 = new Room(105, "은행나무", 20000, "5가", false);

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
		
	}
}
