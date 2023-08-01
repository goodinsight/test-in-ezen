package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Inject
	private EmpServiceImpl service;
	
	@RequestMapping(value="empcount", method=RequestMethod.GET)
	public ModelAndView empcount() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int cnt = service.empCount();
		mav.addObject("cnt", cnt);
		mav.setViewName("home");
		return mav;
	}
	
	@GetMapping(value="listAll")
	public ModelAndView listAll(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<EmpDTO> list = service.listAll();
		request.setAttribute("l", list);
		mav.addObject("list", list);
		mav.setViewName("listAll");
		return mav;
	}
	
	@GetMapping(value="emplist")
	public ModelAndView emplist() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<EmpDTO> list = service.listAll();
		mav.addObject("list", list);
		mav.setViewName("emplist");
		return mav;
	}
	
	@GetMapping(value="empOne")
	public ModelAndView empOne(int empno) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		EmpDTO edto = service.selectOne(empno);
		System.out.println(edto);
		mav.addObject("edto", edto);
		mav.setViewName("empdetail");
		return mav;
	}
	
	@GetMapping(value="empinsert")
	public ModelAndView empInsert() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("empinsertForm");
		return mav;
	}
	
	@PostMapping(value="empinsert")
	public ModelAndView empInsert(EmpDTO edto) throws Exception {
		ModelAndView mav = new ModelAndView();
		service.empInsert(edto);
		EmpDTO dto = service.selectOne(edto.getEmpno());
		System.out.println(dto);
		mav.addObject("dto", dto);
		mav.setViewName("empinsert");
		return mav;
	}
	
	
}
