package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl {
	@Inject
	private EmpDAOImpl dao;
	
	public int empCount() throws Exception{
		
		int cnt = dao.empCount();
		
		return cnt;
	}
	
	public List<EmpDTO> listAll() throws Exception{
		List<EmpDTO> list = dao.listAll();
		return list;
	}
	
	public EmpDTO selectOne(int empno) throws Exception{
		EmpDTO edto = dao.selectOne(empno);
		return edto;
	}

	public EmpDTO empInsert(EmpDTO edto) throws Exception{
		dao.empInsert(edto);
		EmpDTO dto = dao.selectOne(edto.getEmpno());
		return dto;
	}
}
