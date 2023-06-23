/**
 * 학생 정보 추가, 조회, 수정, 삭제
 */
package kr.co.dong.jdbc;

public interface StudentCrud {
	public abstract void insertStd();	//학생추가
	public abstract void allSearchStd();	//학생전체조회
	public abstract void oneSearchStd();	//학생조회(순번 or 학번 or 이름으로)
	public abstract void updateStd();	//학생수정
	public abstract void deleteStd();	//학생삭제

}
