/**
 * 
 */
package alan.tool.conmmon;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author WangHui
 *
 * 2016年9月7日
 */
public class PropertyConfigurer  extends PropertyPlaceholderConfigurer  {

//	private static final Logger logger = LoggerFactory.getLogger(PropertyConfigurer.class);
	protected void loadProperties(Properties props) throws IOException {
		super.loadProperties(props);
		try {
			
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			String decryUsername = AESUtils.aesDecrypt(username, "zyzx");
			String decryPassword = AESUtils.aesDecrypt(password, "zyzx");
			props.setProperty("jdbc.username", decryUsername);
			props.setProperty("jdbc.password", decryPassword);
			
			String logUsername = props.getProperty("log.jdbc.username");
			String logPassword = props.getProperty("log.jdbc.password");
			String decryLogUsername = AESUtils.aesDecrypt(logUsername, "zyzx");
			String decryLogPassword = AESUtils.aesDecrypt(logPassword, "zyzx");
			props.setProperty("log.jdbc.username", decryLogUsername);
			props.setProperty("log.jdbc.password", decryLogPassword);
			
		} catch (Exception e) {
//			logger.error("decode password in properties error!", e);
		}
	}
}
