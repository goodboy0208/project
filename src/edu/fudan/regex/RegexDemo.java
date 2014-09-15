package edu.fudan.regex;

public class RegexDemo {

	/**
	 * @param args
	 */
	/*
	 * 需求：定义一个功能对qq号进行校验。
	 * 要求：长度5~15，只能是数字，0不能开头。
	 */
	public static void main(String[] args) {
		/*
		 * 需求：定义一个功能对qq号进行校验。
		 * 要求：长度5~15，只能是数字，0不能开头。
		 */
//		String qq = "123433";
//		
//		String regex = "[1-9][0-9]{4,14}";//正则表达式
//		
//		boolean b = qq.matches(regex);
//		System.out.println(qq+":"+b);
		
		String str = "aoob";
		String reg = "ao?b";
		boolean b = str.matches(reg);
		System.out.println(str+":"+b);

	}

}
