package kr.co.test.emp;

import java.util.List;

public interface EmpService {
	public abstract List<EmpDTO> listAll();
	public abstract EmpDTO selectOne(int empno);
	public abstract int insert(EmpDTO edto);
	public abstract int update(EmpDTO edto);
	public abstract int delete(int empno);

}
