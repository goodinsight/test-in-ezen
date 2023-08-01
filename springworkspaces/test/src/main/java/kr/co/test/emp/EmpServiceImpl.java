package kr.co.test.emp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService{
	@Inject
	private EmpDAOImpl dao;
	
	
	@Override
	public List<EmpDTO> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public EmpDTO selectOne(int empno) {
		// TODO Auto-generated method stub
		return dao.selectOne(empno);
	}

	@Override
	public int insert(EmpDTO edto) {
		// TODO Auto-generated method stub
		return dao.insert(edto);
	}

	@Override
	public int update(EmpDTO edto) {
		// TODO Auto-generated method stub
		return dao.update(edto);
	}

	@Override
	public int delete(int empno) {
		// TODO Auto-generated method stub
		return dao.delete(empno);
	}

}
