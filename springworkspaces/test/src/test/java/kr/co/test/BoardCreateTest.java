package kr.co.test;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.test.board.BoardDAO;
import kr.co.test.board.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardCreateTest {
	//게시판 글쓰기 1000개 해보기 (DAO insert TEST)
	@Inject
	private BoardDAO boardDAO;
	
	@Test
	public void testInsert() throws Exception{
		BoardDTO boardDTO;
		
		for(int i = 1; i<=1000; i++) {
			boardDTO = new BoardDTO();
			boardDTO.setId("root");
			boardDTO.setTitle("title" + i);
			boardDTO.setContent("title" + i);
			
			boardDAO.register(boardDTO);
			
			Thread.sleep(1000);
		}
		
	}
}
