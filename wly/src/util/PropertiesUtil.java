package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties prop;

	static {
		prop = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("conf/DBConfig.properties");
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static String getValue(String key) {
		if (prop != null) {
			return prop.getProperty(key);
		} else {
			return null;
		}
	}

}
