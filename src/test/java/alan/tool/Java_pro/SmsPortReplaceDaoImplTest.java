/**
 * 
 */
package alan.tool.Java_pro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import alan.tool.bean.SmsPortReplace;
import alan.tool.bean.dao.impl.SmsPortReplaceDaoImpl;

/**
 * @author WangHui
 *
 * 2016年9月7日
 */
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SmsPortReplaceDaoImplTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	public SmsPortReplaceDaoImpl  smsDao;
	
	@Test
	public void testQueryAll(){
		
		List<SmsPortReplace>  beans = smsDao.queryAll();
		for (SmsPortReplace smsPortReplace : beans) {
			System.out.println(smsPortReplace.getReplType()+" --> "+ smsPortReplace.getReplProvince());
		} 
	}
	@Test
	public void readTxtFile()throws Exception {
		String filePath = "C:\\Users\\Administrator\\Desktop\\chan.txt";
		String encoding = "UTF8";
		File file = new File(filePath);
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			int i = 0;

			while ((lineTxt = bufferedReader.readLine()) != null) {
				System.out.println("port = "+lineTxt.split("\\s")[0]+":   chanID ="+lineTxt.split("\\s")[1]);
				Map map = new HashMap<>();
				map.put("chanID", lineTxt.split("\\s")[1]);
				map.put("port", lineTxt.split("\\s")[0]);
				map.put("repPort", "10690356510085");
				map.put("remark", lineTxt.split("\\s")[2]+"-"+lineTxt.split("\\s")[3]);
				System.out.println(smsDao.insert(map));
			}
			read.close();
		} else {
			System.out.println("找不到指定的文件");
		}
	}
}

