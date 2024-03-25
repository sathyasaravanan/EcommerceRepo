package com.cratedTreasures.utils;

import java.util.Date;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=30;
	
	public static String timeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
		return "sathya.saro83"+timeStamp+"@gmail.com";
		
		
		
	}

}
