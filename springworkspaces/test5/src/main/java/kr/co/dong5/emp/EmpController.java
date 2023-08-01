package kr.co.dong5.emp;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {
//	Service를 호출
	@Inject
	private EmpServiceImpl service;
	
	@GetMapping(value="empcount")
	public String empcount(Model model) throws Exception{
		int cnt = service.empCount();
		model.addAttribute("cnt", cnt);
		return "home";
	}
}
 