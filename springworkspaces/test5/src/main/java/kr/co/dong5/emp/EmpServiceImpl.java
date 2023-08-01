/**
 * 1) DAO 및 타 클래스를 호출하여 수행
 * 2) @Service
 */

package kr.co.dong5.emp;

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
