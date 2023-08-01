package kr.co.test.emp;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Inject
	private EmpServiceImpl service;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping(value="selectAll")
	public ModelAndView selectAll() {
		ModelAndView mav = new ModelAndView();
		List<EmpDTO> list = service.listAll();
		mav.addObject("list", list);
		mav.setViewName("selectAll");
		return mav;
	}
	
	@GetMapping(value="selectOne")
	public ModelAndView selectOne(int empno) {
		ModelAndView mav = new ModelAndView();
		EmpDTO edto = service.selectOne(empno);
		mav.addObject("edto",edto);
		mav.setViewName("selectOne");
		return mav;
	}
	
	@GetMapping(value="insert")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertForm");
		return mav;
	}
	@PostMapping(value="insert")
	public ModelAndView insert(EmpDTO edto) {
		ModelAndView mav = new ModelAndView();
		service.insert(edto);
		List<EmpDTO> list = service.listAll();
		mav.addObject("list", list);
		mav.setViewName("selectAll");
		return mav;
	}
	@GetMapping(value="update")
	public ModelAndView update(int empno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("empno", empno);
		mav.setViewName("updateForm");
		return mav;
	}
	
	@PostMapping(value="update")
	public ModelAndView update(EmpDTO dto) {
		ModelAndView mav = new ModelAndView();
		service.update(dto);
		EmpDTO edto = service.selectOne(dto.getEmpno());
		mav.addObject("edto",edto);
		mav.setViewName("selectOne");
		return mav;
	}
	
	@GetMapping(value="delete")
	public ModelAndView delete(int empno) {
		ModelAndView mav = new ModelAndView();
		service.delete(empno);
		List<EmpDTO> list = service.listAll();
		mav.addObject("list", list);
		mav.setViewName("selectAll");
		return mav;
	}
}
