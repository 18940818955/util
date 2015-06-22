package cn.wb.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtil {
	public static Properties getProperties(String url) throws Exception {
		Properties prop = new Properties();
		InputStream in = PropertyUtil.class.getResourceAsStream(url);
		prop.load(in);
		return prop;
	}

	public static Map<String, String> getMapProperties(String url)
			throws Exception {
		Map<String, String> map = new HashMap<String, String>(
				(Map) getProperties(url));
		return map;
	}

	public static String getValueProperties(String url, String param)
			throws Exception {
		Map map = getMapProperties(url);
		return (String) map.get(param);
	}
}
