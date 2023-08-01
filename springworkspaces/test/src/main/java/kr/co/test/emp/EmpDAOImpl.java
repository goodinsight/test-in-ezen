package kr.co.test.emp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO{
	@Inject
	private SqlSession session;
	
	@Override
	public List<EmpDTO> listAll() {
		// TODO Auto-generated method stub
		return session.selectList("kr.co.test.empMapper.listAll");
	}

	@Override
	public EmpDTO selectOne(int empno) {
		// TODO Auto-generated method stub
		return session.selectOne("kr.co.test.empMapper.selectOne", empno);
	}

	@Override
	public int insert(EmpDTO edto) {
		// TODO Auto-generated method stub
		return session.insert("kr.co.test.empMapper.insert", edto);
	}

	@Override
	public int update(EmpDTO edto) {
		// TODO Auto-generated method stub
		return session.update("kr.co.test.empMapper.update", edto);
	}

	@Override
	public int delete(int empno) {
		// TODO Auto-generated method stub
		return session.delete("kr.co.test.empMapper.delete", empno);
	}

}
