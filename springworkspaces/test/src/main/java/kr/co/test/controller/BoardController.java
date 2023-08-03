package kr.co.test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;

import kr.co.test.board.BoardDTO;
import kr.co.test.board.BoardReply;
import kr.co.test.board.BoardService;
import kr.co.test.emp.EmpDTO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	
	
	@GetMapping(value="/board/login")
	public ModelAndView login() {
		logger.info("로그인폼으로 이동 =======>");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping(value="/board/login")
	public ModelAndView login(HttpServletRequest request, HttpSession session, @RequestParam Map<String, Object> map) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		logger.info("데이터베이스로 전송");
		Map<String, Object> user = service.login(map);
		ModelAndView mav = new ModelAndView();
		if(user == null) {
			mav.setViewName("redirect:login");
			return mav;
		}else {
			session.setAttribute("user",user);	//세션부여
			mav.addObject("userlog", user);
			mav.setViewName("redirect:/index");
			return mav;
		}
	}
	
	@GetMapping(value="/board/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.invalidate();	//세션 로그아웃
		mav.setViewName("redirect:/index");
		return mav;
	}
	
	@GetMapping(value="/board/list")
	public ModelAndView list(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = service.list();
		mav.addObject("list", list);
		mav.setViewName("list");
		return mav;
	}
	
	@GetMapping(value="/board/detail")
	public ModelAndView detail(int bno, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav = new ModelAndView();
		BoardDTO board = service.getDetail(bno);
		mav.addObject("board", board);
		
		//댓글 목록 조회
		List<BoardReply> replylist = service.getDetail1(bno);
		mav.addObject("list", replylist);
		
		
		
		mav.setViewName("detail");		
		return mav;
	}
	@GetMapping(value="/board/register")
	public ModelAndView register(HttpSession session, HttpServletRequest request) throws Exception {
		logger.info("글쓰기폼으로 이동 =======>");
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", session.getAttribute("user"));
		mav.setViewName("register");		
		return mav;
	}
	
	@PostMapping(value="/board/register")
	public ModelAndView register(BoardDTO bdto, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		logger.info("title : " + bdto.getTitle());
		logger.info("content : " + bdto.getContent());
		logger.info("id : " + bdto.getId());
		Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        bdto.setRegdate(str);
		
		ModelAndView mav = new ModelAndView();
		service.register(bdto);
		List<BoardDTO> list = service.list();
		mav.addObject("list", list);
		mav.setViewName("redirect:list"); //
		
		return mav;
	}
	
	@GetMapping(value="/board/update")
	public ModelAndView update(int bno) {

		ModelAndView mav = new ModelAndView();
		BoardDTO edto = service.getDetail(bno);
		logger.info("bno : " + edto.getBno());
		mav.addObject("board", edto);
		mav.setViewName("update");
		return mav;
	}
	@PostMapping(value="/board/update")
	public ModelAndView update(BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		logger.info("id : " + dto.getId());
		logger.info("bno : " + dto.getBno());
		service.update(dto);
		BoardDTO edto = service.getDetail(dto.getBno());
		mav.addObject("board",edto);
		mav.setViewName("redirect:detail?bno="+dto.getBno());
		return mav;
	}
	@GetMapping(value="/board/delete")
	public ModelAndView delete(int bno) {
		ModelAndView mav = new ModelAndView();
		service.delete(bno);
		List<BoardDTO> list = service.list();
		mav.addObject("list", list);
		mav.setViewName("redirect:list");
		return mav;
	}
//	@GetMapping(value="/board/reply")
//	public ModelAndView reply(int bno) {
//		ModelAndView mav = new ModelAndView();	
//		mav.addObject("bno", bno);
//		mav.setViewName("reply");
//		return mav;
//	}
	
//	ajax 댓글에 대한 매핑과 메소드를 구현
//	"board/replylist"매핑설정
//	글번호가 요청되어야 함
//	json처리를 위한 라이브러리가 필요함 -> jackson-databind, jackson-core
	
	@ResponseBody
	@PostMapping(value="board/replylist")
	public List<BoardReply> replylist(@RequestParam("bno") int bno){
		return service.getDetail1(bno);
	}
	
	//댓글쓰기
	@ResponseBody
	@PostMapping(value="board/reply2")
	public int reply2(BoardReply boardReply) {
		return service.reply(boardReply);
	}
	
	//댓글수정
	@ResponseBody
	@PostMapping(value="board/replyupdate2")
	public Map<String, Object> replyupdate2(BoardReply boardReply) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			service.replyUpdate(boardReply);
			result.put("status", "OK");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("status", "Fail");
		}
		return result;
	}
//	public int replyupdate2(BoardReply boardReply) {
//		return service.replyUpdate(boardReply);
//	}
	
	
	
}
