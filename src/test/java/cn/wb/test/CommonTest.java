package cn.wb.test;

import lombok.SneakyThrows;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.wb.entities.User;

public class CommonTest {
	@Test
	@SneakyThrows
	public void test1(){
		User user = new User();
		user.setPassword("dd");
		user.setUsername("ss");
//		System.out.println(user);
		ObjectMapper om = new ObjectMapper();
		String writeValueAsString = om.writeValueAsString(user);
		System.out.println(writeValueAsString);
	}
}
