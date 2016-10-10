package alan.tool.bean.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import alan.tool.bean.SmsPortReplace;
import alan.tool.bean.dao.SmsPortReplaceDao;

@Service
public class SmsPortReplaceDaoImpl implements SmsPortReplaceDao {
	
	@Resource
	private SqlSession sqlSession;

	
	@Override
	public List<SmsPortReplace> queryAll() {
		
		return sqlSession.selectList("queryAllSmsPortReplace");
	}


	@Override
	public int insert(Map map) {
		return sqlSession.insert("insertSmsPortReplace", map);
	}


}
