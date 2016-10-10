package alan.tool.Java_pro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alan.tool.conmmon.ConfigFileUtil;

/**
 * Hello world!
 *
 */
public class App {
//	private static Logger logger;

	public static void main(String[] args) throws Exception {
		String logconf = System.getProperty("logback.configurationFile");
		if (StringUtils.isBlank(logconf)) {
			System.setProperty("logback.configurationFile", "logback.xml");
		}
//		logger = LoggerFactory.getLogger(App.class);
		new App().loadSpringConfig();
		LockSupport.park();
	}

	@Deprecated
	@SuppressWarnings("rawtypes")
	public void start(String name, String[] args) throws Exception {
		Options options = new Options();
		options.addOption("h", false, "print help for the command");
		options.addOption("db", false, "load Entity from DB");
		options.addOption("conf", true, "config file path");
		options.addOption(OptionBuilder.withLongOpt("ch").withArgName("channelIds, .../all").hasArgs()
				.withValueSeparator(',').withDescription("start channel with id").create());

		CommandLine cli = null;
		try {
			cli = new PosixParser().parse(options, args);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			return;
		}

		if (cli.hasOption("h")) {

			System.out.println(name + "-conf configuration.xml -ch all");
			return;
		}

		String configFile = "configuration.xml";
		if (cli.hasOption("conf")) {
			configFile = cli.getOptionValue("conf");
		}
		ConfigFileUtil.loadconfiguration(configFile);

		HashSet<String> willstart = new HashSet<String>();
		boolean isAll = true;
		if (cli.hasOption("ch")) {
			List<String> optionsValues = Arrays.asList(cli.getOptionValues("ch"));
			if (optionsValues.contains("all")) {
				isAll = true;
			} else {
				isAll = false;
				willstart.addAll(optionsValues);
			}
		}
		loadSpringConfig();

		LockSupport.park();
	}

	private void loadSpringConfig() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");//NOSONAR
	}
}
