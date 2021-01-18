package com.zqw.common;

public class CommonMethod {
	/**
	 * 卡号脱敏
	 * @param cardNo
	 * @return
	 */
	public static String tCardNo(String cardNo){
		String str=cardNo.substring(0,5)+"****"+cardNo.substring(cardNo.length()-6, cardNo.length());
		return str;
	}
	/**
	 * 手机号脱敏
	 * @param phone
	 * @return
	 */
	public static String tPhone(String phone) {
		String str=phone.substring(0,4)+"****"+phone.substring(phone.length()-4, phone.length());
		return str;
	}
}
