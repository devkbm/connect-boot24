package com.like.core.util;

import java.time.LocalDate;

public class LocalDateUtil {	
	
	public static boolean isBeforeOrEqual(LocalDate date, LocalDate compareToDate) {	    	    
	    return !date.isAfter(compareToDate);
	}

	public static boolean isAfterOrEqual(LocalDate date, LocalDate compareToDate) {	   
	    return !date.isBefore(compareToDate);
	}
	
	
	public static void main(String agrs[]) {
		
		System.out.println("작거나 같다 테스트");
		System.out.println(LocalDateUtil.isBeforeOrEqual(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 2)));
		System.out.println(LocalDateUtil.isBeforeOrEqual(LocalDate.of(2020, 1, 2), LocalDate.of(2020, 1, 2)));
		System.out.println(LocalDateUtil.isBeforeOrEqual(LocalDate.of(2020, 1, 3), LocalDate.of(2020, 1, 2)));
		
		System.out.println("크거나 같다 테스트");
		System.out.println(LocalDateUtil.isAfterOrEqual(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 2)));
		System.out.println(LocalDateUtil.isAfterOrEqual(LocalDate.of(2020, 1, 2), LocalDate.of(2020, 1, 2)));
		System.out.println(LocalDateUtil.isAfterOrEqual(LocalDate.of(2020, 1, 3), LocalDate.of(2020, 1, 2)));
		
		System.out.println(LocalDateUtil.isAfterOrEqual(LocalDate.of(2020, 1, 1), null));
	}
}
