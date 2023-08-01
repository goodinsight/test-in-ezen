package kr.co.dong;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dong.domain.LoginVO;

@Controller
public class Logincontroller {
	public static final Logger logger = LoggerFactory.getLogger(Logincontroller.class);
	
//	@RequestMapping(value="login/loginForm", method = RequestMethod.GET)
//	public ModelAndView loginForm() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("login/loginForm", "login/loginForm");
//		mav.setViewName("login/loginForm");
//		return mav;
//	}
	
	@GetMapping(value="login/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("login/LoginForm", "login/loginForm");
		mav.setViewName("login/loginForm");
		return mav;
	}
	
	@PostMapping(value="login/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("name", name);
		mav.setViewName("login/result");		
		return mav;
	}
	
	@PostMapping(value="login/login2")
	public ModelAndView login(@RequestParam("userId") String userId, @RequestParam("name") String name, HttpServletRequest request ) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("name", name);
		mav.setViewName("login/result");
		
		return mav;
	}
	
	@PostMapping(value="login/login3")
	public ModelAndView login(@RequestParam Map<String, String> info, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info("아이디 : " + info.get("userId"));
		logger.info("이 름 : " + info.get("name"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("info", info);
		mav.setViewName("login/result");
		return mav;
	}
	
	@PostMapping(value="login/login4")
	public ModelAndView login(@ModelAttribute("info") LoginVO loginVo, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info("======>" + loginVo);
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("info", loginVo);
		mav.setViewName("login/result");
		return mav;
	}
	
	
	
	
	
	
	
	
}
	