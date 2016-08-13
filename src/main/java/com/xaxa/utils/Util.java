package com.xaxa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.FORMAT_DATE);
	private static SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat(Constants.FORMAT_DATE_TIME);
	
	public static boolean strCk(String str) {
		return (str!=null && str.length()>0);
	}
	
	public static String getStrDate() {
		return simpleDateFormat.format(new Date());
	}
	
	public static String getStrDateTime() {
		return simpleDateTimeFormat.format(new Date());
	}
}
