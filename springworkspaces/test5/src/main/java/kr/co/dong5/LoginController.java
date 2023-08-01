package kr.co.dong5;

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

import kr.co.dong5.domain.LoginVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
//	@RequestMapping(value="/login/loginForm", method=RequestMethod.GET)
//	public ModelAndView loginForm() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login/loginForm");
////		mav.addObject("login/logingForm", "login/logingForm");
//		return mav;
//	}
	
	@GetMapping(value="/login/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/loginForm");
		return mav;
	}
	// 1. request 한 파라미터를 받는 방법1 : HttpServletRequest
	@PostMapping(value="/login/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		요청한 정보 
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
//		요청한 정보를 DB에 가서 확인
		
//		요청데이터를 확인하여 view에 전달하기 (DB X)
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("name", name);
		mav.setViewName("/login/result");
		return mav;
	}
	// 2. @RequestParam
	@PostMapping(value="login/login2")
	public ModelAndView login2(@RequestParam("userId")String userId,
			@RequestParam("name")String name,
			HttpServletRequest request,
			HttpServletResponse reponse) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("name", name);
		mav.setViewName("/login/result");
		return mav;
	}
	// 3. @RequestParam Map<>
	@PostMapping(value="login/login3")
	public ModelAndView login3(@RequestParam Map<String,LoginVO> info,
			HttpServletRequest request,
			HttpServletResponse reponse) throws Exception{
		request.setCharacterEncoding("utf-8");
		logger.info("아이디 : " + info.get("userId"));
		logger.info("이 름 : " + info.get("name"));
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("info", info);
		mav.setViewName("login/result");
		return mav;
	}
	
	// 4.ModelAttribute
	@PostMapping(value="login/login4")
	public ModelAndView login3(@ModelAttribute("info") LoginVO loginVo, HttpServletRequest request) throws Exception{
//	public ModelAndView login3(LoginVO loginVo, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		logger.info("======>" + loginVo);
				
		ModelAndView mav = new ModelAndView();
//		mav.addObject("info", loginVo);
		mav.setViewName("login/result");
		return mav;
	}
	
}
