package alan.tool.conmmon;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.DefaultConfigurationBuilder;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Service;

/**
 * @author Lihuanghe(18852780@qq.com) 加载configuration文件
 */
@Service
public class ConfigFileUtil {
//	private static final Logger logger = LoggerFactory.getLogger(ConfigFileUtil.class);
	private static DefaultConfigurationBuilder configbuilder = new DefaultConfigurationBuilder();
	public static CombinedConfiguration config;
	private static boolean isLoad = false;

	public synchronized static void loadconfiguration(String filepath) {
		// 多线程并发时，需要判断一次是否被其它线程load过了
		if (isLoad)
			return;
		configbuilder.setFileName(filepath);
		try {
			config = configbuilder.getConfiguration(true);
			isLoad = true;
		} catch (ConfigurationException e) {
//			logger.error("load config {} failed.", filepath, e);
		}
	}

	private static void initLoad() {
		if (!isLoad) {
			loadconfiguration("configuration.xml");
			// loadconfiguration("DBSQL.sql");
		}

	}

	public static File getJeproperties() {
		initLoad();
		Configuration props = config.getConfiguration("BDBproperties");
		if (props == null)
			return null;
		return ((PropertiesConfiguration) props).getFile();
	}

	private static PropertiesConfiguration loadGlobalConfigEntity() {
		initLoad();
		PropertiesConfiguration props = (PropertiesConfiguration) config.getConfiguration("global");
		return props;
	}

	public static String getGlobalPropertiesByKey(String key, String defaultValue) {
		return defaultValue == null ? loadGlobalConfigEntity().getString(key) : loadGlobalConfigEntity().getString(key, defaultValue);
	}

	public static String getGlobalBDBBaseHome() {
		String baseHome = loadGlobalConfigEntity().getString("BDBBaseHome");
		if (baseHome.endsWith("/") || baseHome.endsWith("\\")) {
			return baseHome;
		} else {
			return baseHome + "/";
		}
	}

	public static Charset getGlobaldefaultTransportCharset() {
		String chartset = loadGlobalConfigEntity().getString("defaultTransportCharset");
		return Charset.forName(chartset);

	}
}
