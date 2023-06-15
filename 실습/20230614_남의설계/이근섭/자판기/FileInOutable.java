package kr.co.dong.vendingMachine;

import java.util.List;

public interface FileInOutable {
	Object init();	//파일로 초기화
	void readFile(); 	//파일 읽어오기
	void writeFile(Object obj);	//파일 쓰기
	void updateFile(Object obj);	//파일 수정
	void deleteFile(Object obj);	//파일 지우기	
}
