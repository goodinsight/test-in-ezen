package kr.co.dong.good;

import java.util.List;

public class GoodServiceImpl implements GoodsService{
//	서비스는 DAO를 호출함
	GoodsDAOImpl gdao = new GoodsDAOImpl();
	
	
	@Override
	public List<GoodsBean> listAll() {
		// TODO Auto-generated method stub
		return gdao.listAll();
	}

	@Override
	public int insert(GoodsBean gb) {
		// TODO Auto-generated method stub
		int result = gdao.insert(gb);
		return result;
	}

	@Override
	public GoodsBean selectOne(int gid) {
		// TODO Auto-generated method stub
		return gdao.selectOne(gid);
	}

	@Override
	public List<GoodsBean> selectOne(String gname) {
		// TODO Auto-generated method stub
		return gdao.selectOne(gname);
	}

	@Override
	public int update(GoodsBean gb) {
		// TODO Auto-generated method stub
		return gdao.update(gb);
	}

	@Override
	public int delete(int gid) {
		// TODO Auto-generated method stub
		return gdao.delete(gid);
	}

}
