/*
 * 학생 정보 시스템 ver 1.0
 */
package kr.co.dong.jdbc;

public class StudentManager {
	public static void main(String[] args) {
		StudentControl sc = new StudentControl();
		String sel = "";
		sc.init();
		
		while(sel != "5") {
			sel = sc.menuView();
			
			sc.studentPlay(sel);
		}
		sc.close();
	}
}
