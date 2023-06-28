package kr.co.dong.student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
	StudentDAOimpl sdao = new StudentDAOimpl();
	
	@Override
	public List<StudentBean> listAll() {
		// TODO Auto-generated method stub
		return sdao.listAll();
	}

	@Override
	public int insert(StudentBean sb) {
		// TODO Auto-generated method stub
		return sdao.insert(sb);
	}

	@Override
	public StudentBean selectOne(int sid) {
		// TODO Auto-generated method stub
		return sdao.selectOne(sid);
	}

	@Override
	public List<StudentBean> selectOne(String name) {
		// TODO Auto-generated method stub
		return sdao.selectOne(name);
	}

	@Override
	public int update(StudentBean sb) {
		// TODO Auto-generated method stub
		return sdao.update(sb);
	}

	@Override
	public int delete(int sid) {
		// TODO Auto-generated method stub
		return sdao.delete(sid);
	}

}
