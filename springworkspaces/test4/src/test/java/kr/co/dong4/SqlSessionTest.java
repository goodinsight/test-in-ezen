package kr.co.dong4;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*.xml")
public class SqlSessionTest {
	@Inject
	private SqlSessionFactory sqlSession;
	
	@Test
	public void SqlFactory() {
		System.out.println(sqlSession);
	}
	
	@Test
	public void SqlSession() throws Exception{
		try {
			SqlSession session = sqlSession.
			System.out.println(session);
		} catch(Exception e){
			e.fillInStackTrace();
		}
		
	}
}
