package kr.co.dong.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dong.VO.MovieVO;
import kr.co.dong.service.SearchService;

/**
 * Handles requests for the application search page.
 */
@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	@Autowired
	private SearchService searchService;
//	@Autowired
//	private MovieVO mVo;
	
	
	@GetMapping("search")
	public String search() {
		logger.info("============== > search페이지로 이동");
		return "search";
	}
	
	@GetMapping("search/name")
	public ModelAndView name(MovieVO mVo) {
		logger.info("============== > result페이지로 이동");
		logger.info("mVo : " + mVo);
		ModelAndView mav = new ModelAndView();
		
		List<Integer> movieList = searchService.searchCollectAll(mVo);
		logger.info("movieList : " + movieList);
		mav.addObject("nameMovieList", movieList);
		mav.setViewName("searchresult");
		return mav;
	}
	
	@GetMapping("search/age")
	public ModelAndView age(int m_age) {
		logger.info("============== > result페이지로 이동");
		logger.info("m_age : " + m_age);
		ModelAndView mav = new ModelAndView();
		List<Integer> movieList = searchService.searchAllM_age(m_age);
		logger.info("movieList : " + movieList);
		mav.addObject("ageMovieList", movieList);
		mav.setViewName("searchresult");
		return mav;
	}
	@GetMapping("search/genre")
	public ModelAndView genre(String m_genre) {
		logger.info("============== > result페이지로 이동");
		logger.info("m_genre : " + m_genre);
		ModelAndView mav = new ModelAndView();
		List<Integer> movieList = searchService.searchAllM_genre(m_genre);
		logger.info("movieList : " + movieList);
		mav.addObject("genreMovieList", movieList);
		mav.setViewName("searchresult");
		return mav;
	}
	@GetMapping("search/nation")
	public ModelAndView nation(String m_nation) {
		logger.info("============== > result페이지로 이동");
		logger.info("m_nation : " + m_nation);
		ModelAndView mav = new ModelAndView();
		List<Integer> movieList = searchService.searchAllM_nation(m_nation);
		logger.info("movieList : " + movieList);
		mav.addObject("nationMovieList", movieList);
		mav.setViewName("searchresult");
		return mav;
	}

	
	
}
