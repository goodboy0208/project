package edu.fudan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {
	/*
	 * 正则表达式对字符串常见操作
	 * 1，匹配
	 * 	其实使用的就是String类中的mathches方法。
	 * 
	 * 2，切割
	 * 	其实就是String类中的split方法
	 * 
	 * 3，替换
	 * 	其实使用的就是String类中的replaceAll方法
	 * 
	 * 4，获取
	 * 将正则规则进行对象的封装
	 * 	Pattern p = Pattern.compile("a*b");
	 * 通过正则对象的matcher方法字符串相关联，获取要多字符串操作的匹配对象Matcher
 		Matcher m = p.matcher("aaaaab");
 	 * 通过Matcher匹配器对象的方法对字符串进行操作。
 		boolean b = m.matches();
	 * 
	 */
	
	public static void main(String[] args) {
		functionDemo_4();
	}
	
	/*
	 * 获取
	 */
	private static void functionDemo_4() {
		
		String str = "da jia hao,ming tian bu fang jia!";
		
		String regex = "\\b[a-z]{3}\\b";
		
		//1,将正则封装成对象。
		Pattern p = Pattern.compile(regex);
		//2,通过正则对象获取匹配器对象。
		Matcher m  = p.matcher(str);
		//使用Matcher对象的方法对字符串进行操作。
		//既然要获取三个字母组成的单词。
		//查找。find();返回的是boolean类型。
		System.out.println(str);
		while(m.find()) {
			System.out.println(m.group());//获取匹配的子序列
		
			System.out.println(m.start()+":"+m.end());
		}
	}

	/*
	 * 替换
	 */
	private static void functionDemo_3() {
		String str = "zhangsantttttxiaoqingmmmmmmmzhaoliu";
//		str = str.replaceAll("(.)\\1+", "#");
		//$：在其他参数中可以对前一个参数中的已有的正则规则的获取。
		str = str.replaceAll("(.)\\1+", "$1");
		
		System.out.println(str);
		
		String tel = "15800001111";//替换成158****1111
		
		tel = tel.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$2");
		System.out.println(tel);
	}

	/*
	 * 切割
	 * 组：((A)(B(C)))，看左括号确定组。
	 */
	private static void functionDemo_2() {

/*		String str = "zhangsan    xiaoqing    zhaoliu";
		
		String[] names = str.split(" +");
		
		for(String name:names) {
			System.out.println(name);
		}*/
		
	String str = "zhangsantttttxiaoqingmmmmmmmzhaoliu";
		
		String[] names = str.split("(.)\\1+");//正则中用()进行封装,封装后形成组，产生组号，组号可直接用
		
		for(String name:names) {
			System.out.println(name);
		}
	}

	/*
	 * 演示匹配
	 */
	public static void functionDemo_1() {
		//匹配手机号码是否正确
		String tel = "15800001111";
		String reg = "1[358]\\d{9}";
		boolean b = tel.matches(reg);
		System.out.println(tel+":"+b);
	}
}
