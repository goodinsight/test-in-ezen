/**
 * 1) Mybatis를 담당  ---> SqlSession 사용함
 * 2) @Repository
 */
package kr.co.dong5.emp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl {
	@Inject
	private SqlSession sqlSession;
	
	public int empCount() throws Exception{
		return sqlSession.selectOne("kr.co.dong5.empMapper.cnt"); // namespace.id
	}
}
