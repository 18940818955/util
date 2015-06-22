package cn.wb.test;

import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.wb.util.HttpRequestUtil;
import cn.wb.util.PropertyUtil;

public class Smstest {
	@Test
	public void sendSMS() throws Exception {
		String url ="http://web.cr6868.com/asmx/smsservice.aspx";//post=http://www.cr6868.com/Downloads/sdk.zip
		Map<String, String> mapProperties = PropertyUtil.getMapProperties("/message.properties");
		mapProperties.put("mobile", "18940818955");
		mapProperties.put("content", "nihao");
		ObjectMapper om = new ObjectMapper();
		String writeValueAsString = om.writeValueAsString(mapProperties);
//		System.out.println(writeValueAsString);
		HttpRequestUtil.sendPost(url, writeValueAsString);
	}
}
