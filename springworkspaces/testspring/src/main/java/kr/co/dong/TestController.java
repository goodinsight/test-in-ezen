package kr.co.dong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="intro", method= RequestMethod.GET)
	public ModelAndView intro() {
		ModelAndView mav = new ModelAndView();
		String msg = "회사소개입니다.";
		mav.addObject("msg", msg);	// 데이터
		mav.setViewName("test01");	// view
		
		return mav;
	}
//	public String intro(Model model) {
//		
//		//처리
//		String msg = "회사소개입니다.";
//		
//		model.addAttribute("msg", msg);
//		return "test01";
//	}
	@RequestMapping(value="/intro2", method= RequestMethod.GET)
	public String intro2() {
		return "test02";
	}
	@RequestMapping(value="/intro3", method= RequestMethod.GET)
	public String intro3() {
		return "test03";
	}
	
	@RequestMapping(value="/main", method= RequestMethod.GET)
	public String main() {
		return "main";
	}
}
