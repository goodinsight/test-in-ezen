package room;

import java.util.ArrayList;
import java.util.List;

public class testt {
	public static void main(String[] args) {
		List<Room> list = new ArrayList<Room>();


		Room r1 = new Room(101, "�ҳ���", 20000, "1��", false);
		Room r2 = new Room(102, "������", 20000, "2��", false);
		Room r3 = new Room(103, "���鳪��", 20000, "3��", false);
		Room r4 = new Room(104, "������", 20000, "4��", false);
		Room r5 = new Room(105, "���೪��", 20000, "5��", false);

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		list.add(r5);
		
	}
}
