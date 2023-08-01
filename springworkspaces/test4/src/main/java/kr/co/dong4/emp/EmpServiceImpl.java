package kr.co.dong4.emp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl {
	@Inject
	private EmpDAOImpl dao;
	
	public int empCount() throws Exception{
		return dao.empCount();
	}
}
