package kr.co.dong4.emp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class EmpDAOImpl {
	@Inject
	private SqlSession session;
	
	public int empCount() throws Exception {
		return session.selectOne("kr.co.dong4.empMapper.cnt");
	}
	
}
