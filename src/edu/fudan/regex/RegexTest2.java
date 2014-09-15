package edu.fudan.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 网页爬虫：其实是一个程序，用与在互联网中去获取符合指定规则的数据。
 * 
 * 爬取邮箱地址。
 * 
 */
public class RegexTest2 {
	public static void main(String[] args) throws Exception {
		List<String> list = getMailsByWeb();
		for(String mail:list) {
			System.out.println(mail);
		}
	}
	
	/*
	 * 爬网络
	 */
	private static List<String> getMailsByWeb() throws IOException {
		//1，读取文件。
		URL url = new URL("www.baidu.com");
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(url.openStream()));
		
		//2,对读取的数据进行规则的匹配，从中获取符合规则的数据。
		String mail_regex = "\\w+@\\w+(\\.\\w+)+";
		
		List<String> list = new ArrayList<String>();
		
		Pattern p = Pattern.compile(mail_regex);
		
		String line = null;
		while((line = bufIn.readLine()) != null) {
			Matcher m = p.matcher(line);
			while(m.find()) {
				list.add(m.group());
			}
		}
		
		//3,将符合规则的数据存储到集合中。
		return list;
	}

	/*
	 * 爬本地
	 */
	public static List<String> getMails() throws Exception {
		
		//1，读取文件。
		BufferedReader bufr = new BufferedReader(new FileReader("D:\\mail.txt"));
		
		//2,对读取的数据进行规则的匹配，从中获取符合规则的数据。
		String mail_regex = "\\w+@\\w+(\\.\\w+)+";
		
		List<String> list = new ArrayList<String>();
		
		Pattern p = Pattern.compile(mail_regex);
		
		String line = null;
		while((line = bufr.readLine()) != null) {
			Matcher m = p.matcher(line);
			while(m.find()) {
				list.add(m.group());
			}
		}
		
		//3,将符合规则的数据存储到集合中。
		return list;
	}
}
