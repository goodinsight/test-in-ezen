package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl {
	@Inject
	private SqlSession sqlSession;
	
	private final static String namespace ="kr.co.dong.empMapper.";
	
	public int empCount() {
		int cnt = sqlSession.selectOne(namespace + "cnt");
		
		return cnt;
	}
	
	public List<EmpDTO> listAll() {
		return sqlSession.selectList(namespace + "listAll");
	}
	
	public EmpDTO selectOne(int empno) {
		return sqlSession.selectOne(namespace + "selectOne", empno);
	}

	public void empInsert(EmpDTO edto) {
		sqlSession.insert(namespace + "insert", edto);
	}
}
