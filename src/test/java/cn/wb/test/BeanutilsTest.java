package cn.wb.test;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

public class BeanutilsTest {
	/**
	 * 1、获取字段值
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test1() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		SampleBean bean1 = new SampleBean();
		bean1.setName("rensanning");
		bean1.setAge(31);

		String name = BeanUtils.getProperty(bean1, "name");
		String age = BeanUtils.getProperty(bean1, "age");

		System.out.println(name);
		System.out.println(age);

	}

	/**
	 * 2、设置字段值
	 * 
	 * @throws IllegalAccessException
	 * 
	 * @throws InvocationTargetException
	 */
	@Test
	public void test2() throws IllegalAccessException,
			InvocationTargetException {
		SampleBean bean2 = new SampleBean();
		BeanUtils.setProperty(bean2, "name", "rensanning");
		BeanUtils.setProperty(bean2, "age", 31);

		System.out.println(bean2.getName());
		System.out.println(bean2.getAge());

	}

	/**
	 * 3、赋值Bean
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test3() throws IllegalAccessException, InstantiationException,
			InvocationTargetException, NoSuchMethodException {
		SampleBean bean3 = new SampleBean();
		bean3.setName("rensanning");
		bean3.setAge(31);

		SampleBean clone = (SampleBean) BeanUtils.cloneBean(bean3);

		System.out.println(clone.getName());
		System.out.println(clone.getAge());

	}

	/**
	 * 4、Bean的describe
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * 
	 */
	@Test
	public void test4() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		SampleBean bean4 = new SampleBean();
		bean4.setName("rensanning");
		bean4.setAge(31);

		Map<String, String> map4 = BeanUtils.describe(bean4);

		System.out.println(map4.get("name"));
		System.out.println(map4.get("age"));
	}

	/**
	 * 5、Bean的populate
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test5() throws IllegalAccessException,
			InvocationTargetException {
		SampleBean bean5 = new SampleBean();

		Map<String, String> map5 = new HashMap<String, String>();
		map5.put("name", "rensanning");
		map5.put("age", "31");

		BeanUtils.populate(bean5, map5);

		System.out.println(bean5.getName());
		System.out.println(bean5.getAge());

	}

	/**
	 * 6、获取Bean的数组集合字段值
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test6() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		SampleBean bean6 = new SampleBean();
		bean6.setArray(new String[] { "a", "b", "c" });
		List<String> list0 = new ArrayList<String>();
		list0.add("d");
		list0.add("e");
		list0.add("f");
		bean6.setList(list0);

		String[] array = BeanUtils.getArrayProperty(bean6, "array");

		System.out.println(array.length);// 3
		System.out.println(array[0]);// "a"
		System.out.println(array[1]);// "b"
		System.out.println(array[2]);// "c"

		String[] list = BeanUtils.getArrayProperty(bean6, "list");
		System.out.println(list.length);// 3
		System.out.println(list[0]);// "d"
		System.out.println(list[1]);// "e"
		System.out.println(list[2]);// "f"

		System.out.println(BeanUtils.getProperty(bean6, "array[1]"));// "b"
		System.out.println(BeanUtils.getIndexedProperty(bean6, "array", 2));// "c"

	}

	/**
	 * 7、获取Bean的Map字段值
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test7() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		SampleBean bean7 = new SampleBean();
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		bean7.setMap(map);

		String value1 = BeanUtils.getMappedProperty(bean7, "map", "key1");
		System.out.println(value1);// "value1"

		String value2 = BeanUtils.getMappedProperty(bean7, "map", "key2");
		System.out.println(value2);// "value2"

		System.out.println(BeanUtils.getProperty(bean7, "map.key1"));// "value1"
		System.out.println(BeanUtils.getProperty(bean7, "map.key2"));// "value2"

	}

	/**
	 * 8、获取Bean的嵌套字段值
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test8() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		SampleBean bean = new SampleBean();
		NestedBean nestedBean = new NestedBean();
		nestedBean.setNestedProperty("xxx");
		bean.setNestedBean(nestedBean);

		String value = BeanUtils.getNestedProperty(bean,
				"nestedBean.nestedProperty");
		System.out.println(value);// "xxx"

		System.out.println(BeanUtils.getProperty(bean,
				"nestedBean.nestedProperty"));// "xxx"

	}

	/**
	 * 9、URL字段的特殊处理
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test9() throws IllegalAccessException,
			InvocationTargetException {
		SampleBean bean8 = new SampleBean();

		BeanUtils.setProperty(bean8, "url", "http://www.google.com/");

		URL url = bean8.getUrl();
		System.out.println(url.getProtocol());// "http"
		System.out.println(url.getHost());// "www.google.com"
		System.out.println(url.getPath());// "/"

	}

	/**
	 * 10、日期的转化
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void test10() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		SampleBean bean9 = new SampleBean();

		DateConverter converter = new DateConverter();
		converter.setPattern("yyyy/MM/dd HH:mm:ss");

		ConvertUtils.register(converter, Date.class);
		ConvertUtils.register(converter, String.class);

		BeanUtils.setProperty(bean9, "date", "2010/12/19 23:40:00");

		String value9 = BeanUtils.getProperty(bean9, "date");
		System.out.println(value9);// "2010/12/19 23:40:00"

	}
}

class NestedBean {
	private String nestedProperty;

	public String getNestedProperty() {
		return nestedProperty;
	}

	public void setNestedProperty(String nestedProperty) {
		this.nestedProperty = nestedProperty;
	}

}

class SampleBean {
	private String name;
	private Integer age;
	private String[] array;
	private List list;
	private Map map;
	private NestedBean nestedBean;
	private URL url;

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public NestedBean getNestedBean() {
		return nestedBean;
	}

	public void setNestedBean(NestedBean nestedBean) {
		this.nestedBean = nestedBean;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
