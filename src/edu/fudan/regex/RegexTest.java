package edu.fudan.regex;

import java.util.TreeSet;

/*
 * 正则练习
 */
public class RegexTest {
	public static void main(String[] args) {
		/*
		 * 1,治疗口吃，我我我...我我...我我我要要....要要...要要要学学学....学学编编编....编编编程程...程程
		 * 2,对ip地址排序
		 * 3，对邮件地址校验
		 * 
		 * 
		 */
		test_3();
	}
	
	/*
	 * 对邮箱地址校验
	 */
	private static void test_3() {
		String mail = "abc@sina.com";
		
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{1,3}){1,3}";
		
//		regex = "\\w+@\\w+(\\.\\w+)+";
		
		boolean b = mail.matches(regex);
		
		System.out.println(mail+":"+b);
	}

	/*
	 * ip地址排序
	 * 
	 * 192.168.10.34   127.0.0.1  3.3.3.3  105.70.11.55
	 */
	private static void test_2() {
		
		String ip_str = "192.168.10.34   127.0.0.1  3.3.3.3  105.70.11.55";
		
		//1，为了让ip可以按照字符串顺序比较，只要让ip的每一段的位数相同。
		//所以，补零，按照每一位所需最多0进行补充。每一段都加两个0.
		
		ip_str = ip_str.replaceAll("(\\d+)", "00$1");
		System.out.println(ip_str);
		
		//2,每一段保留数字3位。
		ip_str = ip_str.replaceAll("0*(\\d{3})", "$1");
		System.out.println(ip_str);
		
		
		//1,将ip地址切出
		String[] ips = ip_str.split(" +");
		
		TreeSet<String> ts = new TreeSet<String>();
		
		for(String ip:ips) {
//			System.out.println(ip);
			ts.add(ip);
		}
		
		for(String ip:ts) {
			System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
		}
	}

	/*
	 * 1，治疗口吃
	 */
	public static void test_1() {
		String str = "我我我...我我...我我我要要....要要...要要要学学学....学学编编编....编编编程程...程程";
		//1,将字符串中的.去掉，用替换。
		str = str.replaceAll("\\.", "");
		System.out.println(str);
		
		//2,替换叠词
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
}
