package kr.co.dong4.emp;

import javax.inject.Inject;

import org.apache.taglibs.standard.lang.jstl.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Inject
	private EmpServiceImpl service;
	
	@RequestMapping(value="empcount", method = RequestMethod.GET)
	public ModelAndView empcount() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		int cnt = service.empCount();
		mav.addObject("cnt", cnt);
		mav.setViewName("home");
		return mav;
			
	}
}
