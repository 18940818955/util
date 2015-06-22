package cn.wb.test;

import java.util.Map;

import org.junit.Test;

import cn.wb.util.PropertyUtil;

public class TestJava {
	@Test
	public void testPropertyUtil() throws Exception {
		Map<String, String> mapProperties = PropertyUtil.getMapProperties("/config.properties");
		System.out.println(mapProperties);
	}
	@Test
	public void testHttpRequestUtil(){
		
	}
}
