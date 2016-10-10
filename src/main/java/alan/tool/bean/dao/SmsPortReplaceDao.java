package alan.tool.bean.dao;

import java.util.List;
import java.util.Map;

import alan.tool.bean.SmsPortReplace;

public interface SmsPortReplaceDao {
	public List<SmsPortReplace> queryAll();
	public int insert(Map map);
}